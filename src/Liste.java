public class Liste {
    Node head;
    Node tail;

    public Node insertFromHead(Node n){
        if(head == null){
            head = n;
            tail = n;
            return head;
        }

        head.prev = n;
        n.next = head;
        head = n;

        return n;
    }

    public Node insertFromTail(Node n){
        if(tail == null){
            head = n;
            tail = n;
            return tail;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;
        return n;
    }
}
