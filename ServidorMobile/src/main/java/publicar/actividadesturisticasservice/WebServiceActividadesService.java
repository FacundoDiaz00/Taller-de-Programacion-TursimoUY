
package publicar.actividadesturisticasservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceActividadesService", targetNamespace = "http://actividadesTuristicasService.publicar/", wsdlLocation = "http://localhost:5558/webservices/actividades?wsdl")
public class WebServiceActividadesService
    extends Service
{

    private final static URL WEBSERVICEACTIVIDADESSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEACTIVIDADESSERVICE_EXCEPTION;
    private final static QName WEBSERVICEACTIVIDADESSERVICE_QNAME = new QName("http://actividadesTuristicasService.publicar/", "WebServiceActividadesService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:5558/webservices/actividades?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEACTIVIDADESSERVICE_WSDL_LOCATION = url;
        WEBSERVICEACTIVIDADESSERVICE_EXCEPTION = e;
    }

    public WebServiceActividadesService() {
        super(__getWsdlLocation(), WEBSERVICEACTIVIDADESSERVICE_QNAME);
    }

    public WebServiceActividadesService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEACTIVIDADESSERVICE_QNAME, features);
    }

    public WebServiceActividadesService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEACTIVIDADESSERVICE_QNAME);
    }

    public WebServiceActividadesService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEACTIVIDADESSERVICE_QNAME, features);
    }

    public WebServiceActividadesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceActividadesService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceActividades
     */
    @WebEndpoint(name = "WebServiceActividadesPort")
    public WebServiceActividades getWebServiceActividadesPort() {
        return super.getPort(new QName("http://actividadesTuristicasService.publicar/", "WebServiceActividadesPort"), WebServiceActividades.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceActividades
     */
    @WebEndpoint(name = "WebServiceActividadesPort")
    public WebServiceActividades getWebServiceActividadesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://actividadesTuristicasService.publicar/", "WebServiceActividadesPort"), WebServiceActividades.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEACTIVIDADESSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEACTIVIDADESSERVICE_EXCEPTION;
        }
        return WEBSERVICEACTIVIDADESSERVICE_WSDL_LOCATION;
    }

}
