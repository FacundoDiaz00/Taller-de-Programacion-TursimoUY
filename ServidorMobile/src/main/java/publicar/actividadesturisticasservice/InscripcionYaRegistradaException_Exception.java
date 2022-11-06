
package publicar.actividadesturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InscripcionYaRegistradaException", targetNamespace = "http://actividadesTuristicasService.publicar/")
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
     * @param faultInfo
     * @param cause
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
