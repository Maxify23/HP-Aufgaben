package queue;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class QueueByList implements Queue{
    private ListElement head = null;
    private ListElement tail = null;
    private int size = 0;



    @Override
    public void enqueue(Object element) {
        if (head == null){
            head = new ListElement(element,null);
            tail = head;
        }
        else
        {
        tail.next = new ListElement(element, null);     // tail Referenz auf neues Element gesetzt
        tail = tail.next;                                    // Angliederung des letzten Elementes
        }
        size ++;
    }

    @Override
    public Object dequeue() {
        Object tmp = head.element;
        head = head.next;

        if (head == null){
            tail = null;
        }
        size --;

        return tmp;
    }

    @Override
    public Object first() {
        return head.element;
    }

    @Override
    public void insert(Object element) {
        enqueue(element);
    }

    @Override
    public void remove(Object element) {
      if (head != null ){
          while (Objects.equals(head.element,element)){
              dequeue();
          }

      if (head != null) {
          ListElement tmp = head;
          while (tmp.next != null) {
              if (Objects.equals(tmp.element, element)) {
                  tmp.next = tmp.next.next;
                  size --;
              } else {
                  tmp = tmp.next;
              }

          }
          if (head ==null){
              tail = null;
          }
        }
      }
    }

    @Override
    public boolean contains(Object element) {
        ListElement tmp = head;
        while (tmp != null){
            if (Objects.equals(tmp.element,element)){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public Object get(int i) {
        ListElement tmp = head;
        while (i > 0){
            if(tmp == null){
                return null;
            }
            tmp = tmp.next;
            i --;
        }
        return tmp.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private class ListIterator implements Iterator {
        ListElement tmp = head;

        @Override
        public boolean hasNext() {
            return tmp != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Object oTmp = tmp.element;
                tmp = tmp.next;
                return tmp;
            }
            return null;
        }
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    @Override
    public Queue createEmptyQueue() {
        return new QueueByList();
    }

    private static class ListElement {
        Object element;
        ListElement next;

        public ListElement(Object element, ListElement next){
            this.element = element;
            this.next = next ;
        }
    }

    public String tostring(){
       ListElement tmp = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (tmp != null){
            sb.append(tmp.element);
            if(tmp.next != null){
                sb.append(", ");
            }
            tmp = tmp.next;

        }
        sb.append("]");
        return sb.toString();
    }

}
