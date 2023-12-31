
package publicar.maestroservices;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtInscripcion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fechaInscripcionStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="cantidadTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="salida" type="{http://maestroservices.publicar/}dtSalidaTuristica" minOccurs="0"/>
 *         <element name="turista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="compra" type="{http://maestroservices.publicar/}dtCompra" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInscripcion", propOrder = {
    "fechaInscripcionStr",
    "cantidadTuristas",
    "costo",
    "salida",
    "turista",
    "compra"
})
public class DtInscripcion {

    protected String fechaInscripcionStr;
    protected int cantidadTuristas;
    protected float costo;
    protected DtSalidaTuristica salida;
    protected String turista;
    protected DtCompra compra;

    /**
     * Obtiene el valor de la propiedad fechaInscripcionStr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInscripcionStr() {
        return fechaInscripcionStr;
    }

    /**
     * Define el valor de la propiedad fechaInscripcionStr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInscripcionStr(String value) {
        this.fechaInscripcionStr = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadTuristas.
     * 
     */
    public int getCantidadTuristas() {
        return cantidadTuristas;
    }

    /**
     * Define el valor de la propiedad cantidadTuristas.
     * 
     */
    public void setCantidadTuristas(int value) {
        this.cantidadTuristas = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad salida.
     * 
     * @return
     *     possible object is
     *     {@link DtSalidaTuristica }
     *     
     */
    public DtSalidaTuristica getSalida() {
        return salida;
    }

    /**
     * Define el valor de la propiedad salida.
     * 
     * @param value
     *     allowed object is
     *     {@link DtSalidaTuristica }
     *     
     */
    public void setSalida(DtSalidaTuristica value) {
        this.salida = value;
    }

    /**
     * Obtiene el valor de la propiedad turista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTurista() {
        return turista;
    }

    /**
     * Define el valor de la propiedad turista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTurista(String value) {
        this.turista = value;
    }

    /**
     * Obtiene el valor de la propiedad compra.
     * 
     * @return
     *     possible object is
     *     {@link DtCompra }
     *     
     */
    public DtCompra getCompra() {
        return compra;
    }

    /**
     * Define el valor de la propiedad compra.
     * 
     * @param value
     *     allowed object is
     *     {@link DtCompra }
     *     
     */
    public void setCompra(DtCompra value) {
        this.compra = value;
    }

}
