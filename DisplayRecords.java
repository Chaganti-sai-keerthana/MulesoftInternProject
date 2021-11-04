package movies;
import java.sql.*;

public class DisplayRecords{
	public static void main(String args[]){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con =DriverManager.getConnection("JDBC:sqlite:Movies.db");
			if(con!=null)
			{
				Statement st=con.createStatement();
				PreparedStatement pst= con.prepareStatement("select * from Movies");
				ResultSet rst=pst.executeQuery();
				System.out.println("SID"+" | "+"MVOVIE NAME"+" | "+"YEAR OF RELAEASE"+" | "+"ACTOR"+" | "+"ACTRESS"+" | "+"DIRECTOR");
				System.out.println("*******************************************************************");
				while(rst.next())
				{
				System.out.println(rst.getInt(1)+" | "+rst.getString(2)+" | "+rst.getInt(3)+" | "+rst.getString(4)+" | "+rst.getString(5)+" | "+rst.getString(6));
				}
		con.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}