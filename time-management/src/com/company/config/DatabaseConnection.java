package company.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import company.utils.FileUtilities;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
   
    private DatabaseConnection() throws SQLException { 
        try {
        	
        	// Load Driver
            Class.forName("org.postgresql.Driver");

            // Load connexion postgress from external properties file
            
			HashMap<String, String> mymap = FileUtilities.loadValuesFromProperties();
			String username = mymap.get("username");
			String password = mymap.get("password");
			String host = mymap.get("hostname");
			String port = mymap.get("port");
			String dbname = mymap.get("dbname");

			String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbname;
 
            // create the connexion
            this.connection = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}