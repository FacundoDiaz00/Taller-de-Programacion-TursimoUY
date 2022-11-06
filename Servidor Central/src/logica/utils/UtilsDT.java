package logica.utils;

import configuraciones.Cargador;
import excepciones.ErrorAlProcesar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class UtilsDT {

    public static final DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final DateTimeFormatter formatterLocalDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void guardarImagen(String relativePath, byte[] content) throws ErrorAlProcesar {
        try{
            File fileImg = new File(Cargador.getDirectorioImagenes() + relativePath);
            fileImg.createNewFile();
            FileOutputStream imgFileStream = new FileOutputStream(fileImg);
            imgFileStream.write(content);
            imgFileStream.close();
        } catch (IOException e){
            e.printStackTrace();
            throw new ErrorAlProcesar("No se pudo guardar la imagen");
        }

    }

    public static void borrarImagen(String relativePath){
        File fileImg = new File(Cargador.getDirectorioImagenes() + relativePath);
        fileImg.delete();
    }

}
