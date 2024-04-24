import javax.swing.*;
import java.util.ArrayList;

public class MergeSort extends JPanel {
    private int noComparisons = 0;
    private int arrayAccessCount = 0;

    public void executeMergeSort(ArrayList<Integer> nums, Draw draw, App app) throws InterruptedException {
        mergeSort(nums, draw, 0, nums.size() - 1);
        app.needReset = true;
        app.noComparisons = noComparisons;
        app.arrayAccessCount = arrayAccessCount;
        app.updateCountLabels();
    }

    private void mergeSort(ArrayList<Integer> array, Draw draw, int left, int right) throws InterruptedException {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, draw, left, mid);
            mergeSort(array, draw, mid + 1, right);

            merge(array, draw, left, mid, right);
        }
    }

    private void merge(ArrayList<Integer> array, Draw draw, int left, int mid, int right) throws InterruptedException {
        int i = left, j = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= right) {
            arrayAccessCount += 2; // Increment array access count
            if (array.get(i) <= array.get(j)) {
                noComparisons++; // Increment comparison count
                temp.add(array.get(i));
                i++;
            } else {
                noComparisons++; // Increment comparison count
                temp.add(array.get(j));
                j++;
            }
        }

        while (i <= mid) {
            arrayAccessCount++; // Increment array access count
            temp.add(array.get(i));
            i++;
        }

        while (j <= right) {
            arrayAccessCount++; // Increment array access count
            temp.add(array.get(j));
            j++;
        }

        for (int k = left; k <= right; k++) {
            arrayAccessCount += 2; // Increment array access count
            array.set(k, temp.get(k - left));
            draw.updateArray(array);
            draw.paintImmediately(0, 30, 870, 532);
            Thread.sleep(50);
        }
    }
}