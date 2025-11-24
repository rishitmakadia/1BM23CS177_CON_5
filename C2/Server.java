import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws  Exception{
        ServerSocket sersock=new ServerSocket(4000);
        System.out.println("SERVER READY FOR CONNECTION");
        Socket sock=sersock.accept();
        System.out.println("CONNECTION IS SUCCESSFULL AND IS WAITING FOR CHATTING");
        InputStream istream=sock.getInputStream();
        BufferedReader fileread=new BufferedReader(new InputStreamReader(istream));
        String fname=fileread.readLine();
        BufferedReader contentread=new BufferedReader(new FileReader(fname));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pw=new PrintWriter(ostream,true);
        String str;
        while((str=contentread.readLine())!=null)
        {
            pw.println(str);
           
        }
        sock.close();
        pw.close();
        fileread.close();
        contentread.close();
       
    }
}