
package logica.datatypes;

/**
 * @author Equipo taller prog 16
 */

public class Imagen {
	private String path;
	private String altText;

	public Imagen(String path) {
		this.path = path;
		this.altText = null;
	}

	public Imagen(String path, String altText) {
		this.path = path;
		this.altText = altText;
	}

	public String getPath() {
		return path;
	}

	public String getAltText() {
		return altText;
	}
}