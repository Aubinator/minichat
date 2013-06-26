/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Serveur;
import java.io.BufferedReader;
import java.io.IOException;

public class Reception implements Runnable{
     private BufferedReader in;
    private String message = null, login = null;
     
    public Reception(BufferedReader in, String login){
         
        this.in = in;
        this.login = login;
    }
     
    public void run() {
         
        while(true){
            try {
                 
            message = in.readLine();
            Serveur.AffMessage.setText(Serveur.AffMessage.getText()+login+" : "+message +"\n");
             
            } catch (IOException e) {
                 
                e.printStackTrace();
            }
        }
    }
}
