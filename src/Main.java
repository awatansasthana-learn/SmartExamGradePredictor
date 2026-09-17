import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JTextField nameField;
    private JTextField rollField;
    private JTextField subjectField;
    private JTextField internalField;
    private JTextField midtermField;
    private JTextField endSemField;

    private JTextArea resultArea;

    public Main() {

        setTitle("Smart Exam Grade Predictor");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
    }

    private void createGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Title
        JLabel title = new JLabel(
                "SMART EXAM GRADE PREDICTOR",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        mainPanel.add(title, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(
                new GridLayout(6, 2, 10, 10)
        );

        nameField = new JTextField();
        rollField = new JTextField();
        subjectField = new JTextField();
        internalField = new JTextField();
        midtermField = new JTextField();
        endSemField = new JTextField();

        inputPanel.add(new JLabel("Student Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Roll Number:"));
        inputPanel.add(rollField);

        inputPanel.add(new JLabel("Subject:"));
        inputPanel.add(subjectField);

        inputPanel.add(new JLabel("Internal Marks (0-40):"));
        inputPanel.add(internalField);

        inputPanel.add(new JLabel("Mid-Term Marks (0-30):"));
        inputPanel.add(midtermField);

        inputPanel.add(new JLabel("Expected End-Sem (0-30):"));
        inputPanel.add(endSemField);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(
                new GridLayout(2, 2, 10, 10)
        );

        JButton predictButton =
                new JButton("Predict Grade");

        JButton targetButton =
                new JButton("Target Grade");

        JButton clearButton =
                new JButton("Clear");

        JButton exitButton =
                new JButton("Exit");

        buttonPanel.add(predictButton);
        buttonPanel.add(targetButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Result area
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        JScrollPane scrollPane =
                new JScrollPane(resultArea);

        JPanel resultPanel = new JPanel(
                new BorderLayout()
        );

        resultPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Result"
                )
        );

        resultPanel.add(scrollPane);

        mainPanel.add(
                resultPanel,
                BorderLayout.EAST
        );

        // Button actions

        predictButton.addActionListener(e ->
                predictGrade()
        );

        targetButton.addActionListener(e ->
                calculateTarget()
        );

        clearButton.addActionListener(e ->
                clearFields()
        );

        exitButton.addActionListener(e ->
                System.exit(0)
        );

        add(mainPanel);
    }

    private void predictGrade() {

        try {

            double internal =
                    Double.parseDouble(
                            internalField.getText()
                    );

            double midterm =
                    Double.parseDouble(
                            midtermField.getText()
                    );

            double endSem =
                    Double.parseDouble(
                            endSemField.getText()
                    );

            if (internal < 0 || internal > 40 ||
                midterm < 0 || midterm > 30 ||
                endSem < 0 || endSem > 30) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid marks.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            double total =
                    internal + midterm + endSem;

            String grade =
                    GradeCalculator.calculateGrade(total);

            resultArea.setText(
                    "================================\n" +
                    "       GRADE PREDICTION\n" +
                    "================================\n\n" +

                    "Student : " +
                    nameField.getText() + "\n" +

                    "Roll No : " +
                    rollField.getText() + "\n" +

                    "Subject : " +
                    subjectField.getText() + "\n\n" +

                    String.format(
                            "Internal       : %.2f / 40%n",
                            internal
                    ) +

                    String.format(
                            "Mid-Term       : %.2f / 30%n",
                            midterm
                    ) +

                    String.format(
                            "Expected End   : %.2f / 30%n%n",
                            endSem
                    ) +

                    String.format(
                            "Predicted Total: %.2f / 100%n",
                            total
                    ) +

                    "Predicted Grade: " +
                    grade + "\n"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter numbers only.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void calculateTarget() {

        String[] grades = {
                "A+", "A", "B+", "B", "C", "D"
        };

        String target =
                (String) JOptionPane.showInputDialog(
                        this,
                        "Select your target grade:",
                        "Target Grade",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        grades,
                        grades[0]
                );

        if (target == null) {
            return;
        }

        try {

            double internal =
                    Double.parseDouble(
                            internalField.getText()
                    );

            double midterm =
                    Double.parseDouble(
                            midtermField.getText()
                    );

            double required =
                    TargetCalculator.getRequiredMarks(
                            internal,
                            midterm,
                            target
                    );

            if (required > 30) {

                resultArea.setText(
                        "Target Grade: " + target +
                        "\n\n" +
                        "This target is NOT achievable\n" +
                        "with the current marks."
                );

            } else {

                resultArea.setText(
                        "================================\n" +
                        "       TARGET CALCULATOR\n" +
                        "================================\n\n" +

                        "Current Internal : " +
                        internal + " / 40\n" +

                        "Current Mid-Term : " +
                        midterm + " / 30\n\n" +

                        "Target Grade     : " +
                        target + "\n\n" +

                        String.format(
                                "Required End-Sem : %.2f / 30",
                                required
                        )
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter valid Internal and Mid-Term marks first.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearFields() {

        nameField.setText("");
        rollField.setText("");
        subjectField.setText("");
        internalField.setText("");
        midtermField.setText("");
        endSemField.setText("");

        resultArea.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Main app = new Main();
            app.setVisible(true);

        });
    }
}