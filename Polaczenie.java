import java.sql.*;
import javax.swing.*;


public class Polaczenie {
	static Connection c=null;
	public static Connection polaczenie()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:C:\\ProjektyJava\\OdkrywanieBazy\\odkrywanie.sqlite");
			JOptionPane.showMessageDialog(null,"Connected");
			return c;
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;

		}
	}

}
