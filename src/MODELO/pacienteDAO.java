
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
public class pacienteDAO {
    
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Listar registros en una tabla
    public List<paciente> listar() {
    List<paciente> lista = new ArrayList<>();
    String sql = "SELECT * FROM paciente";
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            paciente p = new paciente();
            p.setId_paciente(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setFecha_nacimiento(rs.getString(3));
            p.setGenero(rs.getString(4));
            p.setDomicilio(rs.getString(5));
            p.setTelefono(rs.getString(6));
            p.setContacto_emergencia(rs.getString(7));
            lista.add(p);
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

    //Listar solo los nombres de los pacientes
    public List<String> listarNombres() {
    List<String> nombres = new ArrayList<>();
    String sql = "SELECT nombre FROM paciente";
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            nombres.add(rs.getString("nombre"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return nombres;
}

    
    //Guardar datos
    public int add(paciente p) {
    int rowsAffected = 0;
    String sql = "INSERT INTO paciente(nombre, fecha_nacimiento, genero, domicilio, telefono, contacto_emergencia) VALUES (?, ?, ?, ?, ?, ?)";
    
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getFecha_nacimiento());
        ps.setString(3, p.getGenero());
        ps.setString(4, p.getDomicilio());
        ps.setString(5, p.getTelefono());
        ps.setString(6, p.getContacto_emergencia());
        
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

    // Verificar si ya existe un paciente con el mismo nombre en la base de datos
    public boolean nombreRepetido(String nombre) {
    
    boolean nombreRepetido = false;

    try {
        con = cn.Conectar();
        String sql = "SELECT COUNT(*) FROM paciente WHERE nombre = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);

        rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            nombreRepetido = (count > 0);
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

    return nombreRepetido;
}
    
    //Actualizar datos
    public int actualizar(paciente p){
        int r=0;
        String sql = "update paciente set nombre=?, fecha_nacimiento=?, genero=?, domicilio=?, telefono=?, contacto_emergencia=? where id_paciente=?";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, p.getNombre());
            ps.setObject(2, p.getFecha_nacimiento());
            ps.setObject(3, p.getGenero());
            ps.setObject(4, p.getDomicilio());
            ps.setObject(5, p.getTelefono());
            ps.setObject(6, p.getContacto_emergencia());
            ps.setObject(7, p.getId_paciente());
            
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
