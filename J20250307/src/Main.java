import java.util.Random;

/**
 * @Shootingmemory
 * @create 2025-03-07-9:28
 */
public class Main {
    public static void main(String[] args) {

    }
    //快速排序
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums,0,nums.length-1);
            return nums;
        }
        public void quickSort(int[] nums,int left,int right){
            if(left>=right){
                int pos=randomizedPartition(nums,left,right);
                quickSort(nums,left,pos-1);
                quickSort(nums,pos+1,right);
            }
        }
        public int randomizedPartition(int[] nums,int left,int right){
            int i=new Random().nextInt(right-left+1)+left;
            swap(nums,i,right);
            return partition(nums,left,right);
        }
        public int partition(int[] nums,int left,int right){
            int pivot=nums[right];
            int i=left-1;
            for(int j=left;j<right;j++){
                if(nums[j]<=pivot){
                    i++;
                    swap(nums,i,j);
                }
            }
            swap(nums,i+1,right);
            return i+1;
        }
        public void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}