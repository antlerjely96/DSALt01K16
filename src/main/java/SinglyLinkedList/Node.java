package SinglyLinkedList;

public class Node {
    //Data của phần tử
    Product data;
    //Thông tin của phần tử tiếp theo
    Node next;

    public Node(Product data){
        this.data = data;
        this.next = null;
    }
}
