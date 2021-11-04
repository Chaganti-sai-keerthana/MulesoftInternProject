package movies;
import java.sql.*;

public class Record {
	public static void main(String args[]){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con =DriverManager.getConnection("JDBC:sqlite:Movies.db");
			if(con!=null)
			{
				Statement st=con.createStatement();
				//Table creation
				st.executeUpdate("Drop table Movies");
				st.executeUpdate("create table Movies(int sid,movie_name String,year_of_release int,Actor String,Actress String,Director String)");
				System.out.println("Table created");
				// Inserting values to table
			    st.executeUpdate("Insert Into Movies values(1,'Dookudu',2011,'Mahesh','samantha','srinu vaital')");
				st.executeUpdate("Insert Into Movies values(2,'pokiri',2007,'Mahesh','Ileana','puri jaganadh')");
				st.executeUpdate("Insert Into Movies values(3,'Love Story',2021,'Naga Chaitanya','Pallavi','sekhar')");
				st.executeUpdate("Insert Into Movies values(4,'sye',2008,'Nithin','Genelia','Rajmouli')");
				st.executeUpdate("Insert Into Movies values(5,'Raja Rani',2016,'Vijay','Nayanthara','Atlee')");
				st.executeUpdate("Insert Into Movies values(6,'Maharshi',2018,'Mahesh','Pooja','Vamsi')");
                con.close();	
             }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}