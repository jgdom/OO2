package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Prestamo;

public class ClienteDao {
	
	private static ClienteDao instanciaDao;
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
	
	public static ClienteDao getInstanciaDao() {
		if(instanciaDao == null) {
			instanciaDao = new ClienteDao();
		}
		return instanciaDao;
	}
	
	public int agregar(Cliente c) {
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
	
	public void actualizar(Cliente c)throws HibernateException{
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
	
	public void eliminar(Cliente c)throws HibernateException{
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
	
	public Cliente traerCliente(long idCliente)throws HibernateException{
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.get(Cliente.class, idCliente);
		}//session.get solo para clave primaria
		finally {
			session.close();
		}
		return c;
	}
	
	public Cliente traerCliente(int dni)throws HibernateException{
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		}
		finally {
			session.close();
		}
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente()throws HibernateException{
		List<Cliente> clientes = null;
		try {
			iniciaOperacion();
			clientes = session.createQuery("from Cliente c order by c.apellido asc,c.nombre asc").list();
		}
		finally {
			session.close();
		}
		return clientes;
	}
	
	public Cliente traerClienteYPrestamos(long idCliente)throws HibernateException{
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente =" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getPrestamos());
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traerClienteTodo() throws HibernateException{
		List<Cliente> objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c order by c.apellido asc,c.nombre asc";
			objeto = session.createQuery(hql).list();
			for(Cliente c : objeto) {
				Hibernate.initialize(c.getPrestamos());
				for(Prestamo p: c.getPrestamos()) {
					Hibernate.initialize(p.getCuotas());
				}
			}
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

}
