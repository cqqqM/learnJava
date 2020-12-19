package 树;

import java.util.ArrayList;
import java.util.Random;

/**
 * 树
 *     - 概念; 由 n（n>0）个有限节点组成一个具有层次关系的集合
 *         节点的高度：节点到叶子节点的最长路径(边数)，所有叶子节点的高度为 0。
 *         节点的深度：根节点到这个节点所经历的边的个数，根的深度为 0。
 *         节点的层数：节点的深度+1
 *         树的高度：根节点的高度
 *
 * 二叉树
 *     - 概念： 每个节点最多有左右两个子节点
 *     - 特殊结构： 完全二叉树--满二叉树
 *     - 存储结构：
 *         链式存储：每个节点（lchild, data, rchild)
 *         顺序存储：父节点在i，则左孩子在2i，右孩子2i+i    适用完全二叉树
 *
 * 二叉树的遍历（待补）
 *
 * 二叉查找树：左 < 根 < 右
 *     - 时间复杂度：最坏退化成链表 O（N）；最好取决于树的高度O(logN)
 *     - 与哈希表对比：
 *         1.哈希表无序；二叉查找树中序遍历有序
 *         2.哈希表的构造更复杂；平衡二叉树只需要考虑平衡问题
 *         3.哈希表扩容、散列冲突，插入性能不稳定；平衡的二叉树性能非常稳定
 *         4.哈希表由于哈希冲突和哈希函数，查找时间不一定小于树的O（logN）
 *
 * 平衡二叉树AVL
 *     解决普通二叉查找树在频繁的插入、删除等动态更新的情况下，出现树过高，时间复杂度退化的问题.
 *     - 概念：任何一个节点的左右子树都是平衡二叉树，且树高相差不大于1
 *     - 树高 logN+1  查询复杂度 O(logN)
 *     - 节点插入失衡的四种情况：
 *         1.LL左子树的左子树插入，需要右旋
 *         2.RR 需要左旋
 *         3.LR 左子树的右子树插入，需要对左子树左旋，再对上层右旋
 *         4.RL 需要对右子树右旋，再对上层左旋
 *
 *         AVL插入新节点所需要的最大旋转次数是常数
 *
 * *红黑树 brTree
 *     工业界最主要使用的二叉搜索平衡树.如java中的TreeMap
 *     实际平衡度不如AVL树，最差情况它从根到叶子的最长路可以是最短路的两倍
 *     保存红黑状态只需要1bit，而AVL树需要额外存储一个平衡值
 */
public class Demo01 {
    public static void main(String[] args) {
        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.put(2);
        bsTree.put(3);
        bsTree.put(1);
        bsTree.put(10);
        bsTree.put(11);
        bsTree.put(14);
        bsTree.put(8);
        bsTree.put(65);
        bsTree.put(32);

        bsTree.showTree();
        bsTree.remove(2);
        bsTree.showTree();
//        System.out.print(bsTree.find(10));

        System.out.println("\nAVL树测试：");
        AVLTree avlTree = new AVLTree();
        avlTree.put(2);
        avlTree.put(3);
        avlTree.put(1);
        avlTree.put(10);
        avlTree.put(11);
        avlTree.put(14);
        avlTree.put(8);
        avlTree.put(65);
        avlTree.put(32);
        avlTree.showTree();



    }
}
