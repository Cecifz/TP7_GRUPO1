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
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("btnAgregar") != null) 	{
			boolean agregado = false;
			int idSeguro= Integer.parseInt(request.getParameter("txtIdSeguro"));
			String descripcion= request.getParameter("txtDescripcion");
			int tipoSeguro=Integer.parseInt(request.getParameter("txtTipoSeguro"));
			double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
			double costoMaxAsegurado =Double.parseDouble(request.getParameter("txtCostoAsegurado"));
			Seguro seguro  =  new Seguro(idSeguro,descripcion,tipoSeguro,costoContratacion,costoMaxAsegurado);
			SeguroDao seguroDao = new SeguroDaoImpl();
			agregado = seguroDao.insert(seguro);
			//REQUESTDISPATCHER
			request.setAttribute("filas", agregado);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
	        rd.forward(request, response);    
	       
		}
		
		if(request.getParameter("listar") != null) {
			SeguroDaoImpl seguroDao = new SeguroDaoImpl();
			ArrayList<Seguro> lista = (ArrayList<Seguro>)seguroDao.readAll();
			request.setAttribute("lista", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if(request.getParameter("readLast") != null) {
		   response.setContentType("text/html");
			PrintWriter out = response.getWriter();  
			SeguroDaoImpl seguroDao = new SeguroDaoImpl();
			int x = seguroDao.readLast();
			out.print("Id Seguro"+x);
			///request.setAttribute("last", x);
			
		//}
	}


}
