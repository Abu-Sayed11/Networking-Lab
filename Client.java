import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{

        Socket var1 = new Socket("localhost", 7878);
        DataOutputStream var2 = new DataOutputStream(var1.getOutputStream());
        DataInputStream var3 = new DataInputStream(var1.getInputStream());
        Scanner var4 = new Scanner(System.in);

        String var5;

        do {
            String var6 = "Client: ";
            System.out.print(var6);
            var5 = var4.next();
            var2.writeUTF(var5);
            String var7 = var3.readUTF();
            System.out.println("Server: " + var7);
        } while(!var5.equalsIgnoreCase("quit"));

        var4.close();
        var2.close();
        var1.close();

    }
}