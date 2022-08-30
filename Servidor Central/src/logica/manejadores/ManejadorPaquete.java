package logica.manejadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import logica.entidades.Paquete;
import logica.entidades.Usuario;

/**
 * @author Equipo taller prog 16
 */

public class ManejadorPaquete {
    private static ManejadorPaquete instancia;

    private Map<String, Paquete> paquetes;
    private ManejadorPaquete() {
    	paquetes = new HashMap<>();
    }
    public static ManejadorPaquete getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorPaquete();
        }
        return instancia;
    }

    public List<Paquete> getPaquetes() {
        return new ArrayList<Paquete>(paquetes.values());
    }

    public Set<String> obtenerIdPaquetes() {
        return paquetes.keySet();
    }

    public void addPaquete(Paquete paquete) {
        paquetes.put(paquete.getNombre(), paquete);
    }

    public Paquete getPaquete(String nombre) {
        return paquetes.get(nombre);
    }

	public boolean existePaquete(String nombre) {
		return (paquetes.containsKey(nombre));
	}

}