package test;
import java.time.LocalDate;
import dao.HibernateUtil;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args)  {
		
		String apellido = "tu apellido juan";
		String nombre = "tu nombre juan";
		int documento = 35000000;
		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.now();
		ClienteABM abm = ClienteABM.getIntanciaClienteABM();
	
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
