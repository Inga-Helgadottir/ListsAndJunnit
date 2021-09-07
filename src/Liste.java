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

    public String printFromHead(){
        Node n = head;
        String res = "";

        while (n != null){
            res = res + n.data;
            n = n.next;
        }
        return res;
    }

    public String printFromTail(){
        Node n = tail;
        String res = "";

        while (n != null){
            res = res + n.data;
            n = n.prev;
        }
        return res;
    }

    public Node removeFromHead(){
        if(head == null){
            return null;
        }

        if(head == tail){
            return head;
        }
        Node n = head;
        head.next = head;
        head.next.prev = null;

        return head;
    }

    public Node removeFromTail(){
        if(head == null){
            return null;
        }

        if(head == tail){
            return tail;
        }
        Node n = tail;
        tail.prev = tail;
        tail.prev.next = null;

        return tail;
    }
}
