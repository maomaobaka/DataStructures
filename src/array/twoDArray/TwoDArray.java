package array.twoDArray;

/**
 * 二维数组的方法及题目
 */
public class TwoDArray {
    /**
     * 给定从左到右，从上到下递增的二维数组，找出是否有给定值
     */
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols=array[0].length;
        if(rows==0) return false;
        if(cols==0) return false;
        int row=rows-1;
        int col=0;
        while(row>=0&&col<cols){
            if(array[row][col]==target) return true;
            else if(array[row][col]<target){
                col++;
            }else {
                row--;
            }
        }
        return false;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
