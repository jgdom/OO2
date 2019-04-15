package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	private static ClienteABM intanciaClienteABM;
	protected ClienteABM() {
		this.inicializar();
	}
	
	public static ClienteABM getIntanciaClienteABM() {
		if(intanciaClienteABM==null) {
			intanciaClienteABM=new ClienteABM();
		}
		return intanciaClienteABM;
	}
	
	private void inicializar() {}
	public Cliente traer(long idCliente) {
		Cliente c = ClienteDao.getIntanciaClienteDao().traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = ClienteDao.getIntanciaClienteDao().traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		if(traer(dni) != null) throw new Exception("ya existe el cliente");
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return ClienteDao.getIntanciaClienteDao().agregar(c);
	}

	public void modificar(Cliente c) throws Exception{
		
		if(traer(c.getDni()) != null) throw new Exception("ya existe en la bd este dni");
		ClienteDao.getIntanciaClienteDao().actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
		if(traer(idCliente) == null) throw new Exception("no existe el cliente a modificar");
		Cliente c = ClienteDao.getIntanciaClienteDao().traer(idCliente);
		ClienteDao.getIntanciaClienteDao().eliminar(c);
	}

	public List<Cliente> traer() {
		return ClienteDao.getIntanciaClienteDao().traer();
	}

	public Cliente traerClienteYPrestamos(long idCliente) {
		return ClienteDao.getIntanciaClienteDao().traerClienteYPrestamos(idCliente);
	}
}