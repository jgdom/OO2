package test;

import negocio.*;
import datos.*;
import java.time.LocalDate;

import dao.HibernateUtil;

public class TestAgregarCuota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM abmp = PrestamoABM.getInstancia();
		CuotaABM abmc = CuotaABM.getInstancia();
		ClienteABM abmcl = ClienteABM.getInstancia();
		try {
			System.out.println(abmp.traerPrestamo((long)1));
			Cuota c1 = new Cuota(1,LocalDate.of(2019, 05, 10),0.0,0.0,0.0,500.0,0.0,LocalDate.of(2019, 04, 20),0.0,abmp.traerPrestamo((long)3));
			System.out.println(c1);
			int idCuota = abmc.agregarCuota(c1);
			
			/*Cuota c2 = new Cuota(2,LocalDate.of(2019, 06, 10),0.0,0.0,0.0,500.0,0.0,LocalDate.of(2019, 05, 20),0.0,abmp.traerPrestamo((long)4));
			Cuota c3 = new Cuota(3,LocalDate.of(2019, 07, 10),0.0,0.0,0.0,500.0,0.0,LocalDate.of(2019, 06, 20),0.0,abmp.traerPrestamo((long)4));
			abmp.agregarPrestamo(LocalDate.of(2019, 04, 10), 1000, 0.0, 3, abmcl.traerCliente((long)4));
			abmc.agregarCuota(c1);
			abmc.agregarCuota(c2);
			abmc.agregarCuota(c3);*/
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
