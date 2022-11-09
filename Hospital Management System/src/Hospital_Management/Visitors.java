package Hospital_Management;

import java.time.LocalTime;

class Visitors
{
    private String name;
    private int age;
    private String ph_no;
    private String address;
    private LocalTime visitTime;
    private String visitingPatient;

    Visitors(String name,int age,String ph_no,String address,String patient){
       setName(name);
       setAge(age);
       setPh_no(ph_no);
       setAddress(address);
       setvisitingPatient(patient);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setvisitingPatient(String visitingPatient) {
        this.visitingPatient = visitingPatient;
    }
    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPh_no() {
        return ph_no;
    }
    public String getAddress() {
        return address;
    }
    public String getvisitingPatient() {
        return visitingPatient;
    }
    public LocalTime getVisitedTime() {
        return visitTime;
    }

}