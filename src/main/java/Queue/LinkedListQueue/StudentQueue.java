package Queue.LinkedListQueue;

public class StudentQueue {
    //Lối sau (rear)
    Node rear;
    //Lối trước
    Node front;

    //Khởi tạo hàng đợi


    public StudentQueue() {
        this.rear = null;
        this.front = null;
    }

    //Thêm phần tử vào hàng đợi (enqueue)
    public void enQueue(Student student){
        Node newNode = new Node(student);
        if(isEmpty()){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    //Xóa phần tử khỏi hàng đợi (dequeue)
    public Student deQueue(){
        if(isEmpty()){
            System.out.println("Hàng đợi rỗng, không xóa được");
            return null;
        } else {
            Student remove = front.data;
            front = front.next;
            if(front == null){
                rear = null;
            }
            return remove;
        }
    }

    //Trả về front nhưng không xóa (peek)
    public Student peek(){
        if(isEmpty()){
            System.out.println("Hàng đợi rỗng");
            return null;
        } else {
            return front.data;
        }
    }

    //Kiểm tra hàng đợi rỗng không (isEmpty)
    public boolean isEmpty(){
        if(front == null){
            return true;
        } return false;
    }

    //In ra hàng đợi
    public void displayQueue(){
        if(isEmpty()){
            System.out.println("Hàng đợi rỗng");
        } else {
            Node current = front;
            while (current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}