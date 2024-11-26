
package MODELO;

/**
 *
 * @author Darileysi Morales
 */
public class cita {
    
    int id_cita;
    int id_paciente;
    String fecha;
    String hora;
    String motivo_cita;
    
    
    public cita(){
        
    }

    public cita(int id_cita, int id_paciente, String fecha, String hora, String motivo_cita) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo_cita = motivo_cita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo_cita() {
        return motivo_cita;
    }

    public void setMotivo_cita(String motivo_cita) {
        this.motivo_cita = motivo_cita;
    }
    
    
}
