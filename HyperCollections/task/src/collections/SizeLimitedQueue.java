package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class SizeLimitedQueue<E> {
    private Deque<E> queue;
    private final int maxSize;

    public SizeLimitedQueue(int size){
        this.queue = new ArrayDeque<E>(size);

        if(size>0){
            this.maxSize = size;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public int size(){
        return queue.size();
    }


    public int maxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public void add(E element) {
        if(element != null){
            if(!isAtFullCapacity()){
                queue.addLast(element);
            }
            else{
                queue.removeFirst();
                queue.addLast(element);
            }
        }else {
            throw new NullPointerException();
        }


    }

    public boolean isAtFullCapacity() {
        return queue.size()==maxSize;
    }

    public E peek() {
        if(queue.isEmpty()){
            return null;
        }

        return queue.peek();
    }

    public E remove() {
        if (queue.isEmpty()){
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    public Object[] toArray() {
        return queue.toArray();
    }

    public E[] toArray(E[] e) {
        return queue.toArray(e);
    }

    public void clear(){
        queue.clear();
    }
}
