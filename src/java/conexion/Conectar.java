/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kathya
 */
public class Conectar {
   static private Connection cn = null;
   public static Connection cone(){
       try {
           String driver="com.mysql.jdbc.Driver";
           String url="jdbc:mysql://localhost:3306/congresoweb";
           String usuario="root";
           String clave="volave2";
           Class.forName(driver);
           cn = DriverManager.getConnection(url, usuario, clave);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
       }
       return cn;
   }
}
