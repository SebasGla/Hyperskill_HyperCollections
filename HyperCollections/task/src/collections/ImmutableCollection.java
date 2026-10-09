package collections;

import java.util.List;
import java.util.Objects;

public final class ImmutableCollection<T> {
    private List<T> list;

    private ImmutableCollection(T... elements){
        list = List.of(elements);
    }

    public static <E> ImmutableCollection<E> of(E... elements){
        Objects.requireNonNull(elements, "elemts is Null");
        return new ImmutableCollection<E>(elements);
    }
    public static <E> ImmutableCollection<E> of(){
        return new ImmutableCollection<>();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean contains(T element){
        for(T listElement:list){
            if (Objects.equals(listElement, element)){
                return true;
            }
        }
        return false;
    }
}
