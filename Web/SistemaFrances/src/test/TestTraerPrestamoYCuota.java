package test;

import dao.HibernateUtil;
import datos.Cliente;
import datos.Prestamo;
import datos.Cuota;
import negocio.ClienteABM;
import negocio.PrestamoABM;
import negocio.CuotaABM;

public class TestTraerPrestamoYCuota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM abm = PrestamoABM.getInstancia();
		try {
			Prestamo p = abm.traerPrestamoYCuota(3);
			System.out.println(p);
			for(Cuota c: p.getCuotas()) {
				System.out.println("\n" + c);
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
