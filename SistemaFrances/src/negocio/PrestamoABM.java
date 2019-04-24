package negocio;

import dao.PrestamoDao;
import java.util.List;
import java.time.LocalDate;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	
	private PrestamoDao dao = PrestamoDao.getInstancia();
	private static PrestamoABM instanciaABM;
	
	public static PrestamoABM getInstancia() {
		if(instanciaABM == null) {
			instanciaABM = new PrestamoABM();
		}
		return instanciaABM;
	}
	
	public Prestamo traerPrestamo(long idPrestamo) {
		Prestamo p = dao.traer(idPrestamo);
		return p;
	}
	
	public List<Prestamo> traerPrestamo(Cliente c){
		return dao.traer(c);
	}
	
	public int agregarPrestamo(LocalDate fecha,double monto,double interes,int cantCuotas,Cliente c) {
		Prestamo p = new Prestamo(fecha,monto,interes,cantCuotas,c);
		return dao.agregar(p);
	}
	
	public void actualizar(Prestamo p) {
		dao.actualizar(p);
	}
	
	public void eliminarPrestamo(Prestamo p) {
		dao.eliminar(p);
	}
	
	public Prestamo traerPrestamoYCuota(long idPrestamo) {
		return dao.traerPrestamoYCuota(idPrestamo);
	}

}
