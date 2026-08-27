package DoublyLinkedList;

public class ProductList {
    Node head;
    Node tail;

    public ProductList(Node head, Node tail) {
        this.head = null;
        this.tail = null;
    }

    //In danh sách từ đầu -> cuối
    public void printListForward() {
        //Kiểm tra danh sách rỗng hay k
        if (head == null){
            System.out.println("Danh sách rỗng");
        } else {
            //Duyệt từ head -> tail
            Node currentNode = head;
            while (currentNode.next != null){
                System.out.println("ID: " + currentNode.data.Id + ", Name" + currentNode.data.Name + ", Quantity: " + currentNode.data.Quantity + ", Price: " + currentNode.data.Price);
                //Dịch sang node tiếp theo
                currentNode = currentNode.next;
            }
        }
    }

    //In danh sách từ cuối -> đầu
    public void printListBackward(){
        //Kiểm tra danh sách rỗng không
        if(tail == null){
            System.out.println("Danh sách rỗng");
        } else {
            //Duyệt từ tail -> head
            Node currentNode = tail;
            while (currentNode.prev != null){
                System.out.println("ID: " + currentNode.data.Id + ", Name" + currentNode.data.Name + ", Quantity: " + currentNode.data.Quantity + ", Price: " + currentNode.data.Price);
                //Dịch về node phía trước
                currentNode = currentNode.prev;
            }
        }
    }

    //Tìm kiếm và in 1 node theo data.Id (duyệt từ head -> tail)
    public void findNodeByIdForward(int Id){
        //Kiểm tra danh sách rỗng hay không
        if(head == null){
            System.out.println("Danh sách rỗng");
        } else {
            //Duyệt từ head -> tail
            Node currentNode = head;
            while (currentNode != null){
                if(currentNode.data.Id == Id){
                    System.out.println("ID: " + currentNode.data.Id + ", Name" + currentNode.data.Name + ", Quantity: " + currentNode.data.Quantity + ", Price: " + currentNode.data.Price);
                }
                //Dịch sang node tiếp theo
                currentNode = currentNode.next;
            }
        }
    }

    //Tìm kiếm và in 1 node theo data.Id (duyệt từ tail -> head)
    public void findNodeByIdBackward(int Id){
        //Kiểm tra danh sách có rỗng không
        if(tail == null){
            System.out.println("Danh sách rỗng");
        } else {
            //Duyệt từ tail -> head
            Node currentNode = tail;
            while (currentNode != null){
                if(currentNode.data.Id == Id){
                    System.out.println("ID: " + currentNode.data.Id + ", Name" + currentNode.data.Name + ", Quantity: " + currentNode.data.Quantity + ", Price: " + currentNode.data.Price);
                }
                //Dịch về node phía trước
                currentNode = currentNode.prev;
            }
        }
    }

    //Thêm node vào đầu danh sách
    public void addNodeFirst(Product product){
        //Tạo node mới
        Node newNode = new Node(product);
        //Kiểm tra danh sách có rỗng không;
        if(head == null){
            head = tail = newNode;
        } else {
            //Trỏ next của node mới vào phần tử đầu tiên cũ
            newNode.next = head;
            //Trỏ prev của node đầu tiên cũ sang node mới
            head.prev = newNode;
            head = newNode;
        }
    }

    //Thêm node vào cuối danh sách
    public void addNodeLast(Product product){
        //Tạo node mới
        Node newNode = new Node(product);
        //Kiểm tra danh sách có rỗng hay không
        if(tail == null){
            head = tail = newNode;
        } else {
            //Trỏ next của phần tử cuối sang node mới
            tail.next = newNode;
            //Trỏ prev của node mới sang node cuối cũ
            newNode.prev = tail;
            tail = newNode;
        }
    }

    //Thêm node vào sau 1 node có id được chọn
    public void addNodeAfterAnyNodeFollowDataId(int Id, Product product){
        //Kiểm tra danh sách rỗng không
        if(head == null){
            System.out.println("Danh sách rỗng");
        } else {
            //Duyệt từ head -> tail
            Node currentNode = head;
            while (currentNode != null){
                if(currentNode.data.Id == Id){
                    //Tạo node mới
                    Node newNode = new Node(product);
                    //Kiểm tra currentNode có phải tail không
                    if(currentNode == tail){
                        currentNode.next = newNode;
                        newNode.prev = tail;
                        tail = newNode;
                    } else {
                        //Node ngay sau currentNode
                        Node nextNode = currentNode.next;
                        //Trỏ next của currentNode sang newNode
                        currentNode.next = newNode;
                        //Trỏ prev của newNode về currentNode
                        newNode.prev = currentNode;
                        //Trỏ next của newNode -> nextNode
                        newNode.next = nextNode;
                        //Trỏ prev của nextNode -> newNode
                        nextNode.prev = newNode;
                    }
                }
                currentNode = currentNode.next;
            }
        }
    }

    //Xóa node đầu tiên
    public void deleteFirstNode(){
        //Kiểm tra danh sách rỗng không
        if(head == null){
            System.out.println("Danh sách rỗng");
        } else if (head == tail) {
            head = tail = null;
        } else {
            //Trỏ next của head sang phần tử tiếp theo
            head = head.next;
            //Trỏ prev của phần tử tiếp theo ở trên -> null
            head.prev = null;
        }
    }

    //Xóa node cuối cùng
    public void deleteLastNode(){
        //Kiểm tra danh sách rỗng không
        if(tail == null){
            System.out.println("Danh sách rỗng");
        } else if (tail == head) {
            tail = head = null;
        } else {
            //Trỏ prev của tail -> phần tử ngay trước last
            tail = tail.prev;
            //Trỏ next của phần tử ngay trước last cũ -> null
            tail.next = null;
        }
    }

    //Xóa node bất kỳ theo data.Id
    public void deleteNodeFollowDataId(int Id){
        //Kiểm tra danh sách rỗng không
        if(head == null){
            System.out.println("Danh sách rỗng");
        } else {
            Node currentNode = head;
            while (currentNode != null){
                if(currentNode.data.Id == Id){
                    if(currentNode == head){
                        deleteFirstNode();
                    } else if(currentNode == tail){
                        deleteLastNode();
                    } else {
                        //Node ngay trước currentNode
                        Node prevNode = currentNode.prev;
                        //Node ngay sau currentNode
                        Node nextNode = currentNode.next;
                        //Trỏ next của prevNode -> nextNode
                        prevNode.next = nextNode;
                        //Trỏ prev của nextNode -> prevNode
                        nextNode.prev = prevNode;
                    }
                }
            }
        }
    }

    //Đếm số Node trong List
    public void countNode(){
        int count = 0;
        if(head == null){
            System.out.println("Danh sách rỗng");
        } else {
            Node currentNode = head;
            while (currentNode != null){
                count++;
                currentNode = currentNode.next;
            }
        }
    }
}
