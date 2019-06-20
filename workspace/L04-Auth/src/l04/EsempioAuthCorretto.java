package l04;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class EsempioAuthCorretto {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cybsec_l04", args[0], args[1]);

		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci il nome utente: ");
		String user = sc.nextLine();
		System.out.print("Digita la password: ");
		String pass = sc.nextLine();
		ResultSet dati;
		if (pass.equals("123456")) {
			PreparedStatement comando = conn.prepareStatement("SELECT * FROM users WHERE " + " username=?");
			comando.setString(1, user);
			dati = comando.executeQuery();
		} else {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.toString().getBytes());
			byte[] digest = md.digest();
			String hash = DatatypeConverter.printHexBinary(digest);
			PreparedStatement comando = conn
					.prepareStatement("SELECT * FROM users WHERE " + " username=? AND password=?");
			comando.setString(1, user);
			comando.setString(2, hash);
			dati = comando.executeQuery();
		}
		if (dati.next()) {
			System.out.println("Benvenuto, " + dati.getString("fullname"));
		} else {
			System.out.println("Accesso fallito.");
		}
	}

}
