package 树;

/**
 * 平衡二叉树
 */
public class AVLTree {
    //节点需要多存储一个高度信息
    public static class AvlNode {
        private int data;
        private int height;
        private AvlNode left;
        private AvlNode right;

        AvlNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }


        /**
         * 中序遍历二叉树 递归方法
         * 左--根--右
         */
        public void middleOder(AvlNode node) {
            if (node == null) return;
            middleOder(node.left);
            System.out.print(node.data + ",");
            middleOder(node.right);
        }

        /**
         * 先序遍历二叉树 递归方法
         * 根--左--右
         */
        public void preOder(AvlNode node) {
            if (node == null) return;
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

    private AvlNode root;

    /**
     * 获取高度，判断是否平衡
     */
    //获取某一节点的高度，空节点的高度是-1
    private int getHeight(AvlNode node) {
        if (node == null) return -1;
        return node.height;
    }

    //获取节点的平衡因子：左子树高度-右子树高度
    private int getBalanceFactor(AvlNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断树是否平衡，递归左右子树
    private boolean isBalanced(AvlNode node) {
        if (node == null) return true;
        int balanceFactor = Math.abs(getBalanceFactor(node));
        if (balanceFactor > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * 平衡维护操作
     */
    //右旋操作 （适用LL情况）
    // 1.保存失衡节点左子树的右孩子
    // 2.把左子树的right指针指向父亲，变为新的右孩子
    // 3.保存的右孩子变为新的右孩子的左孩子
    // 4.更新每个节点的height
    // 5.重新计算失衡节点和旋转后根节点的高度，从下到上
    public AvlNode rightRotate(AvlNode node) {
        AvlNode newRoot = node.left;

        //先保存左子树的右孩子
        AvlNode temp = newRoot.right;

        //失序节点变为新的右孩子
        newRoot.right = node;

        //失序节点的右孩子，变为新的右孩子的左孩子
        node.left = temp;

        //重新计算失衡节点和旋转后根节点的高度，从下到上
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(node.right)) + 1;

        return newRoot;
    }

    //左旋操作（适用RR情况）
    public AvlNode leftRotate(AvlNode node) {
        AvlNode newRoot = node.right;
        AvlNode temp = newRoot.left;
        newRoot.left = node;
        node.right = temp;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(node.right)) + 1;

        return newRoot;
    }

    /**
     * 添加操作
     */
    public void put(int data) {
        root = put(root,data);
    }
    // 向以node为根的二分查找树中插入元素，递归算法
    // 每次插入，更新当前节点的高度，计算平衡因子，解决失衡情况
    // 返回插入新节点后二分查找树的根
    private AvlNode put(AvlNode node, int data) {
        //递归出口，创建节点
        if(node == null){
            return new AvlNode(data);
        }
        //递归向左找
        if(data < node.data) {
            node.left = put(node.left,data);
        } else { //递归向右找
            node.right = put(node.right,data);
        }

        //更新插入节点的高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        //讨论失序的情况
        //1.LL，右旋
        if(balanceFactor > 1 && getBalanceFactor(node.left) > 0) {
            return rightRotate(node);
        }
        //2.LR，左子树左旋，本身再右旋
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }//3.RR,左旋
        if(balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            return leftRotate(node);
        }//4.RL，右子树右旋，本身左旋
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        //不失衡，返回
        return node;
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
