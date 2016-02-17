/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import conexion.Conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kathya
 */
public class obtenerParticipantes extends Conectar{
    static private PreparedStatement pst;
    
    public static ResultSet getParticipantes(String tipo){
        ResultSet rs = null;
        try {
            
            String sql = "Select * from Participante where tipoParticipante= "+"'"+tipo+"'";
            pst = cone().prepareStatement(sql);
            rs=pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(obtenerParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    } 
}
