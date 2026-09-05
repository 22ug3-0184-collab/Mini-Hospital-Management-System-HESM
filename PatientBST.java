public class PatientBST {

    /** Patient data stored by the BST. */
    public static class Patient {
        public final int patientId;

        public Patient(int patientId) {
            this.patientId = patientId;
        }

        public void displayPatient() {
            System.out.println("Patient ID: " + patientId);
        }
    }

    private static class BSTNode {
        private final Patient patient;
        private BSTNode left;
        private BSTNode right;

        private BSTNode(Patient patient) {
            this.patient = patient;
        }
    }

    BSTNode root;

    // Insert patient into BST
    public void insert(Patient patient) {

        root = insertRecursive(root, patient);
    }

    private BSTNode insertRecursive(BSTNode node,
                                    Patient patient) {

        if (node == null) {
            return new BSTNode(patient);
        }

        if (patient.patientId < node.patient.patientId) {

            node.left =
                    insertRecursive(node.left, patient);

        } else if (patient.patientId > node.patient.patientId) {

            node.right =
                    insertRecursive(node.right, patient);

        } else {

            System.out.println("Patient ID already exists.");
        }

        return node;
    }

    // Search patient by ID
    public Patient search(int patientId) {

        BSTNode current = root;

        while (current != null) {

            if (patientId == current.patient.patientId) {
                return current.patient;
            }

            if (patientId < current.patient.patientId) {

                current = current.left;

            } else {

                current = current.right;
            }
        }

        return null;
    }

    // In-order traversal
    public void inOrder() {

        inOrderRecursive(root);
    }

    private void inOrderRecursive(BSTNode node) {

        if (node != null) {

            inOrderRecursive(node.left);

            node.patient.displayPatient();

            inOrderRecursive(node.right);
        }
    }

    // Pre-order traversal
    public void preOrder() {

        preOrderRecursive(root);
    }

    private void preOrderRecursive(BSTNode node) {

        if (node != null) {

            node.patient.displayPatient();

            preOrderRecursive(node.left);

            preOrderRecursive(node.right);
        }
    }

    // Post-order traversal
    public void postOrder() {

        postOrderRecursive(root);
    }

    private void postOrderRecursive(BSTNode node) {

        if (node != null) {

            postOrderRecursive(node.left);

            postOrderRecursive(node.right);

            node.patient.displayPatient();
        }
    }
}
