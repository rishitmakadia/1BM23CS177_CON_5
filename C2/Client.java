import java.net.*;
import java.io.*;
public class Client
{
    public static void main(String[] args ) throws Exception {
        Socket sock=new Socket("127.0.0.1",4000);
        System.out.println("enter the file name");
        BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        String fname=keyRead.readLine();
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pw=new PrintWriter(ostream,true);
        pw.println(fname);
        InputStream stream=sock.getInputStream();
        BufferedReader Socketread=new BufferedReader(new InputStreamReader(stream));
        String str;
        while((str=Socketread.readLine())!=null)
            System.out.println(str);
        pw.close();
        Socketread.close();
        keyRead.close();
           
       }
    }
