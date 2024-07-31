import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Game UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout(5, 5));

        // Create the top panel for health bars and labels
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        // Add player and bot labels
        JLabel playerLabel = new JLabel("Player Name: ");
        JLabel botLabel = new JLabel("Bot Name: ");
        topPanel.add(playerLabel);
        topPanel.add(botLabel);

        // Add health bars
        JProgressBar playerHealthBar = new JProgressBar(0, 100);
        playerHealthBar.setValue(75); // Example value for player health
        playerHealthBar.setStringPainted(true);

        JProgressBar botHealthBar = new JProgressBar(0, 100);
        botHealthBar.setValue(60); // Example value for bot health
        botHealthBar.setStringPainted(true);

        topPanel.add(new JLabel("Player Health:"));
        topPanel.add(playerHealthBar);
        topPanel.add(new JLabel("Bot Health:"));
        topPanel.add(botHealthBar);

        // Create the middle panel for item-1b buttons
        JPanel midPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        for (int i = 1; i <= 8; i++) {
            JButton button = new JButton("item-" + i + "b");
            button.setPreferredSize(new Dimension(100, 30)); // Set button size
            button.addActionListener(new ButtonClickListener());
            midPanel.add(button);
        }

        // Create the bottom panel for item-1p buttons
        JPanel bottomPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        for (int i = 1; i <= 8; i++) {
            JButton button = new JButton("item-" + i + "p");
            button.addActionListener(new ButtonClickListener());
            bottomPanel.add(button);
        }

        // Create the panel for gun, player, and bot buttons
        JPanel gunPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        String[] labels = {"gun", "player", "bot"};
        for (String label : labels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            gunPanel.add(button);
        }

        // Add panels to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(gunPanel, BorderLayout.PAGE_END);

        // Display the frame
        frame.setVisible(true);
    }

    // Button click listener class
    static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            JOptionPane.showMessageDialog(button, "Button " + button.getText() + " clicked");
        }
    }
}
