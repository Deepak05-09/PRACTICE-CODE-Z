package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDateTime;

public class Review {

   

   private String docId;
   private String docName;

   private String rName;
   private LocalDateTime dateTime;
   private int star;
   private String pros;
   private String cons;
   private String description;
   
   Review(String docId,String docName,String rName,LocalDateTime dateTime,int star,String pros,String cons,String description){
      this.docId=docId;
      this.docName=docName;
      this.rName=rName;
      this.dateTime=dateTime;
      this.star=star;
      this.pros=pros;
      this.cons=cons;
      this.description=description;
   }

   public String getDocId() {
       return docId;
   }
   public String getDocName() {
       return docName;
   }
   public String getrName() {
       return rName;
   }
   public LocalDateTime getTime() {
       return dateTime;
   }
   public int getStar() {
       return star;
   }
   public String getPros() {
       return pros;
   }
   public String getCons() {
       return cons;
   }
   public String getDescription() {
       return description;
   }
}

