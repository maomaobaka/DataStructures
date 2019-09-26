package test.tree.BST; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import tree.BST.BSTMethod;
import tree.BST.TreeNode;

/** 
* BSTMethod Tester. 
* 
* @since <pre>09/26/2019</pre>
* @version 1.0 
*/ 
public class BSTMethodTest { 

@Test
public void testMethod() throws Exception {
    TreeNode root=null;
    int vals[]=new int[]{11,12,43,32,61,1};
    BSTMethod method=new BSTMethod();
    root=method.createBST(vals,root);
    method.dfsBST2(root);
}


} 
