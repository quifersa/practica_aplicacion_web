package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Proveedor;
import daos.ProveedoresDAO;
import daosImpl.ProveedoresDAOImpl;

@WebServlet("/ServletEditarProveedor")
@MultipartConfig
public class ServletEditarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("admin") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProveedoresDAO proveedoresDAO = new ProveedoresDAOImpl();
		Proveedor proveedorAEditar = proveedoresDAO.obtenerProveedorPorId(id);
		
		request.setAttribute("proveedorAEditar", proveedorAEditar);
		request.getRequestDispatcher("editarProveedor.jsp").forward(request, response);
		
	}

}
