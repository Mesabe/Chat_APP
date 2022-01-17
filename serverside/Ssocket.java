package Day8_2.serverside.*;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ssocket {
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Server is running================================");
        String input = "Bleh";
        ServerSocket ss = new ServerSocket(3033);

        Socket cs = ss.accept();

        DataInputStream dis = new DataInputStream(cs.getInputStream());
        DataOutputStream dos =new DataOutputStream(cs.getOutputStream());

        while (!input.equalsIgnoreCase("Leave me...")) 
        {
            dis = new DataInputStream(cs.getInputStream());
            input = dis.readUTF();
            System.out.println(input);

            String message = sc.nextLine();
            dos.writeUTF(message);
        }
        

        
        

        dos.close();
        dis.close();
        sc.close();
        ss.close();
        cs.close();
    }
}
