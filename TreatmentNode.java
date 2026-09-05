public class TreatmentNode<T> {

    T patient;

    TreatmentNode<T> next;

    public TreatmentNode(T patient) {

        this.patient = patient;
        this.next = null;
    }
}
