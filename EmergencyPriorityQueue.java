public class EmergencyPriorityQueue {
    EmergencyRequest[] queue; int size;
    public EmergencyPriorityQueue(int capacity){queue=new EmergencyRequest[capacity];size=0;}
    public void enqueue(EmergencyRequest request){if(size==queue.length){System.out.println("Emergency queue is full.");return;}queue[size++]=request;System.out.println("Emergency request added.");}
    public EmergencyRequest dequeue(){if(size==0)return null;int hi=0;for(int i=1;i<size;i++)if(queue[i].priority>queue[hi].priority)hi=i;EmergencyRequest r=queue[hi];for(int i=hi;i<size-1;i++)queue[i]=queue[i+1];queue[--size]=null;return r;}
    public void displayQueue(){if(size==0){System.out.println("No emergency requests.");return;}System.out.println("\n===== EMERGENCY QUEUE =====");for(int i=0;i<size;i++)queue[i].displayRequest();}
}
