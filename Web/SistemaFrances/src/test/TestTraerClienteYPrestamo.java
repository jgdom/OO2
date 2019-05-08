package test;

import negocio.ClienteABM;
import negocio.PrestamoABM;
import datos.*;
import dao.HibernateUtil;

public class TestTraerClienteYPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = ClienteABM.getInstancia();
		PrestamoABM.getInstancia();
		try {
		     Cliente c = abm.traerClienteYPrestamo((long)1);
		     System.out.println(c.getApellido());
			for(Prestamo p: c.getPrestamos()) {
				System.out.println("\n" + p);
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
