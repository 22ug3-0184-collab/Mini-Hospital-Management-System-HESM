import java.util.Scanner;
public class MiniHospitalSystem {
 static Scanner scanner=new Scanner(System.in); 
 static PatientBST patientRecords=new PatientBST(); 
 static EmergencyPriorityQueue emergencyQueue=new EmergencyPriorityQueue(100); 
 static TreatmentStack treatmentStack=new TreatmentStack(); 
 static VisitHistory visitHistory=new VisitHistory();
 
 public static void registerPatient(){
        System.out.println("\n===== REGISTER PATIENT =====");
        System.out.print("Enter Patient ID: ");int id=scanner.nextInt();scanner.nextLine();if(patientRecords.search(id)!=null)
                {System.out.println("Patient ID already exists.");return;}
        System.out.print("Enter Name: ");String name=scanner.nextLine();System.out.print("Enter Age: ");int age=scanner.nextInt();scanner.nextLine();System.out.print("Enter Gender: ");String gender=scanner.nextLine();System.out.print("Enter Medical Condition: ");String condition=scanner.nextLine();patientRecords.insert(new Patient(id,name,age,gender,condition));System.out.println("Patient registered successfully.");}
 public static void searchPatient()
        {System.out.println("\n===== SEARCH PATIENT =====");System.out.print("Enter Patient ID: ");int id=scanner.nextInt();Patient p=patientRecords.search(id);if(p==null)System.out.println("Patient not found.");else p.displayPatient();}
 public static void requestEmergencyTreatment()
        {System.out.println("\n===== EMERGENCY TREATMENT REQUEST =====");System.out.print("Enter Patient ID: ");int id=scanner.nextInt();scanner.nextLine();Patient p=patientRecords.search(id);if(p==null){System.out.println("Patient not found.");return;}System.out.println("\nPriority Levels:");System.out.println("3 - Critical");System.out.println("2 - Serious");System.out.println("1 - Normal");System.out.print("Enter Priority: ");int priority=scanner.nextInt();scanner.nextLine();if(priority<1||priority>3){System.out.println("Invalid priority.");return;}System.out.print("Enter Emergency Type: ");String type=scanner.nextLine();emergencyQueue.enqueue(new EmergencyRequest(p,priority,type));}
 public static void processEmergency()
        {System.out.println("\n===== PROCESS EMERGENCY =====");EmergencyRequest r=emergencyQueue.dequeue();if(r==null){System.out.println("No emergency patients waiting.");return;}r.displayRequest();treatmentStack.push(r.patient);System.out.println("Patient transferred to treatment stack.");}
 public static void completeTreatment()
        {System.out.println("\n===== COMPLETE TREATMENT =====");Patient p=treatmentStack.pop();if(p==null){System.out.println("No patients in treatment stack.");return;}System.out.println("Completing treatment for: "+p.name);scanner.nextLine();System.out.print("Enter Visit Date: ");String date=scanner.nextLine();System.out.print("Enter Visit Reason: ");String reason=scanner.nextLine();System.out.print("Enter Treatment Given: ");String treatment=scanner.nextLine();visitHistory.addVisit(p,date,reason,treatment);System.out.println("Treatment completed successfully.");}
 public static void viewPatientHistory()
        {System.out.println("\n===== PATIENT VISIT HISTORY =====");System.out.print("Enter Patient ID: ");int id=scanner.nextInt();Patient p=patientRecords.search(id);if(p==null){System.out.println("Patient not found.");return;}visitHistory.displayHistory(p);}
 public static void displayPatients()
        {System.out.println("\n===== ALL PATIENT RECORDS =====");if(patientRecords.root==null){System.out.println("No patients registered.");return;}patientRecords.inOrder();}
 public static void displayTraversals()
        {System.out.println("\n===== BST TRAVERSALS =====");System.out.println("\n--- IN-ORDER ---");patientRecords.inOrder();System.out.println("\n--- PRE-ORDER ---");patientRecords.preOrder();System.out.println("\n--- POST-ORDER ---");patientRecords.postOrder();}
 public static void main(String[] args)
        {int choice;do{System.out.println("\n==============================================");System.out.println("     MINI HOSPITAL EMERGENCY MANAGEMENT");System.out.println("==============================================");System.out.println("1. Register Patient");System.out.println("2. Search Patient");System.out.println("3. Request Emergency Treatment");System.out.println("4. Process Emergency Patient");System.out.println("5. Complete Treatment");System.out.println("6. View Patient Visit History");System.out.println("7. Display All Patients");System.out.println("8. Display BST Traversals");System.out.println("9. Display Emergency Queue");System.out.println("10. Display Treatment Stack");System.out.println("0. Exit");System.out.println("==============================================");System.out.print("Enter your choice: ");choice=scanner.nextInt();switch(choice){case 1:registerPatient();break;case 2:searchPatient();break;case 3:requestEmergencyTreatment();break;case 4:processEmergency();break;case 5:completeTreatment();break;case 6:viewPatientHistory();break;case 7:displayPatients();break;case 8:displayTraversals();break;case 9:emergencyQueue.displayQueue();break;case 10:treatmentStack.displayStack();break;case 0:System.out.println("Thank you for using the Hospital System.");break;default:System.out.println("Invalid choice. Please try again.");}}while(choice!=0);scanner.close();}
}
