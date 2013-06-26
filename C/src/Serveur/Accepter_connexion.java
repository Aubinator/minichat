/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;
import java.io.*;
import java.net.*;

public class Accepter_connexion  implements Runnable{
    private ServerSocket socketserver = null;
    public static Socket socket = null;
    private String login = "";
    private PrintWriter out = null;
    private BufferedReader in = null;
    public Thread t1;
    public String distLogin;
    public Accepter_connexion(ServerSocket ss){
     socketserver = ss;
    }
     
    public void run() {
         
        try {
            while(true){
                 
            socket = socketserver.accept();
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              
            out = new PrintWriter(socket.getOutputStream());
            login = in.readLine();                            
            Serveur.AffMessage.setText(Serveur.AffMessage.getText()+" "+login+" vient de se connecter  \n");
            t1 = new Thread(new Chat_ClientServeur(socket,login));
            t1.start();
            
             
            }
        } catch (IOException e) {
             
            Serveur.AffMessage.setText(Serveur.AffMessage.getText()+"Erreur serveur");
        }
         
    }

    public Socket getSocket(){
        return this.socket;
    }
}
