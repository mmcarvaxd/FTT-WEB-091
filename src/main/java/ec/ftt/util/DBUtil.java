package ec.ftt.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class DBUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
    	
        if (connection != null)
            return connection;
        else {
            try {
               /* 
            	Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
                prop.load(inputStream);
                
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                */
                
            	//jdbc:mysql://localhost:3306/?user=root"
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://127.0.0.1:3306";
                String user = "root"; //"scott";
                String password = "12345678";//"@@T1ger!"; //"UFLg@9!wytje8NjR"; System.getenv("FTT_PWD");
                
                Class.forName(driver);
                
                connection = DriverManager.getConnection(url, user, password);
                
                System.out.println("JDBC Connected!! - " + new Date());
            
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
          //  } catch (FileNotFoundException e) {
          //      e.printStackTrace();
      //      } catch (IOException e) {
       //         e.printStackTrace();
        //    }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
            return connection;
        }

    }
}