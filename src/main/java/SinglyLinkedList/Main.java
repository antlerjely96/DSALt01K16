package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        ProductList list = new ProductList();
        Product product1 = new Product(1, "product 1", 20, 20);
        list.addNodeLast(product1);
        Product product2 = new Product(2, "product 2", 30, 10);
        list.addNodeLast(product2);
        Product product3 = new Product(3, "product 3", 15, 15);
        list.addNodeLast(product3);

        list.displayList();
        System.out.println("----------");
        list.countNode();
    }
}
