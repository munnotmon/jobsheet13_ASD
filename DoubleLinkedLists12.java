public class DoubleLinkedLists12 {
    Node12 head;
    int size;

    public DoubleLinkedLists12(){
        head = null;
        size = 0;
    }

    public boolean isEmpty () {
        return head == null;
    }

    public void addFirst (int item) {
        if (isEmpty()) {
            head = new Node12 (null, item, null);
        } else {
            Node12 newNode12 = new Node12 (null, item, head);
            head.prev = newNode12;
            head = newNode12;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node12 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node12 newNode12 = new Node12 (current, item, null);
            current.next = newNode12;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (isEmpty()) {
            addFirst (item);
        } else if (index < 0 || index > size) {
            throw new Exception ("\nNilai indeks di luar batas");
        } else {
            Node12 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node12 newNode12 = new Node12 (null, item, current);
                current.prev = newNode12;
                head = newNode12;
            } else {
                Node12 newNode12 = new Node12 (current.prev, item, current);
                newNode12.prev = current.prev;
                newNode12.next = current;
                current.prev.next = newNode12;
                current.prev = newNode12;
            }
        }
        size++;
    }

    public int size () {
        return size;
    }

    public void clear () {
        head = null;
        size = 0;
    }

    public void print () {
        if (!isEmpty()) {
            Node12 tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil Diisi"); 
        } else {
            System.out.println("\nLinked list kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception ("\nLinked list masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast ();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("\nLinked list masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node12 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove (int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception ("\nNilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node12 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public int getFirst () throws Exception {
        if (isEmpty()) {
            throw new Exception ("\nLinked list kosong");
        }
        return head.data;
    }

    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception ("\nLinked list kosong");
        }
        Node12 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("\nNilai indeks di luar batas.");
        }
        Node12 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
}
