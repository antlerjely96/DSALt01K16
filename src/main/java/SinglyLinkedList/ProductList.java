package SinglyLinkedList;

public class ProductList {
    //Tạo Node head của danh sách
    Node head;
    //Gán head = null tức là tạo ra danh sách rỗng
    public ProductList(){
        this.head = null;
    }

    //Thêm node vào cuối danh sách
    public void addNodeLast(Product product){
        //Tạo node mới để thêm vào cuối danh sách
        Node newNode = new Node(product);
        //Kiểm tra danh sách có rỗng hay không
        if(head == null){
            head = newNode;
        } else {
            //Lấy node hiện tại
            Node currentNode = head;
            //Duyệt qua lần lượt từng node: node hiện tại mà next không null -> nhảy sang node tiếp theo
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            //Gán node cuối cùng hiện tại trỏ đến node cần được thêm vào
            currentNode.next = newNode;
        }
    }

    //Thêm node vào đầu danh sách
    public void addNodeFirst(Product product){
        //Tạo node mới
        Node newNode = new Node(product);
        //Kiểm tra danh sách có rỗng không
        if(head == null){
            head = newNode;
        } else {
            //Trỏ next của node cần thêm vào head
            newNode.next = head;
            //newNode trở thành head
            head = newNode;
        }
    }

    //Thêm node vào sau node bất kỳ sau id của product được chọn
    public void addAfterAnyNode(int Id, Product product){
        //Gán currentNode = head
        Node currentNode = head;
        //Duyệt danh sách
        while (currentNode.next != null){
            //Kiểm tra id của currentNode có = id của product đang tìm không
            if(currentNode.data.Id == Id){
                //Tạo node mới
                Node newNode = new Node(product);
                //Gán newNode trỏ vào node liền sau node hiện tại
                newNode.next = currentNode.next;
                //Trỏ currentNode vào newNode
                currentNode.next = newNode;
            }
            //Tiếp tục duyệt qua các phần tử còn lại
            currentNode = currentNode.next;
        }
    }

    //Hiển thị danh sách
    public void displayList(){
        //Bắt đầu từ head
        Node currentNode = head;
        //Duyệt qua từng phần tử của danh sách
        while (currentNode != null){
            Product product = currentNode.data;
            System.out.println(product.Id + " - " + product.Name + " - " + product.Price + " - " + product.Quantity);
            //Sang node tiếp theo
            currentNode = currentNode.next;
        }
    }

    //Hiển thị phần tử của danh sách theo id của product được nhập vào
    public void findById(int Id){
        //Bắt đầu từ head
        Node currentNode = head;
        //Duyệt qua từng Node
        while (currentNode != null){
            //Kiểm tra id của product == id đang cần tìm không
            if(currentNode.data.Id == Id){
                System.out.println(currentNode.data.Id + " - " + currentNode.data.Name + " - " + currentNode.data.Price + " - " + currentNode.data.Quantity);
            }
            //Sang node tiếp theo
            currentNode = currentNode.next;
        }
    }

    //Xóa phần tử ở cuối
    public void deleteNodeLast(){
        //Kiểm tra danh sách có rỗng không
        if(head == null){
            System.out.println("Danh sach rong, khong co gi de xoa");
        } else if(head.next == null){
            head = null;
        } else {
            //Duyệt qua từng node
            Node currentNode = head;
            while (currentNode.next.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = null;
        }
    }

    //Xóa node đầu tiên
    public void deleteNodeFirst(){
        //Kiểm tra list rỗng không
        if(head == null){
            System.out.println("Danh sach rong, khong xoa duoc");
        } else if(head.next == null){
            head = null;
        } else {
            head = head.next;
        }
    }

    //Xóa node theo product id
    public void deleteById(int Id){
        //Kiểm tra danh sách rỗng hay không
        if(head == null){
            System.out.println("Danh sach rong, khong xoa duoc");
        } else if(head.data.Id == Id){
            head = head.next;
        } else {
            //Duyệt qua từ node
            Node currentNode = head;
            while (currentNode.next != null && !(currentNode.next.data.Id == Id)){
                currentNode = currentNode.next;
            }
            if(currentNode.next == null){
                System.out.println("Khong co node phu hop de xoa");
            } else {
                currentNode.next = currentNode.next.next;
            }
        }
    }

    //Đếm số phần tử trong danh sách
    public void countNode(){
        int count = 0;
        //Duyệt qua từng phần tử
        Node currentNode = head;
        while (currentNode != null){
            count++;
            currentNode = currentNode.next;
        }
        System.out.println("Danh sach co " + count + " node");
    }
}
