package entidad;

public class Seguro {
	  
	//private static int nroId = 0;
	private int idSeguro; 
	private String descripcion; 
    private int idTipo; 
    private Double costoContratacion; 
    private Double costoAsegurado;
      
    /*static int proximoNroID() {
        return idSeguro + 1;
    }
    */
    public void setIdSeguro( int idSeguro) {
    	this.idSeguro = idSeguro;
    }
    public int getIdSeguro() {
 		return idSeguro;
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

 	public Double getCostoContratacion() {
 		return costoContratacion;
 	}

 	public void setCostoContratacion(Double costoContratacion) {
 		this.costoContratacion = costoContratacion;
 	}

 	public Double getCostoAsegurado() {
 		return costoAsegurado;
 	}

 	public void setCostoAsegurado(Double costoAsegurado) {
 		this.costoAsegurado = costoAsegurado;
 	}
    public Seguro() {  
    	//nroId ++;
    	//this.idSeguro = nroId;
        //this.descripcion = "";

    }

    public Seguro(int idSeguro, String descripcion, int idTipo, Double costoContratacion, Double costoAsegurado) {
        //nroId ++;
    	this.idSeguro = idSeguro;
        this.descripcion = descripcion;
        this.idTipo = idTipo;
        this.costoContratacion = costoContratacion;
        this.costoAsegurado = costoAsegurado;
    }
   

    @Override
    public String toString() {
       // return "Nombre: " + nombre + ", Apellido: "+ apellido + ", DNI: " + dni;
    	return   idSeguro + " - "+ descripcion + " - " + idTipo+ " - " + costoContratacion+" - "+costoAsegurado;
    }
    public String toString2() {
      return "idSeguro: " + idSeguro + ", descripcion: "+ descripcion + ", idTipo: " + idTipo+ ", costoContratacion: " + costoContratacion+ ", costoAsegurado: " + costoAsegurado;
     }
}
