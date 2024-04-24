import java.util.ArrayList;
import java.util.Collections;

public class CreateArray {
    public ArrayList<Integer> createArray() {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= 30; i++) { // Adjust loop to iterate 15 times
            nums.add(10 * i);
        }
        Collections.shuffle(nums);
        System.out.println(nums);

        return nums;
    }
}