package dominio;
import java.math.BigDecimal;

public class Seguro {

	private int idSeguro;
	private String descripcion;
	private int idTipo;
	private BigDecimal costoContratacion;
	private BigDecimal costoAsegurado;
	
	public Seguro() { }
	
	public Seguro(int idSeguro, String descripcion, int idTipo, BigDecimal costoContratacion,
			BigDecimal costoAsegurado) {
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public BigDecimal getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(BigDecimal costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public BigDecimal getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(BigDecimal costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + idTipo
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
	
	
	
	
}