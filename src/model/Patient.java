package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{

    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppoinmentDoctor> appoinmentDoctors = new ArrayList<>();
    private ArrayList<AppoinmentNurse> appoinmentNurse = new ArrayList<>();


    public ArrayList<AppoinmentDoctor> getAppoinmentDoctors() {
        return appoinmentDoctors;
    }

    public void addAppoinmentDoctors(Doctor doctor, Date date, String time) {
        AppoinmentDoctor appoinmentDoctor = new AppoinmentDoctor(this, doctor);
        appoinmentDoctor.schedule(date, time);
        appoinmentDoctors.add(appoinmentDoctor);
    }

    public ArrayList<AppoinmentNurse> getAppoinmentNurse() {
        return appoinmentNurse;
    }

    public void setAppoinmentNurse(ArrayList<AppoinmentNurse> appoinmentNurse) {
        this.appoinmentNurse = appoinmentNurse;
    }

    public Patient(String name, String email){ 
        super(name, email);
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public String getWeight (){
        return this.weight + " Kg.";
    }

    public String getHeight() {
        return this.height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public void setPhoneNumber(String phoneNumber) {
        
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAge: "+ birthday + "\n Weight: " + getWeight() + "\n Height: " + getHeight() + "\nBlood: " + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo del paciene");
        //throw new UnsupportedOperationException("Unimplemented method 'showDataUser'");
    }

    


}
