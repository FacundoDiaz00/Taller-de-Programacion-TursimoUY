package logica.manejadores;

import java.util.Map;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;

import logica.entidades.Usuario;

/**
 * @author Equipo taller prog 16
 */

public class ManejadorUsuario {
    private static ManejadorUsuario instancia;

    private Map<String, Usuario> usuarios;
    
    private ManejadorUsuario() {
    	usuarios = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getInstancia(){
        if(instancia == null){
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }

    public List<String> obtenerIdUsuarios() {
        //todo Esto deberia estar en el controlador creo
    	var ret = new ArrayList<String>();
    	if (!usuarios.isEmpty()) {
    		ret = new ArrayList<>(usuarios.keySet());
    	} 
        return ret;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getNickname(), usuario);
    }

    public Usuario getUsuario(String nombre) {
        return usuarios.get(nombre);
    }
    
    public boolean existeUsuario(String nickname, String correo) {
        for (String key: usuarios.keySet()){
            System.out.println(key +" = coso key"+usuarios.get(key));
        }
        System.out.print("usuario existente: "+usuarios.containsKey(nickname));
    	return usuarios.containsKey(nickname) || (usuarios.get(nickname) != null && usuarios.get(nickname).getCorreo() == correo);
    }
    
}