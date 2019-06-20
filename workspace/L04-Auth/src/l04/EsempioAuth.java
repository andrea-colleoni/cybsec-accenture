package l04;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

public class EsempioAuth {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cybsec_l04",
				args[0], args[1]); // la password è un parametro del programma
		Statement comando = conn.createStatement();
		// uso uno Scanner per leggere i dati da tastiera
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci il nome utente: ");
		String user = sc.nextLine();
		// vulnerabilità:   ' OR TRUE OR '' = '
		user = user.replaceAll("'", "''");
		System.out.print("Digita la password: ");
		String pass = sc.nextLine();
		// cifro la password con MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(pass.toString().getBytes());
	    byte[] digest = md.digest();
	    String hash = DatatypeConverter.printHexBinary(digest);
//		ResultSet dati = comando.executeQuery("SELECT * FROM users WHERE "
//				+ " username='" + user +"' AND password=MD5('" + pass + "')");
		ResultSet dati = comando.executeQuery("SELECT * FROM users WHERE "
				+ " username='" + user +"' AND password='" + hash + "'");
		if (dati.next()) {
			System.out.println("Benvenuto, " + dati.getString("fullname"));
		} else {
			System.out.println("Accesso fallito.");
		}
	}

}
