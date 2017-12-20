import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.Border;

public class Wyglad {
	
	//Dotyczy 1 i 2
	static int i=0;
	
	
	//Dotyczy 1
	static int h=0;
 static	int maksmozliwosci=0;
	
	
   //Dotyczyny 2
	static int ih=0;
	static int dh=0;
	   static int d=0;
	   static PreparedStatement ps = null;
		static ResultSet odpowiedz = null;
		static int maksmozliwosci2=0;
		
		//Dotyczy 3
		static int maksmozliwosci3=0;
		
		

	 
	static ArrayList<String> loginy=new ArrayList<String>();
	static ArrayList<String> hasla=new ArrayList<String>();
	static JTextField login=new JTextField();
	static JTextField haslo=new JTextField();
	static Connection c=null;
	
	static int czyznalazloh=0;
	
	public static void main(String[] args) {


		
		Polaczenie p= new Polaczenie();
		
		
		JFrame ramka=new JFrame();
		JPanel panel=new JPanel();
		JButton ok=new JButton("OK");
		login=new JTextField();
        haslo=new JTextField();
		JLabel loginl=new JLabel("Login");
		JLabel haslol=new JLabel("Haslo");
		panel.setLayout(new GridLayout(2,2,2,2));
		
		panel.add(loginl);
		panel.add(login);
		panel.add(haslol);
		panel.add(haslo);
	   ramka.add(panel);
	   ramka.add(ok,BorderLayout.EAST);
		ramka.setSize(400,100);
		ramka.show();
		ramka.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		

		c=p.polaczenie();
			uruchomjedynki();
		i=0;
		czyznalazloh=0;
		uruchomdwojki();
		
	Pliktxt plik=new Pliktxt();
	plik.tworzplik(loginy, hasla);
	
		
		
		
		
		
	
	
	}
  
	
	static String probylogin()
	{
		String zwrotna = null;
  
		
		
		if(i<26)
		{
			zwrotna=Character.toString((char)(i+97));
			login.setText(Character.toString((char)(i+97)));
		
				
		
					i++;
				
		}

	
		return zwrotna;

		
	}
	static String probyhaslo()
	{
		
		String zwrotna = null;
		if(h<26)
		{
		zwrotna=Character.toString((char)(h+97));
					haslo.setText(Character.toString((char)(h+97)));
					h++;
				
		}
		
		
		//jesli i bedzie 25 na jedynkach to break
		return zwrotna;
	}
	
	static void funkcjahaslo(String nick)
	{
		
		while(czyznalazloh!=1)
		{
			
		try
		{
			String wylosowaneh=probyhaslo();
			if(i==26)
			{
				break;
			}
			String query="select * from Uzytkownicy where Haslo=? and Nick=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1,wylosowaneh);
			ps.setString(2,nick);
			ResultSet odpowiedz=ps.executeQuery();
			while(odpowiedz.next())
			{
				czyznalazloh++;
				 hasla.add(odpowiedz.getString(2));
		
				
			}
			
			
		}
		catch (Exception e)
		{
			
		}
		}
		
	}
	
	static String probylogin2()
	{
		String zwrotna = null;
		if(i<26)
		{
		zwrotna=Character.toString((char)(i+97))+Character.toString((char)(d+97));
					login.setText(zwrotna);
					i++;
				
		}
		if(i==26)
		{
			i=0;
			d++;
		}
		
		
	
		
		return zwrotna;	
	}
	static String probyhaslo2()
	{
	
		String zwrotna = null;
		if(i<26)
		{
		zwrotna=Character.toString((char)(ih+97))+Character.toString((char)(dh+97));
					haslo.setText(zwrotna);
					ih++;
				
		}
		if(ih==26)
		{
			ih=0;
			dh++;
		}
	
		
		//jesli i bedzie 25 na jedynkach to break
		return zwrotna;
	}	
	static void funkcjahaslo2(String nick)
	{
	
		while(czyznalazloh!=1)
		{
		try
		{
			String wylosowaneh=probyhaslo2();
			
			String query="select * from Uzytkownicy where Haslo=? and Nick=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1,wylosowaneh);
			ps.setString(2,nick);
			ResultSet odpowiedz=ps.executeQuery();
			while(odpowiedz.next())
			{
				czyznalazloh++;
				 hasla.add(odpowiedz.getString(2));
		
				
			}
			
			
		}
		catch (Exception e)
		{
			
		}
		}
		
	}	
	
	
	
 static void uruchomjedynki()
 {
	 while(maksmozliwosci!=25)
		{
		try
		{
			maksmozliwosci++;			
			String wylosowane=probylogin();
			String query="select * from Uzytkownicy where Nick=?";
			ps=c.prepareStatement(query);
			ps.setString(1,wylosowane); //tu ma szukac
			odpowiedz=ps.executeQuery();
			while(odpowiedz.next())
			{
				
				
				czyznalazloh=0;
				h=0;
			 
		
			 loginy.add(odpowiedz.getString(1));
			 
			 funkcjahaslo(odpowiedz.getString(1));
			
			 
				
				
				
			}
			
			ps.close();
			odpowiedz.close();
		}
		
		catch (Exception e)
		{
			
		}
	}
 }
 
 static void uruchomdwojki()
 {
	 while(maksmozliwosci2!=676)
		{
		try
		{
			maksmozliwosci2++;
			String wylosowane=probylogin2();
			String query="select * from Uzytkownicy where Nick=?";
			ps=c.prepareStatement(query);
			ps.setString(1,wylosowane); //tu ma szukac
			odpowiedz=ps.executeQuery();
	
			
			
			while(odpowiedz.next())
			{
				
				
				
			
			 loginy.add(odpowiedz.getString(1));
			 ih=0;
			 dh=0;
			 funkcjahaslo2(odpowiedz.getString(1));
			 czyznalazloh=0;
			 
		  
			 
			 
				
				
				
			}
			
			
			
		}
	 
	   
		catch (Exception e)
		{
			
		}
	}
	
	
	try {
		odpowiedz.close();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
 }
 
 static void uruchomtrojki()
 {
	 
	 while(maksmozliwosci3!=17576)
		{
		try
		{
			maksmozliwosci3++;
			System.out.println(maksmozliwosci2);
			String wylosowane=probylogin2();
			String query="select * from Uzytkownicy where Nick=?";
			ps=c.prepareStatement(query);
			ps.setString(1,wylosowane); //tu ma szukac
			odpowiedz=ps.executeQuery();
	
			
			
			while(odpowiedz.next())
			{
				
				
				
			
			 loginy.add(odpowiedz.getString(1));
			 ih=0;
			 dh=0;
			 funkcjahaslo2(odpowiedz.getString(1));
			 czyznalazloh=0;
			 
		  
			 
			 
				
				
				
			}
			
			
			
		}
	 
	   
		catch (Exception e)
		{
			
		}
	}
	
	
	try {
		odpowiedz.close();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
	
	
	
	}



//Zrobic 3 cyfrowe 
