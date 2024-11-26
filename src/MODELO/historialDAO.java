
package MODELO;

import MODELO.tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darileysi Morales
 */
public class historialDAO {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Guardar datos
    public int add(historial_clinico h) {
    int rowsAffected = 0;
    String sql = "INSERT INTO historial (id_tratamiento, id_paciente, fecha_hora_creacion) VALUES (?, ?, ?)";
    
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, h.getId_tratamiento());
        ps.setInt(2, h.getId_paciente());
        ps.setString(3, h.getFecha_hora_creacion());
        
        rowsAffected = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión y el PreparedStatement en un bloque finally
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    return rowsAffected;
}
    

    public List<tratamiento> obtenerHistorialPorPaciente(String nombrePaciente) {
    List<tratamiento> historial = new ArrayList<>();
    String sql = "SELECT * FROM tratamiento t " +
                 "JOIN paciente p ON t.id_paciente = p.id_paciente " +
                 "WHERE p.nombre = ?";

    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombrePaciente);
        rs = ps.executeQuery();

        while (rs.next()) {
            tratamiento tratamiento = new tratamiento();
            tratamiento.setId_tratamiento(rs.getInt("id_tratamiento"));
            tratamiento.setId_paciente(rs.getInt("id_paciente"));
            tratamiento.setFecha(rs.getString("fecha")); 
            tratamiento.setTipo_diabetes(rs.getString("tipo_diabetes"));
            tratamiento.setNivel_glucosa(rs.getString("nivel_glucosa")); 
            tratamiento.setPeso(rs.getDouble("peso"));
            tratamiento.setCondiciones_medicas(rs.getString("condiciones_medicas"));
            tratamiento.setMedicamentos_dosis(rs.getString("medicamentos_dosis"));
            tratamiento.setDescripcion_dieta(rs.getString("descripcion_dieta"));
            // Agregar otros atributos según sea necesario

            historial.add(tratamiento);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión y el PreparedStatement en un bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return historial;
}


}
