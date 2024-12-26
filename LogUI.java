import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SVGViewer extends JFrame {

    private boolean buttonClicked = false;
    private Timer timer;
    private float scale = 1.0f; // Scale factor for the button

    public SVGViewer() {
        // Set up the JFrame
        setTitle("SVG Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon("/home/zulqarnain/IdeaProjects/Demo/src/3.png");
        Image backgroundImage = backgroundImageIcon.getImage();

        // Create a panel to hold the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(null); // Use null layout for absolute positioning
        setContentPane(backgroundPanel);

        // Load the BookStore button image
        ImageIcon bookButtonIcon = new ImageIcon("/home/zulqarnain/IdeaProjects/Demo/src/book_button.png");
        Image bookButtonImage = bookButtonIcon.getImage();

        // Create and configure the BookStore button
        JButton bookStoreButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Apply scaling effect
                g2d.scale(scale, scale);
                g2d.drawImage(bookButtonImage, 0, 0, getWidth(), getHeight(), null);
            }
        };
        bookStoreButton.setOpaque(false);
        bookStoreButton.setContentAreaFilled(false);
        bookStoreButton.setBorderPainted(false);

        // Set the position of the BookStore button based on the screenshot coordinates
        bookStoreButton.setBounds(39, 292, bookButtonIcon.getIconWidth(), bookButtonIcon.getIconHeight());

        // Add action listener for the BookStore button
        bookStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClicked = !buttonClicked;

                // Start the scaling animation
                if (buttonClicked) {
                    startScalingAnimation(bookStoreButton, 1.0f, 0.95f); // Scale down
                } else {
                    startScalingAnimation(bookStoreButton, 0.95f, 1.0f); // Scale back to normal
                }
            }
        });

        // Add the BookStore button to the content pane
        backgroundPanel.add(bookStoreButton);

        // Create and configure the Username text field
        JTextField usernameField = new JTextField("Username") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a fully rounded rectangle background
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Fully rounded corners

                // Draw the border
                g2d.setColor(Color.GRAY);
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Fully rounded border

                super.paintComponent(g);
            }
        };
        usernameField.setOpaque(false);
        usernameField.setForeground(Color.GRAY);
        usernameField.setBackground(new Color(255, 255, 255, 128)); // Semi-transparent white background
        usernameField.setBounds(381, 193, 203, 26); // Correct position and size for Username field

        // Add focus listener to remove placeholder text when typing
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setForeground(Color.GRAY);
                    usernameField.setText("Username");
                }
            }
        });

        // Create and configure the Password field (using JPasswordField)
        JPasswordField passwordField = new JPasswordField("Password") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a fully rounded rectangle background
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Fully rounded corners

                // Draw the border
                g2d.setColor(Color.GRAY);
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Fully rounded border

                super.paintComponent(g);
            }
        };
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.GRAY);
        passwordField.setBackground(new Color(255, 255, 255, 128)); // Semi-transparent white background
        passwordField.setBounds(381, 240, 203, 26); // Correct position and size for Password field

        // Add focus listener to handle placeholder text and masking
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*'); // Set the echo character to '*'
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setEchoChar((char) 0); // Disable masking
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Password");
                }
            }
        });

        // Add the text fields to the content pane
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordField);

        // Set the size of the JFrame to match the image dimensions
        setSize(backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
    }

    // Method to start the scaling animation
    private void startScalingAnimation(JButton button, float startScale, float endScale) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(10, new ActionListener() {
            float currentScale = startScale;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentScale < endScale) {
                    currentScale += 0.05f; // Incremental scaling
                } else if (currentScale > endScale) {
                    currentScale -= 0.05f; // Incremental scaling
                }

                if (Math.abs(currentScale - endScale) < 0.01f) {
                    currentScale = endScale;
                    timer.stop();
                }

                scale = currentScale;
                button.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(() -> {
            SVGViewer viewer = new SVGViewer();
            viewer.setVisible(true);
        });
    }
}
