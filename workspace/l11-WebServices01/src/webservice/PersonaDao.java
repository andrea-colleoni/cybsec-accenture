package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {

	public List<Persona> tutti() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cybsec_rubrica", 
				"root", 
				"password");
		PreparedStatement pst = conn.prepareStatement("select * from persone");
		ResultSet risultati = pst.executeQuery();
		List<Persona> elenco = new ArrayList<>();
		while(risultati.next()) {
			Persona p = new Persona();
			p.nome = risultati.getString("nome");
			p.cognome = risultati.getString("cognome");
			p.email = risultati.getString("email");
			p.dataNascita = risultati.getDate("data_nascita");
			p.numeroTelefono = risultati.getString("numero_telefono");
			p.indirizzo = risultati.getString("indirizzo");
			elenco.add(p);
		}
		risultati.close();
		pst.close();
		conn.close();
		return elenco;
	}
}
