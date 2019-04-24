package test;

import negocio.ClienteABM;
import java.time.LocalDate;
import dao.HibernateUtil;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = ClienteABM.getInstancia();
		try {
			System.out.println(abm.traerCliente(35639606));
			long idUltimo = abm.agregarCliente("Simpson", "Homero", 10000000, LocalDate.of(1994, 02, 15));
			System.out.println(idUltimo);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			HibernateUtil.getSessionFactory().close();
		}

	}

}
