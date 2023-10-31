
package publicar.usuarioturisticasservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

import configuraciones.Cargador;
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
@WebServiceClient(name = "WebServiceUsuariosService", targetNamespace = "http://usuarioturisticasservice.publicar/", wsdlLocation = "CONFIO QUE NO IMPORTA")
public class WebServiceUsuariosService
    extends Service
{

    private final static URL WEBSERVICEUSUARIOSSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEUSUARIOSSERVICE_EXCEPTION;
    private final static QName WEBSERVICEUSUARIOSSERVICE_QNAME = new QName("http://usuarioturisticasservice.publicar/", "WebServiceUsuariosService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL(Cargador.getDirrecionDelCentral() + "/usuarios?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEUSUARIOSSERVICE_WSDL_LOCATION = url;
        WEBSERVICEUSUARIOSSERVICE_EXCEPTION = e;
    }

    public WebServiceUsuariosService() {
        super(__getWsdlLocation(), WEBSERVICEUSUARIOSSERVICE_QNAME);
    }

    public WebServiceUsuariosService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEUSUARIOSSERVICE_QNAME, features);
    }

    public WebServiceUsuariosService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEUSUARIOSSERVICE_QNAME);
    }

    public WebServiceUsuariosService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEUSUARIOSSERVICE_QNAME, features);
    }

    public WebServiceUsuariosService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceUsuariosService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceUsuarios
     */
    @WebEndpoint(name = "WebServiceUsuariosPort")
    public WebServiceUsuarios getWebServiceUsuariosPort() {
        return super.getPort(new QName("http://usuarioturisticasservice.publicar/", "WebServiceUsuariosPort"), WebServiceUsuarios.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceUsuarios
     */
    @WebEndpoint(name = "WebServiceUsuariosPort")
    public WebServiceUsuarios getWebServiceUsuariosPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://usuarioturisticasservice.publicar/", "WebServiceUsuariosPort"), WebServiceUsuarios.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEUSUARIOSSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEUSUARIOSSERVICE_EXCEPTION;
        }
        return WEBSERVICEUSUARIOSSERVICE_WSDL_LOCATION;
    }

}
