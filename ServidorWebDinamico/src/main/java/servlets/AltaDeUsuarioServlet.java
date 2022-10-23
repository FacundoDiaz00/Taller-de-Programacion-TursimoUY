package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import excepciones.UsuarioYaRegistradoException;
import logica.controladores.Fabrica;
import logica.controladores.IControladorUsuario;
import logica.datatypes.Imagen;
import utils.Utiles;

/**
 * Servlet implementation class AltaDeUsuario
 */
@WebServlet("/AltaDeUsuario")
@MultipartConfig
public class AltaDeUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IControladorUsuario contUsuario;

    private final String tipoUsuarioProveedor = "proveedor";
    private final String tipoUsuarioTurista = "turista";

    public AltaDeUsuarioServlet() {
        super();
        this.contUsuario = Fabrica.getInstancia().getIControladorUsuario();
    }

    /**
     * parametros posibles: - tipo : Tipo de usuario a crear, puede ser
     * "turista" o "proveedor" - body: con la info del usuario a crear. Los
     * atributos son los siguientes: -
     * 
     */

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getCharacterEncoding() == null) {
            req.setCharacterEncoding("UTF-8");
        }

        req = Utiles.insertarLoDeSiempre(req);
        req.getRequestDispatcher("/WEB-INF/jsp/alta_de_usuario.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getCharacterEncoding() == null) {
            req.setCharacterEncoding("UTF-8");
        }
    	
        String tipoUsuario = (String) req.getParameter("tipoUsuario");

        String nickname = (String) req.getParameter("nickname");
        String nombre = (String) req.getParameter("nombre");
        String apellido = (String) req.getParameter("apellido");
        String password = (String) req.getParameter("password");
        String email = (String) req.getParameter("email");
        String fechaNacStr = (String) req.getParameter("fechaNac");
        String nacionalidad = (String) req.getParameter("nacionalidad");
        String descripcionGeneral = (String) req.getParameter("descripcionGeneral");
        String link = (String) req.getParameter("link");
        if(link != null && link.trim().length() == 0) {
        	link = null;
        }
        Part filePart = req.getPart("img");

        try {

            boolean hayImagen = filePart.getSize() > 0;
            String ext = "";
            String futuroNombreDelPath = "";
            Imagen imgDt = null;
            if (hayImagen) {
                ext = Utiles.devolverExtencionDelNombreDeArchivo(filePart.getSubmittedFileName());

                futuroNombreDelPath = "/usuarios/" + nickname + ext; // Esto es
                                                                     // la
                                                                     // ruta
                                                                     // relativa
                imgDt = new Imagen(futuroNombreDelPath);
            }

            LocalDate fechaNac = LocalDate.parse(fechaNacStr);
            if (tipoUsuario.equals(tipoUsuarioProveedor)) {
                this.contUsuario.altaProveedor(nickname, nombre, apellido, email, password, fechaNac, imgDt,
                        descripcionGeneral, link);
            } else if (tipoUsuario.equals(tipoUsuarioTurista)) {
                this.contUsuario.altaTurista(nickname, nombre, apellido, email, password, fechaNac, imgDt,
                        nacionalidad);
            } else {
                req.setAttribute("motivoDeError", "No se soporta el alta de este tipo de usuario");
                req.getRequestDispatcher("/WEB-INF/jsp/errores/400.jsp").forward(req, resp);
                return;
            }

            if (hayImagen) {
                // Utiles.crearDirectorioImagenesSiNoEstaCreado(servidorPath);
                InputStream imgInputStream = filePart.getInputStream();
                String servidorPath = getServletContext().getRealPath("/");
                File imgFile = new File(servidorPath + "/img" + futuroNombreDelPath);
                imgFile.createNewFile();
                FileOutputStream imgFileStream = new FileOutputStream(imgFile);

                byte[] buffer = new byte[8192];

                int readLength = imgInputStream.read(buffer);
                while (readLength != -1) {
                    imgFileStream.write(buffer, 0, readLength);
                    readLength = imgInputStream.read(buffer);
                }
                imgFileStream.close();
            }

            req.setAttribute("exito", Boolean.TRUE);
            req = Utiles.insertarLoDeSiempre(req);
            req.getRequestDispatcher("/WEB-INF/jsp/alta_de_usuario.jsp").forward(req, resp);
            return;
        } catch (UsuarioYaRegistradoException e) {
            req.setAttribute("motivoDeError",
                    "Ya existe un usuario con este nickname o con ese correo, cambie alguno de estos y pruebe nuevamente");
        }

        // En este punto si o si hay error

        req.setAttribute("tipoUsuario", tipoUsuario);

        req.setAttribute("nickname", nickname);
        req.setAttribute("nombre", nombre);
        req.setAttribute("apellido", apellido);
        req.setAttribute("password", password);
        req.setAttribute("email", email);
        req.setAttribute("fechaNac", fechaNacStr);
        req.setAttribute("nacionalidad", nacionalidad);
        req.setAttribute("descripcionGeneral", descripcionGeneral);
        req.setAttribute("link", link);

        req = Utiles.insertarLoDeSiempre(req);

        req.getRequestDispatcher("/WEB-INF/jsp/alta_de_usuario.jsp").forward(req, resp);

    }

}
