package Algorihtm;

import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.internal.Integers;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : ZJ
 * @date : 18-12-24 上午11:43
 */
public class BinarySearch {
    private Integer index(int[] integers,Integer key){
        Integer index=-1;
        //Arrays.sort(integers);
        Integer mid=integers.length/2;
        if(key==integers[mid]){
            return  mid;
        }
        Integer start=0;
        Integer end=integers.length-1;
        while (start<=end){
            mid=(end-start)/2+start;
            if(key<integers[mid]){
                end=mid-1;
            }else if(key>integers[mid]){
                start=mid+1;
            }else {
                return mid;
            }
        }
        return index;
    }


    private int binSearch(int[] arr,int start,int end,int source){

        int mid=(end-start)/2 +start;
        if(source==arr[mid]){
            return mid;
        }else if(source<arr[mid]){
            return binSearch(arr,start,mid-1,source);
        }else {
            return binSearch(arr,mid+1,end,source);
        }

    }

    @Test
    public void test(){
       int[] arr={0,1,2,3,4,5,6,7};
        int d=binSearch(arr,0,arr.length,2);
        System.out.println(d);
    }
}
