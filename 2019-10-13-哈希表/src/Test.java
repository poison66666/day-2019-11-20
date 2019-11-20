import java.util.Objects;
import java.util.HashMap;
public class Test {
    private static class Node {
        private int key;
        private int value;
        Node next;

        public Node (int key,int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key, value, next);
        }
    }
    private Node[] array;
    private int size;

    public int put(int key,int value){
        int index = key % array.length;
        for(Node cur  = array[index];cur != null;cur = cur.next){
            if(key == cur.key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        size++;
        return -1;
    }

    public int get(int key){
        int index = key % array.length;
        for(Node cur = array[index];cur != null; cur = cur.next){
            if(key == cur.key){
                return cur.value;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Hello" + " " + "world";
        System.out.println(str);

        String s = new String("hello");//未在常量池
        String t = s.intern();//放入常量池
    }
}
