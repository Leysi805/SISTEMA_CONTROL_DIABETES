
package MODELO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Darileysi Morales
 */
public class GeneradorPDF {
    public static void generarPDF(List<tratamiento> historial, String fechaConsulta, String nombrePaciente) { 
        Document document = new Document();

        try {
            String ruta = System.getProperty("user.home");
            // Agrega la fecha y hora actual al nombre del archivo
            String nombreArchivo = "InformeHistorial_" + obtenerFechaHoraActual() + ".pdf";
            
            // Especifica la ruta donde deseas guardar el PDF
            PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/" + nombreArchivo));
            
            agregarEncabezado(document);

            document.open();

            // Agrega un título al documento
            // Antes de agregar el título
            document.add(new Paragraph("\n")); // Agrega algunos espacios en blanco para centrar el título
            Paragraph titulo = new Paragraph("Centro de Salud de Tlalquetzala, Gro", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n")); // Agrega espacios después del título

            Paragraph encabezado = new Paragraph("Informe de Historial Médico", FontFactory.getFont(FontFactory.TIMES_BOLD, 16));
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);
            document.add(new Paragraph("\n")); // Agrega espacios después del título

            // Mostrar la fecha y hora de consulta
            document.add(new Paragraph("Fecha y hora de consulta: " + fechaConsulta));
            document.add(new Paragraph("\n")); // Espacios después de la fecha y hora

            // Mostrar el nombre del paciente
            document.add(new Paragraph("Nombre del Paciente: " + nombrePaciente));
            document.add(new Paragraph("\n")); // Espacios después del nombre del paciente
            
            // Agrega los datos del historial al documento
            for (tratamiento tratamiento : historial) {
                document.add(new Paragraph("ID Tratamiento: " + tratamiento.getId_tratamiento()));
                document.add(new Paragraph("Fecha: " + tratamiento.getFecha()));
                document.add(new Paragraph("Tipo de diabetes: " + tratamiento.getTipo_diabetes()));
                document.add(new Paragraph("Nivel de glucosa: " + tratamiento.getNivel_glucosa()));
                document.add(new Paragraph("Peso: " + tratamiento.getPeso()));
                document.add(new Paragraph("Condiciones médicas: " + tratamiento.getCondiciones_medicas()));
                document.add(new Paragraph("Medicamentos y dosis: " + tratamiento.getMedicamentos_dosis()));
                document.add(new Paragraph("Descripción de la dieta: " + tratamiento.getDescripcion_dieta()));
                document.add(new Paragraph("\n"));  // Agrega un espacio entre tratamientos
            }

            System.out.println("Informe generado correctamente.");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        
    }
    // Método para obtener la fecha y hora actual como cadena
    private static String obtenerFechaHoraActual() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return formato.format(fecha);
    
}
    //Metodo para agregar imagenes al encabezado
    private static void agregarEncabezado(Document document){
        try{
            //Agregar las imagenes al documento
            Image imagen1 = Image.getInstance("/IMAGENES/Gobierno de Mexico.png");
            Image imagen2 = Image.getInstance("/IMAGENES/Secretaria de salud.png");
            
            //Configurar la posicion y tamaño de las imagenes en el documento
            imagen1.setAbsolutePosition(50, 770);
            imagen1.scaleAbsolute(16,16);
            
            imagen2.setAbsolutePosition(120, 770);
            imagen2.scaleAbsolute(16,16);
            
            //Agregar las imagenes al documento
            document.add(imagen1);
            document.add(imagen2);
            
            //Agregar espacio despues de las imagenes
            document.add(new Paragraph("\n"));
        } catch (Exception e){
            
        }
    }
}



