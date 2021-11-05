package movie;
import java.sql.*;
class Movie{
public static void main(String args[]){
    try {
      Class.forName("org.sqlite.JDBC");
      Connection con =DriverManager.getConnection("JDBC:sqlite:Mulesoft.db");
      if(con!=null)
      {
        Statement st=con.createStatement();
        st.executeUpdate("drop table Movies");
        //Table creation
        st.executeUpdate("create table Movies(int sid,movie_name String,year_of_release int,Actor String,Actress String,Director String)");
        System.out.println("Table created\n");
        // Inserting values to table
        st.executeUpdate("Insert Into Movies values(1,'Dookudu',2011,'Mahesh','samantha','srinu vaital')");
        st.executeUpdate("Insert Into Movies values(2,'pokiri',2007,'Mahesh','Ileana','puri jaganadh')");
        st.executeUpdate("Insert Into Movies values(3,'Love Story',2021,'Naga Chaitanya','Pallavi','sekhar')");
        st.executeUpdate("Insert Into Movies values(4,'sye',2008,'Nithin','Genelia','Rajmouli')");
        st.executeUpdate("Insert Into Movies values(5,'Raja Rani',2016,'Vijay','Nayanthara','Atlee')");
        st.executeUpdate("Insert Into Movies values(6,'Maharshi',2018,'Mahesh','Pooja','Vamsi')");
        PreparedStatement pst= con.prepareStatement("select * from Movies");
        ResultSet rst=pst.executeQuery();
        System.out.println("SID"+" | "+"MVOVIE NAME"+" | "+"YEAR OF RELAEASE"+" | "+"ACTOR"+" | "+"ACTRESS"+" | "+"DIRECTOR");
        System.out.println("-----------------------------------------------------------------");
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