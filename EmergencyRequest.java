public class EmergencyRequest {

    Object patient;

    int priority;

    String emergencyType;

    public EmergencyRequest(Object patient,
                            int priority,
                            String emergencyType) {

        this.patient = patient;
        this.priority = priority;
        this.emergencyType = emergencyType;
    }

    public void displayRequest() {

        System.out.println("--------------------------------");
        System.out.println("Patient ID     : " + getPatientField("patientId"));
        System.out.println("Patient Name   : " + getPatientField("name"));
        System.out.println("Emergency      : " + emergencyType);
        System.out.println("Priority Level : " + priority);
        System.out.println("--------------------------------");
    }

    private Object getPatientField(String fieldName) {
        if (patient == null) {
            return "Unknown";
        }

        try {
            java.lang.reflect.Field field = patient.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(patient);
        } catch (ReflectiveOperationException | SecurityException exception) {
            return "Unknown";
        }
    }
}
