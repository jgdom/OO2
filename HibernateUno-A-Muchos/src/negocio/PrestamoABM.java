package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) {
//Implementar: si el no existe el prestamo lanzar la excepci�n
		Prestamo p = dao.traer(idPrestamo);
		return p;
	}

public List<Prestamo> traerPrestamo(Cliente c) {
	return dao.traer(c);
	}


public int agregarPrestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception{
	
	Prestamo p = new Prestamo(fecha,monto,interes,cantCuotas,cliente);
	return dao.agregar(p);
	}
public void modificarPrestamo(Prestamo p) {
	 dao.actualizar(p);
}

public void eliminarPrestamo(Prestamo p) {
	dao.eliminar(p);
}

}