public class TreatmentStack {

    private static class TreatmentNode {

        private final Patient patient;
        private TreatmentNode next;

        private TreatmentNode(Patient patient) {
            this.patient = patient;
        }
    }

    private TreatmentNode top;

    // PUSH
    public void push(Patient patient) {

        TreatmentNode newNode =
                new TreatmentNode(patient);

        newNode.next = top;

        top = newNode;

        System.out.println(
                "Patient added to treatment stack."
        );
    }

    // POP
    public Patient pop() {

        if (top == null) {
            return null;
        }

        Patient patient = top.patient;

        top = top.next;

        return patient;
    }

    // PEEK
    public Patient peek() {

        if (top == null) {
            return null;
        }

        return top.patient;
    }

    // Check if empty
    public boolean isEmpty() {

        return top == null;
    }

    // Display stack
    public void displayStack() {

        if (top == null) {

            System.out.println(
                    "Treatment stack is empty."
            );

            return;
        }

        System.out.println(
                "\n===== TREATMENT STACK ====="
        );

        TreatmentNode current = top;

        while (current != null) {

            System.out.println(
                    "Patient ID: " +
                    current.patient.patientId +
                    " | Name: " +
                    current.patient.name
            );

            current = current.next;
        }
    }
}

/** Represents a patient stored in the treatment stack. */
class Patient {

    final String patientId;
    final String name;

    Patient(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }
}
