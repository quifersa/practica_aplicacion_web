package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Proveedor;
import daos.ProveedoresDAO;
import daosImpl.ProveedoresDAOImpl;


@WebServlet("/ServletRegistroProveedor")
public class ServletRegistroProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("admin") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		String nombreEmpresa = request.getParameter("campoNombreEmpresa");
		String direccion = request.getParameter("campoDireccion");
		String telefono = request.getParameter("campoTelefono");
		String correoElectronico = request.getParameter("campoEmail");
		String paginaWeb = request.getParameter("campoWeb");
		String nombreRepresentante = request.getParameter("campoNombreRepresentante");
		String telefonoRepresentante = request.getParameter("campoTelefonoRepresentante");
		String ambitoActividad = request.getParameter("campoAmbitoActividad");
		String certificadoMinisterioIndustria;
		if (request.getParameter("campoCertificado") == null){
			certificadoMinisterioIndustria = "No";
		}else {
			certificadoMinisterioIndustria = request.getParameter("campoCertificado");
		}
		System.out.println(request.getParameter("campoCertificado"));
		String estructuraJuridica = request.getParameter("campoEstructuraJuridica");
		
		// Validamos los datos
		String expresionRegularNombreEmpresa = "[a-zA-Z0-9.·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{1,70}";
		Pattern pattern1 = Pattern.compile(expresionRegularNombreEmpresa);
		Matcher matcher1 = pattern1.matcher(nombreEmpresa);
		if(matcher1.matches()){
			System.out.println("Nombre empresa v·lido");
		} else{
			System.out.println("Nombre empresa no v·lido");
			request.setAttribute("mensajeErrorNombreEmpresa", "Nombre empresa no v·lido");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularDireccion = "[a-zA-Z0-9.,·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{3,100}";
		Pattern pattern2 = Pattern.compile(expresionRegularDireccion);
		Matcher matcher2 = pattern2.matcher(direccion);
		if(matcher2.matches()){
			System.out.println("DirecciÛn v·lida");
		} else{
			System.out.println("DirecciÛn no v·lida");
			request.setAttribute("mensajeErrorDireccion", "DirecciÛn no v·lida");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularTelefono = "[0-9+]{9,30}";
		Pattern pattern3 = Pattern.compile(expresionRegularTelefono);
		Matcher matcher3 = pattern3.matcher(telefono);
		if(matcher3.matches()){
			System.out.println("TelÈfono v·lido");
		} else{
			System.out.println("TelÈfono no v·lido");
			request.setAttribute("mensajeErrorTelefono", "TelÈfono no v·lido");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularEmail = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—¸‹Á«0-9._+-]{1,70}@"
				+ "[a-zA-Z0-9]{1,30}\\.[a-zA-Z.]{2,20}";
		Pattern pattern4 = Pattern.compile(expresionRegularEmail);
		Matcher matcher4 = pattern4.matcher(correoElectronico);
		if(matcher4.matches()){
			System.out.println("Correo electrÛnico v·lido");
		} else{
			System.out.println("Correo electrÛnico no v·lido");
			request.setAttribute("mensajeErrorEmail", "Correo electrÛnico no v·lido");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularWeb = "[a-zA-Z0-9.·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{1,70}"
				+ "\\.[a-zA-Z0-9.·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{1,70}";
		Pattern pattern5 = Pattern.compile(expresionRegularWeb);
		Matcher matcher5 = pattern5.matcher(paginaWeb);
		if(matcher5.matches()){
			System.out.println("P·gina web v·lida");
		} else{
			System.out.println("P·gina web no v·lida");
			request.setAttribute("mensajeErrorWeb", "P·gina web no v·lida");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularNombreRepresentante = "[a-zA-Z.·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{1,50}";
		Pattern pattern6 = Pattern.compile(expresionRegularNombreRepresentante);
		Matcher matcher6 = pattern6.matcher(nombreRepresentante);
		if(matcher6.matches()){
			System.out.println("Nombre representante v·lido");
		} else{
			System.out.println("Nombre representante no v·lido");
			request.setAttribute("mensajeErrorNombreRepresentante", 
					"Nombre representante no v·lido");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularTelefonoRepresentante= "[0-9+]{9,30}";
		Pattern pattern7 = Pattern.compile(expresionRegularTelefonoRepresentante);
		Matcher matcher7 = pattern7.matcher(telefonoRepresentante);
		if(matcher7.matches()){
			System.out.println("TelÈfono representante v·lido");
		} else{
			System.out.println("TelÈfono representante no v·lido");
			request.setAttribute("mensajeErrorTelefonoRepresentante", 
					"TelÈfono representante no v·lido");
			request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
			return;
		}	
		// Fin validaciÛn
		
		Proveedor nuevoProveedor = new Proveedor(nombreEmpresa, direccion, telefono, 
				correoElectronico, paginaWeb, nombreRepresentante, telefonoRepresentante, 
				ambitoActividad, certificadoMinisterioIndustria, estructuraJuridica);
		System.out.println("Vamos a registrar: " + nuevoProveedor.toString());
		
		ProveedoresDAO proveedoresDAO = new ProveedoresDAOImpl();
		proveedoresDAO.registrarProveedor(nuevoProveedor);
		
		request.getRequestDispatcher("registroProveedorOK.jsp").forward(request, response);
	}

}
