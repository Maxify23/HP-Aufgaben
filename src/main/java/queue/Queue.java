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

    Queue filter (Predicate predicate);

    Queue createEmptyQueue();






}
