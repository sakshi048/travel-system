import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup {

    public static void main(String[] args) {
        // Create frame for login
        JFrame loginFrame = new JFrame("Login Page");
        loginFrame.setSize(600, 400); // Set size to 600x400
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new BorderLayout());

        // Center the frame on the screen
        loginFrame.setLocationRelativeTo(null); // This centers the window

        // Create left panel with the image icon or dummy image placeholder
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(152, 108, 165)); // Set the purple background color
        JLabel imageLabel = new JLabel(new ImageIcon("icons/")); // Replace "icons/" with your image path
        leftPanel.add(imageLabel);
        loginFrame.add(leftPanel, BorderLayout.WEST);
        leftPanel.setPreferredSize(new Dimension(250, 400));

        // Create right panel for login form
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        loginFrame.add(rightPanel, BorderLayout.CENTER);

        // Username label and text field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 50, 80, 25);
        rightPanel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(120, 50, 160, 25);
        rightPanel.add(userText);
        
        // Email label and text field
        JLabel emailLabel = new JLabel("Email Id:");
        emailLabel.setBounds(30, 100, 100, 25);
        rightPanel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(120, 100, 160, 25);
        rightPanel.add(emailText);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 150, 80, 25);
        rightPanel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 150, 160, 25);
        rightPanel.add(passwordText);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 200, 80, 25);
        rightPanel.add(loginButton);

        // Signup button with action listener to open the signup page
        JButton signupButton = new JButton("Signup");
        signupButton.setBounds(210, 200, 80, 25);
        rightPanel.add(signupButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignupPage(); // Call the method to open the signup page
            }
        });

        // Forgot Password button
        JButton forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.setBounds(120, 250, 170, 25);
        rightPanel.add(forgotPasswordButton);

        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openForgotPasswordPage(loginFrame); // Call the method to open the Forgot Password page
            }
        });

        // Set action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(loginFrame, "First time user then signup");
                } else {
                    // Check the credentials from the database
                    try {
                        // Establish connection to MySQL
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sakshi");

                        // SQL query to check if the user exists
                        String sql = "SELECT * FROM account WHERE username = ? AND email = ? AND password = ?";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, username);
                        statement.setString(2, email);
                        statement.setString(3, password);

                        ResultSet resultSet = statement.executeQuery();

                        if (resultSet.next()) {
                            // User exists, login successful
                            JOptionPane.showMessageDialog(loginFrame, "Login Successful!");

                            // Open dashboard after 20 ms
                            Timer timer = new Timer(20, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    openDashboard();
                                }
                            });
                            timer.setRepeats(false);
                            timer.start();

                            // Close the login frame
                            loginFrame.dispose();
                        } else {
                            // User not found or credentials are incorrect
                            JOptionPane.showMessageDialog(loginFrame, "Invalid username, email, or password.");
                        }

                        // Close the connection
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(loginFrame, "Database error: " + ex.getMessage());
                    }
                }
            }
        });

        // Set frame visibility
        loginFrame.setVisible(true);
    }

    // Method to open the Signup Page
    private static void openSignupPage() {
        // Create a new frame for the signup form
        JFrame signupFrame = new JFrame("Signup Form");
        signupFrame.setSize(450, 350);
        signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.setLayout(null);  // Set the layout to null for absolute positioning

        // Create the labels and text fields
        JLabel labelEmail = new JLabel("Email id:", SwingConstants.CENTER);
        labelEmail.setBounds(50, 20, 100, 25);
        signupFrame.add(labelEmail);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(200, 20, 165, 25);
        signupFrame.add(emailField);

        JLabel labelName = new JLabel("Name:", SwingConstants.CENTER);
        labelName.setBounds(50, 60, 100, 25);
        signupFrame.add(labelName);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(200, 60, 165, 25);
        signupFrame.add(nameField);

        JLabel labelAge = new JLabel("Age:", SwingConstants.CENTER);
        labelAge.setBounds(50, 100, 100, 25);
        signupFrame.add(labelAge);

        JTextField ageField = new JTextField(20);
        ageField.setBounds(200, 100, 165, 25);
        signupFrame.add(ageField);

        JLabel labelGender = new JLabel("Gender:", SwingConstants.CENTER);
        labelGender.setBounds(50, 140, 100, 25);
        signupFrame.add(labelGender);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(200, 140, 70, 25);
        signupFrame.add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(270, 140, 80, 25);
        signupFrame.add(femaleButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel labelUsername = new JLabel("Username:", SwingConstants.CENTER);
        labelUsername.setBounds(50, 180, 100, 25);
        signupFrame.add(labelUsername);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(200, 180, 165, 25);
        signupFrame.add(usernameField);

        JLabel labelPassword = new JLabel("Password:", SwingConstants.CENTER);
        labelPassword.setBounds(50, 220, 100, 25);
        signupFrame.add(labelPassword);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(200, 220, 165, 25);
        signupFrame.add(passwordField);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 260, 120, 25);
        signupFrame.add(submitButton);

        // Create reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(250, 260, 120, 25);
        signupFrame.add(resetButton);

        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture form data
                String email = emailField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = maleButton.isSelected() ? "Male" : "Female";
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Store the data in the MySQL database
                try {
                    // Establish connection to MySQL
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sakshi");

                    // SQL query to insert the data
                    String sql = "INSERT INTO account (email, name, age, gender, username, password) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, email);
                    statement.setString(2, name);
                    statement.setInt(3, age);
                    statement.setString(4, gender);
                    statement.setString(5, username);
                    statement.setString(6, password);

                    int rowsInserted = statement.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(signupFrame, "Signup successful! Please login now.");
                        signupFrame.dispose(); // Close the signup frame
                    }

                    // Close the connection
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(signupFrame, "Database error: " + ex.getMessage());
                }
            }
        });

        // Add action listener for the reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emailField.setText("");
                nameField.setText("");
                ageField.setText("");
                genderGroup.clearSelection();
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Make the signup frame visible
        signupFrame.setVisible(true);
    }

    // Method to open Forgot Password Page
    private static void openForgotPasswordPage(JFrame parentFrame) {
        // Create a new frame for the forgot password form
        JFrame forgotPasswordFrame = new JFrame("Forgot Password");
        forgotPasswordFrame.setSize(400, 250);
        forgotPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        forgotPasswordFrame.setLocationRelativeTo(parentFrame);
        forgotPasswordFrame.setLayout(null);  // Set the layout to null for absolute positioning

        // Create the labels and text fields
        JLabel labelEmail = new JLabel("Enter your email:", SwingConstants.CENTER);
        labelEmail.setBounds(50, 50, 120, 25);
        forgotPasswordFrame.add(labelEmail);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(180, 50, 165, 25);
        forgotPasswordFrame.add(emailField);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(140, 100, 120, 25);
        forgotPasswordFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(forgotPasswordFrame, "Please enter your email.");
                } else {
                    // Here you would normally handle the process of sending a password reset link or instructions
                    JOptionPane.showMessageDialog(forgotPasswordFrame, "Password reset instructions have been sent to " + email);
                    forgotPasswordFrame.dispose(); // Close the frame after submission
                }
            }
        });

        // Make the forgot password frame visible
        forgotPasswordFrame.setVisible(true);
    }

    // Method to open the Dashboard after successful login
    public static void openDashboard() {
        // Create the main frame (dashboard window)
        JFrame mainFrame = new JFrame("Dashboard");
        mainFrame.setSize(1500, 1000); // Resize the window to 1500x1000
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Define the lilac color for labels and buttons
        Color lilac = new Color(200, 162, 200);

        // Create a label at the top that says "Explore the Beauty of India"
        JLabel titleLabel = new JLabel("Explore the Beauty of India", SwingConstants.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(lilac);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Nirmala UI", Font.BOLD, 24)); // Set font size to 24 for the title
        mainFrame.add(titleLabel, BorderLayout.NORTH); // Add the label to the top (north) of the layout

        // Create the left panel for the menu
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(250, 1000)); // Set the width of the left panel
        leftPanel.setBackground(new Color(240, 242, 245)); // Set background color (light gray)
        leftPanel.setLayout(new GridLayout(10, 1, 10, 10)); // 10 rows for buttons with spacing

        // Create buttons for the menu
        JButton discoverButton = new JButton("Profile");
        JButton exploreButton = new JButton("Update Profile");
        JButton tourGuideButton = new JButton("Destinations");
        JButton voucherButton = new JButton("Popular Packages");
        JButton blogButton = new JButton("Booked Packages");
        JButton myCollectionsButton = new JButton("Estimated Amount");
        JButton profileButton = new JButton("Itinerary");
        JButton helpCenterButton = new JButton("Favourites");
        JButton settingsButton = new JButton("Contact Us");

        // Set lilac background and black foreground color for all buttons
        JButton[] buttons = { discoverButton, exploreButton, tourGuideButton, voucherButton, blogButton, myCollectionsButton, profileButton, helpCenterButton, settingsButton };
        for (JButton button : buttons) {
            button.setBackground(lilac);
            button.setForeground(Color.BLACK);
        }

        // Add buttons to the left panel
        for (JButton button : buttons) {
            leftPanel.add(button);
        }

        // Add the left panel to the main frame
        mainFrame.add(leftPanel, BorderLayout.WEST);

        // Add action listeners for each button
        discoverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Profile", lilac);
            }
        });

        exploreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Update Profile", lilac);
            }
        });

        tourGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Destinations", lilac);
            }
        });

        voucherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Popular Packages", lilac);
            }
        });

        blogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Booked Packages", lilac);
            }
        });

        myCollectionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Estimated Amount", lilac);
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Itinerary", lilac);
            }
        });

        helpCenterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Favourites", lilac);
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow("Contact Us", lilac);
            }
        });

        // Make the main frame visible
        mainFrame.setLocationRelativeTo(null); // Center the dashboard on the screen
        mainFrame.setVisible(true);
    }

    // Method to open a new window of size 700x600
    public static void openNewWindow(String title, Color backgroundColor) {
        JFrame newWindow = new JFrame(title);
        newWindow.setSize(700, 600);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocationRelativeTo(null); // Center the new window on the screen
        
        // Add a label to the new window (optional)
        JLabel newLabel = new JLabel(title, SwingConstants.CENTER);
        newLabel.setOpaque(true);
        newLabel.setForeground(Color.BLACK);
        newLabel.setFont(new Font("Nirmala UI", Font.BOLD, 20)); // Set a bold font for the label
        newLabel.setBackground(backgroundColor); // Set the lilac background color
        newWindow.add(newLabel);

        newWindow.setVisible(true);
    }
}