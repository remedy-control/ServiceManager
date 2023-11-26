/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import SM_import.IncidentremedyInstanceType.IncidentDescription;
import SM_import.StringType;
import java.util.List;

/**
 *
 * @author LUISALFREDOMONTALVOL
 */
public class SM_IncidentDescription_Adapted extends IncidentDescription{
        public void setIncidentDescription(List<StringType> incidentDescription) {
            this.incidentDescription=incidentDescription;
        }
}
