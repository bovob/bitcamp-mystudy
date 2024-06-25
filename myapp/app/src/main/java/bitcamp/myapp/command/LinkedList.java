package bitcamp.myapp.command;

public class LinkedList {

    Node first;
    Node last;
    int size;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append("홍길동");
        list.append("임꺽정");
        list.append("유관순");
        list.append("안중근");
        list.append("윤봉길");
        list.append("김구");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.getValue(i));
        }
        System.out.println("--------------------------");

        list.delete(0);
        list.printAll();

        list.delete(3);
        list.printAll();

    }

    public void append(Object value) {
        Node newNode = new Node(value);

        if (first == null) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Object getValue(int index) {
        if (index < 0 || index >= size) {
            throw null;
        }
        Node cursor = first;
        int cursorIndex = 0;

        while (cursor != null) {
            if (cursorIndex == index) {
                break;
            }
            cursor = cursor.next;
            cursorIndex++;
        }
        return cursor.value;
    }

    public int size() {
        return size;
    }


    public void printAll() {
        Node cursor = first;
        while (cursor != null) {
            System.out.print(cursor.value + ",");
            cursor = cursor.next;
        }
        System.out.println();
    }

    public Object delete(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node deletedNode = null;

        size--;

        // 첫번째를 삭제할 때
        if (index == 0) {
            deletedNode = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return deletedNode;
        }

        Node cursor = first;
        int currentIndex = 0;

        // 중간을 삭제할 때
        while (cursor != null) {
            if (currentIndex == (index - 1)) {
                break;
            }
            cursor = cursor.next;
            currentIndex++;
        }

        // 중간을 삭제할 때 다다음걸 cursor.next(즉 다음꺼 주소값에 다다음꺼를 넣음)
        cursor.next = cursor.next.next;

        // 마지막 일 경우
        if (cursor.next == null) {
            last = cursor;
        }
        return null;
    }

    public int index(Object value) {

        Node cursor = first;
        int currentIndex = 0;

        while (cursor != null) {
            if (cursor.value == value) {
                return currentIndex;
            }
            cursor = cursor.next;
            currentIndex++;
        }
        return -1;
    }

    public Object[] getArray() {
        Object[] arr = new Object[size];

        Node cursor = first;

        for (int i = 0; i < size; i++) {
            arr[i++] = cursor.value;
            cursor = cursor.next;
        }
        return arr;
    }

}