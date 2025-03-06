package LL;

@SuppressWarnings("unchecked")
public class resizingDequeue<Item> {

    private Item[] q;
    private int n, head, tail;

    public resizingDequeue() {

        q = (Item[]) new Object[2];
        n = 0;
        head = 0;
        tail = 0;

    }

    private void resize(int capacity) {

        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(head + i) % q.length];
        }
        q = temp;
        head = 0;
        tail = n;

    }

    public void pushBack(Item item) {

        if (n == q.length) {
            resize(2 * q.length);
        }

        q[tail] = item;
        tail = (tail - 1 + q.length) % q.length;
        n++;

    }

    public void pushFront(Item item) {

        if (n == q.length) {
            resize(2 * q.length);
        }

        head = (head - 1 + q.length) % q.length;
        q[head] = item;
        n++;

    }

    public Item popBack() {

        tail = (tail - 1 + q.length) % q.length;
        Item item = q[tail];
        q[tail] = null;
        n--;
        if (n > 0 && n == q.length / 4) {
            resize(q.length / 2);
        }
        return item;

    }

    public Item popFront() {

        Item item = q[head];
        head = (head + 1) % q.length;
        q[head] = null;
        n--;
        if (n > 0 && n == q.length / 4) {
            resize(q.length / 2);
        }
        return item;

    }

    public boolean isEmpty() {

        return n == 0;

    }

    public int size() {

        return n;

    }

}
