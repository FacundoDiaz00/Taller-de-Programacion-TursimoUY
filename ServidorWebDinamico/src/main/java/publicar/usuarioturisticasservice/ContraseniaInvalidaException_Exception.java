
package publicar.usuarioturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "ContraseniaInvalidaException", targetNamespace = "http://usuarioturisticasservice.publicar/")
public class ContraseniaInvalidaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ContraseniaInvalidaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ContraseniaInvalidaException_Exception(String message, ContraseniaInvalidaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public ContraseniaInvalidaException_Exception(String message, ContraseniaInvalidaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicar.usuarioturisticasservice.ContraseniaInvalidaException
     */
    public ContraseniaInvalidaException getFaultInfo() {
        return faultInfo;
    }

}
