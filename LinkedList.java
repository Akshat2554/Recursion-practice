public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void delete(int data) {
        Node current = head;
        if (head == null) {
            return;
        }
        else if (head.data == data) {
            head = head.next;
            return;
        }
        else {
            while(current != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    current = current.next;
                    return;
                }
            }
        }
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.print();
        list.delete(2);
        list.print();
        System.out.println(list.search(3));
        System.out.println(list.search(9));
    }
}