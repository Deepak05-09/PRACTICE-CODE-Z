package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;

public class Report {

 private String id;
 private String patientId;
 private LocalDate generatedOn;
 private Doctor generatedBy;
 private String reason;
 private String treatementNeeded;
 private String treatementProvided;
 private String MedicinePrescribed;
 private boolean needRoom;
  
 Report(){
    generatedOn=LocalDate.now();
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
 public void setGeneratedBy(Doctor generatedBy) {
     this.generatedBy = generatedBy;
 }
 public void setReason(String reason) {
     this.reason = reason;
 }
 public void setTreatementNeeded(String treatementNeeded) {
     this.treatementNeeded = treatementNeeded;
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
 public Doctor getGeneratedBy() {
     return generatedBy;
 }
 public String getReason() {
     return reason;
 }
 public String getTreatementNeeded() {
     return treatementNeeded;
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
 /*-------------------------------------------*/
}
