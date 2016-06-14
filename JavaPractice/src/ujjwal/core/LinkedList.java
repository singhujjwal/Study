package ujjwal.core;

//Let's write a generic linked list
//Which is not as versatile as JAVA's implementation of List
public class LinkedList {

    static Node head;

    static class Node {

        Integer data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public LinkedList(Node head) {
        LinkedList.head = head;
    }



    public void append(Integer value) {

        if (head == null) {
            head = new Node(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void printNodes(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
        
    }

    // a->b->c->d->e

    // e->d->c->b->a


    public Node reverseList(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;
        if (current.next == null)
            return head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    public static void main(String[] args) {

        System.out.println("Ujjwal the linked list in java");

        Node n = new Node(25);
        LinkedList ll = new LinkedList(n);
        for (int i = 0; i < 10; i++) {
            ll.append(i);
        }
        ll.printNodes(n);

        n = ll.reverseList(n);
        System.out.println("--------printing revered list------------");

        ll.printNodes(n);
        // Create a

    }

}
