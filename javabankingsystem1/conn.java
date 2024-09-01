package javabankingsystem1;

/**
 *
 * 
 */
import java.sql.*;
public class conn 
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_sql","root","root");
        s=c.createStatement();
        System.out.println("Connection Success");
        }
        catch(ClassNotFoundException | SQLException e)
        {
           System.out.println(e);
        }
    }   
}
