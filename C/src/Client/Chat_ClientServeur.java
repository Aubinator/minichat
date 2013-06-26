
package Client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Chat_ClientServeur  implements Runnable{
private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Scanner sc;
    private Thread t3, t4;
     
    public Chat_ClientServeur(Socket s){
        socket = s;
    }
     
@Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             
            sc = new Scanner(System.in);
             
            
            t3 = new Thread( new Reception(in));
            t3.start();
         
            
             
        } catch (IOException e) {
               Client.AffMessage.setText("Le serveur distant s'est déconnecté !");
        }
    }
    
}
