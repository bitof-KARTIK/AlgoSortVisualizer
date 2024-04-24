import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    ArrayList<Integer> nums;

    public Draw(ArrayList<Integer> array) {
        nums = new ArrayList<>(array);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int idx = 0; idx < nums.size(); idx++) {
            g.setColor(Color.pink);
            g.fillRect(10 + 30 * idx + 4 * idx, 502 - nums.get(idx), 30, nums.get(idx));
        }
    }

    public void updateArray(ArrayList<Integer> array) {
        nums = new ArrayList<>(array);
    }
}