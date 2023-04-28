[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10008270&assignment_repo_type=AssignmentRepo)
# CS345 - Software Engineering at Ithaca College
## Project 02 - Medication Management System

Names:
<< Simret, Ryan, Nardos, Jackson >>


## Sprint 1

Link to UML Diagrams:
https://drive.google.com/file/d/17STnlC82BHdTzgcE2tbXpQmmoAd3Nef2/view?usp=sharing

Sprint 1 Goal:
Implement add, update, and remove methods for medication

Link to Sprint-1 Demo Template:
https://docs.google.com/document/d/1fax_K5YwO2fSB1nvWPvlz7bAZdY4FE4a0QqgtNC8f9I/edit?usp=sharing

Link to Sprint-1 Retrospective Template:
https://docs.google.com/document/d/1jvVmxO__ctFuvnuccIxOlFyEPgpHO2GMbjiDkYvotwk/edit?usp=sharing

Three Use Cases that you will implement first:
1. Users can log in with their account
2. Doctors can prescribe medication to patients
3. The hospital can keep track of all available medications

Which classes & methods do you need to implement for these use cases?
(Indicated which team member is responsible for the implemenation)
1. Doctor - prescribeMedication, updatePrescription (Simret)
2. Patient - requestMedication, viewMedication, isPrescribed, getPassword (Ryan)
3. Hospital - searchMedication, createDoctorAccount, createPatientAccount, login, isAccountValid, isEmailValid, isInputValid, isPasswordValid (Nardos, Jackson)
4. Medication - getName, getId, getDosage, getFrequency (Nardos)


## Sprint 2

Link to UML Diagrams: 
https://drive.google.com/file/d/173eo1GQB0OruaIJAZN5AbeuT8WhMS_RH/view?usp=sharing

Sprint 2 Goal: 
The nurse and patient should be able to interact with the medications, note whether or not it has been taken, and ensure we as users can interact with the product.

Link to Sprint-2 Demo Template: 
https://docs.google.com/document/d/13I9qBxyDp7U4QhsnHe_qwfHW9Dnpp63RJJuaEBakXiw/edit

Link to Sprint-2 Retrospective Template: 
https://docs.google.com/document/d/1GyUqQ98g1fyjH1OvfaZ-NeLqj2uE4O_gJG5dDpgdiQ8/edit

Use Cases to implement: 
1. Medication should have a history that shows how much of a med is added or taken away from the hospital
2. Nurse should notify the doctor when a patient finishes their prescription
3. Users should be able to search for medications prescribed to a patient

Classes and methods to implement: 
1. UI
2. Nurse - 
3. Medication - getQuantity, getHistory, addMedication, reduceMedication, updateHistory (Ryan)
4. Hospital - 
5. Patient - 

