package test.array.twoDArray; 

import array.twoDArray.TwoDArray;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TwoDArray Tester. 
* 
* @author <Authors name> 
* @since <pre>09/30/2019</pre> 
* @version 1.0 
*/ 
public class TwoDArrayTest { 


/** 
* 
* Method: Find(int target, int [][] array) 
* 
*/ 
@Test
public void testFind() throws Exception {
    TwoDArray method=new TwoDArray();
    int[][] arr=new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
    method.print(arr);
    System.out.println(method.Find(16,arr));
}


} 
