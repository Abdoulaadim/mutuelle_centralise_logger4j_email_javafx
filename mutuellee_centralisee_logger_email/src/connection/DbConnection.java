package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import application.Main;

public class DbConnection {
	
	static final String Host = "127.0.0.1";
	static final String Port = "3306";
	static final String DB_NAME = "Mutuelle_centralisee";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	
	private static Connection cnx ;
	static  Logger logger = Logger.getLogger(DbConnection.class.getName());
	public static Connection getConnection() {
		
		try {
			
			cnx= DriverManager.getConnection("jdbc:mysql://"+Host+":"+Port+"/"+DB_NAME+"?characterEncoding=latin1&useConfigs=maxPerformance",USER,PASSWORD);
			logger.info("cnx a la base de donnée avec sucee");
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			logger.debug(e);
			logger.debug("connexion à la base de donnée a été échoue");
		}
		return cnx;
	
		
		
	}
	
	

}
