package travel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class PopularPlacesMaharashtra {

    public static void main(String[] args) {
        // Create the frame for exploring Maharashtra
        JFrame frame = new JFrame("Explore Maharashtra");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Create a panel for the content
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(Color.LIGHT_GRAY);

        // Create a title label at the top
        JLabel titleLabel = new JLabel("Exploring Maharashtra");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title
        panel.add(titleLabel, gbc);

        // Specify the image path (use the correct absolute path here)
        String imagePath = "src/icons/Maharashtra.jpg";  // Replace with your correct image path

        // Check if the file exists
        File imgFile = new File(imagePath);
        if (!imgFile.exists()) {
            System.out.println("Image file not found at the specified path: " + imagePath);
            return;  // Exit if the image doesn't exist
        }

        // Load and resize the image
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(245, 270, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);

        // Create the image label and add it to the left side
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset gridwidth for the image and text
        gbc.insets = new Insets(20, 5, 20, 10); // Adjust insets to align
        panel.add(imageLabel, gbc);

        // Create the text label and add it to the right side
        JLabel textLabel = new JLabel("<html>Maharashtra - A living canvas of history, culture, nature, and the boundless energy of its people.</html>");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 10, 20, 20); // Padding remains the same for the text
        panel.add(textLabel, gbc);

        // Create a button at the bottom
        JButton viewMoreButton = new JButton("View More");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span the button across both columns
        gbc.insets = new Insets(20, 0, 20, 0); // Padding around the button
        panel.add(viewMoreButton, gbc);

        // Add an ActionListener to the button to open the gallery window
        viewMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGalleryWindow(); // This will open the second part of the code (Popular Places)
            }
        });

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to open the gallery window with popular places
    private static void openGalleryWindow() {
        JFrame galleryFrame = new JFrame("Popular places of Maharashtra");
        galleryFrame.setSize(900, 800); // Increase the frame size to accommodate more images
        galleryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        galleryFrame.setLayout(new BorderLayout());

        // Center the frame on the screen
        galleryFrame.setLocationRelativeTo(null);

        // Create a panel for the content (use GridBagLayout)
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(Color.LIGHT_GRAY);

        // Create a scroll pane for the panel with vertical scrolling
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(900, 800));

        // Title label at the top
        JLabel titleLabel = new JLabel("Popular places of Maharashtra");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Span across three columns
        gbc.insets = new Insets(20, 0, 20, 0); // Padding
        panel.add(titleLabel, gbc);

        // Define the image paths and labels for popular places
        String[] imagePaths = {
            "src/icons/Maharashtra.jpg",     // Replace with actual paths
            "src/icons/Mahabaleshwarr.jpg",
            "src/icons/Kolhapur (1).jpg",
            "src/icons/Ratnagiri.jpg",
            "src/icons/Nashik.jpg",
            "src/icons/Lonavla.jpg"
        };

        String[] labels = {"Mumbai", "Mahabaleshwar", "Kolhapur", "Ratnagiri", "Nashik", "Lonavla"};

        // Add the first row of three images horizontally
        for (int i = 0; i < 3; i++) {
            addImageWithLabel(panel, gbc, i, 1, imagePaths[i], labels[i]);
        }

        // Add the second row of three images horizontally
        for (int i = 3; i < 6; i++) {
            addImageWithLabel(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);
        }

        // Add the scroll pane to the gallery frame
        galleryFrame.add(scrollPane);

        // Make the gallery frame visible
        galleryFrame.setVisible(true);
    }

    // Method to add images and labels to the gallery panel
    private static void addImageWithLabel(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {
        // Adjusting constraints for the text label (above the image)
        gbc.gridx = gridx; // Horizontal position
        gbc.gridy = gridy; // Vertical position
        gbc.gridwidth = 1; // Single column width for each image/label
        gbc.insets = new Insets(10, 20, 10, 20); // Margins around the label
        gbc.anchor = GridBagConstraints.CENTER; // Center the label horizontally
        JLabel textLabel = new JLabel(labelText, SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(textLabel, gbc);

        // Load and resize the image
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(230, 210, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);

        // Adjusting constraints for the image (below the label)
        gbc.gridy = gridy + 1; // Position the image below the label
        gbc.insets = new Insets(0, 20, 30, 20); // Margins around the image
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, gbc);

        // Add click listener to each image to open a detailed window
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openNewInterface(labelText);
            }
        });
    }

    // Method to open a new interface on image click
    private static void openNewInterface(String placeName) {
        // Create a new frame for each image
        JFrame newFrame = new JFrame("More about " + placeName);
        newFrame.setSize(400, 400);
        newFrame.setLayout(new BorderLayout());

        // Center the frame on the screen
        newFrame.setLocationRelativeTo(null);

        // Create a panel for the content
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);

        // Create a panel for the most visited places
        JPanel mostVisitedPanel = new JPanel();
        mostVisitedPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Center in the middle
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Padding around the components

        // Add the most visited places information
        JLabel mostVisitedLabel = new JLabel("Most Visited Places in " + placeName);
        mostVisitedLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mostVisitedPanel.add(mostVisitedLabel, gbc);

        // Add sample information about the selected place
        JTextArea infoArea = new JTextArea("Information about " + placeName + "...\n\n" +
                                            "Popular attractions, local cuisines, and cultural insights.");
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        infoArea.setBackground(Color.LIGHT_GRAY);
        infoArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add a button to see packages
        JButton seePackagesButton = new JButton("See Packages");
        seePackagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBookingWindow(placeName); // Open the booking window
            }
        });

        // Add the components to the main panel
        panel.add(mostVisitedPanel);
        panel.add(infoArea);
        panel.add(seePackagesButton);

        // Add the main panel to the frame
        newFrame.add(panel);
        newFrame.setVisible(true);
    }

    // Method to open the booking window
    private static void openBookingWindow(String placeName) {
        JFrame bookingFrame = new JFrame("Book Packages for " + placeName);
        bookingFrame.setSize(400, 300);
        bookingFrame.setLayout(new GridBagLayout());
        bookingFrame.setLocationRelativeTo(null); // Center on screen

        GridBagConstraints gbc = new GridBagConstraints();

        // Create a heading label
        JLabel headingLabel = new JLabel("Book Packages");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0); // Padding
        bookingFrame.add(headingLabel, gbc);

        // Create a label for price range
        JLabel priceLabel = new JLabel("Price Range: ₹5000 - ₹20000");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        bookingFrame.add(priceLabel, gbc);

        // Create a label for number of people
        JLabel numberOfPeopleLabel = new JLabel("Number of People:");
        numberOfPeopleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 2;
        bookingFrame.add(numberOfPeopleLabel, gbc);

        // Create a JComboBox for selecting number of people
        String[] peopleOptions = {"1", "2", "3", "4", "5+"};
        JComboBox<String> peopleComboBox = new JComboBox<>(peopleOptions);
        gbc.gridx = 1;
        bookingFrame.add(peopleComboBox, gbc);

        // Create a button to confirm booking
        JButton confirmBookingButton = new JButton("Confirm Booking");
        gbc.gridwidth = 2; // Span across columns
        gbc.gridy = 3;
        gbc.insets = new Insets(30, 0, 20, 0); // Padding
        bookingFrame.add(confirmBookingButton, gbc);

        // Add action listener for the confirm button (dummy action)
        confirmBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(bookingFrame, "Booking confirmed for " + peopleComboBox.getSelectedItem() + " people!");
                bookingFrame.dispose(); // Close booking window after confirmation
            }
        });

        // Make the booking frame visible
        bookingFrame.setVisible(true);
    }
}
