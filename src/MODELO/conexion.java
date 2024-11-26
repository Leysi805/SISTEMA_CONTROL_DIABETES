
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Darileysi Morales
 */
public class conexion {
    
    Connection con;
    String url = "jdbc:mysql://localhost:3306/scp_d";
    String user = "root";
    String pass = "";
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa");
        } catch (Exception e){
            System.out.println("Error en la conexion a la base de datos" + e);
    }
        return con;
    }
    

    public static void main (String[] args){
        conexion c1 = new conexion();
        c1.Conectar();
    }  
}
