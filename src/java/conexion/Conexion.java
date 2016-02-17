/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Kathya
 */
public class Conexion {
    public String sentenciaSQL;
    public void conectar(String sentenciaSQL) {
        try {
            //Este es el driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Este lo genera automaticamente
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/congresoweb", "root", "volave2");
            Statement state =conexion.createStatement();
            int rs=state.executeUpdate(sentenciaSQL);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

    }
}
