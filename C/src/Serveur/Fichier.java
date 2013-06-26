/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.PrintWriter;

public class Fichier {
    private static String path = "message.txt";
    public static void ecrire(String text) 
	{
		PrintWriter ecri ;
		try
		{
			ecri = new PrintWriter(new FileWriter(path));
			ecri.print(text);
			ecri.flush();
			ecri.close();
		}//try
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a)
		{
			System.out.println("Problème d'IO");
		}
	}//ecrire
 
	public static String lire () 
	{
		BufferedReader lect ;
		String tmp = "";
		try
		{
			lect = new BufferedReader(new FileReader(path)) ;
			while (lect.ready()==true) 
			{
				tmp += lect.readLine() ; 
			}
		}
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a) 
		{
			System.out.println("Problème d'IO");
		}
                
		return tmp;
	}//lecture 
}
