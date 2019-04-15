package test;
import dao.HibernateUtil;
import negocio.ClienteABM;
import datos.Cliente;
public class EliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		try {
			abm.eliminar(1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			HibernateUtil.getSessionFactory().close();
		}
	}

}
