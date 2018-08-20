/* 
 *	冒泡排序，原始数组为A
 *	从第一个元素开始与其后每个元素进行比较，将小数向初始位置冒起。
 */
for(int i = 0; i < A.length - 1; i++){
	for(int j = i + 1; j < A.length; j++){
		if(A[i] > A[j]){
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}
}
/* 
 *	选择排序，原始数组为A
 *	第一次从R[0]~R[n-1]中选取最小值，与R[0]交换;
 *	第二次从R[1]~R[n-1]中选取最小值，与R[1]交换;
 *	....，   
 *	第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换;
 *	.....，
 *	第n-1次从R[n-2]~R[n-1]中选取最小值，与R[n-2]交换;
 *	总共通过n-1次,得到一个按排序码从小到大排列的有序序列。
 */
for(int i = 0; i < A.length - 1; i++){
	int minIndex = i; 
	for(int j = i + 1; j < A.length; j++){
		if(A[minIndex] > A[j]){
			minIndex = j;
		}
		if(minIndex != i){
			int temp = A[i];
			A[i] = A[minIndex];
			A[minIndex] = temp;
		}
	}
}
/* 
 *	插入排序，原始数组为A
 *	在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。
 */
int temp = 0;
for(int i = 1; i < A.length; i++){
	temp = A[i]; 
	int j = 0;
	for(j = i - 1; j >= 0 && A[j] > temp; j--){
		A[j + 1] = A[j];
	}
	A[j + 1] = temp;
}
/* 
 *	快速排序，原始数组为A
 *	设置两个变量i、j，排序开始的时候：i=0，j=N-1；
 *	以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
 *	从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换； 
 *	从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
 *	重复第3、4步，直到i>=j；
 */
public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key = array[lo];
        while(lo < hi){
            while(array[hi] >= key && hi > lo){//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while(array[lo] <= key && hi > lo){
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }
    
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }
/*
 * 堆排序
*/
package sortdemo;

import java.util.Arrays;

/**
 * Created by chengxiao on 2016/12/17.
 * 堆排序demo
 */
public class HeapSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}