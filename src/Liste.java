import java.util.ArrayList;

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
        if(isEmpty()){
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
        if(isEmpty()){
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
    }

    public Node removeFromTail(){
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

        n = tail;

        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;

        return n;
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
        n.prev.next = n.next;
        //change the elements after : prev
        n.next.prev = n.prev;
        printFromHead();
    }

    public void addNodeToMiddle(Node prevNode, Node newNode){
        prevNode.prev.next = newNode;
        prevNode.prev = newNode;
        newNode.prev = prevNode.prev.prev;
        newNode.next = prevNode;

        printFromHead();
    }

    public void emptyList(){
        Node n = head;
        while (n != null){
            n = n.next;
            removeFromHead();
        }
        printFromHead();
    }

    public void changeListOrder(String newOrder){
        ArrayList<Node> orderChangedArr = new ArrayList<>();
        String[] newOrderSplit = newOrder.split(",");

        for (int i = 0; i < newOrderSplit.length; i++) {
            orderChangedArr.add(findNodeInList(newOrderSplit[i]));
        }
        emptyList();
        printFromHead();

        for (Node n : orderChangedArr) {
            insertFromTail(n);
        }
        printFromHead();
    }
}

