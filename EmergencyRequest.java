public class EmergencyRequest {
    Patient patient; int priority; String emergencyType;
    public EmergencyRequest(Patient patient,int priority,String emergencyType){this.patient=patient;this.priority=priority;this.emergencyType=emergencyType;}
    public void displayRequest(){System.out.println("--------------------------------");System.out.println("Patient ID     : "+patient.patientId);System.out.println("Patient Name   : "+patient.name);System.out.println("Emergency      : "+emergencyType);System.out.println("Priority Level : "+priority);System.out.println("--------------------------------");}
}
