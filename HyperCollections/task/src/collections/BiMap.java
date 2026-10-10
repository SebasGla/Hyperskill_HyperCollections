package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BiMap<K, V>  {
    private Map<K, V> forwardMap;
    private Map<V, K> reverseMap;

    public BiMap(){
        this.forwardMap = new HashMap<>();
        this.reverseMap = new HashMap<>();
    }

    public V put(K key, V value){
        if(this.forwardMap.containsKey(key)){
            throw new IllegalArgumentException();
        }

        if(this.reverseMap.containsKey(value)){
            throw new IllegalArgumentException();
        }

        this.forwardMap.put(key, value);
        this.reverseMap.put(value, key);

        return value;
    }


    public void putAll(Map<K, V> b) {
        Set<Map.Entry<K,V>> entries = b.entrySet();

        for(Map.Entry<K, V> entry: entries){
            K key = entry.getKey();
            V value = entry.getValue();

            if (this.forwardMap.containsKey(key)){
                throw new IllegalArgumentException();
            }

            if(this.reverseMap.containsKey(value)){
                throw new IllegalArgumentException();
            }

            this.forwardMap.put(key, value);
            this.reverseMap.put(value, key);
        }
    }

    @Override
    public String toString() {
        return this.forwardMap.toString();
    }

    public Collection<V> values() {
        return this.forwardMap.values();
    }
    
    public Map<V, K> inverse() {
        return this.reverseMap;
    }

    public V forcePut(K key, V value){
        if(this.forwardMap.containsKey(key) && this.forwardMap.containsValue(value)){
            V reverseKey = this.forwardMap.get(key);
            K forwardKey = this.reverseMap.get(value);
            this.forwardMap.replace(key, value);
            this.forwardMap.remove(forwardKey);
            this.reverseMap.replace(value, key);
            this.reverseMap.remove(reverseKey);
        }
        else if(this.forwardMap.containsKey(key)){
            V reverseKey = this.forwardMap.get(key);
            this.forwardMap.replace(key, value);

            this.reverseMap.remove(reverseKey);
            this.reverseMap.put(value, key);

        }else if(this.forwardMap.containsValue(value)){
            K forwardKey = this.reverseMap.get(value);
            this.reverseMap.replace(value, key);

            this.forwardMap.remove(forwardKey);
            this.forwardMap.put(key, value);

        }
        else {
            this.forwardMap.put(key, value);
            this.reverseMap.put(value, key);
        }

        return value;

    }
}
