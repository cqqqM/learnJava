package 树;

/**
 * 链表实现的 二叉查找树
 *
 *     特点：左节点<根<右节点
 *
 *     节点内部类：先序遍历、中序遍历
 *
 *     操作：插入（新建节点）、删除（删除左子树最小节点）、查找、展示
 */
public class BinarySearchTree {
    //定义树节点及其操作
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(Node left, int data, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        /**
         * 中序遍历二叉树 递归方法
         * 左--根--右
         */
        public void middleOder(Node node) {
            if(node == null) return;
            middleOder(node.left);
            System.out.print(node.data + ",");
            middleOder(node.right);
        }

        /**
         * 先序遍历二叉树 递归方法
         * 根--左--右
         */
        public void preOder(Node node) {
            if(node == null) return;
            System.out.print(node.data + ",");
            preOder(node.left);
            preOder(node.right);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    //根节点
    private Node root;

    /**
     * 查找操作
     */
    public Node find(int data) {
        Node current = root;
        while(current != null) {
            if(data == current.data) {
                return current;
            }else if(data > current.data){
                current = current.right;
            }else if(data < current.data) {
                current = current.left;
            }
        }
        System.out.println("Node not found!");
        return null;
    }

    /**
     * 插入操作
     */
    public boolean put(int data) {
        //如果是个空树，创建根节点
        if(root == null) {
            root = createNode(data);
            return true;
        }

        //准备遍历树，找合适的插入位置
        Node current = root;
        while(current!=null) {
            //插入元素与当前位置 1.比大小，找到对应节点 2.节点为空则插入，不为空则继续往下搜索
            if(data < current.data) {
                if(current.left==null){
                    current.left = createNode(data);
                    return true;
                }
                current = current.left;
            }else {
                if (current.right==null) {
                    current.right = createNode(data);
                    return true;
                }
                current = current.right;
            }
        }
        return false;
    }
    //构建节点
    private Node createNode(int data) {
        return new Node(null,data,null);
    }

    /**
     * 删除操作
     * 三种情况
     *     1.叶子节点：直接删除（丢掉父亲的指针）
     *     2.节点有一个孩子：让节点的父亲指向自己的孩子（修改父亲的指针）
     *     3.节点有两个孩子：让节点的父亲指向与节点最接近的节点（左子树的最大叶子/右子树的最小叶子）（只需要交换值 ）
     */
    public void remove(int data) {
        Node current = root;
        //寻找删除节点的同时，还要记录其父节点以修改指针
        Node currParent = null;
        while(current != null) {
            if(data > current.data) {
                currParent = current;
                current = currParent.right;
            }else if(data < current.data){
                currParent = current;
                current = current.left;
            }else {
                break;
            }
            //未找到要删除的节点
            if(data != current.data) {
                System.out.println("要删除的节点不存在！");
                return;
            }
        }

        //第1种情况：父节点到待删除节点的指针置空
        if(current.left == null && current.right == null) {
            if(currParent.left.data == data) { //删除父节点的左节点
                currParent.left = null;
            }else {
                currParent.right = null;
            }
        }

        //第3种情况：删除右子树中值最小的节点，其值拿到待删除节点中
        else if(current.left != null && current.right != null) {
            int min = minDelete(current.right);
            current.data = min;
        }

        //第2种情况：父节点指向待删除节点的一个孩子
        else {
            //判断待删除节点哪边有孩子
            if(current.left != null && current.right == null) {
                //判断待删除节点是其父节点的哪边孩子
                if(current == currParent.left)
                    currParent.left = current.left;
                else
                    currParent.right = current.left;

            }else if(current.right != null && current.left == null) {
                if(current == currParent.left)
                    currParent.left = current.right;
                else
                    currParent.right = current.right;
            }
        }
    }
    //删除以node节点为根的最小节点，把值拿到node上
    private int minDelete(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        //找到了最小节点，删除
        remove(node.data);
        return node.data;
    }

    /**
     * 展示树
     */
    public void showTree() {
        if(root != null) {
            System.out.print("先序遍历根:[");
            root.preOder(root);
            System.out.println("]");

            System.out.print("中序遍历:[");
            root.middleOder(root);
            System.out.println("]");
        }
    }


}
