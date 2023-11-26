/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.infomedia.utils.SOUtils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testjdbc {
    public static void main(String[] args){
        String url="jdbc:oracle:thin:@//10.191.205.235:1522/ARSP81";
        try{
            Connection conexion= DriverManager.getConnection(url,"INTEGRACIONES", "I_t3G4#n");
            Statement instruccion= conexion.createStatement();
            String sql= "SELECT clave, folio_bes, folio_remedy, fecha_creacion FROM INC_FOLIOS_BES";
            ResultSet resultado=instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("ID: "+resultado.getInt("clave"));
                System.out.print(" Folio bes: "+resultado.getString("FOLIO_BES"));
                System.out.println(" Folio_Remedy: "+resultado.getString("FOLIO_REMEDY"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
