package queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class QueueByArray implements Queue {
    Object[] elements = new Object[16];
    int count = 0;

    @Override
    public void enqueue(Object element) {
        if ( count == elements.length - 1){
            elements = Arrays.copyOf(elements, elements.length *2);
        }

        elements[count] = element;
        count++;

    }

    @Override
    public Object dequeue() {
            Object temp = elements[0];
            System.arraycopy(elements,1,elements,0, count);
            count--;
            return temp;
    }

    @Override
    public Object first() {
        if (!isEmpty()){
            return elements[0];
        }
        return null;
    }

    @Override
    public void insert(Object element) {
      enqueue(element);
    }

    @Override
    public void remove(Object element) {
        if (!isEmpty()){
            for (int i = 0;i < count; i++){
                if (Objects.equals(elements[i],element)){
                    System.arraycopy(elements,i+1,elements,i,count - 1);
                    count--;
                    i--;
                        }
                    }
                }
            }



    @Override
    public boolean contains(Object element) {
        if (!isEmpty()){
            for (int i = 0;i <= count; i++){
                if (Objects.equals(elements[i], element)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(int i) {
        if(i <= count) {
            return elements[i];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0 && elements[count] == null){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            count = 0;
            elements = new Object[16];
        }
    }

    private class ArrayIterator implements Iterator {
        int Iterator = 0;

        @Override
        public boolean hasNext() {
            return Iterator < count;
        }

        @Override
        public Object next() {
            return elements[Iterator++];
        }
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    @Override
    public Queue createEmptyQueue() {
        return new QueueByArray();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i<=count; i++){
            sb.append(elements[i]);
            if (i < count){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
