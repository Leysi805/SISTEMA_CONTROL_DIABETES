
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darileysi Morales
 */
public class tratamientoDAO {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    //Listar registros en una tabla
    public List<tratamiento> listar() {
    List<tratamiento> lista = new ArrayList<>();
    String sql = "SELECT * FROM tratamiento";
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            tratamiento t = new tratamiento();
            t.setId_tratamiento(rs.getInt(1));
            t.setId_paciente(rs.getInt(2));
            t.setFecha(rs.getString(3));
            t.setTipo_diabetes(rs.getString(4));
            t.setCondiciones_medicas(rs.getString(5));
            t.setMedicamentos_dosis(rs.getString(6));
            t.setNivel_glucosa(rs.getString(7));
            t.setPeso(rs.getDouble(8));
            t.setDescripcion_dieta(rs.getString(9)); 
            lista.add(t);
        }
    } catch (Exception e) {
        e.printStackTrace(); // Imprimir detalles de la excepción en la consola
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
            e.printStackTrace(); // Imprimir detalles de la excepción en la consola
        }
    }
    return lista;
}

    
    //Guardar datos
    public int add(tratamiento t) {
    int rowsAffected = 0;
    String sql = "INSERT INTO tratamiento(id_paciente, fecha, tipo_diabetes, condiciones_medicas, medicamentos_dosis, nivel_glucosa, peso, descripcion_dieta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, t.getId_paciente());
        ps.setString(2, t.getFecha());
        ps.setString(3, t.getTipo_diabetes());
        ps.setString(4, t.getCondiciones_medicas());
        ps.setString(5, t.getMedicamentos_dosis());
        ps.setString(6, t.getNivel_glucosa());
        ps.setDouble(7, t.getPeso());
        ps.setString(8, t.getDescripcion_dieta()); 
        
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
    
    //Metodo para obtener la clave foranea correspondiente al paciente seleccionado para llenar la tabla
    //Obtener el id correspondiente a un nombre del paciente
    public int obtenerIdPacientePorNombre(String nombre) {
    int idPaciente = -1; // Valor predeterminado en caso de que no se encuentre el paciente

    String sql = "SELECT id_paciente FROM paciente WHERE nombre = ?";

    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);

        rs = ps.executeQuery();

        if (rs.next()) {
            idPaciente = rs.getInt("id_paciente");
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
    return idPaciente;
}
 
    //Obtener nombre de paciente por id para que aparezca en el combobox
    // Método para obtener un paciente por su ID
    public String obtenerPacientePorId(int idPaciente) {
    String nombrePaciente = null;
    
    String sql = "SELECT nombre FROM paciente WHERE id_paciente = ?";

    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idPaciente);
        
        rs = ps.executeQuery();

        if (rs.next()) {
            nombrePaciente = rs.getString("nombre");
            System.out.println("Nombre del paciente obtenido: " + nombrePaciente);
        } else {
            System.out.println("No se encontraron registros para el ID de paciente: " + idPaciente);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener paciente por ID: " + e.getMessage());
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

    return nombrePaciente;
}

    //Listar pacientes
    //Metodo para rellenar el combobox
    public List<String> listarPacientes() {
    List<String> listaPacientes = new ArrayList<>();
    String sql = "SELECT nombre FROM paciente";
    
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            String nombrePaciente = rs.getString("nombre");
            listaPacientes.add(nombrePaciente);
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
    
    return listaPacientes;
}

    
    //Actualizar datos
    public int actualizar(tratamiento t){
        int r=0;
        String sql = "update tratamiento set id_paciente=?, fecha=?, tipo_diabetes=?, condiciones_medicas=?, medicamentos_dosis=?, nivel_glucosa=?, peso=?, descripcion_dieta=? where id_tratamiento=?";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getId_paciente());
            ps.setString(2, t.getFecha());
            ps.setString(3, t.getTipo_diabetes());
            ps.setString(4, t.getCondiciones_medicas());
            ps.setString(5, t.getMedicamentos_dosis());
            ps.setString(6, t.getNivel_glucosa());
            ps.setDouble(7, t.getPeso());
            ps.setString(8, t.getDescripcion_dieta());           
            ps.setInt(9, t.getId_tratamiento());
            r = ps.executeUpdate();
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
    
    return r;
        
    }
}
