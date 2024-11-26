
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darileysi Morales
 */
public class citaDAO {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Guardar datos
    public int add(cita c) {
    int rowsAffected = 0;
    String sql = "INSERT INTO cita (id_paciente, fecha, hora, motivo_cita) VALUES (?, ?, ?, ?)";
    
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, c.getId_paciente());
        ps.setString(2, c.getFecha());
        ps.setString(3, c.getHora());
        ps.setString(4, c.getMotivo_cita()); 
        
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
    
    //Actualizar datos
    public int actualizar(cita c){
        int r=0;
        String sql = "update cita set id_paciente=?, fecha=?, hora=?, motivo_cita=? where id_cita=?";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId_paciente());
            ps.setString(2, c.getFecha());
            ps.setString(3, c.getHora());
            ps.setString(4, c.getMotivo_cita());
            ps.setInt(5, c.getId_cita());
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
    
    //Metodo para obtener la clave foranea correspondiente al paciente seleccionado
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
    
    //Listar registros en una tabla
    public List<cita> listar() {
    List<cita> lista = new ArrayList<>();
    String sql = "SELECT * FROM cita";
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            cita c = new cita();
            c.setId_cita(rs.getInt(1));
            c.setId_paciente(rs.getInt(2));
            c.setFecha(rs.getString(3));
            c.setHora(rs.getString(4));
            c.setMotivo_cita(rs.getString(5));
            lista.add(c);
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
    
    // Cancelar una cita
public int eliminarCita(int idCita) {
    int rowsAffected = 0;
    String sql = "DELETE FROM cita WHERE id_cita = ?";

    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, idCita);

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
    
}
