import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApp extends JFrame {
    private JTextField passcodeField;
    private JLabel statusLabel;
    private JButton enterButton, clearButton;
    private String savedPassword = "";

    public LockerApp() {
        setTitle("Lock Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

       
        JPanel centerPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            centerPanel.add(new JButton(String.valueOf(i)));
        }
        add(centerPanel, BorderLayout.NORTH);

       
        JPanel inputPanel = new JPanel(new BorderLayout());
        
       
        passcodeField = new JPasswordField(15);
        passcodeField.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(passcodeField, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));

       
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passcodeField.setText("");
            }
        });
        buttonPanel.add(clearButton);

       
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPasscode = passcodeField.getText();

                if (savedPassword.isEmpty()) {
                   
                    savedPassword = enteredPasscode;
                    statusLabel.setText("Password Set");
                } else {
                    
                    if (enteredPasscode.equals(savedPassword)) {
                        statusLabel.setText("Correct Password");
                    } else {
                        statusLabel.setText("Incorrect Password");
                    }
                }
                passcodeField.setText("");
            }
        });
        buttonPanel.add(enterButton);

        inputPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.CENTER);

       
        statusLabel = new JLabel("Enter Password", JLabel.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

      
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LockerApp();
            }
        });
    }
}
