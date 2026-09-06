public class VisitHistory {
    public void addVisit(Patient patient,String date,String reason,String treatment) {
        VisitNode n=new VisitNode(date,reason,treatment); if(patient.visitHistory==null) patient.visitHistory=n; else { VisitNode c=patient.visitHistory; while(c.next!=null)c=c.next; c.next=n; } System.out.println("Visit added successfully.");
    }
    public void displayHistory(Patient patient) {
        if(patient.visitHistory==null){System.out.println("No visit history found.");return;} System.out.println("\n===== VISIT HISTORY ====="); VisitNode c=patient.visitHistory; int i=1; while(c!=null){System.out.println("\nVisit "+i);System.out.println("Date      : "+c.date);System.out.println("Reason    : "+c.reason);System.out.println("Treatment : "+c.treatment);c=c.next;i++;}
    }
}
