package edu.ithaca.barr.meds;



import java.util.ArrayList;

public class Patient {
    private String firstname;
    private String lastname;
    private int id;
    private String email;
    private String password;
    private boolean notTakenProperly;
    private boolean done;

    public Patient(String firstname, String lastname, int id, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.email = email;
        this.password = password;
      
        
    }


    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstname;
    }

    public String getLastName(){
        return lastname;
    }
    
    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setNotTakenProperly(boolean notTakenProperly){
        this.notTakenProperly = notTakenProperly;
    }

    public boolean getNotTakenProperly( ){
        return notTakenProperly;
    }


    public void setFinishedPrescription(boolean done){
        this.done= done;
    }
  public boolean finishMedication(){
      return done;
        
    }

}
