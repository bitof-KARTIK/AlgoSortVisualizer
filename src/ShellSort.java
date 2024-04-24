import javax.swing.*;
import java.util.ArrayList;

public class ShellSort extends JPanel {
    public void executeShellSort(ArrayList<Integer> nums, Draw draw, App app) throws InterruptedException {
        int n = nums.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = nums.get(i);
                int j;
                for (j = i; j >= gap && nums.get(j - gap) > temp; j -= gap) {
                    app.arrayAccessCount += 3; // Increment array access count
                    app.noComparisons++; // Increment comparison count
                    nums.set(j, nums.get(j - gap));
                    draw.updateArray(nums);
                    draw.paintImmediately(0, 30, 870, 532);
                    Thread.sleep(50);
                }
                nums.set(j, temp);
            }
        }
        app.needReset = true;
        app.updateCountLabels(); // Update the labels
    }
}