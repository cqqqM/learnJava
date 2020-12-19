package 队列;

/**
 * 基于单链表的队列
 */
public class LinkQueue {
    private int size;
    private Node head;
    private Node tail;

    public class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }

    public LinkQueue() {
        this.head = null;
        this.tail = null;
    }

    //入队列
    public boolean enqueue(Object element) {
        Node newNode = new Node(element,null);
        //如果队列中还没有节点，头尾指向新节点
        if(tail == null) {
            tail = newNode;
            head = newNode;
        }else { //队列已有节点，新节点插入到tail后，tail指向新节点
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    //出队列
    public Object dequeue() {
        //如果队列中无节点
        if(size <= 0) {  //或head==null
            return null;
        }
        Object element = head.data;
        head = head.next;
        size--;
        //如果是最后一个节点出队，tail也要被置空
        if(size <= 0) { //或head==null
            tail = null;
        }
        return element;
    }

    public int getSize() {
        return size;
    }
}
