import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    Liste liste = new Liste();

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
}