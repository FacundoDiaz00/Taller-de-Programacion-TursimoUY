
package publicar.actividadesturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "InscripcionYaRegistradaException", targetNamespace = "http://actividadesturisticasservice.publicar/")
public class InscripcionYaRegistradaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InscripcionYaRegistradaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InscripcionYaRegistradaException_Exception(String message, InscripcionYaRegistradaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public InscripcionYaRegistradaException_Exception(String message, InscripcionYaRegistradaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicar.actividadesturisticasservice.InscripcionYaRegistradaException
     */
    public InscripcionYaRegistradaException getFaultInfo() {
        return faultInfo;
    }

}
