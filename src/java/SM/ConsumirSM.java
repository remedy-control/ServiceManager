/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SM;


import SM_import.ActualizarIncidentremedyRequest;
import SM_import.ActualizarIncidentremedyResponse;
import SM_import.CreateIncidentremedyRequest;
import SM_import.CreateIncidentremedyResponse;
import SM_import.IncidentremedyInstanceType;
import SM_import.IncidentremedyModelType;
//import SM_import.Incidentremedy_Service;
import SM_import.IncidentManagementremedy_Service;
import SM_import.MessageType;
import SM_import.ObjectFactory;
import SM_import.StringType;
import java.net.Authenticator;
import org.apache.log4j.Logger;

public class ConsumirSM {
  ObjectFactory of = new ObjectFactory();
  
  public static final Logger log = Logger.getLogger(SM.ConsumirSM.class);
  
  public String createIncident(IncidentremedyInstanceType request) {
    Authenticator.setDefault((Authenticator)new MyAuthenticator());
    IncidentremedyModelType cttt = this.of.createIncidentremedyModelType();
    cttt.setKeys(this.of.createIncidentremedyKeysType());
    cttt.setInstance(request);
    CreateIncidentremedyRequest incidentremedyRequest = this.of.createCreateIncidentremedyRequest();
    incidentremedyRequest.setModel(cttt);
    incidentremedyRequest.setIgnoreEmptyElements(Boolean.TRUE);
    incidentremedyRequest.setUpdateconstraint(-1L);
    System.out.println("Valor de request de Severity: "+incidentremedyRequest.getModel().getInstance().getSeverity());
        try {
      //CreateIncidentremedyResponse cttr = (new Incidentremedy_Service()).getIncidentremedy().createIncidentremedy(incidentremedyRequest);
      CreateIncidentremedyResponse cttr = (new IncidentManagementremedy_Service()).getIncidentManagementremedy().createIncidentremedy(incidentremedyRequest);
      for (int i = 0; i < cttr.getMessages().getMessage().size(); i++)
        log.info(((MessageType)cttr.getMessages().getMessage().get(i)).getValue()); 
      return ((StringType)cttr.getModel().getKeys().getIncidentID().getValue()).getValue();
    } catch (Error|Exception ex) {
      log.error(ex);
      return ex.toString();
    } 
  }
  //Alejandro
    public String actualizarInc(IncidentremedyModelType cttt){
      Authenticator.setDefault((Authenticator)new MyAuthenticator());
     
      ActualizarIncidentremedyRequest incidentremedyRequest = this.of.createActualizarIncidentremedyRequest();
      incidentremedyRequest.setModel(cttt);
      incidentremedyRequest.setIgnoreEmptyElements(Boolean.TRUE);
      incidentremedyRequest.setUpdateconstraint(-1L);
      log.info("mensaje incidentremedyrequest: "+ incidentremedyRequest.getModel().getInstance().getJournalUpdates().getJournalUpdates().get(0).getValue());
      log.info("mensaje incidentremedyrequest2: "+ incidentremedyRequest.getModel().getKeys().getIncidentID().getValue().getValue());

      try {
          //ActualizarIncidentremedyResponse cttr=(new Incidentremedy_Service()).getIncidentremedy().actualizarIncidentremedy(incidentremedyRequest);
          ActualizarIncidentremedyResponse cttr=(new IncidentManagementremedy_Service()).getIncidentManagementremedy().actualizarIncidentremedy(incidentremedyRequest);
          for (int i = 0; i < cttr.getMessages().getMessage().size(); i++)
      //log.info(((MessageType)cttr.getMessages().getMessage().get(i)).getValues()); 
          log.info(cttr.getMessages().getMessage().get(i).getValue());
           return ((StringType)cttr.getModel().getKeys().getIncidentID().getValue()).getValue();
      
      } catch (Error|Exception ex) {
          log.error(ex);
          return ex.toString();
      }
  } 
}
