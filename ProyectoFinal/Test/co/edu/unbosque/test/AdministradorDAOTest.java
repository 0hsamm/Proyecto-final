package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.persistence.AdministradorDAO;
import co.edu.unbosque.model.persistence.DataMapper;

public class AdministradorDAOTest {

	static AdministradorDAO aDAO;
	public static int contador = 0;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando pruebas unitarias de AdministradorDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		contador++;
		System.out.println("Comenzando prueba #" + contador);
		aDAO = new AdministradorDAO();
	}

	@Test
	public void crear() {
		AdministradorDTO aDTO = new AdministradorDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				LocalDate.of(1990, 4, 15), "Masculino", true);

		aDAO.create(aDTO);
		Administrador temp = aDAO.getListaAdministradores().get(aDAO.count() - 1);

		boolean test = aDTO.getNombre().equals(temp.getNombre()) && aDTO.getApellido().equals(temp.getApellido())
				&& aDTO.getEmail().equals(temp.getEmail()) && aDTO.getContrasena().equals(temp.getContrasena())
				&& aDTO.getFechaNacimiento().equals(temp.getFechaNacimiento())
				&& aDTO.getGenero().equals(temp.getGenero()) && aDTO.isEsAdministrador() == temp.isEsAdministrador();

		assertEquals(true, test);
		aDAO.getListaAdministradores().clear();

		System.out.println(aDAO.getListaAdministradores());
		System.out.println("FINAL DE CREAR");
	}

	@Test
	public void delete() {
		AdministradorDTO aDTO = new AdministradorDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				LocalDate.of(1990, 4, 15), "Masculino", true);

		aDAO.create(aDTO);
		int index = 0;
		aDAO.delete(index);

		boolean test;
		if (index < 0 || index >= aDAO.getListaAdministradores().size()) {
			test = false;
		} else {
			aDAO.getListaAdministradores().remove(index);
			test = true;
		}

		assertEquals(true, test);
		aDAO.getListaAdministradores().clear();

		System.out.println(aDAO.getListaAdministradores());
		System.out.println("FINAL DE DELETE");
	}

	@Test
	public void update() {
		AdministradorDTO aDTO = new AdministradorDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				LocalDate.of(1990, 4, 15), "Masculino", true);
		aDAO.create(aDTO);

		int index = 0;

		AdministradorDTO nuevo = new AdministradorDTO("Andrés", "Gómez", "andres@mail.com", "nueva456",
				LocalDate.of(1985, 10, 2), "Masculino", true);

		aDAO.update(index, nuevo);

		boolean test;
		if (index < 0 || index >= aDAO.getListaAdministradores().size()) {
			test = false;
		} else {
			Administrador newData = DataMapper.convertirAdministradorDTOAAdministrador(nuevo);
			aDAO.getListaAdministradores().set(index, newData);
			test = true;
		}

		assertEquals(true, test);
		aDAO.getListaAdministradores().clear();

		System.out.println(aDAO.getListaAdministradores());
		System.out.println("FINAL DE UPDATE");
	}

	@Test
	public void showAll() {
		AdministradorDTO aDTO = new AdministradorDTO("Carlos", "Ramírez", "carlos@mail.com", "clave123",
				LocalDate.of(1990, 4, 15), "Masculino", true);

		aDAO.create(aDTO);

		String contenido = "";
		aDAO.showAll();

		boolean test;
		if (aDAO.getListaAdministradores().size() > 0) {
			for (Administrador a : aDAO.getListaAdministradores()) {
				contenido += a.toString() + "\n";
			}
			test = true;
		} else {
			test = false;
		}

		assertEquals(true, test);
		aDAO.getListaAdministradores().clear();

		System.out.println(aDAO.getListaAdministradores());
		System.out.println("FINAL DE SHOWALL");
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalización de la prueba #" + contador);
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("=== Finalización de las pruebas de AdministradorDAO ===");
	}
}
