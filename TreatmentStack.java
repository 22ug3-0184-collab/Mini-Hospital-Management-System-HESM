public class TreatmentStack {
    private TreatmentNode top;
    public void push(Patient patient){TreatmentNode n=new TreatmentNode(patient);n.next=top;top=n;System.out.println("Patient added to treatment stack.");}
    public Patient pop(){if(top==null)return null;Patient p=top.patient;top=top.next;return p;}
    public Patient peek(){return top==null?null:top.patient;}
    public boolean isEmpty(){return top==null;}
    public void displayStack(){if(top==null){System.out.println("Treatment stack is empty.");return;}System.out.println("\n===== TREATMENT STACK =====");TreatmentNode c=top;while(c!=null){System.out.println("Patient ID: "+c.patient.patientId+" | Name: "+c.patient.name);c=c.next;}}
}
