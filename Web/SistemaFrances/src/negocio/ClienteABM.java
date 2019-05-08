package negocio;

import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import dao.ClienteDao;

public class ClienteABM {
	
	ClienteDao dao = ClienteDao.getInstanciaDao();
	private static ClienteABM instanciaABM;
	
	public static ClienteABM getInstancia() {
		if(instanciaABM == null) {
			instanciaABM = new ClienteABM();
		}
		return instanciaABM;
	}
	
	public Cliente traerCliente(long idCliente) {
		Cliente c = dao.traerCliente(idCliente);
		return c;
	}
	
	public Cliente traerCliente(int dni) {
		Cliente c = dao.traerCliente(dni);
		return c;
	}
	
	public int agregarCliente(String apellido,String nombre,int dni,LocalDate fechaDeNacimiento)throws Exception {
		if(dao.traerCliente(dni) != null)throw new Exception("ERROR ya existe cliente con dni: " + dni);
		Cliente c = new Cliente(apellido,nombre,dni,fechaDeNacimiento);
		return dao.agregar(c);
	}
	
	public void modificarCliente(Cliente c) throws Exception{
		if(dao.traerCliente(c.getDni())!= null)throw new Exception("ERROR no se pudo modificar cliente");
		dao.actualizar(c);
	}
	
	public void eliminarCliente(Cliente c)throws Exception {
		if(dao.traerCliente(c.getDni()) == null)throw new Exception("ERROR no se pudo eliminar cliente");
		dao.eliminar(c);
	}
	
	public List<Cliente> traerClientes(){
		return dao.traerCliente();
	}
	
	public Cliente traerClienteYPrestamo(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}
	
	public List<Cliente> traerClienteTodo() {
		return dao.traerClienteTodo();
	}

}
