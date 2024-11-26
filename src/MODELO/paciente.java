
package MODELO;

/**
 *
 * @author Darileysi Morales
 */
public class paciente {

    int id_paciente;
    String nombre;
    String fecha_nacimiento;
    String genero;
    String domicilio;
    String telefono;
    String contacto_emergencia;
    
    public paciente(){
        
    }

    public String toString() {
    return nombre; // Reemplaza 'nombrePaciente' con el nombre real del atributo en tu clase Paciente
}
    
    public paciente(int id_paciente, String nombre, String fecha_nacimiento, String genero, String domicilio, String telefono, String contacto_emergencia) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.contacto_emergencia = contacto_emergencia;
    }

    
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto_emergencia() {
        return contacto_emergencia;
    }

    public void setContacto_emergencia(String contacto_emergencia) {
        this.contacto_emergencia = contacto_emergencia;
    }
    
}
