public class Liste {
    Node head;
    Node tail;

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        }
        return false;
    }

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
        System.out.println(res);
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
        Node n = new Node("");
        if(isEmpty()){
            return n;
        }
        if(head == tail){
            n = head;
            head = null;
            tail = null;
            return n;
        }
        n = head;

        head = head.next;
        head.prev.next = null;
        head.prev = null;

        return n;
        /* before
        if(head == null){
            return null;
        }

        if(head == tail){
            return head;
        }
        Node n = head;
        head.next = head;
        head.next.prev = null;

        return head;*/
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

    public Node findNodeInList(String s){
        Node n = head;
        while (n != null){
            if(n.data.equals(s)){
                return n;
            }
            n = n.next;
        }
        return new Node("Node does not exist");
    }

    public void removeNodeFromMiddle(Node n){
        //change the elements before : next
        //change the elements after : prev
        System.out.println("before");
        printFromHead();
        n.prev.next = n.next;
        n.next.prev = n.prev;
        System.out.println("after");
        printFromHead();
    }

    public void addNodeToMiddle(Node prevNode, Node newNode){
        //find out where it should go
        //change the prev to point at n
        //change next prev to point at n
        System.out.println("before");
        printFromHead();
        prevNode.prev.next = newNode;
        prevNode.prev = newNode;
        newNode.prev = prevNode.prev.prev;
        newNode.next = prevNode;
        System.out.println("after");
        printFromHead();
    }
}

