public class VisitHistory {

    private VisitNode getVisitHistory(Object patient) {
        try {
            var field = patient.getClass().getDeclaredField("visitHistory");
            field.setAccessible(true);
            return (VisitNode) field.get(patient);
        } catch (ReflectiveOperationException | ClassCastException exception) {
            throw new IllegalArgumentException(
                    "Patient must contain a VisitNode visitHistory field.", exception);
        }
    }

    private void setVisitHistory(Object patient, VisitNode visitHistory) {
        try {
            var field = patient.getClass().getDeclaredField("visitHistory");
            field.setAccessible(true);
            field.set(patient, visitHistory);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalArgumentException(
                    "Patient must contain a VisitNode visitHistory field.", exception);
        }
    }

    // Add a visit to patient's linked list
    public void addVisit(Object patient,
                         String date,
                         String reason,
                         String treatment) {

        VisitNode newVisit =
                new VisitNode(date, reason, treatment);

        if (getVisitHistory(patient) == null) {

            setVisitHistory(patient, newVisit);

        } else {

                var current =
                    getVisitHistory(patient);

            while (current.next != null) {
                current = current.next;
            }

            current.next = newVisit;
        }

        System.out.println("Visit added successfully.");
    }

    // Display patient's visit history
    public void displayHistory(Object patient) {

        if (getVisitHistory(patient) == null) {

            System.out.println("No visit history found.");
            return;
        }

        System.out.println("\n===== VISIT HISTORY =====");

        var current =
            getVisitHistory(patient);

        int count = 1;

        while (current != null) {

            System.out.println("\nVisit " + count);
            System.out.println("Date      : " + current.date);
            System.out.println("Reason    : " + current.reason);
            System.out.println("Treatment : " + current.treatment);

            current = current.next;
            count++;
        }
    }
}

class VisitNode {

    String date;
    String reason;
    String treatment;
    VisitNode next;

    VisitNode(String date, String reason, String treatment) {
        this.date = date;
        this.reason = reason;
        this.treatment = treatment;
    }
}
