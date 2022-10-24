package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;
import daoImpl.TipoSeguroDaoImpl;
import entidad.Seguro;

/**
 * Servlet implementation class ServletAgregarSeguro
 */
@WebServlet("/ServletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("getID") != null) 	{
		SeguroDaoImpl seguroDao = new SeguroDaoImpl();
		TipoSeguroDaoImpl Tpsd = new TipoSeguroDaoImpl();
		request.setAttribute("id", seguroDao.readLast()+1);
		request.setAttribute("TipoSeguros", Tpsd.readAll());
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
		}
		if(request.getParameter("btnAgregar") != null) 	{
			boolean agregado = false;
			int idSeguro= Integer.parseInt(request.getParameter("txtIdSeguro"));
			String descripcion= request.getParameter("txtDescripcion");
			if (!isNumber(descripcion) && isNumber(request.getParameter("txtCostoContratacion"))&& isNumber(request.getParameter("txtCostoAsegurado")))
			{
				double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
				double costoMaxAsegurado =Double.parseDouble(request.getParameter("txtCostoAsegurado"));
				int tipoSeguro=Integer.parseInt(request.getParameter("TipoSeguro"));
				Seguro seguro  =  new Seguro(idSeguro,descripcion,tipoSeguro,costoContratacion,costoMaxAsegurado);
				SeguroDao seguroDao = new SeguroDaoImpl();
				agregado = seguroDao.insert(seguro);
			}
			else
			{
				request.setAttribute("error", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
				rd.forward(request, response);
			}
			//REQUESTDISPATCHER
			if(agregado)
			{
				request.setAttribute("agregado", 1);
				RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
				rd.forward(request, response);
			}	       
		}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
