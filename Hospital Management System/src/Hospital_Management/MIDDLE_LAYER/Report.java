package Hospital_Management.MIDDLE_LAYER;

import java.util.ArrayList;
import java.util.Date;

public class Report {

 private String id;
 private String patientId;
 private Date generatedOn;
 private Doctor generatedBy;
 private String reason;
 private ArrayList<String> treatementNeeded;
 private ArrayList<String> treatementProvided;
 private  ArrayList<String> MedicinePrescribed;
 private boolean needRoom;

 /*-------------------------------------------*/
 public void setId(String id) {
     this.id = id;
 }
 public void setPatientId(String patientId) {
     this.patientId = patientId;
 }
 public void setGeneratedOn(Date generatedOn) {
     this.generatedOn = generatedOn;
 }
 public void setGeneratedBy(Doctor generatedBy) {
     this.generatedBy = generatedBy;
 }
 public void setReason(String reason) {
     this.reason = reason;
 }
 public void setTreatementNeeded(ArrayList<String> treatementNeeded) {
     this.treatementNeeded = treatementNeeded;
 }
 public void setTreatementProvided(ArrayList<String> treatementProvided) {
     this.treatementProvided = treatementProvided;
 }
 public void setMedicinePrescribed(ArrayList<String> medicinePrescribed) {
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
 public Date getGeneratedOn() {
     return generatedOn;
 }
 public Doctor getGeneratedBy() {
     return generatedBy;
 }
 public String getReason() {
     return reason;
 }
 public ArrayList<String> getTreatementNeeded() {
     return treatementNeeded;
 }
 public ArrayList<String> getTreatementProvided() {
     return treatementProvided;
 }
 public ArrayList<String> getMedicinePrescribed() {
     return MedicinePrescribed;
 }
 public Boolean getRoomNeed(){
  return needRoom;
 }
 /*-------------------------------------------*/
}
