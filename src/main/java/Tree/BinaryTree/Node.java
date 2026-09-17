package Tree.BinaryTree;

public class Node {
    //Data của node
    int data;
    //Trỏ đến node con trái
    Node left;
    //Trỏ đến node con phải
    Node right;

    //Khởi tạo node
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
