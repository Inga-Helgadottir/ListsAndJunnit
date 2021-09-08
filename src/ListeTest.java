import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {

    Liste listeTom = new Liste();

    Liste liste = new Liste();

    @BeforeEach
    void setUp() {
        Node n = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        liste.insertFromHead(n);
        liste.insertFromHead(n2);
        liste.insertFromHead(n3);
        liste.insertFromHead(n4);
    }

    @Test
    void isEmpty(){
        assertEquals(true, listeTom.isEmpty());
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
        assertEquals("", liste.printFromHead());

        liste.insertFromHead(new Node("1"));
        liste.insertFromHead(new Node("2"));
        liste.insertFromHead(new Node("3"));
        liste.insertFromHead(new Node("4"));

        assertEquals("4321", liste.printFromHead());
    }

    @Test
    void printFromTail() {
        assertEquals("", liste.printFromTail());

        liste.insertFromHead(new Node("1"));
        liste.insertFromHead(new Node("2"));
        liste.insertFromHead(new Node("3"));
        liste.insertFromHead(new Node("4"));

        assertEquals("1234", liste.printFromTail());
    }

    @Test
    void removeFromHead() {/*
        assertEquals(null, liste.removeFromHead());

        Node n = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        liste.insertFromHead(n);
        liste.insertFromHead(n2);
        liste.insertFromHead(n3);
        liste.insertFromHead(n4);

        assertEquals(n4, liste.removeFromHead());*/
        Node n = new Node("");
        assertEquals(n.data, listeTom.removeFromHead().data);

        Node n2 = new Node("4");
        listeTom.insertFromHead(n2);
        assertEquals(n2, listeTom.removeFromHead());

        assertEquals(true, listeTom.isEmpty());

        assertEquals("3", liste.removeFromHead().data);
        assertEquals("210", liste.printFromHead());

    }

    @Test
    void removeFromTail() {
        assertEquals(null, liste.removeFromTail());

        Node n = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");

        liste.insertFromHead(n);
        liste.insertFromHead(n2);
        liste.insertFromHead(n3);
        liste.insertFromHead(n4);

        assertEquals(n, liste.removeFromTail());

    }

    @Test
    void findNodeInList() {
        Node n = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        liste.insertFromHead(n);
        liste.insertFromHead(n2);
        liste.insertFromHead(n3);
        liste.insertFromHead(n4);
        assertEquals("3", liste.findNodeInList("3").data);
    }
}