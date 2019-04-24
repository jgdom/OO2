package test;

import java.util.List;

import dao.HibernateUtil;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.PrestamoABM;
import negocio.ClienteABM;

public class TestTraerTodo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = ClienteABM.getInstancia();
		try {
			List<Cliente> lstC = abm.traerClienteTodo();
			for(Cliente c: lstC) {
				System.out.println(c);
				for(Prestamo p : c.getPrestamos()) {
					System.out.println(p);
					for(Cuota cu : p.getCuotas()) {
						System.out.println(cu);
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

}
