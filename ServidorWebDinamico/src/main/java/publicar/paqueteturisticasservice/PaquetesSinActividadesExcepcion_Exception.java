
package publicar.paqueteturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "PaquetesSinActividadesExcepcion", targetNamespace = "http://paqueteturisticasservice.publicar/")
public class PaquetesSinActividadesExcepcion_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private PaquetesSinActividadesExcepcion faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public PaquetesSinActividadesExcepcion_Exception(String message, PaquetesSinActividadesExcepcion faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public PaquetesSinActividadesExcepcion_Exception(String message, PaquetesSinActividadesExcepcion faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicar.paqueteturisticasservice.PaquetesSinActividadesExcepcion
     */
    public PaquetesSinActividadesExcepcion getFaultInfo() {
        return faultInfo;
    }

}