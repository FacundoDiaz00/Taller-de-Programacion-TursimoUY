
package publicar.usuarioturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "ModificacionUsuarioNoPermitida", targetNamespace = "http://usuarioturisticasservice.publicar/")
public class ModificacionUsuarioNoPermitida_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ModificacionUsuarioNoPermitida faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ModificacionUsuarioNoPermitida_Exception(String message, ModificacionUsuarioNoPermitida faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public ModificacionUsuarioNoPermitida_Exception(String message, ModificacionUsuarioNoPermitida faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicar.usuarioturisticasservice.ModificacionUsuarioNoPermitida
     */
    public ModificacionUsuarioNoPermitida getFaultInfo() {
        return faultInfo;
    }

}
