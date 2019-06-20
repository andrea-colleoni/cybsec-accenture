import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. carico il driver
		Class.forName("com.mysql.jdbc.Driver");
		// 2. creo una connessione
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cybsec_accenture", 
				"root", "password");
		// 3. creo un oggetto che trasporta SQL al database
		Statement comando = conn.createStatement();
		ResultSet dati = comando.executeQuery("SHOW databases");//;SELECT * FROM condminio.appartamento");
		while(dati.next()) {
			System.out.println(dati.getString("Database"));
		}
		
		Statement hack = conn.createStatement();
//		hack.execute("SET PASSWORD FOR 'root'@'localhost' = PASSWORD('666')");
		hack.execute("drop database lezione8");
//		hack.execute("CREATE USER 'pippo'@'localhost' IDENTIFIED BY '1234'");
//		hack.execute("GRANT CREATE TEMPORARY TABLES, CREATE TABLESPACE, CREATE ROUTINE, CREATE, ALTER ROUTINE, ALTER, SHOW VIEW, SHOW DATABASES, SELECT, PROCESS, EXECUTE  ON *.* TO 'pippo'@'localhost'");
	}

}
