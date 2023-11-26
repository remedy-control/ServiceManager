/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SM;

import Conexiones.IncidenteDAO;
import Models.SM_Request;
import Models.SM_RequestUp;
import SM_import.IncidentremedyInstanceType;
import SM_import.IncidentremedyModelType;
import SM_import.ObjectFactory;
import domain.Incidente;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;

@WebService(serviceName = "IncidentSM")
public class IncidentSM {

    public static final Logger log = Logger.getLogger(ConsumirSM.class);

    @WebMethod(operationName = "createIncidentSM")
    public String createIncidentSM(@WebParam(name = "folioInc") String folioInc, @WebParam(name = "Category") String Category, @WebParam(name = "Severity") String Severity, @WebParam(name = "PrimaryAssignmentGroup") String PrimaryAssignmentGroup, @WebParam(name = "AffectedCI") String AffectedCI, @WebParam(name = "IncidentDescription") String IncidentDescription, @WebParam(name = "Company") String Company, @WebParam(name = "BriefDescription") String BriefDescription, @WebParam(name = "IMTicketStatus") String IMTicketStatus, @WebParam(name = "Subcategory") String Subcategory, @WebParam(name = "ProductType") String ProductType, @WebParam(name = "ProblemType") String ProblemType, @WebParam(name = "InitialImpact") String InitialImpact, @WebParam(name = "TipoFalla") String TipoFalla, @WebParam(name = "TTRemedydos") String TTRemedydos) {
        //iniciando objetos Java
        SM_Request request = new SM_Request();
        IncidenteDAO incdao = new IncidenteDAO();
        
        //Seleccionando la clave mayor
        int num = incdao.sel_clave();
        
        //Buscando la fecha 
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        //Insertando datos en Base de datos
        Incidente incnew=new Incidente(num,folioInc,timestamp,timestamp);
        incdao.insertar(incnew);

        //creacion del request a SM 
        try {
            request.setRCategory(Category);
            request.setRSeverity(Severity);
            request.setRAffectedCI(AffectedCI);
            request.setRIncidentDescription(IncidentDescription);
            request.setRCompany(Company);
            request.setRBriefDescription(BriefDescription);
            request.setRIMTicketStatus(IMTicketStatus);
            request.setRSubcategory(Subcategory);
            request.setRSiteCategory(Category);
            request.setRProductType(ProductType);
            request.setRProblemType(ProblemType);
            request.setRInitialImpact(InitialImpact);
            request.setRTipoFalla(TipoFalla);
            request.setRTTRemedydos(TTRemedydos);
            System.out.println("Valor del parseo de Severity: " + request.getSeverity().getValue());
            return (new ConsumirSM()).createIncident((IncidentremedyInstanceType) request);
        } catch (Error | Exception err) {
            Date time = new Date();
            log.info("[" + time + "] ERROR");
            log.info(err);
            return "[" + time + "] Internal web server error, report to Remedy to check service log";
        }
        
    }

    @WebMethod(operationName = "UpdateIncidentSM")
    public String updateIncidentSM(@WebParam(name = "Resolution") String Resolution, @WebParam(name = "ServiceManager") String ServiceManager,@WebParam(name = "Status") String Status ) {
        //iniciando objetos Java
        SM_RequestUp request2 = new SM_RequestUp();
        ObjectFactory of = new ObjectFactory();
        SM_Request request = new SM_Request();
        IncidenteDAO incdao = new IncidenteDAO();
        
        //Numero de clave actual
        int clave=incdao.clave();
        
        //Fecha de cierre 
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        
        
        //Actualizar registro
        Incidente inc_mod= new Incidente(clave,ServiceManager,Resolution,Status,timestamp);
        incdao.actualizar(inc_mod);
        
        log.info("JOUNARL UPDATE: " + Resolution + " LA CLASE ES: " + Resolution.getClass());
        log.info("FOLIO SM: " + ServiceManager + " LA CLASE ES: " + ServiceManager.getClass());
        try {
            IncidentremedyModelType cttt = of.createIncidentremedyModelType();
            request.setRJournalUpdates(Resolution);
            request2.setRIncidentID(ServiceManager);
            request.setDowntimeStart(null);

            cttt.setKeys(request2);
            cttt.setInstance(request);
            log.info("MENSAJE FOLIOSM" + cttt.getKeys().getIncidentID().getValue().getValue());
            log.info("MENSAJE JOURNAL: " + cttt.getInstance().getJournalUpdates().getJournalUpdates().get(0).getValue());

            return (new ConsumirSM()).actualizarInc((IncidentremedyModelType) cttt);
        } catch (Error | Exception err) {
            Date time = new Date();
            log.info("[" + time + "] ERROR");
            log.info(err);
            return "[" + time + "] Internal web server error, report to Remedy to check service log";
        }
    }

}
