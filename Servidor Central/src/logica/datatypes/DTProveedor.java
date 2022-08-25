package logica.datatypes;

import java.time.LocalDate;

/**
 * @author Equipo taller prog 16
 */

public class DTProveedor extends DTUsuario {

    private String descrpicionGeneral;
    private String link;

    public DTProveedor(String nickname, String nombre, String apellido, String correo, LocalDate fechaNac,
            String descrpicionGeneral, String link) {
        super(nickname, nombre, apellido, correo, fechaNac);
        this.descrpicionGeneral = descrpicionGeneral;
        this.link = link;
    }

    public String getDescrpicionGeneral() {
        return descrpicionGeneral;
    }

    public String getLink() {
        return link;
    }

}
