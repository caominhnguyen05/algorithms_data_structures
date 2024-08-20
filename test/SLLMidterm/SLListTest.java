package SLLMidterm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLListTest {
    @Test()
    public void testAddOneElement() {
        SLList<String> list = new SLList<>();
        list.addFirst("Hello World");
        assertEquals("Hello World", list.getFirst());
    }

    @Test()
    public void testAddRemoveNull() {
        SLList<Object> list = new SLList<>();
        list.addFirst(null);
        assertNull(list.removeFirst());
    }

    @Test()
    public void testZipNull() {
        SLList<Integer> list1 = new SLList<>();
        list1.addFirst(42);
        list1.addFirst(43);
        list1.addFirst(44);
        SLList<Pair<Integer, Integer>> zipped = list1.zip(null);
        assertNull(zipped.getFirst());
    }

    @Test()
    public void testZipOnePair() {
        SLList<Integer> list1 = new SLList<>();
        SLList<Integer> list2 = new SLList<>();
        list1.addFirst(42);
        list2.addFirst(1337);
        SLList<Pair<Integer, Integer>> zipped = list1.zip(list2);
        assertEquals(new Pair<>(42, 1337), zipped.getFirst());
    }

    @Test()
    public void testAppendNull() {
        SLList<String> list1 = new SLList<>();
        list1.addFirst("Hello");
        list1.append(null);
        assertEquals("Hello", list1.removeFirst());
        assertNull(list1.getFirst());
    }

    @Test()
    public void testAppendOneElement() {
        SLList<String> list1 = new SLList<>();
        SLList<String> list2 = new SLList<>();
        list1.addFirst("Hello");
        list2.addFirst("World");
        list1.append(list2);
        assertEquals("Hello", list1.removeFirst());
        assertEquals("World", list1.removeFirst());
        assertNull(list1.getFirst());
    }

    @Test()
    public void testDropEvenOneElement() {
        SLList<Integer> list = new SLList<>();
        list.addFirst(42);
        list.dropEven();
        assertNull(list.getFirst());
    }


}