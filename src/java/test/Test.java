package test;


import Conexiones.IncidenteDAO;
import Models.SM_Request;
import SM.ConsumirSM;
import SM.IncidentSM;
import SM_import.IncidentremedyInstanceType;
import domain.Incidente;
import java.util.Date;

public class Test {
  public static void main(String[] args) throws Exception {
    SM_Request request = new SM_Request();
    IncidenteDAO incdao = new IncidenteDAO();

    // Creando el request para el folio SM
    try {
      request.setRCategory("FALLA");
      request.setROpenedBy("integracion_logcontrol");
      request.setRSeverity("Medium");
      request.setRLocation("GNCYGTZA");
      request.setRPrimaryAssignmentGroup("FRONT OFFICE");
      request.setRAffectedCI("LG4745L1900");
      request.setRIncidentDescription("FALLA LOG CONTROL_TEST");
      //request.setRDowntimeStart(result);
      request.setRDowntimeStart(new Date());
      request.setRContact("TEMIP USER");
      request.setRBriefDescription("FALLA LOG CONTROL_TEST");
      request.setRTicketOwner("tmipuser");
      request.setRIMTicketStatus("New");
      request.setRSubcategory("DISPONIBILIDAD");
      request.setRProductType("SOFT ALARM");
      request.setRProblemType("ERROR DE CONEXION");
      request.setRInitialImpact("1");
      request.setRIncidentManager("tmipuser");
      request.setRClienteEmpresarial(false);
      request.setRTipoFalla("Infrastructure Event");
      request.setRTTRemedydos("INC000023410377");
      System.out.println("REQUEST: "+request.getQuery());
      System.out.println("SEVERITY: "+request.getSeverity().getValue().getValue());
      (new ConsumirSM()).createIncident((IncidentremedyInstanceType)request);
    } catch (Error|Exception err) {
      Date time = new Date();
      IncidentSM.log.error("[" + time + "] ERROR");
      IncidentSM.log.error(err);
    } 
    
     //Seleccionando la clave mayor
        int num = incdao.sel_clave();
        System.out.println("Numero de la siguiente clave es: " + num);

        //Insertando un nuevo objeto de tipo Incidente
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        Incidente incnew=new Incidente(num,"INCPROOFDEV"+num,timestamp,timestamp);
        incdao.insertar(incnew);
  }
}
