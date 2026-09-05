public class BSTNode<T> {

    T patient;

    BSTNode left;
    BSTNode right;

    public BSTNode(T patient) {

        this.patient = patient;
        this.left = null;
        this.right = null;
    }
}
