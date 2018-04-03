package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Proveedor;
import daos.ProveedoresDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class ProveedoresDAOImpl extends GenericDAO implements ProveedoresDAO{
	
	@Override
	public void registrarProveedor(Proveedor proveedor) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.INSERTAR_PROVEEDOR);
			
			ps.setString(1, proveedor.getNombreEmpresa());
			ps.setString(2, proveedor.getDireccion());
			ps.setString(3, proveedor.getTelefono());
			ps.setString(4, proveedor.getCorreoElectronico());
			ps.setString(5, proveedor.getPaginaWeb());
			ps.setString(6, proveedor.getNombreRepresentante());
			ps.setString(7, proveedor.getTelefonoRepresentante());
			ps.setString(8, proveedor.getAmbitoActividad());
			ps.setString(9, proveedor.getCertificadoMinisterioIndustria());
			ps.setString(10, proveedor.getEstructuraJuridica());

			ps.execute();
			ps.close();
			
			System.out.println("El proveedor se ha registrado correctamente");
		} catch (SQLException e) {
			System.out.println("La sql de inserción de proveedor está mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Proveedor> obtenerProveedores() {
		conectar();
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQL.SELECCIONAR_PROVEEDORES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Proveedor proveedor = new Proveedor();
				proveedor.setNombreEmpresa(rs.getString("nombre_empresa"));
				proveedor.setDireccion(rs.getString("direccion"));
				proveedor.setTelefono(rs.getString("telefono"));
				proveedor.setCorreoElectronico(rs.getString("email"));
				proveedor.setPaginaWeb(rs.getString("web"));
				proveedor.setNombreRepresentante(rs.getString("nombre_representante"));
				proveedor.setTelefonoRepresentante(rs.getString("telefono_representante"));
				proveedor.setAmbitoActividad(rs.getString("ambito_actividad"));
				proveedor.setCertificadoMinisterioIndustria(rs.getString
						("certificado_ministerio_industria"));
				proveedor.setEstructuraJuridica(rs.getString("estructura_juridica"));
				proveedor.setId(rs.getInt("id"));
				proveedores.add(proveedor);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql select proveedores está mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		desconectar();
		return proveedores;
	}
	

	@Override
	public void borrarProveedor(int id) {
		conectar();
	    try {
		   PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_PROVEEDOR);
		   ps.setInt(1, id);
		   ps.execute();
		   ps.close();
		} catch (SQLException e) {
		   System.out.println("La sql de borrado está mal");
	       System.out.println(e.getMessage());// Para sacar un poco más de información del error
		   e.printStackTrace();
		}
	    desconectar();
	}

	@Override
	public Proveedor obtenerProveedorPorId(int id) {
		Proveedor proveedor = new Proveedor();
		conectar();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQL.OBTENER_PROVEEDOR_POR_ID);
			ps.setInt(1, id);
			// Para sql tipo select debo usar el método executeQuery
			ResultSet resultado = ps.executeQuery();
			/* next pasa al siguiente resultado de la base de datos que aún no
			  hemos procesado, si no hay ningún resultado más devuelve false */
			if (resultado.next()) {
				// Nombre de la columna de la tabla en el get String
				proveedor.setNombreEmpresa(resultado.getString("nombre_empresa"));
				proveedor.setDireccion(resultado.getString("direccion"));
				proveedor.setTelefono(resultado.getString("telefono"));
				proveedor.setCorreoElectronico(resultado.getString("email"));
				proveedor.setPaginaWeb(resultado.getString("web"));
				proveedor.setNombreRepresentante(resultado.getString("nombre_representante"));
				proveedor.setTelefonoRepresentante(resultado.getString
						("telefono_representante"));
				proveedor.setAmbitoActividad(resultado.getString("ambito_actividad"));
				proveedor.setCertificadoMinisterioIndustria(resultado.getString
						("certificado_ministerio_industria"));
				proveedor.setEstructuraJuridica(resultado.getString("estructura_juridica"));
				proveedor.setId(resultado.getInt("id"));
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("Seguramente la sql esté mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		desconectar();
		return proveedor;
	}
	
	@Override
	public void guardarCambiosProveedor(Proveedor proveedor) {
		conectar();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_PROVEEDOR);
			ps.setString(1, proveedor.getNombreEmpresa());
			ps.setString(2, proveedor.getDireccion());
			ps.setString(3, proveedor.getTelefono());
			ps.setString(4, proveedor.getCorreoElectronico());
			ps.setString(5, proveedor.getPaginaWeb());
			ps.setString(6, proveedor.getNombreRepresentante());
			ps.setString(7, proveedor.getTelefonoRepresentante());
			ps.setString(8, proveedor.getAmbitoActividad());
			ps.setString(9, proveedor.getCertificadoMinisterioIndustria());
			ps.setString(10, proveedor.getEstructuraJuridica());
			ps.setInt(11, proveedor.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Posiblemente la sql de guardar cambios esté mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		desconectar();
	}
	
}
