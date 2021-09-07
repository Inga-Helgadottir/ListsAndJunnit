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
}