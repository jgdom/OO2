package test;

import java.time.LocalDate;

import dao.HibernateUtil;
import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {
	public static void main(String[] args) {
		ClienteABM abmCliente = ClienteABM.getIntanciaClienteABM();
		ContactoABM abmContacto = ContactoABM.getIntanciaContactoABM(); 
		/*
		 * en vez de tener esas dos lineas puedo hacer un facade y llamar solo el get del sistema que me crearia las instancias 
		 */
		
		try {
			
			long idCliente = 1;
			Cliente cliente;
			cliente = abmCliente.traer(idCliente);
			System.out.println(cliente);
			abmContacto.agregar("ajaramillo@unla.edu.ar", "11-1111-1111", "011-1111-1111", cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//En el test 1 jaramillo y los datos de contactos ya estaban en la bd asi que ahora pruebo si funciona teniendo solo los datos de cliente cargado en la BD
		try {
			long idCliente = abmCliente.agregar("Dominguez","Juan,", 38000000, LocalDate.of(1995, 04, 22));
			Cliente cliente = abmCliente.traer(idCliente);
			System.out.println(cliente);
			abmContacto.agregar("jgdominguez@unla.edu.ar", "11-1111-1111", "011-1111-1111", cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		//pruebo un cliente que no este cargado previamente en la BD
				try {
					Cliente cliente = new Cliente("Dominguez","Juan,", 38000000, LocalDate.of(1995, 04, 22));
					System.out.println(cliente);
					abmContacto.agregar("jgdominguez@unla.edu.ar", "11-1111-1111", "011-1111-1111", cliente);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
		finally {
			HibernateUtil.getSessionFactory().close();
		}
	}
}