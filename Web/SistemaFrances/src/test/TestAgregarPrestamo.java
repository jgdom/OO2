package test;

import negocio.*;
import dao.HibernateUtil;
import java.time.LocalDate;

public class TestAgregarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM abmp = PrestamoABM.getInstancia();
		ClienteABM abmc = ClienteABM.getInstancia();
		try {
		//System.out.println(abmp.traerPrestamo(1));
			//System.out.println(abmp.traerPrestamo(abmc.traerCliente(35639606)));
			abmp.agregarPrestamo(LocalDate.of(2019, 03, 30), 15000, 10, 5, abmc.traerCliente((long)2));
			System.out.println(abmp.traerPrestamo(abmc.traerCliente(10000000)));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
