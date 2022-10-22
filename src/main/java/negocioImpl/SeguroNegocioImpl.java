package negocioImpl;

import java.util.List;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;
import entidad.Seguro;
import negocio.SeguroNegocio;


public class SeguroNegocioImpl implements SeguroNegocio{

SeguroDao pdao = new SeguroDaoImpl();
	
	@Override
	public boolean insert(Seguro seguro) {
		
		boolean estado=false;
		if(seguro.getIdSeguro()>-1 && seguro.getDescripcion().trim().length()>0  &&
		   seguro.getIdTipo()>-1  && seguro.getCostoContratacion()>0  && seguro.getCostoAsegurado()>0 )
		{
			estado=pdao.insert(seguro);
		}
		return estado;
	}
	
	@Override
	public boolean update(Seguro seguro) {
		
		boolean estado=false;
		if(seguro.getIdSeguro()>-1 && seguro.getDescripcion().trim().length()>0  &&
		   seguro.getIdTipo()>-1  && seguro.getCostoContratacion()>0  && seguro.getCostoAsegurado()>0 )
		{
			estado=pdao.update(seguro);
		}
		return estado;
	}
	
	@Override
	public boolean delete(Seguro persona_a_eliminar) {
		boolean estado=false;
		try
		{
			if( persona_a_eliminar.getIdSeguro()  > 0 )
			{
				estado=pdao.delete(persona_a_eliminar);
			}
		}
		catch(Exception e) {
            e.printStackTrace();
}
		return estado;
	}

	@Override
	public List<Seguro> readAll() {
		
		List<Seguro> lSeguro;
		lSeguro = pdao.readAll();
		return lSeguro;
	}
	
	public boolean isNumber(String cadena) {
		boolean isNumber = true;
		
		for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                isNumber = false;
            }
        }
		return isNumber;
	}
	

}

