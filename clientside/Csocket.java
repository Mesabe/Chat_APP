package Day8_2.clientside.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Csocket {
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);

        String input = "Dummy Message";

        System.out.println("Cleint running=========================================");
        Socket css = new Socket("127.0.0.1", 3033);

        DataInputStream dis = new DataInputStream(css.getInputStream());
        DataOutputStream dos =new DataOutputStream(css.getOutputStream());
        while(!input.equalsIgnoreCase("x")){
            //Send input to server
            input = sc.nextLine();
            dos.writeUTF(input);

            //Input form Server
            dis = new DataInputStream(css.getInputStream());
            String line = dis.readUTF();
            System.out.println(line);
        }

        dis.close();
        dos.close();
        css.close();
    }
}
