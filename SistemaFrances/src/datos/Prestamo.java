package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Prestamo {
	
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;
	private Set<Cuota> cuotas;
	
	public Prestamo() {}

	public Prestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		this.cuotas = this.setCuotas();
	}
	
	protected Set<Cuota> setCuotas(){
		Set<Cuota> objeto = new HashSet<Cuota>();
		
		for(int i=0; i<this.cantCuotas;i++) {
			Cuota c = new Cuota(i+1,fecha,monto,this);
			objeto.add(c);
		}
		return objeto;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    public String toString() {
    	String prestamo = "Prestamo:$ " + monto + "\nFecha: " + fecha + "\nInteres: " + interes + "\nCant. de Cuotas: " + cantCuotas;
    	return prestamo;
    }
	
    public Set<Cuota> getCuotas(){
    	return cuotas;
    }
    
    public void setCuotas(Set<Cuota> cuotas) {
    	this.cuotas = cuotas;
    }
   
	

}
