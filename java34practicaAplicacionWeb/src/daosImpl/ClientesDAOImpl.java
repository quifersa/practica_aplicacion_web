package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import daos.ClientesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class ClientesDAOImpl extends GenericDAO implements ClientesDAO{

	@Override
	public void registrarCliente(Cliente cliente) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.INSERTAR_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setInt(3, cliente.getNumero());
			ps.setInt(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularEmpresa());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("La sql de inserción de cliente está mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		desconectar();
	}

	@Override
	public List<Cliente> obtenerClientes() {
		conectar();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQL.SELECCIONAR_CLIENTES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setCodigoPostal(rs.getInt("codigo_postal"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticularEmpresa(rs.getString("particular_empresa"));
				cliente.setId(rs.getInt("id"));
				clientes.add(cliente);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql select clientes está mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		desconectar();
		return clientes;
	}

	@Override
	public void borrarCliente(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error a la hora de borrar el cliente");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		desconectar();
	}

	@Override
	public Cliente obtenerClientePorId(int id) {
		Cliente cliente = new Cliente();
		conectar();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQL.OBTENER_CLIENTE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setCodigoPostal(rs.getInt("codigo_postal"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticularEmpresa(rs.getString("particular_empresa"));
				cliente.setId(rs.getInt("id"));
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("Seguramente la sql esté mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return cliente;
	}

	@Override
	public void guardarCambiosCliente(Cliente cliente) {
		conectar();
		try {
			PreparedStatement ps = 
					miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CLIENTE);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setInt(3, cliente.getNumero());
			ps.setInt(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularEmpresa());
			ps.setInt(9, cliente.getId());
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
