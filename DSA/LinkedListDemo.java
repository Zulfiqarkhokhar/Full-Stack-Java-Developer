/**
 * LinkedListDemo
 */
public class LinkedListDemo {

    Node head;

    public void addLast(Node newNode){
        if(head == null){
            head = newNode;
        }
        else{

            Node cur = head;
            while(cur.next != null){
            cur = cur.next; 
            }
            cur.next = newNode;
        }
    }

    public void addFirst(Node newNode){
        if (head == null) {
            head = newNode;
        }else{
            Node tempNode = head;
            head = newNode;
            head.next = tempNode;
        }
    }

    public void removeFirst(){
        if(head == null){
            return;
        }
        Node tempNode = head.next;
        head = tempNode;
    }

    public void removeLast(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    public void addAtIndex(Node newNode,int index){

        if(head==null){
            head = newNode;
        }
        if(index == 0){
            Node tempNode = head.next;
            head = newNode;
            head.next = tempNode;
        }
        else{
            int count=0;
            Node cur = head;
            while(cur.next != null && count != index-1){
            cur = cur.next;
            count++; 
            }
            Node tempNode = cur.next;
            cur.next = newNode;
            cur.next.next = tempNode;
        }

    }

    public void print(){
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + "-->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        LinkedListDemo list = new LinkedListDemo();

        // list.addLast(n1);
        // list.addLast(n2);
        // list.addLast(n3);

        // list.print();

        list.addFirst(n1);
        list.addFirst(n2);
        list.addFirst(n3);

        // list.print();

        // list.removeFirst();

        // list.print();

        // list.removeFirst();

        // list.print();

        // list.removeLast();
        // list.print();
        // list.removeLast();
        // list.print();
        // list.removeLast();
        list.print();

        list.addAtIndex(n4, 2);

        list.print();

        list.addAtIndex(n5, 1);

        list.print();

         list.addAtIndex(n2, 0);

         list.print();

    }
}

class Node{
    int value;
    Node next;

    Node(int value){
        this.value = value;
        next = null;
    }
}