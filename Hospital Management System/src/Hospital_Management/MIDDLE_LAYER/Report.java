package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;

public class Report {

 private String id;
 private String patientId;
 private LocalDate generatedOn;
 private String generatedBy;
 private String description;
 private String treatementProvided;
 private String MedicinePrescribed;
 private boolean needRoom;
  
 static int rp_id=1;

 Report(String patientId,String description,String treatementProvided,String medicinePrescribed,String generatedby){
    id="RP"+rp_id;
    this.patientId=patientId;
    generatedOn=LocalDate.now();
    this.description=description;
    this.treatementProvided=treatementProvided;
    this.MedicinePrescribed=medicinePrescribed;
    this.generatedBy=generatedby;
 }

 /*-------------------------------------------*/
 public void setId(String id) {
     this.id = id;
 }
 public void setPatientId(String patientId) {
     this.patientId = patientId;
 }
 public void setGeneratedOn(LocalDate generatedOn) {
     this.generatedOn = generatedOn;
 }

 public void setGeneratedBy(String generatedBy) {
     this.generatedBy = generatedBy;
 }
 
 public void setdescription(String reason) {
     this.description = reason;
 }
 
 public void setTreatementProvided(String treatementProvided) {
     this.treatementProvided = treatementProvided;
 }
 public void setMedicinePrescribed(String medicinePrescribed) {
     MedicinePrescribed = medicinePrescribed;
 }

 public void setNeedRoom(boolean needRoom) {
     this.needRoom = needRoom;
 }
 /*-------------------------------------------*/
 public String getId() {
     return id;
 }
 public String getPatientId() {
     return patientId;
 }
 public LocalDate getGeneratedOn() {
     return generatedOn;
 }
 public String getGeneratedBy() {
     return generatedBy;
 }
 public String getdescription() {
     return description;
 }
 
 public String getTreatementProvided() {
     return treatementProvided;
 }

 public String getMedicinePrescribed() {
     return MedicinePrescribed;
 }
 
 public Boolean getRoomNeed(){
  return needRoom;
 }
 
 public String toString()
 {
    return "Patient Id: "+this.patientId+"  Generated Date : "+this.generatedOn+" Generated By : "+getGeneratedBy();
 }
 /*-------------------------------------------*/
}
