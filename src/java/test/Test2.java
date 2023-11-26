package test;

import Conexiones.IncidenteDAO;
import Models.SM_Request;
import Models.SM_RequestUp;
import SM.ConsumirSM;
import SM_import.IncidentremedyInstanceType;
import SM_import.IncidentremedyKeysType;
import java.util.Date;
import static SM.ConsumirSM.log;
import SM_import.IncidentremedyModelType;
import SM_import.ObjectFactory;
import domain.Incidente;

public class Test2 {
 
  public static void main(String[] args) throws Exception {
        SM_Request request = new SM_Request();
        SM_RequestUp request2= new SM_RequestUp();
        ObjectFactory of = new ObjectFactory();
        IncidenteDAO incdao = new IncidenteDAO();
        
    try {
        IncidentremedyModelType cttt= of.createIncidentremedyModelType();
        request2.setRIncidentID("F5285376");
        request.setRJournalUpdates("CERRADO POR CLEAR (REMEDY-JAVA2)");
        request.setDowntimeStart(null);
        
        cttt.setKeys(request2);
        cttt.setInstance(request);
        System.out.println("Valor de Severity: "+cttt.getInstance().getSeverity());
        System.out.println("MENSAJE JOURNAL: "+cttt.getInstance().getJournalUpdates().getJournalUpdates().get(0).getValue());
        (new ConsumirSM()).actualizarInc((IncidentremedyModelType) cttt);
       
        } catch (Error | Exception err) {
            Date time = new Date();
            log.info("[" + time + "] ERROR");
            log.info(err);
            //return "[" + time + "] Internal web server error, report to Remedy to check service log";
        }
            //numero de clave
        int clave = incdao.clave();
        System.out.println("Numero de clave es: " + clave);
        
        //fecha de modificación 
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
//        //Actualizar registro
        Incidente inc_mod = new Incidente(clave, "F5285376", "Este es un comentario de prueba", "Cerrado", timestamp);
        incdao.actualizar(inc_mod);
  }
}
