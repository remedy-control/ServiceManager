/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

//import SM_Import.IncidentremedyInstanceType.IncidentDescription;
import SM_import.IncidentremedyInstanceType.Resolution;
import SM_import.StringType;
//import SM_Import.StringType;
import java.util.List;

public class SM_Resolution_Adapted extends Resolution{
        public void setResolution(List<StringType> Resolution) {
            this.resolution=Resolution;
        }
}
