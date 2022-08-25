package logica.datatypes;

import java.time.LocalDate;

/**
 * @author Equipo taller prog 16
 */

public class DTUsuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private LocalDate fechaNac;

    public DTUsuario(String nickname, String nombre, String apellido, String correo, LocalDate fechaNac) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

}
