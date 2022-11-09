
package publicar.actividadesturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "ObjetoNoExisteEnTurismoUy", targetNamespace = "http://actividadesTuristicasService.publicar/")
public class ObjetoNoExisteEnTurismoUy_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ObjetoNoExisteEnTurismoUy faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ObjetoNoExisteEnTurismoUy_Exception(String message, ObjetoNoExisteEnTurismoUy faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public ObjetoNoExisteEnTurismoUy_Exception(String message, ObjetoNoExisteEnTurismoUy faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicar.actividadesturisticasservice.ObjetoNoExisteEnTurismoUy
     */
    public ObjetoNoExisteEnTurismoUy getFaultInfo() {
        return faultInfo;
    }

}
