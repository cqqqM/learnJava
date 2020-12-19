package 栈;

/**
 * 基于双向链表的链式栈
 */
public class LinkStack {
    private int size;
    private Node tail;

    public class Node {     // 前驱节点
        public Node prev;     // 节点数据
        private Object data;     // 后继节点
        public Node next;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }

    public LinkStack(){
        this.tail = null;
    }

    //入栈：新增两个指针
    public void push(Object obj) {
        Node node = new Node(tail,obj,null);
        if(size>0) {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    //出栈：
    public Object pop() {
        if(size <= 0){
            return null;
        }
        Object tailData = tail.getData();
        tail = tail.prev;
        if(tail!=null) {
            tail.next = null;
        }
        size--;
        return tailData;
    }

}
