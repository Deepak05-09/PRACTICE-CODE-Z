package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.BillDAO;
import Hospital_Management.DATA_LAYER.PatientDAO;


public class Patient 
{
    private String name;
    private String id;
    private int age;
    private Sex sex;
    private BloodGroup Bloodgroup;
    private int weight;
    private int height;
    private String ph_no;
    private String allergyTo;
    private ArrayList<Report> report;
    private String password;
    
    static int p_id=1;
    
    Patient(String password){
       id="PT"+p_id++;
       this.password=password;
    }

    public Patient(String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no,String allergy)
    {
        this.id="PT"+p_id++;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.Bloodgroup=bloodGroup;
        this.height=height;
        this.weight=weight;
        this.ph_no=ph_no;
        allergyTo=allergy;
        report=new ArrayList<>();
        password=ph_no;
    }
    
    /*-----------------SETTERS--------------------------*/
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public void setBloodgroup(BloodGroup bloodtype) {
        Bloodgroup = bloodtype;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
    public void setAllergyTo(String allergyTo) {
        this.allergyTo = allergyTo;
    }
    public void setReport(Report report) {
        this.report.add(report);
    }
    public void changePassword(String password) {
        this.password = password;
    }
    
    /*------------------GETTERS-------------------------*/
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public Sex getSex() {
        return sex;
    }
    public BloodGroup getBloodtype() {
        return Bloodgroup;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public String getPh_no() {
        return ph_no;
    }
    public String getAllergyTo() {
        return allergyTo;
    }
    public String getPassword() {
        return password;
    }
    /*-------------------------------------------*/

    public Patient viewProfile(){
        return this;
    }

    public ArrayList<Report> viewReports() {
        return this.report;
     }
    
    public void giveReview(String docId,String docName,String rName,LocalDateTime dateTime,int star,String pros,String cons,String description){
        Review review=new Review(docId, docName, rName, dateTime,star, pros, cons, description);
        DoctorList doctorList=new DoctorList();
        doctorList.addReview(review);
    }
    

    public ArrayList<Bill> viewBill(){
        return billDAO.get(id);
    }

    public static boolean ispatientExists(String id){
        return patientDAO.isExist(id);
    }
    
    private static PatientDAO patientDAO=new PatientDAO();
    private BillDAO billDAO=new BillDAO();
}