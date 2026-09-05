import java.util.Scanner;

public class MiniHospitalSystem {

        static class Patient {
                int id, age;
                String name, gender, condition;
                Patient(int id, String name, int age, String gender, String condition) {
                        this.id = id; this.name = name; this.age = age;
                        this.gender = gender; this.condition = condition;
                }
                void displayPatient() {
                        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age
                                        + " | Gender: " + gender + " | Condition: " + condition);
                }
        }

        static class PatientBST {
                static class Node { Patient patient; Node left, right; Node(Patient p) { patient = p; } }
                Node root;
                void insert(Patient p) { root = insert(root, p); }
                private Node insert(Node n, Patient p) {
                        if (n == null) return new Node(p);
                        if (p.id < n.patient.id) n.left = insert(n.left, p);
                        else if (p.id > n.patient.id) n.right = insert(n.right, p);
                        return n;
                }
                Patient search(int id) {
                        Node n = root;
                        while (n != null) { if (id == n.patient.id) return n.patient; n = id < n.patient.id ? n.left : n.right; }
                        return null;
                }
                void inOrder() { inOrder(root); }
                private void inOrder(Node n) { if (n != null) { inOrder(n.left); n.patient.displayPatient(); inOrder(n.right); } }
                void preOrder() { preOrder(root); }
                private void preOrder(Node n) { if (n != null) { n.patient.displayPatient(); preOrder(n.left); preOrder(n.right); } }
                void postOrder() { postOrder(root); }
                private void postOrder(Node n) { if (n != null) { postOrder(n.left); postOrder(n.right); n.patient.displayPatient(); } }
        }

        static class EmergencyRequest {
                Patient patient; int priority; String emergencyType;
                EmergencyRequest(Patient p, int priority, String type) { patient = p; this.priority = priority; emergencyType = type; }
                void displayRequest() { System.out.println("Patient: " + patient.name + " | Priority: " + priority + " | Type: " + emergencyType); }
        }

        static class EmergencyPriorityQueue {
                EmergencyRequest[] queue; int size;
                EmergencyPriorityQueue(int capacity) { queue = new EmergencyRequest[capacity]; }
                void enqueue(EmergencyRequest r) {
                        if (size == queue.length) { System.out.println("Emergency queue is full."); return; }
                        int i = size++;
                        while (i > 0 && queue[(i - 1) / 2].priority < r.priority) { queue[i] = queue[(i - 1) / 2]; i = (i - 1) / 2; }
                        queue[i] = r;
                }
                EmergencyRequest dequeue() {
                        if (size == 0) return null;
                        EmergencyRequest result = queue[0], last = queue[--size];
                        int i = 0;
                        while (size > 0 && 2 * i + 1 < size) {
                                int child = 2 * i + 1;
                                if (child + 1 < size && queue[child + 1].priority > queue[child].priority) child++;
                                if (queue[child].priority <= last.priority) break;
                                queue[i] = queue[child]; i = child;
                        }
                        if (size > 0) queue[i] = last;
                        queue[size] = null; return result;
                }
                void displayQueue() { if (size == 0) System.out.println("Emergency queue is empty."); else for (int i = 0; i < size; i++) queue[i].displayRequest(); }
        }

        static class TreatmentStack {
                Patient[] stack = new Patient[100]; int size;
                void push(Patient p) { if (size < stack.length) stack[size++] = p; }
                Patient pop() { return size == 0 ? null : stack[--size]; }
                void displayStack() { if (size == 0) System.out.println("Treatment stack is empty."); else for (int i = size - 1; i >= 0; i--) stack[i].displayPatient(); }
        }

        static class VisitHistory {
                static class Visit { Patient patient; String date, reason, treatment; Visit next; Visit(Patient p, String d, String r, String t) { patient=p; date=d; reason=r; treatment=t; } }
                Visit first;
                void addVisit(Patient p, String d, String r, String t) { Visit v = new Visit(p,d,r,t); v.next = first; first = v; }
                void displayHistory(Patient p) { boolean found=false; for (Visit v=first; v!=null; v=v.next) if (v.patient == p) { found=true; System.out.println("Date: " + v.date + " | Reason: " + v.reason + " | Treatment: " + v.treatment); } if (!found) System.out.println("No visit history found."); }
        }

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientRecords =
            new PatientBST();

    static EmergencyPriorityQueue emergencyQueue =
            new EmergencyPriorityQueue(100);

    static TreatmentStack treatmentStack =
            new TreatmentStack();

    static VisitHistory visitHistory =
            new VisitHistory();


    // ==========================================
    // REGISTER PATIENT
    // ==========================================

    public static void registerPatient() {

        System.out.println("\n===== REGISTER PATIENT =====");

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        if (patientRecords.search(id) != null) {

            System.out.println("Patient ID already exists.");

            return;
        }

        System.out.print("Enter Name: ");

        String name = scanner.nextLine();

        System.out.print("Enter Age: ");

        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Gender: ");

        String gender = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");

        String condition = scanner.nextLine();

        Patient patient =
                new Patient(
                        id,
                        name,
                        age,
                        gender,
                        condition
                );

        patientRecords.insert(patient);

        System.out.println(
                "Patient registered successfully."
        );
    }


    // ==========================================
    // SEARCH PATIENT
    // ==========================================

    public static void searchPatient() {

        System.out.println("\n===== SEARCH PATIENT =====");

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        Patient patient =
                patientRecords.search(id);

        if (patient == null) {

            System.out.println("Patient not found.");

        } else {

            patient.displayPatient();
        }
    }


    // ==========================================
    // REQUEST EMERGENCY TREATMENT
    // ==========================================

    public static void requestEmergencyTreatment() {

        System.out.println(
                "\n===== EMERGENCY TREATMENT REQUEST ====="
        );

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        Patient patient =
                patientRecords.search(id);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        System.out.println("\nPriority Levels:");

        System.out.println("3 - Critical");
        System.out.println("2 - Serious");
        System.out.println("1 - Normal");

        System.out.print("Enter Priority: ");

        int priority = scanner.nextInt();

        scanner.nextLine();

        if (priority < 1 || priority > 3) {

            System.out.println("Invalid priority.");

            return;
        }

        System.out.print("Enter Emergency Type: ");

        String emergencyType =
                scanner.nextLine();

        EmergencyRequest request =
                new EmergencyRequest(
                        patient,
                        priority,
                        emergencyType
                );

        emergencyQueue.enqueue(request);
    }


    // ==========================================
    // PROCESS EMERGENCY
    // ==========================================

    public static void processEmergency() {

        System.out.println(
                "\n===== PROCESS EMERGENCY ====="
        );

        EmergencyRequest request =
                emergencyQueue.dequeue();

        if (request == null) {

            System.out.println(
                    "No emergency patients waiting."
            );

            return;
        }

        System.out.println(
                "Processing emergency patient:"
        );

        request.displayRequest();

        treatmentStack.push(request.patient);

        System.out.println(
                "Patient transferred to treatment stack."
        );
    }


    // ==========================================
    // COMPLETE TREATMENT
    // ==========================================

    public static void completeTreatment() {

        System.out.println(
                "\n===== COMPLETE TREATMENT ====="
        );

        Patient patient =
                treatmentStack.pop();

        if (patient == null) {

            System.out.println(
                    "No patients in treatment stack."
            );

            return;
        }

        System.out.println(
                "Completing treatment for: " +
                patient.name
        );

        scanner.nextLine();

        System.out.print("Enter Visit Date: ");

        String date =
                scanner.nextLine();

        System.out.print("Enter Visit Reason: ");

        String reason =
                scanner.nextLine();

        System.out.print("Enter Treatment Given: ");

        String treatment =
                scanner.nextLine();

        visitHistory.addVisit(
                patient,
                date,
                reason,
                treatment
        );

        System.out.println(
                "Treatment completed successfully."
        );
    }


    // ==========================================
    // VIEW PATIENT HISTORY
    // ==========================================

    public static void viewPatientHistory() {

        System.out.println(
                "\n===== PATIENT VISIT HISTORY ====="
        );

        System.out.print("Enter Patient ID: ");

        int id = scanner.nextInt();

        Patient patient =
                patientRecords.search(id);

        if (patient == null) {

            System.out.println(
                    "Patient not found."
            );

            return;
        }

        visitHistory.displayHistory(patient);
    }


    // ==========================================
    // DISPLAY ALL PATIENTS
    // ==========================================

    public static void displayPatients() {

        System.out.println(
                "\n===== ALL PATIENT RECORDS ====="
        );

        if (patientRecords.root == null) {

            System.out.println(
                    "No patients registered."
            );

            return;
        }

        patientRecords.inOrder();
    }


    // ==========================================
    // BST TRAVERSALS
    // ==========================================

    public static void displayTraversals() {

        System.out.println(
                "\n===== BST TRAVERSALS ====="
        );

        System.out.println("\n--- IN-ORDER ---");

        patientRecords.inOrder();

        System.out.println("\n--- PRE-ORDER ---");

        patientRecords.preOrder();

        System.out.println("\n--- POST-ORDER ---");

        patientRecords.postOrder();
    }


    // ==========================================
    // MAIN MENU
    // ==========================================

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n");

            System.out.println(
                    "=============================================="
            );

            System.out.println(
                    "     MINI HOSPITAL EMERGENCY MANAGEMENT"
            );

            System.out.println(
                    "=============================================="
            );

            System.out.println("1. Register Patient");

            System.out.println("2. Search Patient");

            System.out.println(
                    "3. Request Emergency Treatment"
            );

            System.out.println(
                    "4. Process Emergency Patient"
            );

            System.out.println(
                    "5. Complete Treatment"
            );

            System.out.println(
                    "6. View Patient Visit History"
            );

            System.out.println(
                    "7. Display All Patients"
            );

            System.out.println(
                    "8. Display BST Traversals"
            );

            System.out.println(
                    "9. Display Emergency Queue"
            );

            System.out.println(
                    "10. Display Treatment Stack"
            );

            System.out.println("0. Exit");

            System.out.println(
                    "=============================================="
            );

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    requestEmergencyTreatment();
                    break;

                case 4:
                    processEmergency();
                    break;

                case 5:
                    completeTreatment();
                    break;

                case 6:
                    viewPatientHistory();
                    break;

                case 7:
                    displayPatients();
                    break;

                case 8:
                    displayTraversals();
                    break;

                case 9:
                    emergencyQueue.displayQueue();
                    break;

                case 10:
                    treatmentStack.displayStack();
                    break;

                case 0:

                    System.out.println(
                            "Thank you for using the Hospital System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}
