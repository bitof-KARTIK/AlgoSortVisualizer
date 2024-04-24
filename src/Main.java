import javax.swing.*;

public class Main {
    // Instantiate Objects
    JLabel lblTtl; // Declare a JLabel object for title
    App app; // Declare an App object (custom class)
    BubbleSort bubble; // Declare a BubbleSort object (custom class)

    public Main() {
        // Constructor for Main class
    }

    public static void main(String[] args) {
        // Main method, entry point of the program
        new App(); // Create a new instance of App class
    }

    public void setVisible(boolean b) {
        // Method to set visibility, currently empty
    }
}