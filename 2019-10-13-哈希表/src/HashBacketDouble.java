import java.util.Objects;

class Person {
    String sn;//学号，学号相同，就是同一人
    Person(String sn){
        this.sn = sn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(sn, person.sn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sn);
    }
}
public class HashBacketDouble<K,V> {
    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next = null;
    }

    private Node<K,V>[] array = (Node<K,V>[])new Node[8];
    private int size;

    public V get(K key){
        int hash = key.hashCode();//key->int
        int index = hash % array.length;
        Node<K,V> head = array[index];
        for(Node<K,V> cur = head;cur != null;cur = cur.next){
            if(key.equals(cur.key)){
                return cur.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashBacketDouble<Person,String> hash = new HashBacketDouble<>();
        Person p = new Person("113");
        Person q = new Person("113");
        System.out.println(p.hashCode());
        System.out.println(q.hashCode());
        String name = hash.get(q);
    }
}
