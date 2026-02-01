import java.awt.*;
import java.awt.event.*;

public class ForgotPass {

    // Constructor for Forgot Password window
    ForgotPass() {
        // Create a new frame
        Frame f = new Frame("Forgot Password");
        f.setSize(400, 500);
        f.setLayout(null);

        // Set background color to lilac
        f.setBackground(new Color(200, 162, 200));

        // Create Labels and TextFields
        Label lblusername, lblname, lblque, lblans, lblpass;
        TextField txtusername, txtname, txtque, txtans, txtpass;
        Button btnRetrieve;

        // Username Label
        lblusername = new Label("Username");
        lblusername.setBounds(50, 100, 100, 30);
        f.add(lblusername);

        // Name Label
        lblname = new Label("Name");
        lblname.setBounds(50, 150, 100, 30);
        f.add(lblname);

        // Security Question Label
        lblque = new Label("Security Question");
        lblque.setBounds(50, 200, 120, 30);
        f.add(lblque);

        // Answer Label
        lblans = new Label("Answer");
        lblans.setBounds(50, 250, 100, 30);
        f.add(lblans);

        // Password Label
        lblpass = new Label("Password");
        lblpass.setBounds(50, 300, 100, 30);
        f.add(lblpass);

        // Create TextFields
        txtusername = new TextField();
        txtusername.setBounds(200, 100, 150, 30);
        f.add(txtusername);

        txtname = new TextField();
        txtname.setBounds(200, 150, 150, 30);
        f.add(txtname);

        txtque = new TextField();
        txtque.setBounds(200, 200, 150, 30);
        f.add(txtque);

        txtans = new TextField();
        txtans.setBounds(200, 250, 150, 30);
        f.add(txtans);

        txtpass = new TextField();
        txtpass.setBounds(200, 300, 150, 30);
        f.add(txtpass);

        // Retrieve Button
        btnRetrieve = new Button("Retrieve");
        btnRetrieve.setBounds(150, 350, 70, 30);
        f.add(btnRetrieve);

        // Action listener for the Retrieve button
        btnRetrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // Close the Forgot Password window
                new LoadingPage(); // Open the loading screen
            }
        });

        // Add functionality to close the window
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Set the frame visible
        f.setVisible(true);
    }

    // Inner class for the Loading Page
    class LoadingPage {
        Frame loadingFrame;
        Label lblTitle, lblLoading;
        ProgressBar progressBar;

        // Constructor for the Loading Page window
        LoadingPage() {
            loadingFrame = new Frame("Loading...");
            loadingFrame.setSize(500, 300);
            loadingFrame.setLayout(null);

            // Title Label
            lblTitle = new Label("TRAVEL AND TOURISM APPLICATION", Label.CENTER);
            lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
            lblTitle.setBounds(50, 50, 400, 30);
            loadingFrame.add(lblTitle);

            // Loading Text
            lblLoading = new Label("Loading please...", Label.CENTER);
            lblLoading.setForeground(Color.RED);
            lblLoading.setBounds(200, 180, 100, 20);
            loadingFrame.add(lblLoading);

            // Create a progress bar
            progressBar = new ProgressBar();
            progressBar.setBounds(150, 130, 200, 20);
            loadingFrame.add(progressBar);

            // Add functionality to close the window
            loadingFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });

            // Set the frame visible
            loadingFrame.setVisible(true);

            // Simulate loading
            new Thread(() -> {
                try {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setValue(i); // Update the progress bar
                        Thread.sleep(50); // Simulate loading time
                    }
                    loadingFrame.dispose(); // Close loading window when complete
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
    }

    // Inner class for the Progress Bar
    class ProgressBar extends Canvas {
        private int value = 0;

        public void setValue(int value) {
            this.value = value;
            repaint(); // Redraw the canvas with the updated value
        }

        public void paint(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight()); // Background of progress bar
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, (int) (getWidth() * (value / 100.0)), getHeight()); // Progress fill
            g.setColor(Color.BLACK);
            g.drawString(value + "%", getWidth() / 2 - 10, getHeight() / 2 + 5); // Percentage text
        }
    }

    // Main method to run the program
    public static void main(String args[]) {
        new ForgotPass();
    }
}

