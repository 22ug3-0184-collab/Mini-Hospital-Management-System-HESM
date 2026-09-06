public class PatientBST {
    BSTNode root;
    public void insert(Patient patient){root=insertRecursive(root,patient);}
    private BSTNode insertRecursive(BSTNode node,Patient patient){if(node==null)return new BSTNode(patient);if(patient.patientId<node.patient.patientId)node.left=insertRecursive(node.left,patient);else if(patient.patientId>node.patient.patientId)node.right=insertRecursive(node.right,patient);else System.out.println("Patient ID already exists.");return node;}
    public Patient search(int id){BSTNode c=root;while(c!=null){if(id==c.patient.patientId)return c.patient;if(id<c.patient.patientId)c=c.left;else c=c.right;}return null;}
    public void inOrder(){inOrderRecursive(root);} private void inOrderRecursive(BSTNode n){if(n!=null){inOrderRecursive(n.left);n.patient.displayPatient();inOrderRecursive(n.right);}}
    public void preOrder(){preOrderRecursive(root);} private void preOrderRecursive(BSTNode n){if(n!=null){n.patient.displayPatient();preOrderRecursive(n.left);preOrderRecursive(n.right);}}
    public void postOrder(){postOrderRecursive(root);} private void postOrderRecursive(BSTNode n){if(n!=null){postOrderRecursive(n.left);postOrderRecursive(n.right);n.patient.displayPatient();}}
}
