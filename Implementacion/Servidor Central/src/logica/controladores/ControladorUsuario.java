package logica.controladores;
import logica.manejadores.ManejadorUsuario;
import logica.entidades.Turista;
import java.time.LocalDate;
import java.util.ArrayList;
import logica.entidades.Proveedor;

import java.util.List;

import logica.datatypes.DTUsuario;
import logica.entidades.Usuario;
import logica.manejadores.ManejadorUsuario;

/**
 * @author Equipo taller prog 16
 */
public class ControladorUsuario implements IControladorUsuario {

    public List<String> obtenerIdUsuarios() {
        ManejadorUsuario ins = ManejadorUsuario.getInstancia();
        return ins.obtenerIdUsuarios();
    }
	
    public Boolean altaTurista(String nickname, String nombre, String apellido, String correo,LocalDate FNacimiento, String nacionalidad){
        ManejadorUsuario mu = ManejadorUsuario.getInstancia();
        if(mu.existeUsuario(nickname)) {
            //throw new UsuarioRepetidoException("El usuario " + ci + " ya esta registrado");
        	return false;
        }

        Turista u = new Turista(nickname, nombre, apellido, correo,FNacimiento,nacionalidad);
        mu.addUsuario(u);
        return true;
    }
    
    public Boolean altaProveedor(String nickname,String nombre,String apellido,String correo,String descripcion,String link, LocalDate FNacimiento){
        ManejadorUsuario mu = ManejadorUsuario.getInstancia();
        if(mu.existeUsuario(nickname)) {
            //throw new UsuarioRepetidoException("El usuario " + ci + " ya esta registrado");
        	return false;
        }

        Proveedor u = new Proveedor(nickname, nombre, apellido, correo,FNacimiento, descripcion, link);
        mu.addUsuario(u);
        return true;
    }

    public DTUsuario obtenerDTUsuario(String nickname) {
        ManejadorUsuario ins = ManejadorUsuario.getInstancia();
        Usuario u = ins.getUsuario(nickname);
        return u.getDTUsuario();
    }

}
