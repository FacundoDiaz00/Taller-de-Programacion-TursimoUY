
package publicar.actividadesturisticasservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "WebServiceActividades", targetNamespace = "http://actividadesTuristicasService.publicar/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceActividades {


    /**
     * 
     * @param arg0
     * @return
     *     returns publicar.actividadesturisticasservice.DtActividadTuristicaCollection
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorCategoriaRequest", output = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorCategoriaResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorCategoria/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtActividadTuristicaCollection obtenerDTActividadesTuristicasConfirmadasPorCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns publicar.actividadesturisticasservice.DtActividadTuristicaCollection
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorDepartamentoRequest", output = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorDepartamentoResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorDepartamento/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtActividadTuristicaCollection obtenerDTActividadesTuristicasConfirmadasPorDepartamento(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns publicar.actividadesturisticasservice.DtActividadTuristicaDetalle
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadTuristicaDetalleRequest", output = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadTuristicaDetalleResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerDTActividadTuristicaDetalle/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtActividadTuristicaDetalle obtenerDTActividadTuristicaDetalle(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @return
     *     returns publicar.actividadesturisticasservice.ListOfString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerIdDepartamentosRequest", output = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerIdDepartamentosResponse")
    public ListOfString obtenerIdDepartamentos();

    /**
     * 
     * @return
     *     returns publicar.actividadesturisticasservice.ListOfString
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerIdCategoriasRequest", output = "http://actividadesTuristicasService.publicar/WebServiceActividades/obtenerIdCategoriasResponse")
    public ListOfString obtenerIdCategorias();

}
