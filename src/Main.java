public class Main {
    public static Liste l = new Liste();

    public static void main(String[] args) {
        Node n = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        l.insertFromHead(n);
        l.insertFromHead(n2);
        l.insertFromHead(n3);
        l.insertFromHead(n4);
        l.findNodeInList("3");
    }
}
