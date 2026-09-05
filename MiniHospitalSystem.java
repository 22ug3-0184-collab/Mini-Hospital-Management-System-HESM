import java.util.Scanner;

// 1. PATIENT CLASS

class Patient {
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

// 2. VISIT HISTORY - LINKED LIST

class VisitNode {
    String date;
    String reason;
    String treatment;
    VisitNode next;

    public VisitNode(String date, String reason, String treatment) {
        this.date = date;
        this.reason = reason;
        this.treatment = treatment;
        this.next = null;
    }
}

class VisitHistory {

    // Add a visit to the patient's linked list
    public void addVisit(Patient patient, String date,
                         String reason, String treatment) {

        VisitNode newVisit =
                new VisitNode(date, reason, treatment);

        if (patient.visitHistory == null) {
            patient.visitHistory = newVisit;
        } else {
            VisitNode current = patient.visitHistory;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newVisit;
        }

        System.out.println("Visit added successfully.");
    }

    // Display patient's visit history
    public void displayHistory(Patient patient) {

        if (patient.visitHistory == null) {
            System.out.println("No visit history found.");
            return;
        }

        System.out.println("\n===== VISIT HISTORY =====");

        VisitNode current = patient.visitHistory;
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

// 3. PATIENT RECORDS - BINARY SEARCH TREE

class BSTNode {
    Patient patient;
    BSTNode left;
    BSTNode right;

    public BSTNode(Patient patient) {
        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}

class PatientBST {

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
            node.left = insertRecursive(node.left, patient);
        } else if (patient.patientId > node.patient.patientId) {
            node.right = insertRecursive(node.right, patient);
        } else {
            System.out.println("Patient ID already exists.");
        }

        return node;
    }

    // Search patient by Patient ID
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

// 4. EMERGENCY REQUEST - PRIORITY QUEUE

class EmergencyRequest {

    Patient patient;
    int priority;
    String emergencyType;

    public EmergencyRequest(Patient patient,
                            int priority,
                            String emergencyType) {

        this.patient = patient;
        this.priority = priority;
        this.emergencyType = emergencyType;
    }

    public void displayRequest() {

        System.out.println("--------------------------------");
        System.out.println("Patient ID     : " + patient.patientId);
        System.out.println("Patient Name   : " + patient.name);
        System.out.println("Emergency      : " + emergencyType);
        System.out.println("Priority Level : " + priority);
        System.out.println("--------------------------------");
    }
}

// PRIORITY QUEUE IMPLEMENTATION

class EmergencyPriorityQueue {

    EmergencyRequest[] queue;
    int size;

    public EmergencyPriorityQueue(int capacity) {
        queue = new EmergencyRequest[capacity];
        size = 0;
    }

    // Add emergency request
    public void enqueue(EmergencyRequest request) {

        if (size == queue.length) {
            System.out.println("Emergency queue is full.");
            return;
        }

        queue[size] = request;
        size++;

        System.out.println("Emergency request added.");
    }

    // Remove highest-priority request
    public EmergencyRequest dequeue() {

        if (size == 0) {
            return null;
        }

        int highestPriorityIndex = 0;

        for (int i = 1; i < size; i++) {

            if (queue[i].priority >
                queue[highestPriorityIndex].priority) {

                highestPriorityIndex = i;
            }
        }

        EmergencyRequest highest =
                queue[highestPriorityIndex];

        // Shift remaining elements
        for (int i = highestPriorityIndex; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        queue[size - 1] = null;
        size--;

        return highest;
    }

    // Display all emergency requests
    public void displayQueue() {

        if (size == 0) {
            System.out.println("No emergency requests.");
            return;
        }

        System.out.println("\n===== EMERGENCY QUEUE =====");

        for (int i = 0; i < size; i++) {
            queue[i].displayRequest();
        }
    }
}

// 5. TREATMENT QUEUE - LIFO STACK

class TreatmentNode {

    Patient patient;
    TreatmentNode next;

    public TreatmentNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}


class TreatmentStack {

    private TreatmentNode top;

    
    // PUSH
    // Add a patient to the top of the stack
    

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
    // Remove the patient from the top of the stack
    
    public Patient pop() {

        if (top == null) {
            return null;
        }

        Patient patient = top.patient;

        top = top.next;

        return patient;
    }


    // PEEK
    // View the patient at the top without removing
    
    public Patient peek() {

        if (top == null) {
            return null;
        }

        return top.patient;
    }


    // CHECK IF STACK IS EMPTY
    
    public boolean isEmpty() {

        return top == null;
    }


    // DISPLAY STACK
    
    public void displayStack() {

        if (top == null) {

            System.out.println(
                    "Treatment stack is empty."
            );

            return;
        }

        System.out.println("\n===== TREATMENT STACK =====");

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


    public static void enqueue(Patient patient) {
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }
}


// 6. MAIN HOSPITAL SYSTEM

public class MiniHospitalSystem{

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientRecords =
            new PatientBST();

    static EmergencyPriorityQueue emergencyQueue =
            new EmergencyPriorityQueue(100);

    static TreatmentStack treatmentStack =
            new TreatmentStack();

    static VisitHistory visitHistory =
            new VisitHistory();

// REGISTER PATIENT

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
                new Patient(id, name, age, gender, condition);

        patientRecords.insert(patient);

        System.out.println("Patient registered successfully.");
    }

    // SEARCH PATIENT

    public static void searchPatient() {

        System.out.println("\n===== SEARCH PATIENT =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientRecords.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            patient.displayPatient();
        }
    }

    // REQUEST EMERGENCY TREATMENT

    public static void requestEmergencyTreatment() {

        System.out.println("\n===== EMERGENCY TREATMENT REQUEST =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientRecords.search(id);

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
        String emergencyType = scanner.nextLine();

        EmergencyRequest request =
                new EmergencyRequest(
                        patient,
                        priority,
                        emergencyType
                );

        emergencyQueue.enqueue(request);
    }

    // PROCESS EMERGENCY

    public static void processEmergency() {

        System.out.println("\n===== PROCESS EMERGENCY =====");

        EmergencyRequest request =
                emergencyQueue.dequeue();

        if (request == null) {
            System.out.println("No emergency patients waiting.");
            return;
        }

        System.out.println("Processing emergency patient:");

        request.displayRequest();

        treatmentStack.push(request.patient);

        System.out.println(
                "Patient transferred to treatment queue."
        );
    }


    // COMPLETE TREATMENT
    
    public static void completeTreatment() {

        System.out.println("\n===== COMPLETE TREATMENT =====");

        Patient patient =
            treatmentStack.pop();

        if (patient == null) {
            System.out.println("No patients in treatment queue.");
            return;
        }

        System.out.println(
                "Completing treatment for: " +
                patient.name
        );

        scanner.nextLine();

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Visit Reason: ");
        String reason = scanner.nextLine();

        System.out.print("Enter Treatment Given: ");
        String treatment = scanner.nextLine();

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


    // VIEW PATIENT HISTORY
    
    public static void viewPatientHistory() {

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        Patient patient = patientRecords.search(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        visitHistory.displayHistory(patient);
    }

    // DISPLAY ALL PATIENTS
    
    public static void displayPatients() {

        System.out.println("\n===== ALL PATIENT RECORDS =====");

        if (patientRecords.root == null) {
            System.out.println("No patients registered.");
            return;
        }

        patientRecords.inOrder();
    }


    // BST TRAVERSALS

    public static void displayTraversals() {

        System.out.println("\n===== BST TRAVERSALS =====");

        System.out.println("\n--- IN-ORDER ---");
        patientRecords.inOrder();

        System.out.println("\n--- PRE-ORDER ---");
        patientRecords.preOrder();

        System.out.println("\n--- POST-ORDER ---");
        patientRecords.postOrder();
    }




    // MAIN MENU
    
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n");
            System.out.println("==============================================");
            System.out.println("     MINI HOSPITAL EMERGENCY MANAGEMENT");
            System.out.println("==============================================");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Request Emergency Treatment");
            System.out.println("4. Process Emergency Patient");
            System.out.println("5. Complete Treatment");
            System.out.println("6. View Patient Visit History");
            System.out.println("7. Display All Patients");
            System.out.println("8. Display BST Traversals");
            System.out.println("9. Display Emergency Queue");
            System.out.println("10. Display Treatment Queue");
            System.out.println("0. Exit");
            System.out.println("==============================================");

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
                    emergencyQueue.displayQueue();
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


