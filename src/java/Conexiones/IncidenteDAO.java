/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import static Conexiones.Conexion.*;
import domain.Incidente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IncidenteDAO {

    private static final String SQL_SELECT = "SELECT * FROM INC_FOLIOS_SM";
    private static final String SELECT_CLAVE = "SELECT MAX(CLAVE)+1 FROM INC_FOLIOS_SM";
    private static final String CLAVE = "SELECT MAX(CLAVE) FROM INC_FOLIOS_SM";
    private static final String SQL_INSERT = "INSERT INTO INC_FOLIOS_SM(CLAVE,FOLIO_REMEDY,FECHA_CREACION,FOLIO_SM,COM_INC_RMD,ESTATUS,FECHA_FINALIZACION) VALUES(?,?,?,'-','-','-',?)";
    private static final String SQL_UPDATE = "UPDATE INC_FOLIOS_SM SET  FOLIO_SM=?, COM_INC_RMD=?,ESTATUS=?,FECHA_FINALIZACION=? WHERE CLAVE=?";
    private static final String SQL_DELETE = "DELETE FROM INC_FOLIOS_SM WHERE CLAVE=?";
    public int maximo;
    
    
    //metodo para selecionar los objectos de SQL
    public List<Incidente> Seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Incidente inc = null;
        List<Incidente> incs = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int clave = rs.getInt("CLAVE");
                String fol_rem = rs.getString("FOLIO_REMEDY");
                Timestamp fecha = rs.getTimestamp("FECHA_CREACION");
                String fol_sm = rs.getString("FOLIO_SM");
                String comentario=rs.getString("COM_INC_RMD");
                String status=rs.getString("ESTATUS");
                Timestamp fecha_fin=rs.getTimestamp("FECHA_FINALIZACION");

                //Convirtiendo objetos de la base de datos a objetos java 
                inc = new Incidente(clave, fol_rem, fecha, fol_sm,comentario,status,fecha_fin);

                incs.add(inc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return incs;
    }

    //metodo para selecionar la clave mas alta como objeto de SQL
    public int sel_clave() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Incidente num = null;
        try {
            maximo=0;
            conn = getConnection();
            stmt = conn.prepareStatement(SELECT_CLAVE);
            rs = stmt.executeQuery();
            if (rs.next()) {
                maximo=rs.getInt("MAX(CLAVE)+1");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return maximo;
    }
    public int clave() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Incidente num = null;
        try {
            maximo=0;
            conn = getConnection();
            stmt = conn.prepareStatement(CLAVE);
            rs = stmt.executeQuery();
            if (rs.next()) {
                maximo=rs.getInt("MAX(CLAVE)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return maximo;
    }

    //metodo para insertar los objectos de Java a SQL
    public int insertar(Incidente incidente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, incidente.getClave());
            stmt.setString(2, incidente.getFOLIO_REMEDY());
            stmt.setTimestamp(3, incidente.getFECHA_CREACION());
            stmt.setTimestamp(4, incidente.getFECHA_FINALIZACION());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }
    
    public int actualizar(Incidente incidente){
        Connection conn=null;
        PreparedStatement stmt=null;
        int registros =0;
        
        try{
            conn =getConnection();
            stmt=conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, incidente.getFOLIO_SM());
            stmt.setString(2, incidente.getCOM_INC_RMD());
            stmt.setString(3, incidente.getESTATUS());
            stmt.setTimestamp(4, incidente.getFECHA_FINALIZACION());
            stmt.setInt(5, incidente.getClave());
            registros=stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
        
    }
    public int eliminar(Incidente incidente){
        Connection conn=null;
        PreparedStatement stmt=null;
        int registros =0;
        
        try{
            conn =getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, incidente.getClave());
            registros=stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(IncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
        
    }
}
