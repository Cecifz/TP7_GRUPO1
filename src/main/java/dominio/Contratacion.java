package dominio;

import java.math.BigDecimal;

public class Contratacion {

	private int idContratacion;
	private String nombreUsuario;
	private int idSeguro;
	private BigDecimal costoContratacion;
	
	public Contratacion() { }

	public Contratacion(int idContratacion, String nombreUsuario, int idSeguro, BigDecimal costoContratacion) {
		this.idContratacion = idContratacion;
		this.nombreUsuario = nombreUsuario;
		this.idSeguro = idSeguro;
		this.costoContratacion = costoContratacion;
	}

	public int getIdContratacion() {
		return idContratacion;
	}

	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public BigDecimal getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(BigDecimal costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	@Override
	public String toString() {
		return "Contratacion [idContratacion=" + idContratacion + ", nombreUsuario=" + nombreUsuario + ", idSeguro="
				+ idSeguro + ", costoContratacion=" + costoContratacion + "]";
	}	
		
}
