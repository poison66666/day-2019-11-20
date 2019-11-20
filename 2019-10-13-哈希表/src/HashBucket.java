public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    public int put(int key,int value){
        int index = key % array.length;

        for(Node cur = array[index]; cur != null;cur = cur.next){
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

        if(loadFactor() >= LOAD_FACTOR){
            resize();
        }
        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length*2];
        for(int i = 0;i<array.length;i++){
            Node next;
            for(Node cur = array[i];cur != null;cur = cur.next){
                next = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }


    private double loadFactor(){
        return size*1.0/array.length;
    }

    public HashBucket(){
        array = new Node[8];
        size = 0;
    }

    public int get(int key){
        int index = key % array.length;
        for(Node cur = array[index];cur != null;cur = cur.next){
            if(key == cur.key){
                return cur.value;
            }
        }
        return -1;
    }

    public int remove(int key){
        int index = key%array.length;
        Node head = array[index];
        if(head != null && key == head.key) {
            array[index] = array[index].next;
            return head.value;
        }
        Node prev = null;
        for(Node cur = head;cur != null;cur = cur.next){
            if(key == cur.key){
                prev.next = cur.next;
                return cur.value;
            }
            prev = cur;
        }
        return -1;
    }
}
