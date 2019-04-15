package test;
import java.time.LocalDate;
import dao.HibernateUtil;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args)  {
		
		String apellido = "tu apellido";
		String nombre = "tu nombre";
		int documento = 35000000;
		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.now();
		ClienteABM abm = new ClienteABM();
	
		try {
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento,
					fechaDeNacimiento);
		System.out.println("Cliente Añadido : "+ultimoIdCliente);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			HibernateUtil.getSessionFactory().close();
		}
	}
}
