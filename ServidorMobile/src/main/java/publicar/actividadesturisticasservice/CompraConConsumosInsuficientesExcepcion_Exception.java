
package publicar.actividadesturisticasservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "CompraConConsumosInsuficientesExcepcion", targetNamespace = "http://actividadesTuristicasService.publicar/")
public class CompraConConsumosInsuficientesExcepcion_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CompraConConsumosInsuficientesExcepcion faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CompraConConsumosInsuficientesExcepcion_Exception(String message, CompraConConsumosInsuficientesExcepcion faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public CompraConConsumosInsuficientesExcepcion_Exception(String message, CompraConConsumosInsuficientesExcepcion faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicar.actividadesturisticasservice.CompraConConsumosInsuficientesExcepcion
     */
    public CompraConConsumosInsuficientesExcepcion getFaultInfo() {
        return faultInfo;
    }

}
