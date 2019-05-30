package demo;

/**
 * @author : ZJ
 * @date : 18-9-12 上午10:04
 */
public class Test {
    int numSize = 1000;

    int arraySize =(int)Math.ceil((double)numSize/32);

    private int array[] = new int[arraySize];


    /**
     * @param args
     */
    public static void main(String[] args) {

        //也可以使用bitset
        Test test = new Test();
        test.initBitMap();
        int sortArray[] = new int[]{1,4,32,2,6,9,3};

        for(int i=0;i<sortArray.length;i++){
            test.set1(sortArray[i]);
        }
        for(int i=0;i<test.numSize;i++){
            if(test.get(i) !=0){
                System.out.print((i)+" ");
            }
        }

    }

    public void initBitMap(){
        for(int i=0;i<array.length;i++){
            array[i] = 0;
        }
    }
    public void set1(int pos){
        System.out.println(pos>>5);
        System.out.println(1 <<(pos% 32));
        System.out.println(1<<(pos%32));
        array[pos>>5] =     array[pos>>5] | (1 <<(31-pos% 32) ); //给相应位置1

    }

    public int get(int pos){
        return array[pos>>5] & (1 <<(31-pos% 32 ));
    }
}
