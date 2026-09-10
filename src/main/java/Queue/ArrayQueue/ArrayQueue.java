package Queue.ArrayQueue;

public class ArrayQueue {
    public int capacity;
    public int[] queue;
    public int rear;

    //Khởi tạo queue
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.rear = 0;
    }

    //Kiểm tra hàng đợi rỗng không (isEmpty)
    public boolean isEmpty(){
        if(rear == 0){
            return true;
        } return false;
    }

    //Kiểm tra hàng đợi đầy không (isFull)
    public boolean isFull(){
        if(rear == capacity){
            return true;
        } return false;
    }

    //Thêm phần tử vào hàng đợi (enqueue)
    public void enQueue(int data){
        if(isFull()){
            System.out.println("Hàng đợi đầy, không thêm được");
        } else {
            queue[rear] = data;
            rear++;
        }
    }

    //Xóa phần tử đầu hàng đợi (dequeue)
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Hàng đợi rỗng, không dequeue được");
            return -1;
        } else {
            //Hiển thị phần tử lấy được
            int front = queue[0];
            System.out.println("Phần tử được dequeue: " + front);
            //Dịch các phần tử lên 1 vị trị
            for (int i = 0; i < rear - 1; i++){
                queue[i] = queue[i + 1];
            }
            rear--;
            return front;
        }
    }

    //Lấy phần tử đầu tiên nhưng không xóa (peek)
    public int peek(){
        if(isEmpty()){
            System.out.println("Hàng đợi rỗng");
            return -1;
        } else {
            System.out.println("Front = " + queue[0]);
            return queue[0];
        }
    }

    //In ra các phần tử trong queue
    public void displayQueue(){
        for (int i = 0; i < rear; i++){
            System.out.println(queue[i] + "\t");
        }
    }
}
