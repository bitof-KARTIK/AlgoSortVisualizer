import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class App extends JFrame implements ActionListener {
    // Instantiate Objects
    JComboBox algosDropdown;
    JLabel lblTtl;
    String selectedAlgo = "";
    JPanel panelUpper = new JPanel();
    CreateArray newArray = new CreateArray();
    ArrayList<Integer> array = newArray.createArray();
    Draw draw = new Draw(array);

    // Buttons
    JButton start;
    JButton reset;

    // Instantiate Algorithms
    BubbleSort bubble = new BubbleSort();
    SelectionSort selection = new SelectionSort();
    InsertionSort insertion = new InsertionSort();
    QuickSort quick = new QuickSort();
    MergeSort merge = new MergeSort();
    ShellSort shell = new ShellSort();
    HeapSort heap = new HeapSort();

    // Runtime, No. Comparisons, Array Accesses
    JLabel runtimeLabel;
    JLabel comparisonsLabel;
    JLabel arrayAccessesLabel;

    // Global variables
    int noComparisons = 0;
    int arrayAccessCount = 0;

    // Bool value for reset check
    boolean needReset = false;

    public App() {
        // Instantiate stuff
        this.setTitle("Sorting Algorithms Visualizer");
        this.setSize(new Dimension(870, 622));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        lblTtl = new JLabel("Sorting Algorithms Visualizer");
        lblTtl.setBounds(235, 0, 400, 60);
        lblTtl.setFont(new Font("Arial", Font.BOLD, 25));
        lblTtl.setForeground(Color.white);
        panelUpper.add(lblTtl);

        // Runtime, Number Comparisons, Number Array Accesses
        // Runtime label
        runtimeLabel = new JLabel("Runtime: null");
        runtimeLabel.setBounds(10, 10, 200, 30);
        runtimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        runtimeLabel.setForeground(Color.white);
        panelUpper.add(runtimeLabel);

        // Comparisons label
        comparisonsLabel = new JLabel("Comparisons: 0");
        comparisonsLabel.setBounds(10, 40, 200, 30);
        comparisonsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        comparisonsLabel.setForeground(Color.white);
        panelUpper.add(comparisonsLabel);

        // Array Accesses label
        arrayAccessesLabel = new JLabel("Array Accesses: 0");
        arrayAccessesLabel.setBounds(10, 70, 200, 30);
        arrayAccessesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        arrayAccessesLabel.setForeground(Color.white);
        panelUpper.add(arrayAccessesLabel);

        // Combo Box
        String[] algorithms = {"Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Merge Sort", "Shell Sort", "Heap Sort"};
        algosDropdown = new JComboBox(algorithms);
        algosDropdown.setBounds(690, 0, 155, 30);
        algosDropdown.addActionListener(this);
        panelUpper.add(algosDropdown);

        // Buttons
        // Start Button
        start = new JButton("Start");
        start.setBounds(700, 30, 140, 30);
        start.addActionListener(this);
        panelUpper.add(start);

        // Reset Button
        reset = new JButton("Reset");
        reset.setBounds(700, 60, 140, 30);
        reset.addActionListener(this);
        panelUpper.add(reset);

        // Align two panels
        panelUpper.setBounds(0, 0, 870, 100);
        draw.setBounds(0, 100, 870, 522);

        // Set background colours
        panelUpper.setBackground(Color.darkGray);
        draw.setBackground(Color.darkGray);

        // Add panels
        panelUpper.setLayout(new BorderLayout());
        this.add(draw);
        this.add(panelUpper);
        this.validate();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check status before pressing start button
        if (e.getSource() == start && algosDropdown.getSelectedItem() != "Select Algorithm" && !needReset) {
            if (selectedAlgo.equals("Bubble")) {
                try {
                    bubble.executeBubbleSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo.equals("Selection")) {
                try {
                    selection.executeSelectionSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo.equals("Insertion")) {
                try {
                    insertion.executeInsertionSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo.equals("Quick")) {
                try {
                    quick.executeQuickSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo.equals("Merge")) {
                try {
                    merge.executeMergeSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo.equals("Shell")) {
                try {
                    shell.executeShellSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo.equals("Heap")) {
                try {
                    heap.executeHeapSort(array, draw, this);
                    updateCountLabels();
                    draw.updateArray(array);
                    draw.repaint();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }

        // Reset button status
        if (e.getSource() == reset) {
            array = newArray.createArray();
            draw.updateArray(array);
            draw.repaint();
            needReset = false;
            noComparisons = 0;
            arrayAccessCount = 0;
            updateCountLabels();
        }

        // Combo box status
        if (e.getSource() == algosDropdown) {
            System.out.println(algosDropdown.getSelectedItem());
            if (algosDropdown.getSelectedItem() == "Bubble Sort") {
                selectedAlgo = "Bubble";
                runtimeLabel.setText("Runtime: O(N^2)");
            } else if (algosDropdown.getSelectedItem() == "Selection Sort") {
                selectedAlgo = "Selection";
                runtimeLabel.setText("Runtime: O(N^2)");
            } else if (algosDropdown.getSelectedItem() == "Insertion Sort") {
                selectedAlgo = "Insertion";
                runtimeLabel.setText("Runtime: O(N^2)");
            } else if (algosDropdown.getSelectedItem() == "Quick Sort") {
                selectedAlgo = "Quick";
                runtimeLabel.setText("Runtime: Nlog(N)");
            } else if (algosDropdown.getSelectedItem() == "Merge Sort") {
                selectedAlgo = "Merge";
                runtimeLabel.setText("Runtime: Nlog(N)");
            } else if (algosDropdown.getSelectedItem() == "Shell Sort") {
                selectedAlgo = "Shell";
                runtimeLabel.setText("Runtime: Nlog(N)");
            } else if (algosDropdown.getSelectedItem() == "Heap Sort") {
                selectedAlgo = "Heap";
                runtimeLabel.setText("Runtime: Nlog(N)");
            }
        }
    }

    void updateCountLabels() {
        comparisonsLabel.setText("Comparisons: " + noComparisons);
        arrayAccessesLabel.setText("Array Accesses: " + arrayAccessCount);
    }
}