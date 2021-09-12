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

    public Node findNode(String s){
        Node n = head;
        while (n != null){
            if(n.data.equals(s)){
                return n;
            }
            n = n.next;
        }
        return new Node("");
    }

    public Node removeNodeFromMiddle(String s){
        if(isEmpty()){
            return new Node("");
        }
        if(findNode(s).data.equals("")){
            return new Node("");
        }
        Node node = findNode(s);

        if(node == head){
            return removeFromHead();
        }

        if(node == tail){
            return removeFromTail();
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;

        return node;
    }

    public void addNodeToMiddle(String data, String beforeNode){
        Node n = new Node(data);
        if(isEmpty()){
            insertFromTail(n);
            return;
        }
        if(findNode(beforeNode).data.equals("")){
            insertFromTail(n);
            return;
        }
        if(findNode(beforeNode) == head){
            insertFromHead(n);
            return;
        }
        Node after = findNode(beforeNode);
        Node before = after.prev;

        n.next = after;
        n.prev = before;

        after.prev = n;
        before.next = n;
    }

    public void emptyList(){
        if(isEmpty()){
            return;
        }
        Node n = head;
        while (n != null){
            n = n.next;
            removeFromHead();
        }
        printFromHead();
    }

    public void changeListOrder(String newOrder){
        if(isEmpty()){
            return;
        }
        ArrayList<Node> orderChangedArr = new ArrayList<>();
        String[] newOrderSplit = newOrder.split(",");

        for (int i = 0; i < newOrderSplit.length; i++) {
            orderChangedArr.add(findNode(newOrderSplit[i]));
        }
        emptyList();
        printFromHead();

        for (Node n : orderChangedArr) {
            insertFromTail(n);
        }
        printFromHead();
    }
}

