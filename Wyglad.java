import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	static int i=0;
	static int j=0;
	
	
	static ArrayList<String> loginy=new ArrayList<String>();
	static ArrayList<String> hasla=new ArrayList<String>();
	static JTextField login=new JTextField();
	static JTextField haslo=new JTextField();
	static Connection c=null;
	static int czyznalazlo=0;
	static int czyznalazloh=0;
	static int konta=0;
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
		
		
		
		
		
		
		
		
		PreparedStatement ps = null;
		ResultSet odpowiedz = null;
		c=p.polaczenie();
		while(konta!=1)
		{
			//tu bede zajmowal sie loginem
			while(czyznalazlo!=1)
			{
			try
			{
				String wylosowane=probylogin();
				String query="select * from Uzytkownicy where Nick=?";
				ps=c.prepareStatement(query);
				ps.setString(1,wylosowane); //tu ma szukac
				odpowiedz=ps.executeQuery();
				System.out.println(konta);
				while(odpowiedz.next())
				{
					
					czyznalazlo++;
					i=0;
					System.out.println(odpowiedz.getString(1));
				 loginy.add(odpowiedz.getString(1));
				 funkcjahaslo(odpowiedz.getString(1));
				 konta++;
				 
					
					
					
				}
				System.out.println(konta);
				
			}
			catch (Exception e)
			{
				
			}
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
		System.out.println("Weszklo w p haslo");
		String zwrotna = null;
		if(i<26)
		{
		zwrotna=Character.toString((char)(i+97));
					haslo.setText(Character.toString((char)(i+97)));
					i++;
				
		}
		return zwrotna;
	}
	
	static void funkcjahaslo(String nick)
	{
		System.out.println("Weszklo w p funkcje ");
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
		System.out.println(loginy.get(0));
		System.out.println(hasla.get(0));
	}
	
	
	
	
	
	
	
		
	}

	
	//dopiero odlaczy od bazy jak sie uda wszystkie
	//po skonczeniu pokazuje baze w pliku tekstowym 
	//while konta=2 probuj
	//gdy juz 1 znajdzie to nie powtarzaj w petli .
	// narazie do 3 znakow tylko tylko literki a-z male
//1.umiesc w petlach 
//2. wymysl algorytm

	
	
	

