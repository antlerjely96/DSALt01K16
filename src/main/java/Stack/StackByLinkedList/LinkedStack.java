package Stack.StackByLinkedList;

public class LinkedStack {
    //Thể hiện phần tử Top của ngăn xếp
    private Node top;

    //Tạo ra stack rỗng
    public LinkedStack() {
        this.top = null;
    }

    //Thao tác push (Thêm phần tử vào stack)
    public void push(int value){
        Node newNode = new Node(value);
        //Cho newNode là top
        newNode.next = top;
        top = newNode;
    }

    //Thao tác pop (Lấy ra giá trị top, trả về giá trị đã lấy, xóa giá tr đó khỏi stack)
    public int pop(){
        //Kiểm tra ngăn xếp có rỗng không
        if(isEmpty()){
            System.out.println("Stack rỗng, không có gì để pop");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            System.out.println("Giá trị vừa pop: " + value);
            return value;
        }
    }

    //Thao tác isEmpty (Kiểm tra stack có rỗng không)
    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    //Thao tác peek (Lấy ra và trả về top, không xóa khỏi stack)
    public int peek(){
        //Kiểm tra stack rỗng không
        if(isEmpty()){
            System.out.println("Stack rỗng");
            return -1;
        } else {
            return top.data;
        }
    }
}
