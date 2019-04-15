package test;

import dao.HibernateUtil;
import datos.Cliente;
import negocio.ClienteABM;

public class TestModificarCliente {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
				ClienteABM abm = new ClienteABM();
				long id=4;
				// traer el obj a modificar
				Cliente c=abm.traer(id);
				System. out .println( "Cliente a Modificar -->" +c);
				// modificar por set los atributos
				c.setDni(123412341);
			
				try {
					abm.modificar(c); //update del objeto
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				} finally {
					HibernateUtil.getSessionFactory().close();
				}
			

	}

}
