
package publicar.paqueteturisticasservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "WebServicePaquetesService", targetNamespace = "http://paqueteTuristicasService.publicar/", wsdlLocation = "http://localhost:5558/webservices/paquetes?wsdl")
public class WebServicePaquetesService
    extends Service
{

    private final static URL WEBSERVICEPAQUETESSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEPAQUETESSERVICE_EXCEPTION;
    private final static QName WEBSERVICEPAQUETESSERVICE_QNAME = new QName("http://paqueteTuristicasService.publicar/", "WebServicePaquetesService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:5558/webservices/paquetes?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEPAQUETESSERVICE_WSDL_LOCATION = url;
        WEBSERVICEPAQUETESSERVICE_EXCEPTION = e;
    }

    public WebServicePaquetesService() {
        super(__getWsdlLocation(), WEBSERVICEPAQUETESSERVICE_QNAME);
    }

    public WebServicePaquetesService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEPAQUETESSERVICE_QNAME, features);
    }

    public WebServicePaquetesService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEPAQUETESSERVICE_QNAME);
    }

    public WebServicePaquetesService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEPAQUETESSERVICE_QNAME, features);
    }

    public WebServicePaquetesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicePaquetesService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicePaquetes
     */
    @WebEndpoint(name = "WebServicePaquetesPort")
    public WebServicePaquetes getWebServicePaquetesPort() {
        return super.getPort(new QName("http://paqueteTuristicasService.publicar/", "WebServicePaquetesPort"), WebServicePaquetes.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicePaquetes
     */
    @WebEndpoint(name = "WebServicePaquetesPort")
    public WebServicePaquetes getWebServicePaquetesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://paqueteTuristicasService.publicar/", "WebServicePaquetesPort"), WebServicePaquetes.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEPAQUETESSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEPAQUETESSERVICE_EXCEPTION;
        }
        return WEBSERVICEPAQUETESSERVICE_WSDL_LOCATION;
    }

}
