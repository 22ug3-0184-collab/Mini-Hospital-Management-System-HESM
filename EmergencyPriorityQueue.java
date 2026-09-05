public class EmergencyPriorityQueue {

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
        for (int i = highestPriorityIndex;
             i < size - 1;
             i++) {

            queue[i] = queue[i + 1];
        }

        queue[size - 1] = null;

        size--;

        return highest;
    }

    // Display emergency queue
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

/**
 * Emergency request stored by {@link EmergencyPriorityQueue}.
 *
 * This class is package-private so it can remain in the same source file while
 * still being available to the other classes in this application.
 */
class EmergencyRequest {

    public int priority;

    public EmergencyRequest(int priority) {
        this.priority = priority;
    }

    public void displayRequest() {
        System.out.println("Priority: " + priority);
    }
}
