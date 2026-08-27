package DoublyLinkedList;

public class Node {
    public Product data;
    //Trỏ đến phần tử phía trước
    public Node prev;
    //Trỏ đến phần tử phía sau
    public Node next;

    public Node(Product data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
