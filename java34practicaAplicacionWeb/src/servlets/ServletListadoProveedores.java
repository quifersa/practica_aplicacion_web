package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Proveedor;
import daos.ProveedoresDAO;
import daosImpl.ProveedoresDAOImpl;

@WebServlet("/ServletListadoProveedores")
public class ServletListadoProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("admin") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		ProveedoresDAO proveedoresDAO = new ProveedoresDAOImpl();
		List<Proveedor> proveedores = proveedoresDAO.obtenerProveedores();
		
		request.setAttribute("proveedores", proveedores);
		request.getRequestDispatcher("gestionProveedores.jsp").forward(request, response);
		
	}

}
