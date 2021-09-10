import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Liste listeTom = new Liste();
    Liste liste = new Liste();

    @BeforeEach
    void setUp() {
        Node n = new Node("0");
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        liste.insertFromHead(n);
        liste.insertFromHead(n1);
        liste.insertFromHead(n2);
        liste.insertFromHead(n3);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void isEmpty(){
        assertEquals(true, listeTom.isEmpty());
        assertEquals(false, liste.isEmpty());
    }

    @Test
    void insertFromHead() {
        Node n = new Node("data");
        Node n2 = new Node("data2");

        assertEquals("data", liste.insertFromHead(n).data);
        assertEquals("data2", liste.insertFromHead(n2).data);
    }

    @Test
    void insertFromTail() {
        Node n = new Node("data");
        Node n2 = new Node("data2");

        assertEquals("data", liste.insertFromTail(n).data);
        assertEquals("data2", liste.insertFromTail(n2).data);

    }

    @Test
    void printFromHead() {
        assertEquals("", listeTom.printFromHead());

        assertEquals("3210", liste.printFromHead());
    }

    @Test
    void printFromTail() {
        assertEquals("", listeTom.printFromTail());

        assertEquals("0123", liste.printFromTail());
    }

    @Test
    void removeFromHead() {
        Node n = new Node("");
        assertEquals(n.data, listeTom.removeFromHead().data);
        assertEquals(true, listeTom.isEmpty());

        Node n2 = new Node("313");
        listeTom.insertFromHead(n2);

        assertEquals(n2, listeTom.removeFromHead());
        assertEquals(true, listeTom.isEmpty());

        liste.insertFromHead(n2);
        assertEquals(n2, liste.removeFromHead());
        assertEquals("3210", liste.printFromHead());
    }

    @Test
    void removeFromTail() {
        assertEquals("", listeTom.removeFromTail().data);

        Node n = new Node("1");

        listeTom.insertFromHead(n);

        assertEquals(n, listeTom.removeFromTail());
        assertEquals(true, listeTom.isEmpty());

        assertEquals("0", liste.removeFromTail().data);

        assertEquals("321", liste.printFromHead());

    }

    @Test
    void findNode() {
        assertEquals("3", liste.findNode("3").data);
        assertEquals("0", liste.findNode("0").data);
        assertEquals("", liste.findNode("6").data);
    }

    @Test
    void removeNodeFromMiddle() {
        assertEquals("", listeTom.removeNodeFromMiddle("111").data);

        assertEquals("3", liste.removeNodeFromMiddle("3").data);
        assertEquals("210", liste.printFromHead());

        assertEquals("0", liste.removeNodeFromMiddle("0").data);
        assertEquals("21", liste.printFromHead());

        liste.insertFromHead(new Node("3"));
        assertEquals("321", liste.printFromHead());

        assertEquals("2", liste.removeNodeFromMiddle("2").data);

        assertEquals("31", liste.printFromHead());

        liste.insertFromHead(new Node("4"));
        assertEquals(null, liste.removeNodeFromMiddle("4").next);

        liste.insertFromHead(new Node("4"));
        assertEquals(null, liste.removeNodeFromMiddle("4").prev);
    }

    @Test
    void addNodeToMiddle() {
        /*
        Node n = new Node("8");
        liste.addNodeToMiddle(liste.findNode("2"), n);
        Assert.assertEquals("38210", outputStreamCaptor.toString().trim());*/
        liste.addNodeToMiddle("4", "3");
        assertEquals("43210", liste.printFromHead());

        liste.addNodeToMiddle("666", "2");
        assertEquals("43666210", liste.printFromHead());

    }

    @Test
    void emptyList() {
        liste.emptyList();
        Assert.assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    void changeListOrder() {
        liste.changeListOrder("2,3,0,1");
        Assert.assertEquals("2301", outputStreamCaptor.toString().trim());
    }
}