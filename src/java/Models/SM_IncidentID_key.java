/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import SM_import.StringType;
import SM_import.IncidentremedyKeysType;
import javax.xml.bind.JAXBElement;

public class SM_IncidentID_key extends IncidentremedyKeysType{
    public void setIncidentid(JAXBElement<StringType> incidentid){
        //System.out.println("A VER QUE SHOW: "+journalUpdates.get(0).getValue());
        this.incidentID=incidentid;
        //System.out.println("EL RESULTADO ES: "+this.journalUpdates.get(0).getValue());
        //System.out.println("LA CLASE ES: "+this.journalUpdates.getClass());
    }
}
