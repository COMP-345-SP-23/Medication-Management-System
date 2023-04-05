package edu.ithaca.barr.meds;

public class Patient {
    String email;
    String password;
    public Patient(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    
}
