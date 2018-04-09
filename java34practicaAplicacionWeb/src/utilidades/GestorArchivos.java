package utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class GestorArchivos {

	private static final String CARPETA_SUBIDAS = "subidasAppWeb";
	
	public static String rutaArchivo (int id){
		
		String ruta = CARPETA_SUBIDAS + File.separator + id + ".jpg";
		// Como estamos trabajando en local, para ver los resultados debo dar rutas absolutas
		
		File f = new File(ruta);
		
		return f.getAbsolutePath();
		
	}
	
	public static void guardarArchivo(Part archivo, String ruta){
		
		File carpetaSubidas = new File(CARPETA_SUBIDAS);
		if (!carpetaSubidas.exists()) {
			carpetaSubidas.mkdir();
		}
		try {
			InputStream is = archivo.getInputStream();
			FileOutputStream fos = 	
					new FileOutputStream(CARPETA_SUBIDAS + File.separator + ruta);
			byte[] leidos = new byte[1024];
			while ((is.read(leidos)) != -1) {
				fos.write(leidos);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public static void borrarArchivo(String ruta){
		
		File archivoBorrar = new File(CARPETA_SUBIDAS + File.separator + ruta);

		archivoBorrar.delete();
		
	}
	
}
