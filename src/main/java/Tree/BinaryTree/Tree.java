package Tree.BinaryTree;

public class Tree {
    //Tạo root (1 tree luôn phải có root)
    Node root;

    //Khởi tạo root
    public void setRoot(int data){
        this.root = new Node(data);
    }

    //Tạo node mới cho cây
    public void addNode(Node parent, Node child){
        if(parent.left == null){
            parent.left = child;
        } else if (parent.right == null) {
            parent.right = child;
        }
    }

    //Tìm node trái nhất
    public Node findMostLeftNode(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node;
        }
        Node child = node.left;
        return findMostLeftNode(child);
    }

    //Thêm node trái nhất
    public void addMostLeftNode(int data){
        Node node = findMostLeftNode(root);
        if(node != null){
            Node newNode = new Node(data);
            node.left = newNode;
        }
    }

    //Tìm node phải nhất
    public Node findMostRightNode(Node node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node;
        }
        return findMostRightNode(node.right);
    }

    //Thêm phải nhất
    public void addMostRightNode(int data){
        Node node = findMostRightNode(root);
        if(node != null){
            node.right = new Node(data);
        }
    }

    //In cây
    public void printTree(Node node, int level){
        if(node == null){
            return;
        }
        for (int i = 0; i < level; i++){
            System.out.println("   ");
        }
        System.out.println("- " + node.data);
        printTree(node.left, level + 1);
        printTree(node.right, level + 1);
    }

    //preOrder
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data + " | ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //postOrder
    public void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        System.out.println(node.data + " | ");
        postOrder(node.right);
    }
}
