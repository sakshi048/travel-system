import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TravelPackageApp {

    // Create a nested class for package details
    static class PackageDetails {
        String familyPackage;
        String adventurePackage;
        String romanticPackage;
        String luxuryPackage;
        String cruisePackage;
        String pilgrimagePackage;

        public PackageDetails(String familyPackage, String adventurePackage, String romanticPackage,
                              String luxuryPackage, String cruisePackage, String pilgrimagePackage) {
            this.familyPackage = familyPackage;
            this.adventurePackage = adventurePackage;
            this.romanticPackage = romanticPackage;
            this.luxuryPackage = luxuryPackage;
            this.cruisePackage = cruisePackage;
            this.pilgrimagePackage = pilgrimagePackage;
        }
    }

    // Create a map for state packages
    static Map<String, PackageDetails> packageMap = new HashMap<>();

    static {
        // Populate package details for each state
        packageMap.put("Maharashtra", new PackageDetails(
                "Family Package: Taj Mahal Palace (Mumbai): ₹25,000+ per night<br>\n" +
                        "Aamby Valley (Lonavala): ₹9000-₹30,000 per night<br>\n" +
                        "Conrad Hotel (Pune): ₹10,000+ per night<br>\n" +
                        "Le Méridien (Mahabaleshwar): ₹8000+ per night<br>\n" +
                        "Beyond by Sula (Nashik): ₹8000+ per night<br>\n" +
                        "Radisson Blu (Alibaug): ₹7500+ per night<br>\n" +
                        "The Byke Heritage (Matheran): ₹5000+ per night<br>\n" +
                        "Malhar Machi (Mulshi): ₹15,000+ per night<br>\n" +
                        "Waterfront Shaw (Lavasa): ₹7000+ per night<br>\n" +
                        "The Blue Ocean Resort (Ratnagiri): ₹10,000+ per night<br>",
                "Adventure Package: River Rafting (Kolad): ₹1200-₹1500 per person<br>\n" +
                        "Malshej Ghat: Free<br>\n" +
                        "Paragliding (Kamshet): ₹3000-₹5000<br>\n" +
                        "Trekking (Tamhini Ghat): Free<br>\n" +
                        "Camping (Bhandardara): ₹500-₹1500 (depending on facilities)<br>\n" +
                        "Ratangad Fort Trek: Free<br>\n" +
                        "Raigad Fort: ₹30<br>\n" +
                        "Rock Climbing (Harishchandragad): Free (Trekking: ₹1500 for guides)<br>\n" +
                        "Bhivpuri Waterfall Rappelling: ₹1200-₹1500<br>\n" +
                        "Paragliding (Panchgani): ₹3000-₹5000<br>",
                "Romantic Package: Explore the beaches of Ganpatipule and the hill stations of Mahabaleshwar.",
                "Luxury Package: Stay at The Taj Mahal Palace, Mumbai or The Oberoi, Mumbai.",
                "Cruise Package: Enjoy a luxury cruise on the Mandovi River.",
                "Pilgrimage Package: Visit Siddhivinayak Temple, Haji Ali, and Shirdi Sai Baba Temple."
        ));

        packageMap.put("Goa", new PackageDetails(
                "Family Package: Enjoy water sports at Baga Beach and visit the Spice Plantation.",
                "Adventure Package: Scuba diving and trekking in the Western Ghats.",
                "Romantic Package: Sunset cruise on Mandovi River and visit to Palolem Beach.",
                "Luxury Package: Stay at Taj Exotica or W Goa.",
                "Cruise Package: Enjoy a sunset cruise on the Mandovi River.",
                "Pilgrimage Package: Visit Basilica of Bom Jesus and Se Cathedral."
        ));

        packageMap.put("Rajasthan", new PackageDetails(
                "Family Package: Visit forts and palaces in Jaipur, Jodhpur, and Udaipur.",
                "Adventure Package: Camel safari in Jaisalmer and zip-lining at Mehrangarh Fort.",
                "Romantic Package: Hot air balloon ride in Jaipur and boat ride on Lake Pichola.",
                "Luxury Package: Stay at Umaid Bhawan Palace or Rambagh Palace.",
                "Cruise Package: Boat ride on Lake Pichola.",
                "Pilgrimage Package: Visit Ajmer Sharif Dargah and Pushkar Camel Fair."
        ));

        packageMap.put("Uttarakhand", new PackageDetails(
                "Family Package: Visit Nainital Lake, Bhimtal, and Sattal.",
                "Adventure Package: Trekking in the Himalayas and river rafting in Rishikesh.",
                "Romantic Package: Visit Mussoorie for a couple's retreat.",
                "Luxury Package: Stay at JW Marriott, Mussoorie or The Naini Retreat.",
                "Cruise Package: Enjoy a river cruise on the Ganges.",
                "Pilgrimage Package: Visit Haridwar, Rishikesh, and Kedarnath."
        ));
    }

    public static void main(String[] args) {
        // Create the main frame
        JFrame mainFrame = new JFrame("Main Window");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 200);

        // Create a button that opens the travel package window
        JButton openPackageButton = new JButton("Open Travel Package Selector");
        openPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTravelPackageWindow();
            }
        });

        // Add the button to the main frame
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(openPackageButton);

        // Display the main frame
        mainFrame.setVisible(true);
    }

    // Method to open the travel package selection window
    public static void openTravelPackageWindow() {
        JFrame frame = new JFrame("Travel Package Selector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2)); // Adjust the grid for the new button

        JLabel ageLabel = new JLabel("Enter Age:");
        JTextField ageField = new JTextField(10);

        JLabel stateLabel = new JLabel("Select State:");
        String[] states = {"Maharashtra", "Goa", "Rajasthan", "Uttarakhand"};
        JComboBox<String> stateComboBox = new JComboBox<>(states);

        JLabel budgetLabel = new JLabel("Select Budget:");
        String[] budgetOptions = {"A: 5,000 - 10,000", "B: 11,000 - 20,000", "C: 21,000 - 30,000", "D: 31,000-50,000", "E: 50,000>"};
        JComboBox<String> budgetComboBox = new JComboBox<>(budgetOptions);

        JCheckBox discountCheckbox = new JCheckBox("Apply Discount (Student/Senior Citizen)");
        discountCheckbox.setEnabled(false);

        JButton showPackagesButton = new JButton("Show Packages");

        // Handle discount checkbox based on age
        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int age = Integer.parseInt(ageField.getText());
                    if ((age >= 1 && age <= 24) || age >= 60) {
                        discountCheckbox.setSelected(true);
                        discountCheckbox.setEnabled(true);
                    } else {
                        discountCheckbox.setSelected(false);
                        discountCheckbox.setEnabled(false);
                    }
                } catch (NumberFormatException ex) {
                    discountCheckbox.setSelected(false);
                    discountCheckbox.setEnabled(false);
                }
            }
        });

        showPackagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state = (String) stateComboBox.getSelectedItem();
                String budget = (String) budgetComboBox.getSelectedItem();
                boolean hasDiscount = discountCheckbox.isSelected();
                int age = Integer.parseInt(ageField.getText());

                openPackageWindow(age, state, budget, hasDiscount);
            }
        });

        // Add components to the panel
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(stateLabel);
        panel.add(stateComboBox);
        panel.add(budgetLabel);
        panel.add(budgetComboBox);
        panel.add(discountCheckbox);
        panel.add(showPackagesButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Open package window with suggestions based on age, state, and budget
    public static void openPackageWindow(int age, String state, String budget, boolean hasDiscount) {
        JFrame packageFrame = new JFrame("Package Details");
        packageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        packageFrame.setSize(600, 500);

        StringBuilder packageText = new StringBuilder();
        String imagePath = "";
        double discountFactor = hasDiscount ? 0.85 : 1.0;

        PackageDetails details = packageMap.get(state);
        packageText.append("<html><h2>Tour Packages for ").append(state).append("</h2>");

        // Add different package details based on age
        if (age <= 18) {
            packageText.append("<h3>Family Package:</h3>").append(details.familyPackage).append("<br>")
                       .append("<h3>Adventure Package:</h3>").append(details.adventurePackage).append("<br>")
                       .append("<h3>Pilgrimage Package:</h3>").append(details.pilgrimagePackage).append("<br>");
            imagePath = "images/family_adventure_pilgrimage.jpg";
        } else if (age <= 30) {
            packageText.append("<h3>Adventure Package:</h3>").append(details.adventurePackage).append("<br>")
                       .append("<h3>Family Package:</h3>").append(details.familyPackage).append("<br>")
                       .append("<h3>Romantic Package:</h3>").append(details.romanticPackage).append("<br>")
                       .append("<h3>Cruise Package:</h3>").append(details.cruisePackage).append("<br>")
                       .append("<h3>Pilgrimage Package:</h3>").append(details.pilgrimagePackage).append("<br>")
                       .append("<h3>Luxury Package:</h3>").append(details.luxuryPackage).append("<br>");
            imagePath = "images/adventure_family_romantic_cruise.jpg";
        } else if (age >= 60) {
            packageText.append("<h3>Pilgrimage Package:</h3>").append(details.pilgrimagePackage).append("<br>")
                       .append("<h3>Cruise Package:</h3>").append(details.cruisePackage).append("<br>")
                       .append("<h3>Luxury Package:</h3>").append(details.luxuryPackage).append("<br>")
                       .append("<h3>Family Package:</h3>").append(details.familyPackage).append("<br>");
            imagePath = "images/pilgrimage_cruise_luxury.jpg";
        } else if (age >= 40 && age < 60) {
            packageText.append("<h3>Luxury Package:</h3>").append(details.luxuryPackage).append("<br>")
                       .append("<h3>Romantic Package:</h3>").append(details.romanticPackage).append("<br>")
                       .append("<h3>Pilgrimage Package:</h3>").append(details.pilgrimagePackage).append("<br>");
            imagePath = "images/luxury_romantic_pilgrimage.jpg";
        } else {
            packageText.append("<h3>Luxury Package:</h3>").append(details.luxuryPackage).append("<br>")
                       .append("<h3>Romantic Package:</h3>").append(details.romanticPackage).append("<br>");
            imagePath = "images/luxury_romantic.jpg";
        }

        packageText.append("</html>");

        JLabel packageLabel = new JLabel(packageText.toString());
        packageFrame.add(packageLabel, BorderLayout.CENTER);

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon(imagePath);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        packageFrame.add(backgroundLabel, BorderLayout.NORTH);

        packageFrame.setVisible(true);
    }
}