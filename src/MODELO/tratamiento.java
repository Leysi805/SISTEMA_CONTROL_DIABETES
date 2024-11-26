
package MODELO;

/**
 *
 * @author Darileysi Morales
 */
public class tratamiento {
    
    int id_tratamiento;
    int id_paciente;
    String fecha;
    String tipo_diabetes;
    String condiciones_medicas;
    String medicamentos_dosis;
    String nivel_glucosa;
    Double peso;
    String descripcion_dieta;
    
    public tratamiento(){
        
    }

    public tratamiento(int id_tratamiento, int id_paciente, String fecha, String tipo_diabetes, String condiciones_medicas, String medicamentos_dosis, String nivel_glucosa, Double peso, String descripcion_dieta) {
        this.id_tratamiento = id_tratamiento;
        this.id_paciente = id_paciente;
        this.fecha = fecha;
        this.tipo_diabetes = tipo_diabetes;
        this.condiciones_medicas = condiciones_medicas;
        this.medicamentos_dosis = medicamentos_dosis;
        this.nivel_glucosa = nivel_glucosa;
        this.peso = peso;
        this.descripcion_dieta = descripcion_dieta;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
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

    public String getTipo_diabetes() {
        return tipo_diabetes;
    }

    public void setTipo_diabetes(String tipo_diabetes) {
        this.tipo_diabetes = tipo_diabetes;
    }

    public String getCondiciones_medicas() {
        return condiciones_medicas;
    }

    public void setCondiciones_medicas(String condiciones_medicas) {
        this.condiciones_medicas = condiciones_medicas;
    }

    public String getMedicamentos_dosis() {
        return medicamentos_dosis;
    }

    public void setMedicamentos_dosis(String medicamentos_dosis) {
        this.medicamentos_dosis = medicamentos_dosis;
    }

    public String getNivel_glucosa() {
        return nivel_glucosa;
    }

    public void setNivel_glucosa(String nivel_glucosa) {
        this.nivel_glucosa = nivel_glucosa;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDescripcion_dieta() {
        return descripcion_dieta;
    }

    public void setDescripcion_dieta(String descripcion_dieta) {
        this.descripcion_dieta = descripcion_dieta;
    }
    
    
}
