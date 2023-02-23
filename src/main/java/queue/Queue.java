package queue;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.function.Predicate;

public interface Queue {

    void enqueue (Object element);

    Object dequeue();

    Object first();

    void insert (Object element);

    void remove (Object element);

    boolean contains (Object element);

    Object get (int i);

    int size();

    boolean isEmpty();

    void clear();

    String toString();

    Iterator iterator();

    default Queue filter (Predicate predicate){
        Queue queue = createEmptyQueue();
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            Object tmp = iterator.next();
            if(predicate.test(tmp)){
                queue.enqueue(tmp);
            }
        }
        return null;
    }

    Queue createEmptyQueue();








}
