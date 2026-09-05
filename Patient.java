public class Patient {

    int patientId;
    String name;
    int age;
    String gender;
    String condition;

    // Linked List for patient visit history
    VisitNode visitHistory;

    public Patient(int patientId, String name, int age,
                   String gender, String condition) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.condition = condition;
        this.visitHistory = null;
    }

    public void displayPatient() {

        System.out.println("--------------------------------");
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Condition  : " + condition);
        System.out.println("--------------------------------");
    }
}
