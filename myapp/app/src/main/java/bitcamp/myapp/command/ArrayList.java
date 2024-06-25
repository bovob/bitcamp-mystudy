package bitcamp.myapp.command;

import java.util.Arrays;

public class ArrayList {

    private static final int MAX_SIZE = 3;

    private Object[] list = new Object[MAX_SIZE];
    private int size = 0;

    public void add(Object obj) {
        if (size == list.length) {
            int oldSize = list.length;
            int newSize = oldSize + (oldSize >> 1); // 기존대비 50% 증가
            list = Arrays.copyOf(list, newSize);
        }
        list[size++] = obj;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object deletedObj = list[index];
        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return deletedObj;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(list, 0, arr, 0, arr.length);
        return arr;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (list[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        java.util.ArrayList l;
        return list[index];
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

}
