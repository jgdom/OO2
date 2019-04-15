package negocio;

import dao.ClienteDao;
import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	private static ContactoABM instanciaContactoABM;
	
	protected ContactoABM() {
		this.inicializar();
	}
	
	public static ContactoABM getIntanciaContactoABM() {
		if(instanciaContactoABM==null) {
			instanciaContactoABM=new ContactoABM();
		}
		return instanciaContactoABM;
	}
	
	private void inicializar() {
		
	}

	public Contacto traer(long idContacto) {
		Contacto c = ContactoDao.getIntanciaContactoDao().traer(idContacto);
		return c;
	}

	public int agregar(String email, String movil, String fijo, Cliente cliente) throws Exception {
		Contacto c = new Contacto(email, movil, fijo, cliente);
		if(traer(cliente.getIdCliente())!=null) throw new Exception("ERROR Ya existe el contacto");
		return ContactoDao.getIntanciaContactoDao().agregar(c);
	}

	public void modificar(Contacto c) {
		ContactoDao.getIntanciaContactoDao().actualizar(c);
	}

	public void eliminar(long idContacto) {
		Contacto c = ContactoDao.getIntanciaContactoDao().traer(idContacto);
		ContactoDao.getIntanciaContactoDao().eliminar(c);
	}
}