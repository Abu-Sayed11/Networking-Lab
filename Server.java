import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Server {

    public static void main(String[] args) throws Exception{

        ServerSocket var1 = new ServerSocket(7878);
        Socket var2 = var1.accept();
        DataInputStream var3 = new DataInputStream(var2.getInputStream());
        DataOutputStream var4 = new DataOutputStream(var2.getOutputStream());

        String var5;

        do {
            var5 = var3.readUTF();
            System.out.println(var5);
            if (var5.equalsIgnoreCase("hi")) {
                var4.writeUTF("Hello");
            }else {
                DateTimeFormatter var6;
                String var8;
                if (var5.equalsIgnoreCase("time")) {
                    var6 = DateTimeFormatter.ofPattern("HH.mm");
                    LocalTime var7 = LocalTime.now();
                    var8 = var7.format(var6);
                    var4.writeUTF(var8);
                }else if (var5.equalsIgnoreCase("date")) {
                    var6 = DateTimeFormatter.ofPattern("dd.MM.YYYY");
                    LocalDate var9 = LocalDate.now();
                    var8 = var9.format(var6);
                    var4.writeUTF(var8);
                }else if (var5.equalsIgnoreCase("quit")) {
                    var4.writeUTF("Quiting.......");
                }else {
                    var4.writeUTF("Unknown");
                }
                
            }
        }while(!var5.equalsIgnoreCase("quit"));
        var1.close();
    }
}
