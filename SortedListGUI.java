import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextArea textArea;
    private JTextField inputField;
    private JTextField searchField;

    public SortedListGUI() {
        sortedList = new SortedList();
        setTitle("Sorted List GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add margin
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add margin

        inputField = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = inputField.getText();
                sortedList.add(value);
                updateTextArea();
                inputField.setText("");
            }
        });

        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = searchField.getText();
                String result = sortedList.search(value);
                textArea.append(result + "\n");
                searchField.setText("");
            }
        });

        inputPanel.add(new JLabel("Add String:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(new JLabel("Search String:"));
        inputPanel.add(searchField);
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void updateTextArea() {
        textArea.setText("");
        for (String s : sortedList.getList()) {
            textArea.append(s + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SortedListGUI().setVisible(true);
            }
        });
    }
}