/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emission implements Runnable{
    private PrintWriter out;
    private String message = null, cmpMsg = "";
    private Scanner sc = null;
    private String login;
     
    public Emission(PrintWriter out) {
        this.out = out;
    }
 
     
    public void run() {
         
          sc = new Scanner(System.in);
           
          while(true){
              try {
                  Thread.currentThread().sleep(1000);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Emission.class.getName()).log(Level.SEVERE, null, ex);
              }
              if (Serveur.pseudo.getText() != "")
                  login = Serveur.pseudo.getText();
              else
                  login = "Serveur";
              message = Fichier.lire();
              if (message.compareTo(cmpMsg) != 0){
                out.println(login+" vous dit :"+message+"\n");
                out.flush();
                cmpMsg = message;
              }
                
              }
    }
    
}
