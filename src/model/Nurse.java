package model;

public class Nurse extends User {
    
    private String speciality;

    public Nurse (String name, String email){
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Verde");
        System.out.println("Departamentos: Pediatra, Cardiologia");
        //throw new UnsupportedOperationException("Unimplemented method 'showDataUser'");
    }
    

}
