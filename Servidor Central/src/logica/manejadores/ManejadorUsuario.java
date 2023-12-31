package logica.manejadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excepciones.ObjetoNoExisteEnTurismoUy;
import logica.entidades.Usuario;

/**
 * @author Equipo taller prog 16
 */

public class ManejadorUsuario {
	private static ManejadorUsuario instancia;

	private Map<String, Usuario> usuariosPorNick;
	private Map<String, Usuario> usuariosPorCorreo;

	private ManejadorUsuario() {
		usuariosPorCorreo = new HashMap<String, Usuario>();
		usuariosPorNick = new HashMap<String, Usuario>();
	}

	public static ManejadorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorUsuario();
		}
		return instancia;
	}

	public List<Usuario> getUsuarios() {
		return new ArrayList<Usuario>(usuariosPorNick.values());
	}

	public Set<String> obtenerCorreoUsuarios() {
		return usuariosPorCorreo.keySet();
	}

	public Set<String> obtenerNickUsuarios() {
		return usuariosPorNick.keySet();
	}

	public void addUsuario(Usuario usuario) {
		usuariosPorNick.put(usuario.getNickname(), usuario);
		usuariosPorCorreo.put(usuario.getCorreo(), usuario);
	}

	public Usuario getUsuarioPorNick(String nickname) throws ObjetoNoExisteEnTurismoUy {
		if (usuariosPorNick.containsKey(nickname))
			return usuariosPorNick.get(nickname);
		else {
			throw new ObjetoNoExisteEnTurismoUy(Usuario.class);
		}
	}

	public Usuario getUsuarioPorCorreo(String correo) throws ObjetoNoExisteEnTurismoUy {
		if (usuariosPorCorreo.containsKey(correo))
			return usuariosPorCorreo.get(correo);
		else {
			throw new ObjetoNoExisteEnTurismoUy(Usuario.class);
		}

	}

	public boolean existeUsuario(String nickname, String correo) {
		return usuariosPorNick.containsKey(nickname) || usuariosPorCorreo.containsKey(correo);
	}

}
