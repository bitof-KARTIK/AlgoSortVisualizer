import javax.swing.*;
import java.util.*;

public class SelectionSort extends JPanel {
    private int noComparisons = 0;
    private int arrayAccessCount = 0;

    public void executeSelectionSort(ArrayList<Integer> nums, Draw draw, App app) throws InterruptedException {
        int n = nums.size();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                arrayAccessCount += 2; // Increment array access count
                if (nums.get(j) < nums.get(minIdx)) {
                    noComparisons++; // Increment comparison count
                    minIdx = j;
                }
            }

            // Swap the minimum element with the current element
            Collections.swap(nums, i, minIdx);

            // Update the visualization
            draw.updateArray(nums);
            draw.paintImmediately(0, 30, 870, 532);
            Thread.sleep(100);
        }

        app.needReset = true;
        app.noComparisons = noComparisons;
        app.arrayAccessCount = arrayAccessCount;
        app.updateCountLabels();
    }
}