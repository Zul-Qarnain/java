import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class LoginUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLayout(new BorderLayout());
            frame.setResizable(false);

            // Left panel for image
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setPreferredSize(new Dimension(400, 500));
            leftPanel.setBackground(Color.BLACK); // Ensure the background is black for the image

            // Load image from the classpath
            URL imageUrl = LoginUI.class.getResource("/ui/resources/laptop.png");
            if (imageUrl != null) {
                try {
                    BufferedImage image = ImageIO.read(imageUrl);
                    Image scaledImage = image.getScaledInstance(400, 500, Image.SCALE_SMOOTH);
                    JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
                    leftPanel.add(imageLabel, BorderLayout.CENTER);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Image not found");
            }

            // Right panel for login form with rounded corners
            RoundedPanel rightPanel = new RoundedPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
            rightPanel.setBackground(new Color(24, 24, 24));
            rightPanel.setPreferredSize(new Dimension(400, 500));

            // Title
            JLabel titleLabel = new JLabel("Login");
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Email field
            JTextField emailField = new JTextField();
            emailField.setMaximumSize(new Dimension(350, 30));
            emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
            emailField.setBackground(new Color(40, 40, 40));
            emailField.setForeground(Color.WHITE);
            emailField.setCaretColor(Color.WHITE);
            emailField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            emailField.setOpaque(false);

            // Password field
            JPasswordField passwordField = new JPasswordField();
            passwordField.setMaximumSize(new Dimension(350, 30));
            passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
            passwordField.setBackground(new Color(40, 40, 40));
            passwordField.setForeground(Color.WHITE);
            passwordField.setCaretColor(Color.WHITE);
            passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            passwordField.setOpaque(false);

            // Login button with rounded corners
            RoundedButton loginButton = new RoundedButton("Log in");
            loginButton.setBackground(new Color(138, 43, 226));
            loginButton.setForeground(Color.WHITE);
            loginButton.setFocusPainted(false);
            loginButton.setMaximumSize(new Dimension(350, 40));
            loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Social login buttons with rounded corners
            RoundedButton githubButton = new RoundedButton("Github");
            githubButton.setBackground(new Color(40, 40, 40));
            githubButton.setForeground(Color.WHITE);
            githubButton.setFocusPainted(false);
            githubButton.setMaximumSize(new Dimension(350, 40));
            githubButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            RoundedButton twitterButton = new RoundedButton("Twitter");
            twitterButton.setBackground(new Color(40, 40, 40));
            twitterButton.setForeground(Color.WHITE);
            twitterButton.setFocusPainted(false);
            twitterButton.setMaximumSize(new Dimension(350, 40));
            twitterButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Forgot password and create account links
            JLabel forgotPasswordLabel = new JLabel("Forgot your password?");
            forgotPasswordLabel.setForeground(Color.LIGHT_GRAY);
            forgotPasswordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel createAccountLabel = new JLabel("Create account");
            createAccountLabel.setForeground(Color.LIGHT_GRAY);
            createAccountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Add components to the right panel
            rightPanel.add(Box.createRigidArea(new Dimension(0, 50)));
            rightPanel.add(titleLabel);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            rightPanel.add(emailField);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            rightPanel.add(passwordField);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            rightPanel.add(loginButton);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            rightPanel.add(githubButton);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            rightPanel.add(twitterButton);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            rightPanel.add(forgotPasswordLabel);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            rightPanel.add(createAccountLabel);

            // Add panels to the frame
            frame.add(leftPanel, BorderLayout.WEST);
            frame.add(rightPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

// Custom JPanel with rounded corners
class RoundedPanel extends JPanel {
    public RoundedPanel() {
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        g2.dispose();
    }
}

// Custom JButton with rounded corners
class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        super.paintComponent(g2);
        g2.dispose();
    }
}
