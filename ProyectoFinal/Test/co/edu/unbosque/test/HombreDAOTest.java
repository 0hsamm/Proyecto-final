package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.DataMapper;

public class HombreDAOTest {

	static HombreDAO hDAO;
	public static int contador = 0;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Empezando las pruebas unitarias de las funciones CRUD de HombreDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		contador++;
		System.out.println("Comenzando prueba #" + contador);
		hDAO = new HombreDAO();
	}

	@Test
	public void crear() {
		HombreDTO hDTO = new HombreDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				java.time.LocalDate.of(1995, 8, 12), "Masculino", false, true, "Carlitos", "foto.jpg", false, 10,
				2500000, 1.80);

		hDAO.create(hDTO);
		Hombre temp = hDAO.getListaHombres().get(hDAO.count() - 1);

		boolean test = hDTO.getNombre().equals(temp.getNombre()) && hDTO.getApellido().equals(temp.getApellido())
				&& hDTO.getEmail().equals(temp.getEmail()) && hDTO.getContrasena().equals(temp.getContrasena())
				&& hDTO.getAlias().equals(temp.getAlias()) && hDTO.getEstatura() == temp.getEstatura()
				&& hDTO.getPromedioIngMensual() == temp.getPromedioIngMensual();

		assertEquals(true, test);
		hDAO.getListaHombres().clear();

		System.out.println(hDAO.getListaHombres());
		System.out.println("FINAL DE CREAR");
	}

	@Test
	public void delete() {
		HombreDTO hDTO = new HombreDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				java.time.LocalDate.of(1995, 8, 12), "Masculino", false, true, "Carlitos", "foto.jpg", false, 10,
				2500000, 1.80);

		hDAO.create(hDTO);
		int index = 0;
		hDAO.delete(index);

		boolean test;
		if (index < 0 || index >= hDAO.getListaHombres().size()) {
			test = false;
		} else {
			hDAO.getListaHombres().remove(index);
			test = true;
		}

		assertEquals(true, test);
		hDAO.getListaHombres().clear();

		System.out.println(hDAO.getListaHombres());
		System.out.println("FINAL DE DELETE");
	}

	@Test
	public void update() {
		HombreDTO hDTO = new HombreDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				java.time.LocalDate.of(1995, 8, 12), "Masculino", false, true, "Carlitos", "foto.jpg", false, 10,
				2500000, 1.80);
		hDAO.create(hDTO);

		int index = 0;

		HombreDTO h2 = new HombreDTO("Juan", "Pérez", "juan@mail.com", "nueva123", java.time.LocalDate.of(1993, 2, 25),
				"Masculino", false, true, "JuanP", "foto2.jpg", false, 20, 3200000, 1.75);

		hDAO.update(index, h2);

		boolean test;
		if (index < 0 || index >= hDAO.getListaHombres().size()) {
			test = false;
		} else {
			Hombre newData = DataMapper.convertirHombreDTOAHombre(h2);
			hDAO.getListaHombres().set(index, newData);
			test = true;
		}

		assertEquals(true, test);
		hDAO.getListaHombres().clear();

		System.out.println(hDAO.getListaHombres());
		System.out.println("FINAL DE UPDATE");
	}

	@Test
	public void showAll() {
		HombreDTO hDTO = new HombreDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				java.time.LocalDate.of(1995, 8, 12), "Masculino", false, true, "Carlitos", "foto.jpg", false, 10,
				2500000, 1.80);

		hDAO.create(hDTO);

		String contenido = "";
		hDAO.showAll();

		boolean test;
		if (hDAO.getListaHombres().size() > 0) {
			for (Hombre h : hDAO.getListaHombres()) {
				contenido += h.toString() + "\n";
			}
			test = true;
		} else {
			test = false;
		}

		assertEquals(true, test);
		hDAO.getListaHombres().clear();

		System.out.println(hDAO.getListaHombres());
		System.out.println("FINAL DE SHOWALL");
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalización de la prueba #" + contador);
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("=== Finalización de las pruebas de HombreDAO ===");
	}
}
