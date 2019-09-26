package tree.BST;

import java.util.LinkedList;
import java.util.Stack;

public class BSTMethod {
    /**
     * 构造二叉排序树
     */
    public TreeNode createBST(int[] val, TreeNode root) {
        root = null;
        for (int i = 0; i < val.length; i++) {
            root = insertBST(val[i], root);
        }
        return root;
    }

    /**
     * 递归插入二叉树
     */
    public TreeNode insertBST(int val, TreeNode root) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }
        if (val < root.val) root.left = insertBST(val, root.left);
        if (val > root.val) root.right = insertBST(val, root.right);

        return root;
    }


    /**
     * 中序遍历BST
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val + " ");
            inOrder(root.right);
        }
    }

    /**
     * 层次遍历BST(效率低)
     */
    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) {
            list.add(root);
            while (!list.isEmpty()) {
                TreeNode newNode = list.poll();
                System.out.println(newNode.val + " ");
                if (root.left != null) list.add(root.left);
                if (root.right != null) list.add(root.right);
            }
        }
    }

    /**
     * 深度优先遍历BST(同前序遍历)
     */
    public void dfsBST(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            dfsBST(root.left);
            dfsBST(root.right);
        }
    }

    /**
     * 深度优先遍历BST(同前序遍历)非递归实现
     */
    public void dfsBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 后序遍历BST
     */
    public void postOrder(TreeNode root) {
        System.out.println(root.val);
        postOrder(root.left);
        postOrder(root.right);
    }


    /**
     * 查找指定值是否存在
     */
    public boolean find(int val, TreeNode root) {
        boolean flag = false;
        if (root == null) {
            return false;
        } else if (root.val == val) {
            return true;
        } else {
            flag = find(val, root.left);
            if (!flag) {
                flag = find(val, root.right);
            }
        }
        return flag;
    }

    /**
     * 删除指定节点(非递归)
     * 假如目标节点的左子树为空，直接将右子树的根取代目标节点
     * 假如目标节点的右子树为空，直接将左子树的根取代目标节点
     * 假如目标节点的左右子树都不为空，将左边子树的最右边的叶子节点  或  右子树的最左边的叶子节点取代目标节点
     * 这里取右子树最小值，共有两种情况
     * 1、这个最小值是叶子节点，
     * 2、这个最小值不是叶子节点，有一颗右子树
     * 对于第一种直接将叶子节点的值赋给要删除的节点，然后将双亲的左子树置空
     * 对于第二种将叶子节点的值赋给要删除的节点，接着将双亲的右子树指向被删节点的右子树。
     * 上面两种情况合起来就是假如有右子树，就将右子树链接到该节点的双亲上
     */
    public TreeNode delete(int val, TreeNode root) {
        if (!find(val, root)) return null;
        TreeNode cur = root;
        TreeNode parent = null;
        //找到待删除节点及其父节点
        while (cur != null) {
            if (val < cur.val) {
                parent = cur;
                cur = cur.left;
            } else if (val > cur.val) {
                parent = cur;
                cur = cur.right;
            } else break;
        }
        //若该节点左右孩子都不为空，记录下该节点的后继节点（右孩子），一直找到右孩子的最左边的叶子节点，将其替换为待删除节点
        if (cur.left != null && cur.right != null) {
            parent = cur;
            TreeNode post = cur.right;
            while (post.left != null) {
                parent = post;
                post = post.left;
            }
            cur.val = post.val;
            cur = post;
        }
        //删除cur引用的节点
        TreeNode child = cur.left;
        if (child != null) {
            child = cur.right;
        }
        if (parent == null) {
            root = child;
        } else if (cur.val < parent.val) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        return root;
    }

    /**
     * 删除指定节点（递归）
     */
    public TreeNode delete2(int val, TreeNode root) {
        if (!find(val, root)) return null;
        if (root == null) return null;
        if (val < root.val) {
            root.left = delete2(val, root.left);
        } else if (val > root.val) {
            root.right = delete2(val, root.right);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else if (root.left != null && root.right != null) {
                TreeNode parent = root.right;
                while (parent.left != null) {
                    parent = parent.left;
                }
                root.val = parent.val;
                root.right = delete2(parent.val, root.right);
            }

        }
        return root;
    }


    /**
     * 寻找指定值的节点是否存在，并返回该节点
     */
    public TreeNode findAndReturn(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return findAndReturn(root.left, val);
        } else if (val > root.val) {
            return findAndReturn(root.right, val);
        } else {

            return root;
        }
    }

    /**
     * 递归求BST的高度
     */
    public int highOfTree(TreeNode root){
        if(root==null) return 0;
        return highOfTree(root.left)>highOfTree(root.right)?highOfTree(root.left)+1:highOfTree(root.right)+1;
    }

    /**
     * 递归求BST的节点数
     */
    public int number(TreeNode root){
        if(root==null) return 0;
        return number(root.left)+number(root.right)+1;
    }

    /**
     * 交换每个节点的左右孩子
     */
    public TreeNode mirror(TreeNode root){
        if(root==null) return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null||node.right!=null){
                TreeNode temp=node.left;
                node.left=node.right;
                node.right=temp;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 递归交换左右孩子
     */
    public void mirror2(TreeNode root){
        if(root==null) return ;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirror2(root.left);
        mirror2(root.right);
    }


}


