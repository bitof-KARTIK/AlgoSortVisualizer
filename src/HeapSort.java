import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class HeapSort extends JPanel {
    private int noComparisons = 0;
    private int arrayAccessCount = 0;

    public void executeHeapSort(ArrayList<Integer> nums, Draw draw, App app) throws InterruptedException {
        int n = nums.size();

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i, draw);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap the root element with the last element
            arrayAccessCount += 3; // Increment array access count
            Collections.swap(nums, 0, i);

            // Heapify the reduced heap
            heapify(nums, i, 0, draw);
        }

        app.needReset = true;
        app.noComparisons = noComparisons;
        app.arrayAccessCount = arrayAccessCount;
        app.updateCountLabels();
    }

    private void heapify(ArrayList<Integer> nums, int n, int i, Draw draw) throws InterruptedException {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        arrayAccessCount += 2; // Increment array access count
        if (left < n && nums.get(left) > nums.get(largest)) {
            noComparisons++; // Increment comparison count
            largest = left;
        }

        // If right child is larger than largest so far
        arrayAccessCount += 2; // Increment array access count
        if (right < n && nums.get(right) > nums.get(largest)) {
            noComparisons++; // Increment comparison count
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap the root with the largest element
            arrayAccessCount += 3; // Increment array access count
            Collections.swap(nums, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(nums, n, largest, draw);

            // Update the visualization
            draw.updateArray(nums);
            draw.paintImmediately(0, 30, 870, 532);
            Thread.sleep(50);
        }
    }
}