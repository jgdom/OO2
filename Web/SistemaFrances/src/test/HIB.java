package test;
import dao.HibernateUtil;
import org.hibernate.Session;
public class HIB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		sesion.close();
		
	}

}
