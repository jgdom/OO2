package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import datos.Cuota;
import datos.Prestamo;

public class CuotaDao {
	
	private static CuotaDao instancia;
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion()throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he)throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos",he);
	}
	
	public static CuotaDao getInstancia() {
		if(instancia == null) {
			instancia = new CuotaDao();
		}
		return instancia;
	}
	
	public Cuota traerCuota(long idCuota)throws HibernateException{
		Cuota c = null;
		try {
			iniciaOperacion();
			String hql = "from Cuota c inner join fetch c.prestamo p where c.idCuota=" + idCuota;
			c = (Cuota)session.createQuery(hql).uniqueResult();
		}
		finally {
			session.close();
		}
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuota> traerCuota(Prestamo p)throws HibernateException{
		List<Cuota> cuotas = null;
		try {
			iniciaOperacion();
			String hql = "from Cuota c inner join fetch c.prestamo p where p.idPrestamo=" + p.getIdPrestamo();
			cuotas = session.createQuery(hql).list();
		}
		finally {
			session.close();
		}
		return cuotas;
	}
	
	public int agregar(Cuota c)throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Cuota c)throws HibernateException{
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}
	
	public void eliminar(Cuota c)throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(c);
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}
	
	

}
