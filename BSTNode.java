public class BSTNode<T> {

    T patient;

    BSTNode<T> left;
    BSTNode<T> right;

    public BSTNode(T patient) {

        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}
