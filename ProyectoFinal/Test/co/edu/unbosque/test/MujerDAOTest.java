package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.MujerDAO;
import co.edu.unbosque.model.persistence.DataMapper;

public class MujerDAOTest {

	static MujerDAO mDAO;
	public static int contador = 0;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Empezando las pruebas unitarias de las funciones CRUD de MujerDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		contador++;
		System.out.println("Comenzando prueba #" + contador);
		mDAO = new MujerDAO();
	}

	@Test
	public void crear() {
		MujerDTO mDTO = new MujerDTO("Laura", "Gómez", "laura@mail.com", "clave123",
				java.time.LocalDate.of(1998, 5, 10), "Femenino", false, true, "LauG", "foto.jpg", false, 20, 1.68,
				false);

		mDAO.create(mDTO);
		Mujer temp = mDAO.getListaMujeres().get(mDAO.count() - 1);

		boolean test = mDTO.getNombre().equals(temp.getNombre()) && mDTO.getApellido().equals(temp.getApellido())
				&& mDTO.getEmail().equals(temp.getEmail()) && mDTO.getContrasena().equals(temp.getContrasena())
				&& mDTO.getAlias().equals(temp.getAlias()) && mDTO.getEstatura() == temp.getEstatura()
				&& mDTO.isEsDivorciada() == temp.isEsDivorciada();

		assertEquals(true, test);
		mDAO.getListaMujeres().clear();

		System.out.println(mDAO.getListaMujeres());
		System.out.println("FINAL DE CREAR");
	}

	@Test
	public void delete() {
		MujerDTO mDTO = new MujerDTO("Laura", "Gómez", "laura@mail.com", "clave123",
				java.time.LocalDate.of(1998, 5, 10), "Femenino", false, true, "LauG", "foto.jpg", false, 20, 1.68,
				false);

		mDAO.create(mDTO);
		int index = 0;
		mDAO.delete(index);

		boolean test;
		if (index < 0 || index >= mDAO.getListaMujeres().size()) {
			test = false;
		} else {
			mDAO.getListaMujeres().remove(index);
			test = true;
		}

		assertEquals(true, test);
		mDAO.getListaMujeres().clear();

		System.out.println(mDAO.getListaMujeres());
		System.out.println("FINAL DE DELETE");
	}

	@Test
	public void update() {
		MujerDTO mDTO = new MujerDTO("Laura", "Gómez", "laura@mail.com", "clave123",
				java.time.LocalDate.of(1998, 5, 10), "Femenino", false, true, "LauG", "foto.jpg", false, 20, 1.68,
				false);
		mDAO.create(mDTO);

		int index = 0;

		MujerDTO m2 = new MujerDTO("Carolina", "Pérez", "caro@mail.com", "nueva123",
				java.time.LocalDate.of(1997, 3, 22), "Femenino", false, true, "CaroP", "foto2.jpg", false, 30, 1.70,
				true);

		mDAO.update(index, m2);

		boolean test;
		if (index < 0 || index >= mDAO.getListaMujeres().size()) {
			test = false;
		} else {
			Mujer newData = DataMapper.convertirMujerDTOAMujer(m2);
			mDAO.getListaMujeres().set(index, newData);
			test = true;
		}

		assertEquals(true, test);
		mDAO.getListaMujeres().clear();

		System.out.println(mDAO.getListaMujeres());
		System.out.println("FINAL DE UPDATE");
	}

	@Test
	public void showAll() {
		MujerDTO mDTO = new MujerDTO("Laura", "Gómez", "laura@mail.com", "clave123",
				java.time.LocalDate.of(1998, 5, 10), "Femenino", false, true, "LauG", "foto.jpg", false, 20, 1.68,
				false);

		mDAO.create(mDTO);

		String contenido = "";
		mDAO.showAll();

		boolean test;
		if (mDAO.getListaMujeres().size() > 0) {
			for (Mujer m : mDAO.getListaMujeres()) {
				contenido += m.toString() + "\n";
			}
			test = true;
		} else {
			test = false;
		}

		assertEquals(true, test);
		mDAO.getListaMujeres().clear();

		System.out.println(mDAO.getListaMujeres());
		System.out.println("FINAL DE SHOWALL");
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalización de la prueba #" + contador);
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("=== Finalización de las pruebas de MujerDAO ===");
	}
}
