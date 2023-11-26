
package domain;

import java.sql.Timestamp;

public class Incidente {
    private int clave;
    private String FOLIO_REMEDY;
    private Timestamp FECHA_CREACION;
    private String FOLIO_SM;
    private String COM_INC_RMD;
    private String ESTATUS;
    private Timestamp FECHA_FINALIZACION;


    public Incidente() {
    }
    
    public Incidente(int clave) {
        this.clave = clave;
    }
    //Contructor para insercion de registro 
     public Incidente(int clave, String FOLIO_REMEDY, Timestamp FECHA_CREACION, Timestamp FECHA_FINALIZACION) {
        this.clave=clave;
        this.FOLIO_REMEDY = FOLIO_REMEDY;
        this.FECHA_CREACION = FECHA_CREACION;
        this.FECHA_FINALIZACION = FECHA_FINALIZACION;
    }
     //Contructor para la actualizacion de registro
    public Incidente(int clave, String FOLIO_SM, String COM_INC_RMD, String ESTATUS, Timestamp FECHA_FINALIZACION) {
        this.clave=clave;
        this.FOLIO_SM = FOLIO_SM;
        this.COM_INC_RMD = COM_INC_RMD;
        this.ESTATUS = ESTATUS;
        this.FECHA_FINALIZACION = FECHA_FINALIZACION;
    }

    public Incidente(int clave, String FOLIO_REMEDY, Timestamp FECHA_CREACION, String FOLIO_SM, String COM_INC_RMD, String ESTATUS, Timestamp FECHA_FINALIZACION) {
        this.clave = clave;
        this.FOLIO_REMEDY = FOLIO_REMEDY;
        this.FECHA_CREACION = FECHA_CREACION;
        this.FOLIO_SM = FOLIO_SM;
        this.COM_INC_RMD = COM_INC_RMD;
        this.ESTATUS = ESTATUS;
        this.FECHA_FINALIZACION = FECHA_FINALIZACION;
    }


    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getFOLIO_REMEDY() {
        return FOLIO_REMEDY;
    }

    public void setFOLIO_REMEDY(String FOLIO_REMEDY) {
        this.FOLIO_REMEDY = FOLIO_REMEDY;
    }

    public Timestamp getFECHA_CREACION() {
        return FECHA_CREACION;
    }

    public void setFECHA_CREACION(Timestamp FECHA_CREACION) {
        this.FECHA_CREACION = FECHA_CREACION;
    }

    public String getFOLIO_SM() {
        return FOLIO_SM;
    }

    public void setFOLIO_SM(String FOLIO_SM) {
        this.FOLIO_SM = FOLIO_SM;
    }

    public String getCOM_INC_RMD() {
        return COM_INC_RMD;
    }

    public void setCOM_INC_RMD(String COM_INC_RMD) {
        this.COM_INC_RMD = COM_INC_RMD;
    }

    public String getESTATUS() {
        return ESTATUS;
    }

    public void setESTATUS(String ESTATUS) {
        this.ESTATUS = ESTATUS;
    }

    public Timestamp getFECHA_FINALIZACION() {
        return FECHA_FINALIZACION;
    }

    public void setFECHA_FINALIZACION(Timestamp FECHA_FINALIZACION) {
        this.FECHA_FINALIZACION = FECHA_FINALIZACION;
    }

    @Override
    public String toString() {
        return "Incidente{" + "clave=" + clave + ", FOLIO_REMEDY=" + FOLIO_REMEDY + ", FECHA_CREACION=" + FECHA_CREACION + ", FOLIO_SM=" + FOLIO_SM + ", COM_INC_RMD=" + COM_INC_RMD + ", ESTATUS=" + ESTATUS + ", FECHA_FINALIZACION=" + FECHA_FINALIZACION + '}';
    }

    
    
}
