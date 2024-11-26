
package MODELO;

/**
 *
 * @author Darileysi Morales
 */
public class historial_clinico {
    
    int id_historial;
    int id_paciente;
    int id_tratamiento;
    String fecha_hora_creacion;
    
    public historial_clinico(){
        
    }

    public historial_clinico(int id_historial, int id_paciente, int id_tratamiento, String fecha_hora_creacion) {
        this.id_historial = id_historial;
        this.id_paciente = id_paciente;
        this.id_tratamiento = id_tratamiento;
        this.fecha_hora_creacion = fecha_hora_creacion;
    }

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getFecha_hora_creacion() {
        return fecha_hora_creacion;
    }

    public void setFecha_hora_creacion(String fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
    }
    
    
}
