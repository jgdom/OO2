package negocio;
import java.time.LocalDate;
import  java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	private static ClienteABM instanciaClienteABM;
	//
	protected ClienteABM() {
		this.inicializar();
	}
	
	public static ClienteABM getIntanciaClienteABM() {
		if(instanciaClienteABM==null) {
			instanciaClienteABM=new ClienteABM();
		}
		return instanciaClienteABM;
	}
	
	private void inicializar() {}
	
	public Cliente traer(long idCliente) throws Exception {
		Cliente c= ClienteDao.getIntanciaClienteDao().traer(idCliente);
		if(c==null) throw new Exception("ERROR no existe el cliente con id: "+ idCliente);
		return c;
	}
	
	public Cliente traer(int dni) throws Exception {
		Cliente c=ClienteDao.getIntanciaClienteDao().traer(dni);
		//if(c==null) throw new Exception("ERROR no existe el cliente con dni: "+ dni);
		return c;
	}
	
	public int agregar(String apellido,String nombre, int dni,LocalDate fechaDeNacimiento) throws Exception{
		//if(traerCliente(dni)!=null) throw new Exception("ERROR ya existe el cliente con dni: "+dni);
		Cliente c=new Cliente(apellido,nombre,dni,fechaDeNacimiento);
		return ClienteDao.getIntanciaClienteDao().agregar(c);
	}
	
	public void modificar(Cliente c) throws Exception{
		//if(traerCliente(c.getDni()).getDni()==c.getDni()) throw new Exception("Ya existe el cliente con dni: "+c.getDni());
		if(traer(c.getIdCliente()).getIdCliente()==c.getIdCliente()) throw new Exception("Ya existe el cliente con id: "+c.getIdCliente());
		ClienteDao.getIntanciaClienteDao().actualizar(c);
	}
	
	public void eliminar(long idCliente) {
		Cliente c=ClienteDao.getIntanciaClienteDao().traer(idCliente);
		ClienteDao.getIntanciaClienteDao().eliminar(c);
	}
	
	public List<Cliente>traerCliente(){return ClienteDao.getIntanciaClienteDao().traer();
	}

	public Cliente traerClienteYContacto(long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}
}
