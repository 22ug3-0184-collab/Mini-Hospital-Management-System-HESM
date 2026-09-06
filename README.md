# Mini-Hospital-Management-System-HESM
Mini Hospital Emergency Management System developed using Java Data Structures and Algorithms.
Project Description

The Mini Hospital Emergency Management System is a Java-based console application designed to simulate the management of patients arriving at a hospital.

The system demonstrates the practical use of different data structures to manage patient records, emergency requests, treatment processing, and patient visit history.

Data Structures Used

The system implements the following data structures:

1. Binary Search Tree (BST)

Patient records are stored using a Binary Search Tree.

Patient ID is used as the key.
Patients can be inserted into the BST.
Patients can be searched using Patient ID.
In-order, Pre-order, and Post-order traversals are implemented.

Files:

BSTNode.java
PatientBST.java
2. Priority Queue

Emergency treatment requests are managed using a priority queue.

Priority levels:

3 - Critical
2 - Serious
1 - Normal

The patient with the highest priority is processed first.

Files:

EmergencyRequest.java
EmergencyPriorityQueue.java
3. Stack

Patients waiting for treatment are managed using a LIFO stack.

The stack supports:

Push
Pop
Peek
Display

Files:

TreatmentNode.java
TreatmentStack.java
4. Linked List

Patient visit history is stored using a linked list.

Each visit contains:

Visit date
Visit reason
Treatment given

Files:

VisitNode.java
VisitHistory.java
Main Features

The system provides the following functions:

Register Patient
Search Patient
Request Emergency Treatment
Process Emergency Patient
Complete Treatment
View Patient Visit History
Display All Patients
Display BST Traversals
Display Emergency Queue
Display Treatment Stack
Exit
Project Structure
MiniHospitalSystem/
│
├── Patient.java
├── VisitNode.java
├── VisitHistory.java
├── BSTNode.java
├── PatientBST.java
├── EmergencyRequest.java
├── EmergencyPriorityQueue.java
├── TreatmentNode.java
├── TreatmentStack.java
├── MiniHospitalSystem.java
└── README.md

How to Run
Open the project in Visual Studio Code.
Make sure Java JDK is installed.
Open the project folder in VS Code.
Compile the Java files.
Run MiniHospitalSystem.java.
Use the menu to interact with the system.
Development Process

The project was developed step-by-step using Git and GitHub.

The main development commits include:

Created project structure
Implemented patient BST
Added BST search and traversal
Implemented emergency priority queue
Implemented treatment stack
Implemented patient visit linked list
Integrated hospital management system
Added testing
Updated README
Testing

The system was tested using different patient IDs, emergency priorities, treatment requests, and visit histories.

Example test:

Register Patient ID 101
Register Patient ID 102
Search Patient ID 101
Create an emergency request for Patient 101
Process the emergency request
Add the patient to the treatment stack
Complete treatment
Add visit details
View the patient's visit history
Technologies Used
Java
Visual Studio Code
Git
GitHub

Author  M. K. S. S. Ananda (22ug3-0184) Mini Hospital Emergency Management System