package Models;

import SM_import.BooleanType;
import SM_import.DateTimeType;
import SM_import.DecimalType;
import SM_import.IncidentremedyInstanceType;
import SM_import.ObjectFactory;
import SM_import.StringType;
import com.infomedia.utils.PropertyLoader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public final class SM_Request extends IncidentremedyInstanceType {
  private final Properties prop = PropertyLoader.load("ConstantExtern.Default.properties");
  
  private final ObjectFactory of = new ObjectFactory();
  
  public SM_Request() {
    try {
      setRDowntimeStart(new Date());
    } catch (ParseException|DatatypeConfigurationException ex) {
      Logger.getLogger(Models.SM_Request.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    setRPrimaryAssignmentGroup("FRONT OFFICE");
    setROpenedBy(this.prop.getProperty("USER").toLowerCase());
    setRContact(this.prop.getProperty("USER").toUpperCase());
    setRTicketOwner(this.prop.getProperty("USER").toLowerCase());
    setRIncidentManager(this.prop.getProperty("USER").toLowerCase());
    setRClienteEmpresarial(false);
    setRE1Afectados((byte)0);
    setRClientesAfectados((byte)0);
    setRCeldasAfectadas((byte)0);
    setRDslamAfectados((byte)0);
    setRInternetAfectados((byte)0);
  }
  
  private DateTimeType defineDate(Date time, String format) throws ParseException, DatatypeConfigurationException {
    DateTimeType temp1 = new DateTimeType();
    GregorianCalendar c = new GregorianCalendar();
    c.setTime(time);
    temp1.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
    return temp1;
  }
  
  public void setRCategory(String Category) {
    if (Category != null) {
      StringType temp1 = new StringType();
      temp1.setValue(Category);
      setCategory(this.of.createIncidentremedyInstanceTypeCategory(temp1));
    } 
  }
  
  public void setROpenedBy(String OpenedBy) {
    if (OpenedBy != null) {
      StringType temp1 = new StringType();
      temp1.setValue(OpenedBy);
      setOpenedBy(this.of.createIncidentremedyInstanceTypeOpenedBy(temp1));
    } 
  }
  
  public void setRSeverity(String Severity) {
    if (Severity != null) {
      StringType temp1 = new StringType();
      switch (Severity.toLowerCase()) {
        case "low":
          temp1.setValue("4");
          break;
        case "medium":
          temp1.setValue("3");
          break;
        case "high":
          temp1.setValue("2");
          break;
        case "critical":
          temp1.setValue("1");
          break;
      }
      setSeverity(this.of.createIncidentremedyInstanceTypeSeverity(temp1));
    } 
  }
  
  public void setRPrimaryAssignmentGroup(String PrimaryAssignmentGroup) {
    if (PrimaryAssignmentGroup != null) {
      StringType temp1 = new StringType();
      temp1.setValue(PrimaryAssignmentGroup);
      setPrimaryAssignmentGroup(this.of.createIncidentremedyInstanceTypePrimaryAssignmentGroup(temp1));
    } 
  }
  
  public void setRIncidentDescription(String IncidentDescription) {
    if (IncidentDescription != null) {
      StringType temp1 = new StringType();
      temp1.setValue(IncidentDescription);
      ArrayList<StringType> listDescription = new ArrayList<>();
      listDescription.add(temp1);
      SM_IncidentDescription_Adapted description = new SM_IncidentDescription_Adapted();
      description.setIncidentDescription(listDescription);
      setIncidentDescription((IncidentremedyInstanceType.IncidentDescription)description);
    } 
  }
  
  public void setRDowntimeStart(Date DowntimeStart) throws ParseException, DatatypeConfigurationException {
    if (DowntimeStart != null)
      setDowntimeStart(this.of.createIncidentremedyInstanceTypeDowntimeStart(defineDate(DowntimeStart, this.prop.getProperty("DATEFORMAT")))); 
  }
  
  public void setRContact(String ContactType) {
    if (ContactType != null) {
      StringType temp1 = new StringType();
      temp1.setValue(ContactType);
      setContact(this.of.createIncidentremedyInstanceTypeContact(temp1));
    } 
  }
  
  public void setRBriefDescription(String BriefDescription) {
    if (BriefDescription != null) {
      StringType temp1 = new StringType();
      temp1.setValue(BriefDescription);
      setBriefDescription(this.of.createIncidentremedyInstanceTypeBriefDescription(temp1));
    } 
  }
  
  public void setRTicketOwner(String TicketOwner) {
    if (TicketOwner != null) {
      StringType temp1 = new StringType();
      temp1.setValue(TicketOwner);
      setTicketOwner(this.of.createIncidentremedyInstanceTypeTicketOwner(temp1));
    } 
  }
  
  public void setRSubcategory(String Subcategory) {
    if (Subcategory != null) {
      StringType temp1 = new StringType();
      temp1.setValue(Subcategory);
      setSubcategory(this.of.createIncidentremedyInstanceTypeSubcategory(temp1));
    } 
  }
  
  public void setRProductType(String ProductType) {
    if (ProductType != null) {
      StringType temp1 = new StringType();
      switch (ProductType) {
        case "General":
          temp1.setValue("GENERAL");
          break;
        case "SoftAlarm":
          temp1.setValue("SOFT ALARM");
          break;
        default:
          temp1.setValue(ProductType.toUpperCase());
          break;
      } 
      setProductType(this.of.createIncidentremedyInstanceTypeProductType(temp1));
    } 
  }
  
  public void setRProblemType(String ProblemType) {
    if (ProblemType != null) {
      StringType temp1 = new StringType();
      temp1.setValue(ProblemType);
      setProblemType(this.of.createIncidentremedyInstanceTypeProblemType(temp1));
    } 
  }
  
  public void setRInitialImpact(String InitialImpact) {
    if (InitialImpact != null) {
      StringType temp1 = new StringType();
      switch (InitialImpact) {
        case "1-Extensive/Widespread":
          temp1.setValue("1");
          break;
        case "2-Significant/Large":
          temp1.setValue("2");
          break;
        case "3-Moderate/Limited":
          temp1.setValue("3");
          break;
        case "4-Minor/Localized":
          temp1.setValue("4");
          break;
        default:
          temp1.setValue(InitialImpact);
          break;
      } 
      setInitialImpact(this.of.createIncidentremedyInstanceTypeInitialImpact(temp1));
    } 
  }
  
  public void setRIncidentManager(String IncidentManager) {
    if (IncidentManager != null) {
      StringType temp1 = new StringType();
      temp1.setValue(IncidentManager);
      setIncidentManager(this.of.createIncidentremedyInstanceTypeIncidentManager(temp1));
    } 
  }
  
  public void setRClienteEmpresarial(boolean ClienteEmpresarial) {
    BooleanType temp1 = new BooleanType();
    temp1.setValue(ClienteEmpresarial);
    setClienteEmpresarial(this.of.createIncidentremedyInstanceTypeClienteEmpresarial(temp1));
  }
  
  public void setRE1Afectados(byte E1Afectados) {
    DecimalType temp1 = new DecimalType();
    temp1.setValue(BigDecimal.valueOf(E1Afectados));
    setE1Afectados(this.of.createIncidentremedyInstanceTypeE1Afectados(temp1));
  }
  
  public void setRClientesAfectados(byte ClientesAfectados) {
    DecimalType temp1 = new DecimalType();
    temp1.setValue(BigDecimal.valueOf(ClientesAfectados));
    setClientesAfectados(this.of.createIncidentremedyInstanceTypeClientesAfectados(temp1));
  }
  
  public void setRCeldasAfectadas(byte CeldasAfectadas) {
    DecimalType temp1 = new DecimalType();
    temp1.setValue(BigDecimal.valueOf(CeldasAfectadas));
    setCeldasAfectadas(this.of.createIncidentremedyInstanceTypeCeldasAfectadas(temp1));
  }
  
  public void setRDslamAfectados(byte DslamAfectados) {
    DecimalType temp1 = new DecimalType();
    temp1.setValue(BigDecimal.valueOf(DslamAfectados));
    setDslamAfectados(this.of.createIncidentremedyInstanceTypeDslamAfectados(temp1));
  }
  
  public void setRInternetAfectados(byte InternetAfectados) {
    DecimalType temp1 = new DecimalType();
    temp1.setValue(BigDecimal.valueOf(InternetAfectados));
    setInternetAfectados(this.of.createIncidentremedyInstanceTypeInternetAfectados(temp1));
  }
  
  public void setRTipoFalla(String TipoFalla) {
    if (TipoFalla != null) {
      StringType temp1 = new StringType();
      switch (TipoFalla) {
        case "User Service Restoration":
          temp1.setValue("0");
          break;
        case "User Service Request":
          temp1.setValue("1");
          break;
        case "Infrastructure Restoration":
          temp1.setValue("2");
          break;
        case "Infrastructure Event":
          temp1.setValue("3");
          break;
        default:
          temp1.setValue(TipoFalla);
          break;
      } 
      setTipoFalla(this.of.createIncidentremedyInstanceTypeTipoFalla(temp1));
      
    } 
  }
  
  public void setRTTRemedydos(String TTRemedydos) {
    if (TTRemedydos != null) {
      StringType temp1 = new StringType();
      temp1.setValue(TTRemedydos);
      setTTRemedydos(this.of.createIncidentremedyInstanceTypeTTRemedydos(temp1));
    } 
  }
  
  public void setRAffectedCI(String AffectedCI) {
    if (AffectedCI != null) {
      StringType temp1 = new StringType();
      temp1.setValue(AffectedCI);
      setAffectedCI(this.of.createIncidentremedyInstanceTypeAffectedCI(temp1));
    } 
  }
  
  public void setROpenTime(Date OpenTime) throws ParseException, DatatypeConfigurationException {
    if (OpenTime != null)
      setOpenTime(this.of.createIncidentremedyInstanceTypeOpenTime(defineDate(OpenTime, this.prop.getProperty("DATEFORMAT")))); 
  }
  
  public void setRUpdatedTime(Date UpdatedTime) throws ParseException, DatatypeConfigurationException {
    if (UpdatedTime != null)
      setUpdatedTime(this.of.createIncidentremedyInstanceTypeUpdatedTime(defineDate(UpdatedTime, this.prop.getProperty("DATEFORMAT")))); 
  }
  
  public void setRLocation(String Location) {
    if (Location != null) {
      StringType temp1 = new StringType();
      temp1.setValue(Location);
      setLocation(this.of.createIncidentremedyInstanceTypeLocation(temp1));
    } 
  }
  
  public void setRCompany(String Company) {
    if (Company != null) {
      StringType temp1 = new StringType();
      temp1.setValue(Company);
      setCompany(this.of.createIncidentremedyInstanceTypeCompany(temp1));
    } 
  }
  
  public void setRUpdatedBy(String UpdatedBy) {
    if (UpdatedBy != null) {
      StringType temp1 = new StringType();
      temp1.setValue(UpdatedBy);
      setUpdatedBy(this.of.createIncidentremedyInstanceTypeUpdatedBy(temp1));
    } 
  }
  
  public void setRIMTicketStatus(String IMTicketStatus) {
    if (IMTicketStatus != null) {
      StringType temp1 = new StringType();
      switch (IMTicketStatus) {
        case "New":
          temp1.setValue("0");
          break;
        case "Assigned":
          temp1.setValue("1");
          break;
        case "In Progress":
          temp1.setValue("2");
          break;
        case "Pending":
          temp1.setValue("3");
          break;
        case "Resolved":
          temp1.setValue("4");
          break;
        case "Closed":
          temp1.setValue("5");
          break;
        case "Cancelled":
          temp1.setValue("6");
          break;
        default:
          temp1.setValue(IMTicketStatus);
          break;
      } 
      setIMTicketStatus(this.of.createIncidentremedyInstanceTypeIMTicketStatus(temp1));
    } 
  }
  
  public void setRPhase(String Phase) {
    if (Phase != null) {
      StringType temp1 = new StringType();
      temp1.setValue(Phase);
      setPhase(this.of.createIncidentremedyInstanceTypePhase(temp1));
    } 
  }
  
  public void setRSiteCategory(String SiteCategory) {
    if (SiteCategory != null) {
      StringType temp1 = new StringType();
      temp1.setValue(SiteCategory);
      setSiteCategory(this.of.createIncidentremedyInstanceTypeSiteCategory(temp1));
    } 
  }
  
  public void setRIncidentID(String IncidentID) {
    if (IncidentID != null) {
      StringType temp1 = new StringType();
      temp1.setValue(IncidentID);
      setIncidentID(this.of.createIncidentremedyInstanceTypeIncidentID(temp1));
    } 
  }
      //Alejandro
        public void setRResolution(String Resolution) {
        if (Resolution != null) {
            StringType temp1 = new StringType();
            temp1.setValue(Resolution);
            ArrayList<StringType> listResolution = new ArrayList();
            listResolution.add(temp1);
            SM_Resolution_Adapted resolution = new SM_Resolution_Adapted();
            resolution.setResolution(listResolution); 
            this.setResolution(resolution);
        }
    }
        public void setRJournalUpdates(String JournalUpdates) {
        if (JournalUpdates != null) {
            StringType temp1 = new StringType();
            temp1.setValue(JournalUpdates);
            ArrayList<StringType> listJournalUpdates = new ArrayList();
            listJournalUpdates.add(temp1);
            SM_JournalUpdates_Adapted journalupdates = new SM_JournalUpdates_Adapted();
            journalupdates.setJournalUpdates(listJournalUpdates);
            setJournalUpdates((IncidentremedyInstanceType.JournalUpdates)journalupdates);
        }
    }

}