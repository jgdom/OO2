package test;
import dao.HibernateUtil;
import negocio.ClienteABM;

public class EliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = ClienteABM.getIntanciaClienteABM();
		try {
			abm.eliminar(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			HibernateUtil.getSessionFactory().close();		}
	}

}
