import java.util.Arrays;

/**
 * Created by konstantin.silin on 23.10.2015.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrToSort = Utils.getRandomIntArray(10);
        System.out.println(Arrays.toString(arrToSort));
        BubbleSort sorter = new BubbleSort();
        sorter.sort(arrToSort);
        System.out.println(Arrays.toString(arrToSort));

        System.out.println("Check sorted array: " + Utils.checkSort(arrToSort));
    }

    private void sort(int[] arrToSort) {
        if (arrToSort.length > 1) {
            int buff = 0;
            for (int j = 0; j < arrToSort.length; j ++) {
                boolean isSorted = true;
                for (int i = 0; i < arrToSort.length - 1; i++) {
                    if (arrToSort[i] > arrToSort[i + 1]) {
                        isSorted = false;
                        buff = arrToSort[i];
                        arrToSort[i] = arrToSort[i + 1];
                        arrToSort[i + 1] = buff;
                    }
                }

                if (isSorted) {
                    System.out.println("Preliminary sorted");
                    break;
                }
            }
        }
    }
}
