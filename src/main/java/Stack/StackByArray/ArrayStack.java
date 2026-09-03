package Stack.StackByArray;

public class ArrayStack {
    private int[] array;
    private int capacity;
    private int top;

    //Tạo stack với capacity gán sẵn
    public ArrayStack() {
        this.capacity = 10;
        this.top = -1;
        this.array = new int[capacity];
    }

    //Tạo stack với capacity nhập vào khi chạy
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.array = new int[capacity];
    }

    //Push
    public void push(int value){
        if(isFull()){
            System.out.println("Stack đầy");
        } else {
            array[++top] = value;
        }
    }

    //Pop
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack rỗng");
            return -1;
        } else {
            return array[top--];
        }
    }

    //isEmpty
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
    //isFull
    public boolean isFull(){
        if(top == capacity - 1){
            return true;
        }
        return false;
    }

    //peek
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack rỗng");
            return -1;
        } else {
            return array[top];
        }
    }
}
