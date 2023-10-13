import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpinnerNumberModel;

public class ManualTest {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Manual Test");


        JLabel label1 = new JLabel("  Via Chanel:");
        JLabel label2 = new JLabel("  Time: (1-24) ");
        JLabel label3 = new JLabel("  Amount: (1-50000)");


        String[] items = {"Select", "Counter Service", "Big Branch", "Sub Branch"};
        JComboBox<String> dropdown = new JComboBox<>(items);


        JSpinner timeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
        JSpinner.DefaultEditor timeEditor = (JSpinner.DefaultEditor) timeSpinner.getEditor();
        timeEditor.getTextField().setHorizontalAlignment(JTextField.RIGHT);

        JTextField numberField2 = new JTextField(10);

        JButton submitButton = new JButton("Submit");

        frame.setLayout(new GridLayout(4, 2));

        frame.add(label1);
        frame.add(dropdown);
        frame.add(label2);
        frame.add(timeSpinner);
        frame.add(label3);
        frame.add(numberField2);
        frame.add(new JLabel()); 
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = dropdown.getSelectedItem().toString();
                int selectedTime = (int) timeSpinner.getValue();
                int selectedAmount = Integer.parseInt(numberField2.getText());

                String timeSuffix = (selectedTime < 12) ? "am" : "pm";
                if (selectedTime > 12) {
                    selectedTime -= 12;
                }

                BankingSystem bankingSystem = new BankingSystem();

                String result = bankingSystem.deposit(selectedOption, selectedTime, selectedAmount);
                System.out.println(result);
                
                String timeText = selectedTime + " " + timeSuffix;
                System.out.println(selectedOption);
                System.out.println(timeText);
                System.out.println(selectedAmount + " Baht");
                
                JOptionPane.showMessageDialog(frame, result);

            }
        });

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
