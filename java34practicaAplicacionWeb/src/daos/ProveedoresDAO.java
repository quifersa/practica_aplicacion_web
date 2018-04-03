package daos;

import java.util.List;

import modelo.Proveedor;

public interface ProveedoresDAO {

	void registrarProveedor(Proveedor proveedor);
	List<Proveedor> obtenerProveedores ();
	void borrarProveedor(int id);
	Proveedor obtenerProveedorPorId(int id);
	void guardarCambiosProveedor (Proveedor proveedor);
	
}
