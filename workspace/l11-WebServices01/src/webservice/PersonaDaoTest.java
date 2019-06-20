package webservice;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class PersonaDaoTest {

	@Test
	public void testTutti() throws ClassNotFoundException, SQLException {
		PersonaDao dao = new PersonaDao();
		List<Persona> risultato = dao.tutti();
		assertEquals(1, risultato.size());
	}

}
