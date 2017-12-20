
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Pliktxt {
	
	public void tworzplik(ArrayList <String>loginy,ArrayList<String>hasla)
	{
		
			PrintWriter writer;
			try {
				writer = new PrintWriter("Baza.txt","UTF-8");
				writer.println("LISTA LOGINOW I HASEL"+"\n");
				for(int i=0;i<loginy.size();i++)
				{
				writer.println("LOGIN: "+i+" "+loginy.get(i));
				writer.println("HASLO: "+i+" "+hasla.get(i));
				
				}
				writer.close();
				
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	

}
}
