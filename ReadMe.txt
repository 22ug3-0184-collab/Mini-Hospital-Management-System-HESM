/*  Data Structures Used

1. Binary Search Tree — Patient Records

The **Binary Search Tree (BST)** stores patient records according to their Patient ID.

```text
             105
            /   \
          102    110
         /  \      \
       101  104     115
```

If the Patient ID is smaller than the current node, the patient is inserted into the **left subtree**.

If the Patient ID is larger, the patient is inserted into the **right subtree**.

This also allows efficient patient searching.

---

### 2. Priority Queue — Emergency Treatment

Emergency patients are handled according to their priority.

```text
Priority 3 = Critical
Priority 2 = Serious
Priority 1 = Normal
```

Example:

```text
Patient 101 → Priority 1
Patient 102 → Priority 3
Patient 103 → Priority 2
Patient 104 → Priority 3
```

The system processes:

```text
Patient 102
      ↓
Patient 104
      ↓
Patient 103
      ↓
Patient 101
```

The higher-priority emergency is treated first.

---

### 3. Queue — Treatment

The treatment queue follows **FIFO (First In, First Out)**.

```text
FRONT                         REAR
  ↓                             ↓
[Patient 102] → [Patient 104] → [Patient 103]
```

The patient who enters the treatment queue first is processed first.

---

### 4. Linked List — Visit History

Each patient has a linked list containing previous visits.

```text
Patient
   |
   ↓
[Visit 1] → [Visit 2] → [Visit 3] → NULL
```

Each visit stores:

* Date
* Reason
* Treatment

This allows multiple visits to be stored for one patient.

# Main System Flow

```text
                  START
                    |
                    ↓
             Register Patient
                    |
                    ↓
              Patient BST
                    |
          +---------+---------+
          |                   |
          ↓                   ↓
    Emergency Request     Search Patient
          |
          ↓
    Priority Queue
          |
          ↓
  Process Emergency
          |
          ↓
    Treatment Queue
          |
          ↓
   Complete Treatment
          |
          ↓
    Visit History
      Linked List
          |
          ↓
          END
```

# Important Algorithms

## BST Search

```text
1. Start from the root.
2. Compare the required Patient ID with the current node.
3. If IDs are equal, patient is found.
4. If required ID is smaller, move to the left child.
5. If required ID is larger, move to the right child.
6. Continue until the patient is found or NULL is reached.
```

## Emergency Priority Processing

```text
1. Check whether the emergency queue is empty.
2. Find the request with the highest priority.
3. Remove that request.
4. Send the patient to the treatment queue.
5. Continue until all emergency requests are processed.
```

## Treatment Queue

```text
ENQUEUE:
Add patient at the rear.

DEQUEUE:
Remove patient from the front.
```

## Visit History

```text
1. Create a new visit node.
2. If the patient's history is empty,
   make the new node the first node.
3. Otherwise, move to the end of the linked list.
4. Add the new visit.
```

# Time Complexity

| Operation                | Data Structure | Average / Typical Complexity |
| ------------------------ | -------------- | ---------------------------: |
| Insert Patient           | BST            |                     O(log n) |
| Search Patient           | BST            |                     O(log n) |
| BST Traversal            | BST            |                         O(n) |
| Add Emergency Request    | Priority Queue |                         O(1) |
| Process Emergency        | Priority Queue |                         O(n) |
| Add Treatment Patient    | Queue          |                         O(1) |
| Remove Treatment Patient | Queue          |                         O(1) |
| Add Visit                | Linked List    |                         O(n) |
| Display Visit History    | Linked List    |                         O(n) |

**Note:** A normal BST can become unbalanced, so insertion/search can become **O(n)** in the worst case.

# Suggested Demonstration

For your individual mid assignment demonstration, you can enter patients such as:

```text
Patient ID: 105
Name: Kamal
Age: 45
Gender: Male
Condition: Chest Pain

Patient ID: 102
Name: Nimal
Age: 30
Gender: Male
Condition: Fracture

Patient ID: 110
Name: Amal
Age: 65
Gender: Male
Condition: Severe Bleeding
```

Then create emergency requests:

```text
Kamal → Priority 2
Nimal → Priority 1
Amal  → Priority 3
```

When **Process Emergency Patient** is selected, Amal should be processed first because he has priority 3.

Then the patient moves into the treatment queue:

```text
Emergency Priority Queue
          ↓
       Amal
          ↓
   Treatment Queue
          ↓
  Complete Treatment
          ↓
   Visit History
          ↓
    Linked List
```*/
