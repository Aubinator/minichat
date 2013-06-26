/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Emission implements Runnable{
    private PrintWriter out;
    private String login = null, message = null;
    private Scanner sc = null;
     
    public Emission(PrintWriter out, String msg) {
        this.out = out;
        this.message = msg;
         
    }
 
     
    public void run() {
         
         
             out.println(message);
             System.out.println(message);
             out.flush();
                    
    }
}
