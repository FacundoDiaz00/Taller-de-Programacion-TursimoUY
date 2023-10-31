
package publicar.actividadesturisticasservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "WebServiceActividades", targetNamespace = "http://actividadesturisticasservice.publicar/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    publicar.actividadesturisticasservice.ObjectFactory.class,
    net.java.dev.jaxb.array.ObjectFactory.class
})
public interface WebServiceActividades {


    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdDepartamentosRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdDepartamentosResponse")
    public StringArray obtenerIdDepartamentos();

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg10
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @throws ActividadTuristicaYaRegistradaException_Exception
     * @throws ErrorAlProcesar_Exception
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaActividadTuristicaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaActividadTuristicaResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaActividadTuristica/Fault/ObjetoNoExisteEnTurismoUy"),
        @FaultAction(className = ActividadTuristicaYaRegistradaException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaActividadTuristica/Fault/ActividadTuristicaYaRegistradaException"),
        @FaultAction(className = ErrorAlProcesar_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaActividadTuristica/Fault/ErrorAlProcesar")
    })
    public void altaActividadTuristica(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        int arg4,
        @WebParam(name = "arg5", partName = "arg5")
        float arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        byte[] arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        StringArray arg9,
        @WebParam(name = "arg10", partName = "arg10")
        String arg10)
        throws ActividadTuristicaYaRegistradaException_Exception, ErrorAlProcesar_Exception, ObjetoNoExisteEnTurismoUy_Exception
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
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadTuristicaDetalleRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadTuristicaDetalleResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadTuristicaDetalle/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtActividadTuristicaDetalle obtenerDTActividadTuristicaDetalle(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdCategoriasRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdCategoriasResponse")
    public StringArray obtenerIdCategorias();

    /**
     * 
     * @return
     *     returns publicar.actividadesturisticasservice.DtMapActividadSalidaTuristicaCollection
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidasTuristicasRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidasTuristicasResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidasTuristicas/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtMapActividadSalidaTuristicaCollection obtenerDTSalidasTuristicas()
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @throws ActividadTuristicaNoAceptada_Exception
     * @throws ErrorAlProcesar_Exception
     * @throws FechaAltaActividadPosteriorAFechaAltaSalidaException_Exception
     * @throws FechaAltaSalidaPosteriorAFechaSalidaException_Exception
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     * @throws SalidaYaRegistradaException_Exception
     */
    @WebMethod
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristicaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristicaResponse", fault = {
        @FaultAction(className = FechaAltaSalidaPosteriorAFechaSalidaException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristica/Fault/FechaAltaSalidaPosteriorAFechaSalidaException"),
        @FaultAction(className = ActividadTuristicaNoAceptada_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristica/Fault/ActividadTuristicaNoAceptada"),
        @FaultAction(className = FechaAltaActividadPosteriorAFechaAltaSalidaException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristica/Fault/FechaAltaActividadPosteriorAFechaAltaSalidaException"),
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristica/Fault/ObjetoNoExisteEnTurismoUy"),
        @FaultAction(className = SalidaYaRegistradaException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristica/Fault/SalidaYaRegistradaException"),
        @FaultAction(className = ErrorAlProcesar_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaSalidaTuristica/Fault/ErrorAlProcesar")
    })
    public void altaSalidaTuristica(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        int arg4,
        @WebParam(name = "arg5", partName = "arg5")
        byte[] arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6)
        throws ActividadTuristicaNoAceptada_Exception, ErrorAlProcesar_Exception, FechaAltaActividadPosteriorAFechaAltaSalidaException_Exception, FechaAltaSalidaPosteriorAFechaSalidaException_Exception, ObjetoNoExisteEnTurismoUy_Exception, SalidaYaRegistradaException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns publicar.actividadesturisticasservice.DtSalidaTuristicaDetalle
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidaTuristicaDetalleRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidaTuristicaDetalleResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidaTuristicaDetalle/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtSalidaTuristicaDetalle obtenerDTSalidaTuristicaDetalle(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @throws AltaInscripcionPosteriorAFechaSalidaException_Exception
     * @throws CompraConConsumosInsuficientesExcepcion_Exception
     * @throws CompraPaqueteVencidoExcepcion_Exception
     * @throws FechaAltaSalidaTuristicaPosteriorAFechaInscripcion_Exception
     * @throws InscripcionYaRegistradaException_Exception
     * @throws NoExisteConsumoParaLaActividadExcepcion_Exception
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     * @throws PaqueteNoCompradoExcepcion_Exception
     * @throws SuperaElMaximoDeTuristasException_Exception
     */
    @WebMethod
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristicaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristicaResponse", fault = {
        @FaultAction(className = InscripcionYaRegistradaException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/InscripcionYaRegistradaException"),
        @FaultAction(className = SuperaElMaximoDeTuristasException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/SuperaElMaximoDeTuristasException"),
        @FaultAction(className = FechaAltaSalidaTuristicaPosteriorAFechaInscripcion_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/FechaAltaSalidaTuristicaPosteriorAFechaInscripcion"),
        @FaultAction(className = AltaInscripcionPosteriorAFechaSalidaException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/AltaInscripcionPosteriorAFechaSalidaException"),
        @FaultAction(className = CompraPaqueteVencidoExcepcion_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/CompraPaqueteVencidoExcepcion"),
        @FaultAction(className = CompraConConsumosInsuficientesExcepcion_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/CompraConConsumosInsuficientesExcepcion"),
        @FaultAction(className = PaqueteNoCompradoExcepcion_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/PaqueteNoCompradoExcepcion"),
        @FaultAction(className = NoExisteConsumoParaLaActividadExcepcion_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/NoExisteConsumoParaLaActividadExcepcion"),
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/altaInscripcionSalidaTuristica/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public void altaInscripcionSalidaTuristica(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3)
        throws AltaInscripcionPosteriorAFechaSalidaException_Exception, CompraConConsumosInsuficientesExcepcion_Exception, CompraPaqueteVencidoExcepcion_Exception, FechaAltaSalidaTuristicaPosteriorAFechaInscripcion_Exception, InscripcionYaRegistradaException_Exception, NoExisteConsumoParaLaActividadExcepcion_Exception, ObjetoNoExisteEnTurismoUy_Exception, PaqueteNoCompradoExcepcion_Exception, SuperaElMaximoDeTuristasException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdComprasDisponiblesParaInscripcionRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdComprasDisponiblesParaInscripcionResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerIdComprasDisponiblesParaInscripcion/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public StringArray obtenerIdComprasDisponiblesParaInscripcion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns publicar.actividadesturisticasservice.DtSalidaTuristica
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidaTuristicaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidaTuristicaResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTSalidaTuristica/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtSalidaTuristica obtenerDTSalidaTuristica(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns byte[]
     * @throws ErrorAlProcesar_Exception
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/getComprobanteInscripcionRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/getComprobanteInscripcionResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/getComprobanteInscripcion/Fault/ObjetoNoExisteEnTurismoUy"),
        @FaultAction(className = ErrorAlProcesar_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/getComprobanteInscripcion/Fault/ErrorAlProcesar")
    })
    public byte[] getComprobanteInscripcion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws ErrorAlProcesar_Exception, ObjetoNoExisteEnTurismoUy_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @throws TurismoUyException_Exception
     */
    @WebMethod
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/cambiarEstadoDeActividadTuristicaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/cambiarEstadoDeActividadTuristicaResponse", fault = {
        @FaultAction(className = TurismoUyException_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/cambiarEstadoDeActividadTuristica/Fault/TurismoUyException")
    })
    public void cambiarEstadoDeActividadTuristica(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        EstadoActividadTuristica arg1)
        throws TurismoUyException_Exception
    ;

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/incrementarContadorActividadRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/incrementarContadorActividadResponse")
    public void incrementarContadorActividad(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/incrementarContadorSalidaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/incrementarContadorSalidaResponse")
    public void incrementarContadorSalida(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicar.actividadesturisticasservice.DtActividadTuristicaCollection
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorDepartamentoRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorDepartamentoResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorDepartamento/Fault/ObjetoNoExisteEnTurismoUy")
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
     *     returns publicar.actividadesturisticasservice.DtActividadTuristicaCollection
     * @throws ObjetoNoExisteEnTurismoUy_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorCategoriaRequest", output = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorCategoriaResponse", fault = {
        @FaultAction(className = ObjetoNoExisteEnTurismoUy_Exception.class, value = "http://actividadesturisticasservice.publicar/WebServiceActividades/obtenerDTActividadesTuristicasConfirmadasPorCategoria/Fault/ObjetoNoExisteEnTurismoUy")
    })
    public DtActividadTuristicaCollection obtenerDTActividadesTuristicasConfirmadasPorCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ObjetoNoExisteEnTurismoUy_Exception
    ;

}
