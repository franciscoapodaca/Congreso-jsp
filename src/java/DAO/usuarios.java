/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kathya
 */
public class usuarios {

    public static void eliminaUsuarios(String nombreU) {
        Conexion conectar = new Conexion();
        conectar.conectar("delete from usuario " + " where nombreU= " + "'" + nombreU + "'");
    }

    public static void agregarUsuario(String nomU, String contra, String tipo) {
        Conexion conectar = new Conexion();
        conectar.conectar("insert into Usuario values('" + nomU + "','" + contra + "','" + tipo + "')");
    }

    public static void actualizaUsuario(String nomU, String contra, String tipo) {

        Conexion conectar = new Conexion();
        conectar.conectar("update usuario set password= " + "'" + contra + "'" + ", tipoUsuario= " + "'" + tipo + "'" + " where nombreU= " + "'" + nomU + "'");
    }

    public static boolean validaExistencia(String nombre) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "congresoweb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "volave2";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("select * from usuario " + " where nombreU=?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}
