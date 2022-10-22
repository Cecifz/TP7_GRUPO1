package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;
import entidad.Seguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean agregado = false;
		if(request.getParameter("btnAgregar") != null) 	{
			Seguro seguro  =  new Seguro();
			seguro.setIdSeguro(Integer.parseInt(request.getParameter("txtIdSeguro")));
			seguro.setDescripcion(request.getParameter("txtDescripcion"));
			seguro.setIdTipo(Integer.parseInt(request.getParameter("txtTipoSeguro")));
			seguro.setCostoContratacion(Double.parseDouble(request.getParameter("txtCostoContratacion")));
			seguro.setCostoAsegurado(Double.parseDouble(request.getParameter("txtCostoAsegurado")));
			
			SeguroDao seguroDao = new SeguroDaoImpl();
			agregado = seguroDao.insert(seguro);
			//REQUESTDISPATCHER
			request.setAttribute("filas", agregado);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
	        rd.forward(request, response);    
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
