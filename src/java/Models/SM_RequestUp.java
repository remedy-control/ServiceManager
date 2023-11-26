/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import SM_import.IncidentremedyKeysType;
import SM_import.ObjectFactory;
import SM_import.StringType;

/**
 *
 * @author CONSULTOR
 */
public final class SM_RequestUp extends IncidentremedyKeysType {
    private final ObjectFactory of = new ObjectFactory();
    
    public SM_RequestUp() {
    }
      public void setRIncidentID(String IncidentID) {
    if (IncidentID != null) {
      StringType temp1 = new StringType();
      temp1.setValue(IncidentID);
      setIncidentID(this.of.createIncidentremedyKeysTypeIncidentID(temp1));

}
    
}
}
