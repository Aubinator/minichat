/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion implements Runnable {
 
    private Socket socket = null;
    public static Thread t2;
    public static String login = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Scanner sc = null;
    private boolean connect = false;
     
    public Connexion(PrintWriter o, BufferedReader z, String log){
         
        out = o;
        in = z;
        login = log;
    }
     
    /**
     *
     */
    
    public void run() {
         
        try {
             
       
     
         Thread.currentThread().sleep(1000);
        out.println(login.toString());

        
         
         
        
         
        if(in.readLine().equals("connecte")){
     
  
            Client.AffMessage.setText("Je suis connecté");
        connect = true;
          }
         
        else {
               Client.AffMessage.setText("Vos informations sont incorrectes "); 
          }
         

        } catch (IOException e) {
             
               Client.AffMessage.setText("Le serveur ne répond plus ");
        } catch (InterruptedException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
