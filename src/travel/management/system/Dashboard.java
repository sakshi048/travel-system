package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


public class Dashboard {
    public static Connection connection;

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Dashboard");
        mainFrame.setSize(1500, 1000);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        Color lilac = new Color(200, 162, 200);

        JLabel titleLabel = new JLabel("Explore the Beauty of India", SwingConstants.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(lilac);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Nirmala UI", Font.BOLD, 24));
        mainFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 1000));
        leftPanel.setBackground(new Color(240, 242, 245));
        leftPanel.setLayout(new GridLayout(8, 1, 10, 10));

        JButton discoverButton = new JButton("Profile");
        JButton exploreButton = new JButton("Update Profile");
        JButton tourGuideButton = new JButton("Destinations");
        JButton voucherButton = new JButton("Popular Packages");
        JButton myCollectionsButton = new JButton("Estimated Amount");
        JButton profileButton = new JButton("Itinerary");
        JButton settingsButton = new JButton("Contact Us");
        JButton showPackagesButton = new JButton("View Packages");

        JButton[] buttons = {discoverButton, exploreButton, tourGuideButton, voucherButton,
                myCollectionsButton, profileButton, settingsButton, showPackagesButton};

        for (JButton button : buttons) {
            button.setBackground(lilac);
            button.setForeground(Color.BLACK);
            leftPanel.add(button);
        }
        mainFrame.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(1200, 1000));
        rightPanel.setLayout(null);

        try {
            ImageIcon icon = new ImageIcon("C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\d3.jpg");
            Image img = icon.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
            JLabel imageLabel = new JLabel(new ImageIcon(img));
            imageLabel.setBounds(0, 0, 1200, 1000);
            rightPanel.add(imageLabel);
        } catch (Exception e) {
            System.err.println("Image not found: " + e.getMessage());
        }

        mainFrame.add(rightPanel, BorderLayout.CENTER);

        ActionListener buttonListener = e -> {
            JButton source = (JButton) e.getSource();
            if (source == discoverButton) {
                new ProfileWindow().setVisible(true);
            } else if (source == exploreButton) {
                new UserProfileUpdate().setVisible(true);
            } else if (source == tourGuideButton) {
                openDestinationsWindow();
            } else if (source == voucherButton) {
                Favorites.openFavoritesWindow();
            } else if (source == myCollectionsButton) {
                new EstimatedAmount().setVisible(true);
            } else if (source == profileButton) {
                new Itinerary();
            } else if (source == settingsButton) {
                new Contactus().setVisible(true);
            } else if (source == showPackagesButton) {
                new TravelPackageApp().setVisible(trueSS);
            }
        };

        for (JButton button : buttons) {
            button.addActionListener(buttonListener);
        }

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "sakshi");
    }



public static class TravelPackageApp extends JFrame {
    

    private String familyPackage;
    private String familyPackageDetails;
    private String adventurePackage;
    private String adventurePackageDetails;
    private String romanticPackage;
    private String romanticPackageDetails;
    private String luxuryPackage;
    private String luxuryPackageDetails;
    private String cruisePackage;
    private String cruisePackageDetails;
    private String pilgrimagePackage;
    private String pilgrimagePackageDetails;

    public TravelPackageApp(String familyPackage, String familyPackageDetails, String adventurePackage, 
                            String adventurePackageDetails, String romanticPackage, 
                            String romanticPackageDetails, String luxuryPackage, 
                            String luxuryPackageDetails, String cruisePackage, 
                            String cruisePackageDetails, String pilgrimagePackage, 
                            String pilgrimagePackageDetails) {
        this.familyPackage = familyPackage;
        this.familyPackageDetails = familyPackageDetails;
        this.adventurePackage = adventurePackage;
        this.adventurePackageDetails = adventurePackageDetails;
        this.romanticPackage = romanticPackage;
        this.romanticPackageDetails = romanticPackageDetails;
        this.luxuryPackage = luxuryPackage;
        this.luxuryPackageDetails = luxuryPackageDetails;
        this.cruisePackage = cruisePackage;
        this.cruisePackageDetails = cruisePackageDetails;
        this.pilgrimagePackage = pilgrimagePackage;
        this.pilgrimagePackageDetails = pilgrimagePackageDetails;
    }
}


    static Map<String, TravelPackageApp> packageMap = new HashMap<>();
    static {
        packageMap.put("Maharashtra", new TravelPackageApp(
                "Family Package: Taj Mahal Palace (Mumbai): ₹25,000+ per night",
                 "Aamby Valley (Lonavala): ₹9000-₹30,000 per night<br>\n" +
                        "Conrad Hotel (Pune): ₹10,000+ per night<br>\n" +
                        "Le Méridien (Mahabaleshwar): ₹8000+ per night<br>\n" +
                        "Beyond by Sula (Nashik): ₹8000+ per night<br>\n" +
                        "Radisson Blu (Alibaug): ₹7500+ per night<br>\n" +
                        "The Byke Heritage (Matheran): ₹5000+ per night<br>\n" +
                        "Malhar Machi (Mulshi): ₹15,000+ per night<br>\n" +
                        "Waterfront Shaw (Lavasa): ₹7000+ per night<br>\n" +
                        "The Blue Ocean Resort (Ratnagiri): ₹10,000+ per night<br>",

                "Adventure Package: Trekking, Paragliding, Water Sports: ₹3000-₹8000",
                "Malshej Ghat: Free<br>\n" +
                        "Paragliding (Kamshet): ₹3000-₹5000<br>\n" +
                        "Trekking (Tamhini Ghat): Free<br>\n" +
                        "Camping (Bhandardara): ₹500-₹1500 (depending on facilities)<br>\n" +
                        "Ratangad Fort Trek: Free<br>\n" +
                        "Raigad Fort: ₹30<br>\n" +
                        "Rock Climbing (Harishchandragad): Free (Trekking: ₹1500 for guides)<br>\n" +
                        "Bhivpuri Waterfall Rappelling: ₹1200-₹1500<br>\n" +
                        "Paragliding (Panchgani): ₹3000-₹5000<br>",

                "Romantic Package: Spa Packages: ₹15,000-₹30,000","Marine Drive (Mumbai): Free<br>\n"+
"Rajmachi Point (Khandala): Free<br>\n"+
"Elephanta Caves (Mumbai): ₹40 (Indian), ₹600 (Foreign)<br>\n"+
"Mulshi Dam (Pune): Free<br>\n"+
"Ambazari Lake (Nagpur): Free (Boating: ₹200)<br>\n"+
"Matheran Hill Station: Entry ₹50<br>\n"+
"Lavasa City: Free (Boating: ₹500-₹1000)<br>\n"+
"Alibaug Beach: Free<br>\n"+
"Sinhagad Fort (Pune): ₹20<br> ",

                "Luxury Package: Private villas: ₹30,000+", "Aamby Valley (Lonavala): ₹9000-₹30,000 per night<br>\n" + 
                                        "Conrad Hotel (Pune): ₹10,000+ per night<br>\n" + 
                                        "Le Méridien (Mahabaleshwar): ₹8000+ per night<br>\n" + 
                                        "Beyond by Sula (Nashik): ₹8000+ per night<br>\n" + 
                                        "Radisson Blu (Alibaug): ₹7500+ per night<br>\n" + 
                                        "The Byke Heritage (Matheran): ₹5000+ per night<br>\n" + 
                                        "Malhar Machi (Mulshi): ₹15,000+ per night<br>\n" + 
                                        "Waterfront Shaw (Lavasa): ₹7000+ per night<br>\n" + 
                                        "The Blue Ocean Resort (Ratnagiri): ₹10,000+ per night<br>",

                "Cruise Package: Goa to Mumbai Cruise: ₹20,000+","Alibaug Ferry to Mandwa: ₹135 (Regular Ferry), ₹1000 (Speed Boat)<br>\n" + //
                                        "Houseboat (Tarkarli): ₹6000+ per night<br>\n" + 
                                        "Coastal Cruises (Ganpatipule): ₹3000-₹5000<br>\n" + 
                                        "Karnala Riverboat Tour: ₹200-₹500<br>\n" + 
                                        "Jaigad Creek Houseboat (Ratnagiri): ₹8000+ per night<br>\n" + 
                                        "Dolphin Cruise (Dapoli): ₹300-₹500<br>\n" + 
                                        "Ferry to Elephanta Caves: ₹200-₹250<br>\n" + 
                                        "Private Yacht (Mandwa Beach): ₹10,000+ for half-day<br>\n" + 
                                        "Speed Boat Ride (Kihim Beach): ₹1000-₹2000<br>",

                "Pilgrimage Package: Shirdi Temple: ₹1000+ per person", 
                "Vithoba Temple (Pandharpur): Free<br>\n" + 
                                        "Trimbakeshwar Temple (Nashik): Free<br>\n" + 
                                        "Khandoba Temple (Jejuri): Free<br>\n" + 
                                        "Ganpatipule Temple (Ganpatipule): Free<br>\n" + 
                                        "Shani Shingnapur (Ahmednagar): Free<br>\n" + 
                                        "Grishneshwar Temple (Ellora): Free<br>\n" + 
                                        "Tulja Bhavani Temple (Tuljapur): Free<br>\n" + 
                                        "Dagdusheth Halwai Temple (Pune): Free<br>\n" + 
                                        "Rameshwar Temple (Nasik): Free<br>"
        ));

        

        packageMap.put("Goa", new TravelPackageApp(
                "Family Package: Baga Beach: Free",
                 "Dudhsagar Waterfalls: ₹300 (jeep ride)<br>\n" + 
                                        "Fort Aguada: ₹25<br>\n" + 
                                        "Anjuna Flea Market: Free<br>\n" + 
                                        "Basilica of Bom Jesus: Free<br>\n" + 
                                        "Chapora Fort: Free<br>\n" + 
                                        "Vagator Beach: Free<br>\n" + 
                                        "Mandrem Beach: Free<br>\n" + 
                                        "Cabo de Rama Fort: Free<br>\n" + 
                                        "Casino Royale: ₹1500+ entry fee<br>",

                "Adventure Package: Scuba Diving: ₹4000-₹8000",
                "Water Sports (Calangute Beach): ₹1000-₹3000<br>\n" + 
                                        "Parasailing (Candolim Beach): ₹1500-₹2500<br>\n" + 
                                        "Trekking (Netravali Wildlife Sanctuary): Free<br>\n" + 
                                        "Zip-lining (Big Foot): ₹500-₹800<br>\n" + 
                                        "Kitesurfing (Morjim Beach): ₹2000-₹4000<br>\n" + 
                                        "Kayaking (Palolem Beach): ₹500-₹800<br>\n" + 
                                        "Bungee Jumping (Anjuna): ₹3000-₹5000<br>\n" + 
                                        "Cycling (Divar Island): ₹500-₹1000<br>\n" + 
                                        "Dolphin Spotting Tours: ₹800-₹1500<br>  ",
                "Romantic Package: Beach Resorts: ₹10,000+",
                "Cabo de Rama Fort: Free<br>\n" + 
                                        "Dudhsagar Waterfalls: ₹300 (jeep ride)<br>\n" + 
                                        "Chapora Fort: Free<br>\n" + 
                                        "Butterfly Beach: Free<br>\n" + 
                                        "Houseboat on Chapora River: ₹6000+ per night<br>\n" + 
                                        "Mandovi River Cruise: ₹500-₹800<br>\n" + 
                                        "Private Yacht (Dona Paula): ₹10,000+ for half-day<br>\n" + 
                                        "Vagator Beach: Free<br>\n" + 
                                        "Divar Island Cycling Tour: ₹500-₹1000<br>",
                "Luxury Package: Taj Exotica: ₹25,000+",
        "Taj Exotica Resort & Spa: ₹12,000+ per night<br>\n" + 
                                        "W Goa: ₹10,000+ per night<br>\n" + 
                                        "ITC Grand Goa: ₹10,000+ per night<br>\n" + 
                                        "Alila Diwa Goa: ₹10,000+ per night<br>\n" + 
                                        "The St. Regis Goa Resort: ₹14,000+ per night<br>\n" + 
                                        "Radisson Blu Resort: ₹8000+ per night<br>\n" + 
                                        "Grand Hyatt Goa: ₹9000+ per night<br>\n" + 
                                        "Caravela Beach Resort: ₹7500+ per night<br>\n" + 
                                        "Taj Fort Aguada Resort: ₹8000+ per night<br>  ",

                "Cruise Package: River Cruise: ₹2000+ per person", 
                "Goa Dinner Cruise: ₹1000-₹2000<br>\n" + 
                                        "Luxury Yacht (Dona Paula): ₹10,000+ for half-day<br>\n" + 
                                        "Casino Cruise: ₹2000-₹3000<br>\n" + 
                                        "Backwater Cruise (Divar Island): ₹800-₹1200<br>\n" + 
                                        "Sunset River Cruise: ₹600-₹1000<br>\n" + 
                                        "Dolphin Cruise (Coco Beach): ₹700-₹1200<br>\n" + 
                                        "Private Boat Charter: ₹15,000+ per day<br>\n" + 
                                        "Houseboat on Chapora River: ₹6000+ per night<br>\n" + 
                                        "Catamaran Sailing: ₹2000-₹4000<br>",

                "Pilgrimage Package: Basilica of Bom Jesus: Free",
                 "Basilica of Bom Jesus: Free<br>\n" + 
                                        "Se Cathedral: Free<br>\n" + 
                                        "Shri Shantadurga Temple: Free<br>\n" + 
                                        "St. Augustine Tower: Free<br>\n" + 
                                        "Nerul River Church: Free<br>\n" + 
                                        "Church of St. Cajetan: Free<br>\n" + 
                                        "Safa Shahouri Mosque: Free<br>\n" + 
                                        "Our Lady of the Immaculate Conception Church: Free<br>\n" + 
                                        "St. Alex Church: Free<br>\n"
        ));
        packageMap.put("Uttarakhand", new TravelPackageApp(
                "Family Package: Mussoorie: Free",
                 "Kempty Falls: Free<br>\n" + 
                                        "Gun Hill: ₹100 (ropeway ride)<br>\n" + 
                                        "Camel's Back Road: Free<br>\n" + 
                                        "Mall Road: Free<br>\n" + 
                                        "Company Garden: ₹25<br>\n" + 
                                        "George Everest House: Free<br>\n" + 
                                        "Lal Tibba: ₹50<br>\n" + 
                                        "Soham Heritage Centre: ₹100<br>",
                                        
                "Adventure Package: Bungee Jumping: ₹3000-₹4500", 
                "River Rafting (Rishikesh): ₹1000-₹3000<br>\n" + 
                                        "Trekking (Valley of Flowers): Free<br>\n" + 
                                        "Paragliding (Nainital): ₹2000-₹4000<br>\n" + 
                                        "Camping (Chopta): ₹500-₹2000<br>\n" + 
                                        "Zip-lining (Shivpuri): ₹500-₹1500<br>\n" + 
                                        "Skiing (Auli): ₹5000-₹8000<br>\n" + 
                                        "Mountain Biking (Rishikesh): ₹1000-₹2000<br>",
                                        
                "Romantic Package: Lake Resorts: ₹8000+", "Nainital Lake: Free<br>\n" + 
                                        "Boating on Naini Lake: ₹500-₹1000<br>\n" + 
                                        "Snow View Point: ₹200 (cable car ride)<br>\n" + 
                                        "Tiffin Top: Free<br>\n" + 
                                        "Jim Corbett Safari: ₹2000-₹5000<br>\n" + 
                                        "Kausani: Free<br>\n" + 
                                        "Ranikhet: Free<br>\n" + 
                                        "Chopta: Free<br>\n",
                                        
                "Luxury Package: The Roseate Ganges: ₹20,000+", 
                "Ananda in the Himalayas: ₹25,000+ per night<br>\n" + 
                                        "The Roseate Ganges: ₹20,000+ per night<br>\n" + 
                                        "Taj Rishikesh Resort & Spa: ₹18,000+ per night<br>\n" + 
                                        "Le Meridien Jim Corbett: ₹15,000+ per night<br>\n" + 
                                        "Welcomhotel The Savoy: ₹12,000+ per night<br>\n" + 
                                        "Aahana The Corbett Wilderness: ₹10,000+ per night<br>",

                "Cruise Package: River Rafting: ₹1000+", 
                "Luxury Houseboats (Nainital): ₹5000+ per night<br>\n" + 
                                        "Boating on Bhimtal Lake: ₹500-₹1000<br>\n" + 
                                        "Luxury Rafting Cruise (Rishikesh): ₹2000+<br>",
                                        
                "Pilgrimage Package: Char Dham Yatra: Free", "Kedarnath Temple: Free<br>\n" + 
                                        "Badrinath Temple: Free<br>\n" + 
                                        "Gangotri Temple: Free<br>\n" + 
                                        "Yamunotri Temple: Free<br>\n" + 
                                        "Haridwar Ganga Aarti: Free<br>\n" + 
                                        "Rishikesh Triveni Ghat: Free<br>"
));
packageMap.put("Rajasthan", new TravelPackageApp(
                "Family Package: Jaipur: Free",
                 "Hawa Mahal: ₹50<br>\n" + 
                                        "City Palace: ₹200<br>\n" + 
                                        "Amer Fort: ₹100<br>\n" + 
                                        "Jantar Mantar: ₹50<br>\n" + 
                                        "Albert Hall Museum: ₹40<br>\n" + 
                                        "Jal Mahal: Free<br>",
                                        
                "Adventure Package: Camel Safari: ₹1000-₹3000", 
        "Hot Air Balloon Ride (Jaipur): ₹10,000+<br>\n" + 
                                        "Zip-lining (Mehrangarh Fort): ₹1500-₹2000<br>\n" + 
                                        "Sand Dune Bashing (Jaisalmer): ₹2000-₹5000<br>\n" + 
                                        "Camping (Thar Desert): ₹2000-₹5000<br>\n" + 
                                        "Quad Biking (Jaisalmer): ₹1000-₹2000<br>\n" + 
                                        "Horse Riding (Pushkar): ₹1000-₹3000<br>",
                                        
                "Romantic Package: Heritage Resorts: ₹10,000+", 
        "Lake Pichola Boat Ride: ₹500-₹1000<br>\n" + 
                                        "Udaipur City Palace: ₹300<br>\n" + 
                                        "Monsoon Palace: ₹50<br>\n" + 
                                        "Fateh Sagar Lake: Free<br>\n" + 
                                        "Jag Mandir: ₹500+<br>\n" + 
                                        "Kumbhalgarh Fort: ₹50<br>\n" + 
                                        "Sajjangarh Palace: ₹100<br>\n",
                                        
                "Luxury Package: Oberoi Udaivilas: ₹30,000+", 
        "Taj Lake Palace: ₹25,000+ per night<br>\n" + //
                                        "The Leela Palace: ₹20,000+ per night<br>\n" + 
                                        "Rambagh Palace: ₹18,000+ per night<br>\n" + 
                                        "Samode Palace: ₹15,000+ per night<br>",

                "Cruise Package: Lake Pichola Boat Ride: ₹500+", 
        "Luxury Houseboats (Udaipur): ₹5000+ per night<br>\n" + 
                                        "Lake Pichola Sunset Cruise: ₹500-₹1000<br>\n" + 
                                        "Luxury Yacht (Pushkar Lake): ₹15,000+ per day<br>",
                                        
                "Pilgrimage Package: Pushkar Lake: Free", "Pushkar Brahma Temple: Free<br>\n" + 
                                        "Ajmer Sharif Dargah: Free<br>\n" + 
                                        "Karni Mata Temple: Free<br>\n" + 
                                        "Dilwara Temples (Mount Abu): Free<br>\n" + 
                                        "Eklingji Temple: Free<br>\n" + 
                                        "Shri Govind Dev Ji Temple: Free<br>"
));
    }

 


   private void setupUI() {
        JFrame frame = new JFrame("Travel Package Selector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);

        JPanel panel = new BackgroundPanel("download.jpg");
        panel.setLayout(new GridLayout(6, 1));

        JTextField ageField = new JTextField(10);
        JComboBox<String> stateComboBox = new JComboBox<>(new String[]{"Maharashtra", "Goa", "Uttarakhand", "Rajasthan"});
        JCheckBox discountCheckbox = new JCheckBox("Apply Discount (Student/Senior Citizen)");

        JButton showPackagesButton = new JButton("Show Packages");
        showPackagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int age = Integer.parseInt(ageField.getText());
                    String state = (String) stateComboBox.getSelectedItem();
                    boolean hasDiscount = discountCheckbox.isSelected();
                    openPackageWindow(age, state, hasDiscount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid age.");
                }
            }
        });

        panel.add(new JLabel("Enter Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Select State:"));
        panel.add(stateComboBox);
        panel.add(discountCheckbox);
        panel.add(showPackagesButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Method to display the package details based on selected state.
    public static void openPackageWindow(int age, String state, boolean hasDiscount) {
        JFrame packageFrame = new JFrame("Package Details");
        packageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        packageFrame.setSize(600, 500);

        TravelPackageApp details = packageMap.getOrDefault(state, new TravelPackageApp());

        StringBuilder packageText = new StringBuilder("<html><h2>Tour Packages for " + state + "</h2>");
        packageText.append(details.familyPackage).append("<br>")
                   .append(details.adventurePackage).append("<br>")
                   .append(details.romanticPackage).append("<br>")
                   .append(details.luxuryPackage).append("<br>")
                   .append(details.cruisePackage).append("<br>")
                   .append(details.pilgrimagePackage).append("<br>");

        // Thank you message
        packageText.append("<br><h3>Thank you for considering our packages!</h3></html>");

        JLabel packageLabel = new JLabel(packageText.toString(), SwingConstants.CENTER);
        packageFrame.add(new JScrollPane(packageLabel));
        packageFrame.setVisible(true);
    }

    // Custom JPanel to handle background images.
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String fileName) {
            backgroundImage = new ImageIcon(fileName).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
        public static TravelPackageApp getPackagesByState(String state) {
        return packageMap.get(state);
    }




  static class Itinerary extends JFrame {

    private static HashMap<String, String> itineraries;

    public Itinerary() {
        // Set up the frame
        JFrame frame = new JFrame("Travel Itinerary Planner");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.setSize(600, 449);  // Adjusted frame size for better content display

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\img.jpg");
  // Replace with the correct path
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null); 
        frame.setContentPane(backgroundLabel); 

        // Define itineraries for each state
        // Define itineraries for each state
        itineraries = new HashMap<>();
        itineraries.put("Andhra Pradesh", "Cost: ₹15,000–₹25,000\nHighlights: Tirupati, Araku Valley, Belum Caves\nRoute: Tirupati -> Araku Valley -> Belum Caves");
        itineraries.put("Arunachal Pradesh", "Cost: ₹25,000–₹35,000\nHighlights: Tawang, Sela Pass, Namdapha National Park\nRoute: Tawang -> Sela Pass -> Namdapha National Park");
        itineraries.put("Assam", "Cost: ₹18,000–₹28,000\nHighlights: Kaziranga, Majuli, Kamakhya Temple\nRoute: Kaziranga -> Majuli -> Kamakhya Temple");
        itineraries.put("Bihar", "Cost: ₹12,000–₹22,000\nHighlights: Bodh Gaya, Nalanda, Vaishali\nSuggested Route: Bodh Gaya -> Nalanda -> Vaishali");
        itineraries.put("Chhattisgarh", "Cost: ₹15,000–₹25,000\nHighlights: Chitrakote Falls, Kanger Valley, Barnawapar\nSuggested Route: Chitrakote -> Kanger -> Barnawapar");
        itineraries.put("Goa", "Cost: ₹20,000–₹30,000\nHighlights: Beaches, Forts, Dudhsagar Falls\nSuggested Route: Beaches -> Dudhsagar -> Forts");
        itineraries.put("Gujarat", "Cost: ₹20,000–₹30,000\nHighlights: Gir National Park, Somnath, Rann of Kutch\nSuggested Route: Gir -> Somnath -> Rann of Kutch");
        itineraries.put("Haryana", "Cost: ₹10,000–₹20,000\nHighlights: Sultanpur, Kurukshetra, Pinjore Gardens\nSuggested Route: Sultanpur -> Kurukshetra -> Pinjore Gardens");
        itineraries.put("Himachal Pradesh", "Cost: ₹20,000–₹35,000\nHighlights: Shimla, Manali, Dalhousie\nSuggested Route: Shimla -> Manali -> Dalhousie");
        itineraries.put("Jharkhand", "Cost: ₹12,000–₹22,000\nHighlights: Ranchi, Betla, Deoghar\nSuggested Route: Ranchi -> Betla -> Deoghar");
        itineraries.put("Karnataka", "Cost: ₹20,000–₹35,000\nHighlights: Mysore, Hampi, Coorg\nSuggested Route: Mysore -> Hampi -> Coorg");
        itineraries.put("Kerala", "Cost: ₹25,000–₹35,000\nHighlights: Munnar, Alleppey, Thekkady\nSuggested Route: Munnar -> Alleppey -> Thekkady");
        itineraries.put("Madhya Pradesh", "Cost: ₹18,000–₹30,000\nHighlights: Khajuraho, Kanha, Ujjain\nSuggested Route: Khajuraho -> Kanha -> Ujjain");
        itineraries.put("Maharashtra", "Cost: ₹18,000–₹30,000\nHighlights: Mumbai, Ajanta & Ellora, Shirdi\nSuggested Route: Mumbai -> Ajanta -> Shirdi");
        itineraries.put("Manipur", "Cost: ₹20,000–₹30,000\nHighlights: Loktak Lake, Imphal, Kangla Fort\nSuggested Route: Loktak -> Imphal -> Kangla Fort");
        itineraries.put("Meghalaya", "Cost: ₹20,000–₹30,000\nHighlights: Cherrapunji, Umiam Lake, Living Root Bridges\nSuggested Route: Cherrapunji -> Umiam -> Living Root Bridges");
        itineraries.put("Mizoram", "Cost: ₹20,000–₹30,000\nHighlights: Aizawl, Vantawng Falls, Phawngpui Peak\nSuggested Route: Aizawl -> Vantawng -> Phawngpui Peak");
        itineraries.put("Nagaland", "Cost: ₹20,000–₹30,000\nHighlights: Kohima, Dzukou Valley, Khonoma\nSuggested Route: Kohima -> Dzukou -> Khonoma");
        itineraries.put("Odisha", "Cost: ₹18,000–₹28,000\nHighlights: Konark, Puri, Chilika Lake\nSuggested Route: Konark -> Puri -> Chilika Lake");
        itineraries.put("Punjab", "Cost: ₹15,000–₹25,000\nHighlights: Golden Temple, Jallianwala Bagh, Anandpur Sahib\nSuggested Route: Golden Temple -> Jallianwala -> Anandpur Sahib");
        itineraries.put("Rajasthan", "Cost: ₹20,000–₹35,000\nHighlights: Jaipur, Jaisalmer, Udaipur\nSuggested Route: Jaipur -> Jaisalmer -> Udaipur");
        itineraries.put("Sikkim", "Cost: ₹20,000–₹30,000\nHighlights: Gangtok, Tsomgo Lake, Yumthang Valley\nSuggested Route: Gangtok -> Tsomgo -> Yumthang");
        itineraries.put("Tamil Nadu", "Cost: ₹18,000–₹28,000\nHighlights: Meenakshi Temple, Mahabalipuram, Kodaikanal\nSuggested Route: Meenakshi -> Mahabalipuram -> Kodaikanal");
        itineraries.put("Telangana", "Cost: ₹15,000–₹25,000\nHighlights: Charminar, Golconda Fort, Ramoji Film City\nSuggested Route: Charminar -> Golconda -> Ramoji");
        itineraries.put("Tripura", "Cost: ₹15,000–₹25,000\nHighlights: Ujjayanta Palace, Neermahal, Jampui Hills\nSuggested Route: Ujjayanta -> Neermahal -> Jampui Hills");
        itineraries.put("Uttar Pradesh", "Cost: ₹18,000–₹28,000\nHighlights: Taj Mahal, Varanasi, Agra Fort\nSuggested Route: Taj Mahal -> Varanasi -> Agra Fort");
        itineraries.put("Uttarakhand", "Cost: ₹18,000–₹28,000\nHighlights: Rishikesh, Nainital, Jim Corbett\nSuggested Route: Rishikesh -> Nainital -> Jim Corbett");
        itineraries.put("West Bengal", "Cost: ₹18,000–₹28,000\nHighlights: Victoria Memorial, Darjeeling, Sundarbans\nSuggested Route: Victoria Memorial -> Darjeeling -> Sundarbans");


        // Title label
        JLabel titleLabel = new JLabel("Select a state to view itinerary");
        titleLabel.setBounds(100, 30, 350, 30);  
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        backgroundLabel.add(titleLabel);

        // Create a dropdown for state selection
        JLabel stateLabel = new JLabel("Select State:");
        stateLabel.setBounds(50, 100, 150, 25);
        stateLabel.setForeground(Color.BLACK);
        backgroundLabel.add(stateLabel);

        String[] states = itineraries.keySet().toArray(new String[0]);
        JComboBox<String> stateDropdown = new JComboBox<>(states);
        stateDropdown.setBounds(200, 100, 200, 25);
        backgroundLabel.add(stateDropdown);

        // Create a "View Itinerary" button
        JButton viewButton = new JButton("View Itinerary");
        viewButton.setBounds(200, 160, 200, 40);
        backgroundLabel.add(viewButton);

        // Text Area to display selected itinerary
        JTextArea itineraryArea = new JTextArea(10, 50);
        itineraryArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        itineraryArea.setLineWrap(true);
        itineraryArea.setWrapStyleWord(true);
        itineraryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itineraryArea);
        scrollPane.setBounds(50, 220, 500, 100);
        backgroundLabel.add(scrollPane);

        // Add action listener to button to show selected itinerary
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedState = (String) stateDropdown.getSelectedItem();
                String itinerary = itineraries.get(selectedState);
                itineraryArea.setText(itinerary);
            }
        });

        // Display the frame
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    
}



public static class EstimatedAmount extends JFrame {
    private static HashMap<String, Integer[]> statePackageCosts;

    public EstimatedAmount() {
        // Set up the frame
        JFrame frame = new JFrame("Travel Cost Estimator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);  // Adjusted frame size for better content display

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\esti.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null); // Absolute positioning for custom arrangement
        frame.setContentPane(backgroundLabel); // Set background label as the content pane

        // Initialize state cost data
        initializeStatePackageCosts();

        // Title label
        JLabel titleLabel = new JLabel("Calculate your estimated amount here");
        titleLabel.setBounds(100, 30, 350, 30);  // Adjusted positioning to fit frame
        titleLabel.setFont(new Font("Arial", Font.BOLD, 1));
        titleLabel.setForeground(Color.WHITE);  // Changed font color to white
        backgroundLabel.add(titleLabel);

        // Dropdown for selecting state
        JLabel stateLabel = new JLabel("Select State:");
        stateLabel.setBounds(50, 100, 150, 25);
        stateLabel.setForeground(Color.WHITE);  // Changed font color to white
        String[] states = statePackageCosts.keySet().toArray(new String[0]);
        JComboBox<String> stateDropdown = new JComboBox<>(states);
        stateDropdown.setBounds(200, 100, 200, 25);
        backgroundLabel.add(stateLabel);
        backgroundLabel.add(stateDropdown);

        // Input for number of persons
        JLabel personsLabel = new JLabel("Number of Persons:");
        personsLabel.setBounds(50, 160, 150, 25);
        personsLabel.setForeground(Color.WHITE);  // Changed font color to white
        JTextField personsField = new JTextField();
        personsField.setBounds(200, 160, 200, 25);
        backgroundLabel.add(personsLabel);
        backgroundLabel.add(personsField);

        // Input for number of days
        JLabel daysLabel = new JLabel("Number of Days:");
        daysLabel.setBounds(50, 220, 150, 25);
        daysLabel.setForeground(Color.WHITE);  // Changed font color to white
        JTextField daysField = new JTextField();
        daysField.setBounds(200, 220, 200, 25);
        backgroundLabel.add(daysLabel);
        backgroundLabel.add(daysField);

        // Button to calculate total cost
        JButton calculateButton = new JButton("Calculate Total Cost");
        calculateButton.setBounds(150, 300, 200, 40);  // Positioned below the input fields with more space
        backgroundLabel.add(calculateButton);

        // Label for displaying the result
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 380, 400, 30);  // Added below the button with enough room for text
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(Color.WHITE);  // Changed result text color to white
        backgroundLabel.add(resultLabel);

        // Action listener for calculating total cost
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedState = (String) stateDropdown.getSelectedItem();
                    int numberOfPersons = Integer.parseInt(personsField.getText());
                    int numberOfDays = Integer.parseInt(daysField.getText());

                    // Get the cost range for the selected state
                    Integer[] costRange = statePackageCosts.get(selectedState);
                    int avgCostPerDay = (costRange[0] + costRange[1]) / 2;

                    // Calculate the total cost
                    int totalCost = avgCostPerDay * numberOfPersons * numberOfDays;

                    // Display the result
                    resultLabel.setText("Total Estimated Cost: ₹" + totalCost);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for persons and days.");
                }
            }
        });

        // Center the frame on the screen and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to initialize state cost data
    private static void initializeStatePackageCosts() {
        statePackageCosts = new HashMap<>();
        statePackageCosts.put("Andhra Pradesh", new Integer[]{15000, 25000});
        statePackageCosts.put("Arunachal Pradesh", new Integer[]{25000, 35000});
        statePackageCosts.put("Assam", new Integer[]{18000, 28000});
        statePackageCosts.put("Bihar", new Integer[]{12000, 22000});
        statePackageCosts.put("Chhattisgarh", new Integer[]{15000, 25000});
        statePackageCosts.put("Goa", new Integer[]{20000, 30000});
        statePackageCosts.put("Gujarat", new Integer[]{20000, 30000});
        statePackageCosts.put("Haryana", new Integer[]{10000, 20000});
        statePackageCosts.put("Himachal Pradesh", new Integer[]{20000, 35000});
        statePackageCosts.put("Jharkhand", new Integer[]{12000, 22000});
        statePackageCosts.put("Karnataka", new Integer[]{20000, 35000});
        statePackageCosts.put("Kerala", new Integer[]{25000, 35000});
        statePackageCosts.put("Madhya Pradesh", new Integer[]{18000, 30000});
        statePackageCosts.put("Maharashtra", new Integer[]{18000, 30000});
        statePackageCosts.put("Manipur", new Integer[]{20000, 30000});
        statePackageCosts.put("Meghalaya", new Integer[]{20000, 30000});
        statePackageCosts.put("Mizoram", new Integer[]{20000, 30000});
        statePackageCosts.put("Nagaland", new Integer[]{20000, 30000});
        statePackageCosts.put("Odisha", new Integer[]{18000, 28000});
        statePackageCosts.put("Punjab", new Integer[]{15000, 25000});
        statePackageCosts.put("Rajasthan", new Integer[]{20000, 35000});
        statePackageCosts.put("Sikkim", new Integer[]{20000, 30000});
        statePackageCosts.put("Tamil Nadu", new Integer[]{18000, 28000});
        statePackageCosts.put("Telangana", new Integer[]{15000, 25000});
        statePackageCosts.put("Tripura", new Integer[]{15000, 25000});
        statePackageCosts.put("Uttar Pradesh", new Integer[]{18000, 28000});
        statePackageCosts.put("Uttarakhand", new Integer[]{18000, 28000});
        statePackageCosts.put("West Bengal", new Integer[]{18000, 28000});
    }

    public static void main(String[] args) {
        new EstimatedAmount(); // Create an instance of the class to display the frame
    }
}


 

public static class ProfileWindow extends JFrame {
    private JFrame profileFrame;

    public ProfileWindow() {
        profileFrame = new JFrame("Profile");
        profileFrame.setSize(600, 400);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setLocationRelativeTo(null); // Center the frame
        profileFrame.setLayout(new BorderLayout());

        // Create left panel with image icon or dummy image placeholder
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(152, 108, 165)); // Set the purple background color
        JLabel imageLabel = new JLabel(new ImageIcon("src/icons/login.png"));
        imageLabel.setBounds(10,40,150,150);// Replace "icons/" with your image path
        leftPanel.add(imageLabel);
        profileFrame.add(leftPanel, BorderLayout.WEST);
        leftPanel.setPreferredSize(new Dimension(250, 400));

        // Create right panel for login form
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        profileFrame.add(rightPanel, BorderLayout.CENTER);

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
                openForgotPasswordPage(profileFrame); // Call the method to open the Forgot Password page
            }
        });

        // Action listener for the "Login" button
       // Action listener for the "Login" button
loginButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText().trim();
        String email = emailText.getText().trim();
        String password = new String(passwordText.getPassword()).trim();

        // Validate input
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(profileFrame, "Please fill in all fields.");
            return;
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "sakshi");
            String sql = "SELECT * FROM account WHERE username = ? AND email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // User exists, now check the password
                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals(password)) {
                    JOptionPane.showMessageDialog(profileFrame, "Login Successful!");
                    new Dashboard(); // Create a new Dashboard instance
                    profileFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(profileFrame, "Invalid password.");
                }
            } else {
                // User doesn't exist, prompt for signup
                int response = JOptionPane.showConfirmDialog(profileFrame, 
                    "No account found with that username and email. Would you like to sign up?", 
                    "Signup", 
                    JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    openSignupPage(); // Call the method to open the signup page
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(profileFrame, "Database error: " + ex.getMessage());
        }
    }
});

 setLocationRelativeTo(null); 
        // Set frame visibility
        profileFrame.setVisible(true);
    }

    // Method to open Signup Page
 private void openSignupPage() {
    JFrame signupFrame = new JFrame("Signup");
    signupFrame.setSize(400, 350);
    signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    signupFrame.setLayout(null);  // Set the layout to null for absolute positioning
    signupFrame.setLocationRelativeTo(null);
    // Create labels and text fields for signup
    JLabel labelName = new JLabel("Name:", SwingConstants.CENTER);
    labelName.setBounds(50, 30, 100, 25);
    signupFrame.add(labelName);

    JTextField nameField = new JTextField(20);
    nameField.setBounds(160, 30, 165, 25);
    signupFrame.add(nameField);

    JLabel labelEmail = new JLabel("Email:", SwingConstants.CENTER);
    labelEmail.setBounds(50, 70, 100, 25);
    signupFrame.add(labelEmail);

    JTextField emailField = new JTextField(20);
    emailField.setBounds(160, 70, 165, 25);
    signupFrame.add(emailField);

    JLabel labelAge = new JLabel("Age:", SwingConstants.CENTER);
    labelAge.setBounds(50, 110, 100, 25);
    signupFrame.add(labelAge);

    JTextField ageField = new JTextField(20);
    ageField.setBounds(160, 110, 165, 25);
    signupFrame.add(ageField);

    JLabel labelGender = new JLabel("Gender:", SwingConstants.CENTER);
    labelGender.setBounds(50, 150, 100, 25);
    signupFrame.add(labelGender);

    String[] genders = { "Male", "Female" };
    JComboBox<String> genderComboBox = new JComboBox<>(genders);
    genderComboBox.setBounds(160, 150, 165, 25);
    signupFrame.add(genderComboBox);

    JLabel labelUsername = new JLabel("Username:", SwingConstants.CENTER);
    labelUsername.setBounds(50, 190, 100, 25);
    signupFrame.add(labelUsername);

    JTextField usernameField = new JTextField(20);
    usernameField.setBounds(160, 190, 165, 25);
    signupFrame.add(usernameField);

    JLabel labelPassword = new JLabel("Password:", SwingConstants.CENTER);
    labelPassword.setBounds(50, 230, 100, 25);
    signupFrame.add(labelPassword);

    JPasswordField passwordField = new JPasswordField(20);
    passwordField.setBounds(160, 230, 165, 25);
    signupFrame.add(passwordField);

    JButton submitButton = new JButton("Sign Up");
    submitButton.setBounds(120, 270, 120, 25);
    signupFrame.add(submitButton);

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String ageText = ageField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Validate inputs
            if (name.isEmpty() || email.isEmpty() || ageText.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(signupFrame, "Please fill in all fields.");
                return;
            }

            // Validate age
            int age;
            try {
                age = Integer.parseInt(ageText);
                if (age < 0) {
                    JOptionPane.showMessageDialog(signupFrame, "Please enter a valid age.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(signupFrame, "Please enter a valid age.");
                return;
            }

            // Insert into the database
            try {
                Connection connection = jdbc(); // Use the jdbc method to get connection
                String sql = "INSERT INTO account (name, email, age, gender, username, password) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setInt(3, age);
                statement.setString(4, gender);
                statement.setString(5, username);
                statement.setString(6, password); // Consider hashing the password

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(signupFrame, "Signup successful for " + username);
                    signupFrame.dispose(); // Close the signup frame after submission
                } else {
                    JOptionPane.showMessageDialog(signupFrame, "Signup failed. Please try again.");
                }

                statement.close();
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(signupFrame, "Database error: " + ex.getMessage());
            }
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

    // Placeholder methods for database connection and password hashing
    private Connection jdbc() throws SQLException {
    // Implement your database connection logic here
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "sakshi");
}

}

  

 

    // Inner class for user profile update

    static class UserProfileUpdate extends JFrame {
        private JTextField nameField, emailField, ageField, usernameField, passwordField;
        private JButton updateButton, backButton;

        public UserProfileUpdate() {
            // Set window properties
            setTitle("User Profile Update");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null); // Center the frame
            setLayout(null); // Use absolute positioning

            // Set positions and sizes of labels and text fields
            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setBounds(50, 50, 159, 37); // X, Y, Width, Height
            add(nameLabel);

            nameField = new JTextField();
            nameField.setBounds(220, 50, 200, 37); // X, Y, Width, Height
            add(nameField);

            JLabel emailLabel = new JLabel("Email id:");
            emailLabel.setBounds(50, 100, 159, 37);
            add(emailLabel);

            emailField = new JTextField();
            emailField.setBounds(220, 100, 200, 37);
            add(emailField);

            JLabel ageLabel = new JLabel("Age:");
            ageLabel.setBounds(50, 150, 159, 37);
            add(ageLabel);

            ageField = new JTextField();
            ageField.setBounds(220, 150, 200, 37);
            add(ageField);

            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setBounds(50, 200, 159, 37);
            add(usernameLabel);

            usernameField = new JTextField();
            usernameField.setBounds(220, 200, 200, 37);
            add(usernameField);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setBounds(50, 250, 159, 37);
            add(passwordLabel);

            passwordField = new JPasswordField();
            passwordField.setBounds(220, 250, 200, 37);
            add(passwordField);

            // Set position and size of buttons
            updateButton = new JButton("Update");
            updateButton.setBounds(120, 320, 100, 37); // X, Y, Width, Height
            add(updateButton);

            backButton = new JButton("Back");
            backButton.setBounds(240, 320, 100, 37);
            add(backButton);

            // Add action listener for Update button
            updateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateUserProfile();
                }
            });

            // Add action listener for Back button
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Close current window
                }
            });
        }

        // Method to update user profile in the database
        private void updateUserProfile() {
            String name = nameField.getText();
            String email = emailField.getText();
            String age = ageField.getText();
            String username = usernameField.getText();
            String password = new String(((JPasswordField) passwordField).getPassword());

            // Database connection
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection (ensure your database name and credentials are correct)
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "sakshi");

// SQL query to update user profile
String query = "UPDATE users SET name = ?, email = ?, age = ?, password = ? WHERE username = ?";

                pst = conn.prepareStatement(query);

                // Set parameters
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, age);
                pst.setString(4, password);
                pst.setString(5, username);
System.out.println("Executing query: " + pst.toString());

                // Execute update
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "User profile updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update profile. Please check your inputs.");
                }
            } catch (SQLException se) {
    se.printStackTrace();
    JOptionPane.showMessageDialog(this, "SQL Error: " + se.getMessage());
} catch (ClassNotFoundException cnfe) {
    cnfe.printStackTrace();
    JOptionPane.showMessageDialog(this, "Driver not found: " + cnfe.getMessage());
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}
 finally {
               try {
    if (pst != null) pst.close(); // Close the statement
    if (conn != null) conn.close(); // Close the connection
} catch (SQLException se) {
    se.printStackTrace();
}

            }
        }
    
    } 


 

    // Method to open a new window of size 700x60

// Favorites class for managing travel packages

class Favorites {

    // Array of package types
    private static String[] packageTypes = {
        "Adventure Package", "Family Package", "Romantic Getaway",
        "Luxury Package", "Pilgrimage Package", "Cruise Package"
    };

    // Array of images (update these paths to the actual image paths on your system)
    private static String[] imagePaths = {
        "C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\adven.jpg", "C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\famiy.jpg", "C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\romantic.jpg",
        "C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\luxury.jpg", "C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\pilgr.jpg", "C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\cruise.jpg"
    };

    // Array of descriptions for each package
     // Array of descriptions for each package
    private static String[] packageDescriptions = {
        "Experience thrilling adventures like hiking, rock climbing, and zip-lining.\nThe Adventure Package is designed for thrill-seekers and outdoor enthusiasts who crave excitement and adrenaline during their travels. \n This package offers a curated selection of activities and experiences that immerse you in nature and provide unforgettable adventures.\n" + //
                        "\n" + //
        " The Adventure Package is designed for thrill-seekers eager to explore the great outdoors and engage in exhilarating activities. This package offers a perfect blend of excitement, nature, and unique experiences.\n" + //
                        "\n" + //
                        "Inclusions:\n" + //
                        "\n" + //
                        "Outdoor Activities: Enjoy hiking, rock climbing, zip-lining, and white-water rafting.\n" + //
                        "\n" + //
                        "Wildlife Exploration: Participate in guided safaris or bird-watching tours.\n" + //
                        "\n" + //
                        "Camping Experiences: Experience overnight camping with campfire nights and stargazing.\n" + //
                        "\n" + //
                        "Expert Guides: Benefit from knowledgeable guides ensuring safety and enhancing your experience.\n" + //
                        "\n" + //
                        "Transportation: Includes all necessary transportation to activity sites.",
        "Spend quality time with your partner on a romantic getaway with sunset dinners.\nThe Romantic Getaway Package is crafted for couples seeking a special escape filled with intimacy and unforgettable experiences. \nPerfect for anniversaries, honeymoons, or simply reconnecting, this package combines romance, relaxation, and adventure in beautiful settings.\n The Family Package is designed for families looking to create memorable experiences together while enjoying fun, educational, and relaxing activities.\n" + //
                        "\n" + //
                        "Inclusions:\n" + //
                        "\n" + //
                        "Family-Friendly Accommodations: Stay in spacious hotels or resorts with kid-friendly amenities.\n" + //
                        "\n" + //
                        "Exciting Activities: Enjoy theme park visits, wildlife encounters, and outdoor adventures suitable for all ages.\n" + //
                        "\n" + //
                        "Meals: Benefit from inclusive dining options that cater to diverse tastes.\n" + //
                        "\n" + //
                        "Transportation: All necessary transportation to and from activities for a hassle-free experience.\n" + //
                        "\n" + //
                        "Guided Tours: Engage in educational experiences at museums and cultural sites." 
                                                  
+// "Guided Tours: Engage in educational experiences at museums and cultural sites.",
        "Indulge in a luxurious vacation with fine dining, spa treatments, and premium services.\nThe Luxury Package offers an unparalleled travel experience for those seeking comfort, elegance, and personalized service. Enjoy exclusive amenities and lavish accommodations tailored to your desires.\n" + //
                        "\n" + //
                        "Inclusions:\n" + //
                        "\n" + //
                        "Five-Star Accommodations: Stay in opulent hotels or resorts with world-class service.\n" + //
                        "\n" + //
                        "Gourmet Dining: Savor exquisite meals from top chefs, including private dining options.\n" + //
                        "\n" + //
                        "Personal Concierge Service: Enjoy a dedicated concierge to cater to your needs.\n" + //
                        "\n" + //
                        "Exclusive Activities: Experience private yacht charters, helicopter tours, and VIP access to events.\n" + //
                        "\n" + //
                        "Wellness Treatments: Indulge in luxury spa services and personalized wellness programs.\n" + //
                        "\n" + //
                        "Customized Itineraries: Tailor-made travel plans that suit your interests.",
        "Travel on a budget with affordable options that don’t compromise on fun.\nThe Budget Package is designed for travelers who want to explore without breaking the bank. This package offers affordable yet enjoyable experiences, making travel accessible to everyone.\n" + //
                        "\n" + //
                        "Inclusions:\n" + //
                        "\n" + //
                        "Comfortable Accommodations: Stay in budget-friendly hotels or hostels with essential amenities.\n" + //
                        "\n" + //
                        "Value Dining Options: Enjoy local cuisine at affordable restaurants and casual eateries.\n" + //
                        "\n" + //
                        "Group Activities: Participate in guided tours and activities that provide great value for money.\n" + //
                        "\n" + //
                        "Transportation: Includes economical transport options, such as public transport and shared transfers.\n" + //
                        "\n" + //
                        "Local Experiences: Discover hidden gems and cultural experiences that don’t require high spending.",
        "Set sail on a luxurious cruise with exotic destinations and entertainment.\nThe Cruise Package offers an exciting way to explore multiple destinations while enjoying luxurious amenities aboard a cruise ship. Perfect for those seeking adventure, relaxation, and unique experiences at sea.\n" + //
                        "\n" + //
                        "Inclusions:\n" + //
                        "\n" + //
                        "Luxurious Accommodations: Stay in comfortable cabins with stunning ocean views and onboard amenities.\n" + //
                        "\n" + //
                        "Gourmet Dining: Enjoy a variety of dining options, from casual eateries to upscale restaurants.\n" + //
                        "\n" + //
                        "Entertainment: Access to onboard entertainment, including shows, live music, and themed events.\n" + //
                        "\n" + //
                        "Excursions: Explore various ports of call with guided shore excursions and activities.\n" + //
                        "\n" + //
                        "Wellness Facilities: Relax with spa treatments, fitness classes, and pools on the ship.\n" + //
                        "\n" + //
                        "Conclusion: The Cruise Package combines relaxation and adventure, allowing you to discover new destinations while enjoying the comforts and entertainment of a luxury cruise experience"
    };


    // Method to open the Favorites window
    public static void openFavoritesWindow() {
        // Create new frame for the Favorites window
       // Create new frame for the packages window
        JFrame packagesFrame = new JFrame("Travel Packages");
        packagesFrame.setSize(1080, 1200);
        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
packagesFrame.setLocationRelativeTo(null); // Center the frame

        // Make the frame resizable
        packagesFrame.setResizable(true);

        // Create a panel to hold the images and labels
        JPanel packagesPanel = new JPanel();
        packagesPanel.setLayout(new GridBagLayout());  // Using GridBagLayout for better resizing behavior
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;

        // Add images and package types to the panel
        for (int i = 0; i < packageTypes.length; i++) {
            final int index = i; // Declare a final variable to capture the current index
            JPanel packageItemPanel = new JPanel(new BorderLayout());
            JLabel imgLabel = new JLabel(new ImageIcon(imagePaths[i])); // Replace with actual image paths
            JLabel packageLabel = new JLabel(packageTypes[i], SwingConstants.CENTER);

            // Add mouse listener to open a description dialog on click
            imgLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    JOptionPane.showMessageDialog(packagesFrame, 
                        packageDescriptions[index], 
                        packageTypes[index], 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });

            packageItemPanel.add(imgLabel, BorderLayout.CENTER);
            packageItemPanel.add(packageLabel, BorderLayout.SOUTH);

            gbc.gridy = i; // Set the row
            packagesPanel.add(packageItemPanel, gbc);
        }

        // Create a scroll pane and add the packages panel to it
        JScrollPane scrollPane = new JScrollPane(packagesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Prevent horizontal scrolling

        // Make the scroll pane adaptive to resizing
        packagesFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        // Make the packages frame visible
        packagesFrame.setVisible(true);
    }
}    // Method to open a new window for destinations


    // Method to open a new window for destinations

    public static void openDestinationsWindow() {

        JFrame destinationsFrame = new JFrame("Destinations");

        destinationsFrame.setSize(500, 500);

        destinationsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        destinationsFrame.setLocationRelativeTo(null); // Center the new window on the screen

 

        // Load and resize the background image

ImageIcon originalIcon = new ImageIcon("C:\\Users\\Sakshi\\OneDrive\\Documents\\NetBeansProjects\\travel management system\\src\\icons\\dropdown.jpg");

        Image scaledImage = originalIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(scaledImage));

        destinationsFrame.setContentPane(background);

        background.setLayout(new GridBagLayout());

 

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

 

       // Title label

        JLabel title = new JLabel("NAMASTEYY!!! Toh kaha jana pasand karoge??");

        title.setForeground(Color.WHITE); // Set text color

        title.setFont(new Font("Tahoma", Font.ITALIC, 18)); // Set font

        gbc.gridx = 0;

        gbc.gridy = 0; // First row

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        background.add(title, gbc);

 

        JLabel label = new JLabel("Select state to explore:");

        label.setForeground(Color.WHITE); // Set text color

        label.setFont(new Font("Tahoma", Font.ITALIC, 16));

        gbc.gridx = 0;

        gbc.gridy = 1; // Second row

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 10, 0); // Padding

        background.add(label, gbc);

        // Create a combo box for state selection

        String[] states = {

               "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",

            "Himachal Pradesh", "Jharkhand", "Karnataka", "Madhya Pradesh", "Maharashtra",

            "Manipur", "Meghalaya", "Rajasthan", "Uttar Pradesh", "Uttarakhand", "West Bengal"

        };

    // Create a JComboBox for states with a smaller size

// Create a JComboBox for states with a smaller size

// Create a JComboBox for states with a smaller width and increased height

JComboBox<String> stateComboBox = new JComboBox<>(states);

stateComboBox.setPreferredSize(new Dimension(20, 30)); // Set width to 80 and height to 30

stateComboBox.setMinimumSize(new Dimension(20, 30)); // Set minimum size to maintain the same dimensions

stateComboBox.setMaximumSize(new Dimension(20, 30)); // Set maximum size to maintain the same dimensions

 

gbc.gridx = 0;

gbc.gridy = 2; // Next row

gbc.insets = new Insets(5, 0, 5, 0); // Padding

background.add(stateComboBox, gbc);

 

// Create a button to proceed to the selected state's information

JButton proceedButton = new JButton("Explore");

proceedButton.setPreferredSize(new Dimension(20, 30)); // Set width to 80 and height to 30 for consistency

gbc.gridx = 0; // Ensure it is in the same column

gbc.gridy = 5; // Move it to the bottom row

gbc.insets = new Insets(5, 0, 5, 0); // Padding

gbc.anchor = GridBagConstraints.PAGE_END; // Align the button to the bottom

background.add(proceedButton, gbc);

 

 

 

        // Add action listener to the proceed button

        proceedButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String selectedState = (String) stateComboBox.getSelectedItem();

                if (selectedState.equals("Maharashtra")) {

                    openPopularPlacesMaharashtra(); // Open Maharashtra details if selected

                }

                else if(selectedState.equals("Goa"))

                {

                    openPopularPlacesGoa();

                }

                else if(selectedState.equals("Bihar"))

                {

                    openPopularPlacesBihar();

                }

                else if(selectedState.equals("Gujarat"))

                {

                    openPopularPlacesGujarat();

                }

                else if(selectedState.equals("Himachal Pradesh"))

                {

                    openPopularPlacesHimachalPradesh();

                }

                else if(selectedState.equals("Jharkhand"))

                {

                    openPopularPlacesJharkhand();

                }

                else if(selectedState.equals("Karnataka"))

                {

                    openPopularPlacesKarnataka();

                }

                else if(selectedState.equals("Chhattisgarh"))

                {

                    openPopularPlacesChhattisgarh();

                }

                else if(selectedState.equals("Haryana"))

                {

                    openPopularPlacesHaryana();

                }

               else if(selectedState.equals("Madhya Pradesh"))

                {

                    openPopularPlacesMadhyaPradesh();

                }

                 else if(selectedState.equals("Manipur"))

                {

                    openPopularPlacesManipur();

                }

               

                 else if(selectedState.equals("Meghalaya"))

                {

                    openPopularPlacesMeghalaya();

                }

                 else if(selectedState.equals("Uttarakhand"))

                {

                    openPopularPlacesUttarakhand();

                }

                else if(selectedState.equals("Rajasthan"))

                {

                    openPopularPlacesRajasthan();

                }

               else if(selectedState.equals("Uttar Pradesh"))

                {

                    openPopularPlacesUttarPradesh();

                }

                  else if(selectedState.equals("West Bengal"))

                {

                    openPopularPlacesWestBengal();

                }

              

            }

        });

 

        // Make the frame visible

        destinationsFrame.setVisible(true);

    }

   

         public static void openPopularPlacesWestBengal()

     {

       JFrame frame = new JFrame("Explore West Bengal");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring West Bengal");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/wb 1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Experience Bengal – The Sweetest Part of India.</html>");

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

                openGalleryWindow29(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow29() {

        JFrame galleryFrame = new JFrame("Popular places of West Bengal");

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

        JLabel titleLabel = new JLabel("Popular places of West Bengal");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/wb 1.jpg", // Replace with actual paths

            "src/icons/wb 2.jpg",

            "src/icons/wb 3.jpg",

            "src/icons/wb 4.jpg",

            "src/icons/wb 5.jpg",

            "src/icons/wb 6.jpg"

        };

 

        String[] labels = {"Victoria Memorial (Kolkata) ", "   Sundarbans ", " Darjeeling", "  Kalimpong", " Howrah Bridge", " Bishnupur Terracotta Temples"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel29(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel30(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

       // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel29(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface29(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface29(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Darjeeling</li><li> Kalimpong</li><li>   Howrah Bridge</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel(" October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow29(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel30(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface29(labelText);

            }

        });

}

     private static void openPackagesWindow29() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Day 1: Arrival and Sightseeing</li>\n" +

"<li>Pickup from Nashik Railway Station or Airport.</li>\n" +

"<li>Check-in to a 3-star hotel.</li>\n" +

"<li>Visit:</li>\n" +

"<li>Trimbakeshwar Temple (One of the 12 Jyotirlingas).</li>\n" +

"<li>Panchavati (Ramkund, Sita Gufa, Kalaram Temple).</li>\n" +

"<li>Anjneri Hills (Believed to be the birthplace of Lord Hanuman).</li>\n" +

"<li>Day 2: Vineyard Tour</li>\n" +


"<li>Accommodation: 3-Star hotel in Nashik.</li>\n" +

"<li>Double occupancy with breakfast included.</li>\n" +

"<li>Standard Package (3-Star Hotel): ₹8,000 – ₹10,000.</li>\n" +

"<li>Deluxe Package (4-Star Hotel + Vineyard Stay): ₹15,000 – ₹18,000.</li>\n" +

"<li>Luxury Package (5-Star Hotel + Wine-Paired Meals + Private Guide): ₹25,000 – ₹30,000.</li>\n" +

"<li>Add-ons:</li></html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

   

    

         public static void openPopularPlacesUttarPradesh()

     {

       JFrame frame = new JFrame("Explore Uttar Pradesh");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Uttar Pradesh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/upp.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Uttar Pradesh:Amazing Heritage, Grand Experiences.</html>");

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

                openGalleryWindow27(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow27() {

        JFrame galleryFrame = new JFrame("Popular places of Uttar Pradesh");

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

        JLabel titleLabel = new JLabel("Popular places of Uttar Pradesh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/upp.jpg", // Replace with actual paths

            "src/icons/up2.jpg",

            "src/icons/up3.jpg",

            "src/icons/up4.jpg",

            "src/icons/up5.jpg",

            "src/icons/up6.jpg"

        };

 

        String[] labels = {" Taj Mahal ", "  Varanasi Ghats ", " Fatehpur Sikri", "  Lucknow Bara Imambara", "Sarnath", " Mathura-Vrindavan"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel27(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel28(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel27(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface27(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface27(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li> Mathura-Vrindavan</li><li> Varanasi Ghats</li><li>  Taj Mahal</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel(" October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow27(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel28(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface27(labelText);

            }

        });

}

     private static void openPackagesWindow27() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Taj Mahal</li>   \n" +

"\n" +

"   One of the Seven Wonders of the World, the Taj Mahal is a symbol of love built by Emperor Shah Jahan in memory of his wife Mumtaz Mahal. Its marble architecture and intricate inlay work attract millions of visitors. \n" +

"\n" +

"   Entry Fee: ₹50–₹1100. \n" +

"\n" +

" \n" +

"\n" +

"<br><li> Varanasi Ghats</li>  \n" +

"\n" +

"   The ghats of Varanasi are a spiritual hub for Hindus, where they perform rituals and take holy dips in the Ganges River. The evening Ganga Aarti is a mesmerizing experience. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"<br><li> Agra Fort</li> \n" +

"\n" +

"   A UNESCO World Heritage Site, Agra Fort is a historical fort located near the Taj Mahal. It served as the main residence of the Mughal emperors. \n" +

"\n" +

"   Entry Fee: ₹40–₹600. \n" +

"\n" +

" \n" +

"\n" +

"</html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    // <li></li>\n" +

   

         public static void openPopularPlacesRajasthan()

     {

       JFrame frame = new JFrame("Explore Rajasthan");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Rajasthan");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/rajasthan2.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Rajasthan:Welcome to My Land.</html>");

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

                openGalleryWindow25(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow25() {

        JFrame galleryFrame = new JFrame("Popular places of Rajasthan");

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

        JLabel titleLabel = new JLabel("Popular places of Rajasthan");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/r.jpg", // Replace with actual paths

            "src/icons/rajasthan2.jpg",

            "src/icons/rajasthan3.jpg",

            "src/icons/rajasthan4.jpg",

            "src/icons/rajasthan5.jpg",

            "src/icons/rajasthan6.jpg"

        };

 

        String[] labels = {" Jaipur ", "  Udaipur ", " Jodhpur", "  Jaisalmer", " Ranthambore National Park", "Mount Abu"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel25(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel26(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel25(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface25(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface25(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Jaipur</li><li> Udaipur</li><li> Jaisalmer</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel(" October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow25(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel26(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface25(labelText);

            }

        });

}

     private static void openPackagesWindow25() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Jaipur (Amer Fort)   \n" +

"\n" +

"   Jaipur's Amer Fort is a majestic example of Rajput architecture. Perched on a hill, it offers panoramic views of Maota Lake and features grand courtyards, intricate artwork, and the famous Sheesh Mahal (Mirror Palace). \n" +

"\n" +

"   Entry Fee: ₹100. \n" +

"\n" +

" \n" +

"\n" +

"Jaisalmer Fort   \n" +

"\n" +

"   Known as the Golden Fort due to its yellow sandstone walls, Jaisalmer Fort is one of the largest forts in the world. It houses palaces, temples, and merchant haveli, giving a glimpse of Rajasthan's rich history. \n" +

"\n" +

"   Entry Fee: ₹50–₹100. \n" +

"\n" +

" \n" +

"\n" +

"- Udaipur City Palace   \n" +

"\n" +

"   Situated on the banks of Lake Pichola, Udaipur's City Palace is a blend of Rajasthani and Mughal architecture. It offers stunning views of the lake and is filled with museums, courtyards, and gardens. \n" +

"\n" +

"   Entry Fee: ₹250–₹300. \n" +

"\n" +

" \n" +

"\n" +

"Mount Abu   \n" +

"\n" +

"   The only hill station in Rajasthan, Mount Abu is famous for its cool climate and the Dilwara Temples. It’s a popular retreat from the desert heat with lush greenery and serene lakes. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"Jantar Mantar   \n" +

"\n" +

"   A UNESCO World Heritage Site, Jantar Mantar is an astronomical observatory built by Maharaja Jai Singh II. It features massive stone instruments used to track celestial bodies. \n" +

"\n" +

"   Entry Fee: ₹50–₹200. \n" +

"\n" +

" \n" +

"\n" +

"Ranthambore National Park   \n" +

"\n" +

"   One of India’s largest national parks, Ranthambore is renowned for its tiger population. Safaris through the park also offer chances to spot leopards, crocodiles, and a variety of bird species. \n" +

"\n" +

"   Entry Fee: ₹1500–₹3000 for safari. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

   

    

    

    

         public static void openPopularPlacesUttarakhand()

     {

       JFrame frame = new JFrame("Explore Uttarakhand");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Uttarakhand");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/uttarakhand1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Uttarakhand:Devbhumi(The land of gods)</html>");

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

                openGalleryWindow23(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow23() {

        JFrame galleryFrame = new JFrame("Popular places of Uttarakhand");

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

        JLabel titleLabel = new JLabel("Popular places of Uttarakhand");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/uttarakhand1.jpg", // Replace with actual paths

            "src/icons/uttarakhand2.jpg",

            "src/icons/uttarakhand3.jpg",

            "src/icons/uttarakhand4.jpg",

            "src/icons/uttarakhand5.jpg",

            "src/icons/uttarakhand6.jpg"

        };

 

        String[] labels = { " Jim Corbett National Park","Nainital", "Mussoorie", " Haridwar", "  Valley of Flowers"," Kedarnath Temple"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel23(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel24(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel23(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface23(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface23(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Kedarnath Temple</li><li> Haridwar</li><li> Mussoorie</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel(" March - June");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

       JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow23(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel24(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface23(labelText);

            }

        });

}

     private static void openPackagesWindow23() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Day 1: Arrival and Sightseeing</li>\n" +

"<li>Pickup from Nashik Railway Station or Airport.</li>\n" +

"<li>Check-in to a 3-star hotel.</li>\n" +

"<li>Visit:</li>\n" +

"<li>Trimbakeshwar Temple (One of the 12 Jyotirlingas).</li>\n" +

"<li>Panchavati (Ramkund, Sita Gufa, Kalaram Temple).</li>\n" +

"<li>Anjneri Hills (Believed to be the birthplace of Lord Hanuman).</li>\n" +

"<li>Day 2: Vineyard Tour</li>\n" +


"<li>Accommodation: 3-Star hotel in Nashik.</li>\n" +

"<li>Double occupancy with breakfast included.</li>\n" +

"<li>Standard Package (3-Star Hotel): ₹8,000 – ₹10,000.</li>\n" +

"<li>Deluxe Package (4-Star Hotel + Vineyard Stay): ₹15,000 – ₹18,000.</li>\n" +

"<li>Luxury Package (5-Star Hotel + Wine-Paired Meals + Private Guide): ₹25,000 – ₹30,000.</li>\n" +

"<li>Add-ons:</li></html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

   

            public static void openPopularPlacesMeghalaya()

     {

       JFrame frame = new JFrame("Explore Meghalaya");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Meghalaya");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/meghalaya1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Meghalaya:Scotland of the East</html>");

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

                openGalleryWindow21(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow21() {

        JFrame galleryFrame = new JFrame("Popular places of Meghalaya");

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

        JLabel titleLabel = new JLabel("Popular places of Meghalaya");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/meghalaya1.jpg", // Replace with actual paths

            "src/icons/meghalaya2.jpg",

            "src/icons/meghalaya3.jpg",

            "src/icons/meghalaya4.webp",

            "src/icons/meghalaya5.jpg",

            "src/icons/meghalaya6.jpg"

        };

 

        String[] labels = {" Cherrapunji", "Living Root Bridges", " Shillong Peak", " Mawlynnong Village", " Nohkalikai Falls", "Umiam Lake"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel21(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel22(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel21(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface21(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface21(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Cherrapunji</li><li>  Shillong Peak</li><li> Nohkalikai Falls</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel(" October - April");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow21(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel22(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface21(labelText);

            }

        });

}

     private static void openPackagesWindow21() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Cherrapunji </li>  \n" +

"\n" +

"   Known as one of the wettest places on Earth, Cherrapunji is famous for its living root bridges, waterfalls, and caves.  \n" +

"\n" +

"The picturesque landscapes attract trekkers and nature enthusiasts. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"<li>Mawsmai Caves  </li> \n" +

"\n" +

"   A popular limestone cave near Cherrapunji, Mawsmai Caves are known for their unique formations and easy access. The caves are well-lit, allowing visitors to explore the natural beauty of the rock formations. \n" +

"\n" +

"   Entry Fee:₹20. \n" +

"\n" +

" \n" +

"\n" +

"<li>Umiam Lake <li>  \n" +

"\n" +

"   This man-made reservoir is a scenic spot for picnics, boating, and water sports. \n" +

"\n" +

" Umiam Lake is surrounded by rolling hills, making it a favorite destination for nature lovers. \n" +

"\n" +

"   Entry Fee:₹20. \n" +

"\n" +

" \n" +

"\n </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    

     

     

     

     

         public static void openPopularPlacesManipur()

     {

       JFrame frame = new JFrame("Explore Manipur");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Manipur");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/manipur1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Manipur: Jewel of the East.</html>");

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

                openGalleryWindow19(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow19() {

        JFrame galleryFrame = new JFrame("Popular places of Manipur");

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

        JLabel titleLabel = new JLabel("Popular places of Manipur");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/manipur1.jpg", // Replace with actual paths

            "src/icons/manipur2.jpg",

            "src/icons/manipur3.png",

            "src/icons/manipur4.jpg",

            "src/icons/manipur6.jpg",

            "src/icons/manipur5.jpg"

        };

 

        String[] labels = {"  Loktak Lake", "Kangla Fort", " Keibul Lamjao National Park", "Shree Govindajee Temple", " Tharon Cave", "Sendra Island"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel19(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel20(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel19(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface19(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

   private static void openNewInterface19(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Loktak Lake</li><li> Keibul Lamjao National Park</li><li>Tharon Cave</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow19(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel20(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface19(labelText);

            }

        });

}

     private static void openPackagesWindow19() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Loktak Lake</li>   \n" +

"\n" +

"   The largest freshwater lake in northeast India, Loktak is famous for its floating islands, called phumdis. The lake is also home to the endangered Sangai deer. \n" +

"\n" +

"   Entry Fee:Free. \n" +

"\n" +

" \n" +

"\n" +

"<li>Imphal War Cemetery**</li>  \n" +

"\n" +

"   A memorial dedicated to soldiers who died during World War II, the cemetery is maintained by the Commonwealth War Graves Commission. It is a place of historical significance. \n" +

"\n" +

"      Entry Fee:Free. \n" +

"\n" +

" \n" +

"\n" +

"<li>Kangla Fort**<li> \n" +

"\n" +

"   Once the seat of the Manipur kings, Kangla Fort is a historically and culturally significant site. It houses ancient structures and temples. \n" +

"\n" +

"   Entry Fee:₹10. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

   

    

         public static void openPopularPlacesMadhyaPradesh()

     {

       JFrame frame = new JFrame("Explore Madhya Pradesh");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Madhya Pradesh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/mp1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Madhya Pradesh: The Heart of Incredible India.</html>");

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

                openGalleryWindow17(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow17() {

        JFrame galleryFrame = new JFrame("Popular places of Madhya Pradesh");

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

        JLabel titleLabel = new JLabel("Popular places of Madhya Pradesh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/mp1.jpg", // Replace with actual paths

            "src/icons/mp2.jpg",

            "src/icons/mp3.jpg",

            "src/icons/mp4.jpg",

            "src/icons/mp5.jpg",

            "src/icons/mp6.jpg"

        };

 

        String[] labels = {" Khajuraho Temples", "Kanha National Park", " Sanchi Stupa", "  Bandhavgarh National Park", " Ujjain Mahakaleshwar Temple", "Pachmarhi"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel17(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel18(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel17(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface17(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface17(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Ujjain Mahakaleshwar Temple</li><li> Khajuraho Temples</li><li>Pachmarhi</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow17(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel18(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface17(labelText);

            }

        });

}

     private static void openPackagesWindow17() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Khajuraho Temples</li>   \n" +

"\n" +

"   Famous for their intricate erotic sculptures, the Khajuraho temples are a UNESCO World Heritage site and a masterpiece of Indian temple architecture. \n" +

"\n" +

"Entry Fee: 40–₹600. \n" +

"\n" +

" \n" +

"\n" +

"<li>Bandhavgarh National Park</li>   \n" +

"\n" +

"   Known for its high density of Bengal tigers, Bandhavgarh is one of the best places in India to spot these majestic creatures in the wild. \n" +

"\n" +

"Entry Fee: ₹300–₹1500 for safaris. \n" +

"\n" +

" \n" +

"\n" +

"<li>Kanha National Park</li>   \n" +

"\n" +

"   The inspiration behind Rudyard Kipling's *The Jungle Book*, Kanha is home to a variety of wildlife, including tigers, leopards, and sloth bears. \n" +

"\n" +

"Entry Fee: ₹300–₹1500 for safaris. \n" +

"\n" +

" \n" +

"\n" +

"<li>Bhimbetka Rock Shelters</li>   \n" +

"\n" +

"   A UNESCO World Heritage site, these rock shelters feature ancient cave paintings dating back to the Stone Age. They offer insights into the early human life in India. \n" +

"\n" +

"   Entry Fee: ₹25. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

   

         public static void openPopularPlacesHaryana()

     {

       JFrame frame = new JFrame("Explore Haryana");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Haryana");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/haryana1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Haryana: The Land of Heritage and Harmony</html>");

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

                openGalleryWindow15(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow15() {

        JFrame galleryFrame = new JFrame("Popular places of Haryana");

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

        JLabel titleLabel = new JLabel("Popular places of Haryana");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/haryana1.jpg", // Replace with actual paths

            "src/icons/haryana2.jpg",

            "src/icons/haryana3.png",

            "src/icons/haryana4.jpg",

            "src/icons/haryana5.jpg",

            "src/icons/haryana6.jpg"

        };

 

        String[] labels = {" Kingdom of Dreams (Gurugram)", "Sultanpur National Park", " Kurukshetra", " Pinjore Gardens", "Morni Hills", "Brahma Sarovar"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel15(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel16(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel15(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface15(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface15(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li> Kingdom of Dreams (Gurugram)</li><li> Kurukshetra</li><li>Brahma Sarovar</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow15(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel16(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface15(labelText);

            }

        });

}

     private static void openPackagesWindow15() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Sultanpur National Park**:  \n" +

"\n" +

"   A paradise for birdwatchers, Sultanpur National Park is home to hundreds of bird species, including migratory birds. It is a peaceful retreat for nature lovers. \n" +

"\n" +

"Entry Fee: ₹5–₹40. \n" +

"\n" +

" \n" +

"\n" +

"- **Morni Hills**:  \n" +

"\n" +

"   Morni Hills is a serene hill station located in the foothills of the Himalayas.  \n" +

"\n" +

"It is known for its lush greenery, trekking trails, and peaceful atmosphere. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Kurukshetra**:  \n" +

"\n" +

"   The land where the epic Mahabharata war was fought, Kurukshetra is a historically significant site with several temples, museums, and pilgrimage spots. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Brahma Sarovar**:  \n" +

"\n" +

"   A large water tank that is considered sacred by Hindus, Brahma Sarovar is said to be where Lord Brahma performed a ritual to create the universe.  \n" +

"\n" +

"It is an important pilgrimage site. \n" +

"\n" +

"Entry Fee: Free. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

   

    

    

    public static void openPopularPlacesJharkhand()

     {

       JFrame frame = new JFrame("Explore Jharkhand");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Jharkhand");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/jarkhand1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Jharkhand</html>");

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

                openGalleryWindow13(); // This will open the second part of the code (Popular Places)

            }

       });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow13() {

        JFrame galleryFrame = new JFrame("Popular places of Jharkhand");

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

        JLabel titleLabel = new JLabel("Popular places of Jharkhand");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/jarkhand1.jpg", // Replace with actual paths

            "src/icons/jarkhand2.jpg",

            "src/icons/jarkhand3.jpg",

            "src/icons/jarkhand4.jpg",

            "src/icons/jarkhand5.jpg",

            "src/icons/jarkhand6.jpg"

        };

 

        String[] labels = {"  Betla National Park", " Baidyanath Temple (Deoghar)", "  Netarhat", " Dassam Falls", "Ranchi Lake", "Parasnath Hills"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel13(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel14(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel13(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface13(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface13(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Betla National Park</li><li> Dassam Falls</li><li>Ranchi Lake</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow13(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel14(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface13(labelText);

            }

        });

}

     private static void openPackagesWindow13() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Ranchi**:  \n" +

"\n" +

"   The capital of Jharkhand, Ranchi is known for its scenic waterfalls, lakes, and lush green landscapes. It is a growing urban center with a peaceful atmosphere. \n" +

"\n" +

"Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Betla National Park**:  \n" +

"\n" +

"   Located in the Palamu district, Betla National Park is home to elephants, tigers, leopards, and other wildlife. It offers safari rides for tourists. \n" +

"\n" +

"Entry Fee: ₹15–₹300 for safari. \n" +

"\n" +

" \n" +

"\n" +

"- **Hundru Falls**:  \n" +

"\n" +

"   A picturesque waterfall located near Ranchi, Hundru Falls is a popular picnic spot and offers a stunning view, especially during the monsoon season. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Dassam Falls**:  \n" +

"\n" +

"   Another scenic waterfall near Ranchi, Dassam Falls is a popular destination for nature lovers and photographers. \n" +

"\n" +

"Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Deoghar (Baidyanath Temple)**:  \n" +

"\n" +

"   One of the 12 Jyotirlingas of Lord Shiva, Baidyanath Temple in Deoghar is a major pilgrimage site for Hindus. It is visited by millions of devotees every year. \n" +

"\n" +

"Entry Fee: Free. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    

     

    // Method to open bihar

    public static void openPopularPlacesBihar()

     {

       JFrame frame = new JFrame("Explore Bihar");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Bihar");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/bihar1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Bihar: Land of Ancient Glory, Timeless Heritage</html>");

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

                openGalleryWindow7(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow7() {

        JFrame galleryFrame = new JFrame("Popular places of Bihar");

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

        JLabel titleLabel = new JLabel("Popular places of Bihar");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/bihar1.jpg", // Replace with actual paths

            "src/icons/bihar.jpg",

            "src/icons/bihar3.jpg",

            "src/icons/bihar4.jpg",

            "src/icons/bihar5.jpg",

            "src/icons/bihar6.jpg"

        };

 

        String[] labels = {" Mahabodhi Temple (Bodh Gaya)", "Nalanda University Ruins", "Rajgir", " Patna Sahib Gurudwara", "Vaishali", "Vikramshila Ruins"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel7(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel8(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel8(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface5(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface7(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Vikramshila Ruins</li><li> Mahabodhi Temple (Bodh Gaya)</li><li>Nalanda University Ruins</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow7(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel7(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface7(labelText);

            }

        });

}

     private static void openPackagesWindow7() {

       // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Mahabodhi Temple**:  \n" +

"\n" +

"   The Mahabodhi Temple, a UNESCO World Heritage Site, marks the location where Gautama Buddha attained enlightenment under the Bodhi Tree. \n" +

"\n" +

" This temple is a sacred pilgrimage site for Buddhists worldwide. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Nalanda University Ruins**:  \n" +

"\n" +

"   Nalanda was one of the world’s first residential universities, attracting scholars from across Asia. The ruins of this ancient center of learning provide a glimpse into its glorious past. \n" +

"\n" +

"   Entry Fee: ₹15. \n" +

"\n" +

" \n" +

"\n" +

"- **Vaishali**:  \n" +

"\n" +

"   An important archaeological site, Vaishali is where Lord Buddha preached his last sermon. \n" +

"\n" +

" It is also famous for its Ashokan Pillar and the relic stupa. \n" +

"\n" +

"   Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Patna Sahib Gurudwara**:  \n" +

"\n" +

"   Built in honor of Guru Gobind Singh, the tenth Sikh Guru, this Gurudwara is one of the most important pilgrimage sites for Sikhs.  \n" +

"\n" +

"It is located on the banks of the Ganges River in Patna. \n" +

"\n" +

"   Entry Fee: Free. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    

     

     

  

    //method to open goa

     public static void openPopularPlacesGoa()

     {

       JFrame frame = new JFrame("Explore Goa");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Goa");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/goa 5.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Goa-The state of tropical climate</html>");

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

                openGalleryWindow1(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow1() {

        JFrame galleryFrame = new JFrame("Popular places of Goa");

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

        JLabel titleLabel = new JLabel("Popular places of Goa");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/goa 1.jpg", // Replace with actual paths

           "src/icons/goa 2.jpg",

            "src/icons/goa 3.jpg",

            "src/icons/goa 4.jpg",

            "src/icons/goa 5.jpg",

            "src/icons/goa 6.jpg"

        };

 

        String[] labels = {"Baga Beach", "Basilica of Bom Jesus", "Dudhsagar Waterfalls", "Anjuna Beach", "Aguada Fort", "Chapora Fort"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel1(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel2(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel1(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface1(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface1(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Baga Beach</li><li> Dudhsagar Waterfalls</li><li> Anjuna Beach</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("November - Feburary");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow1(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel2(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface1(labelText);

            }

        });

}

     private static void openPackagesWindow1() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Baga Beach**:  \n" +

"\n" +

"   One of the most popular beaches in Goa, Baga Beach is known for its lively nightlife, water sports, and beachside shacks. It's a favorite spot for both relaxation and adventure. \n" +

"\n" +

"Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Aguada Fort**:  \n" +

"\n" +

"   This Portuguese fort, built in the 17th century, overlooks the Arabian Sea and served as a defense against invasions. The fort also houses a lighthouse, which is one of the oldest in Asia. \n" +

"\n" +

"Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Dudhsagar Falls**:  \n" +

"\n" +

"   Located on the Mandovi River, Dudhsagar Falls is one of India’s tallest waterfalls. \n" +

"\n" +

" It is a popular destination for trekking and jeep safaris, offering breathtaking views of the cascading water. \n" +

"\n" +

"Entry Fee: ₹50–₹500 for jeep ride. \n" +

"\n" +

" \n" +

"\n" +

"- **Basilica of Bom Jesus**:  \n" +

"\n" +

"   A UNESCO World Heritage Site, this basilica is famous for containing the remains of St. Francis Xavier. Its baroque architecture and historical significance make it one of Goa’s most visited landmarks. \n" +

"\n" +

"Entry Fee: Free. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

        // PopularPlacesMaharashtra code ends here

    //Popular places gujarat

     public static void openPopularPlacesGujarat()

     {

       JFrame frame = new JFrame("Explore Gujarat");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Gujarat");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/gujarat1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Discover Gujarat: Colors of Culture, Spirit of Enterprise</html>");

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

                openGalleryWindow3(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow3() {

        JFrame galleryFrame = new JFrame("Popular places of Gujarat");

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

        JLabel titleLabel = new JLabel("Popular places of Gujarat");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/gujarat6.jpg", // Replace with actual paths

            "src/icons/gujarat2.jpg",

            "src/icons/sabarmati.jpg",

            "src/icons/rann.jpg",

            "src/icons/gujarat4.jpg",

            "src/icons/gujarat5.jpg"

        };

 

        String[] labels = {"Statue of Unity", "Gir National Park", "Sabarmati Ashram", "Rann of Kutch", " Somnath Temple", "Dwarkadhish Temple"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel3(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel4(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel3(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface3(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface3(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Dwarkadhish Temple</li><li> Somnath Temple</li><li> Anjuna Beach</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("November - Feburary");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow3(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel4(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface3(labelText);

            }

        });

}

     private static void openPackagesWindow3() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Somnath Temple**:  \n" +

"\n" +

"   One of the 12 Jyotirlingas of Lord Shiva, Somnath Temple is a revered pilgrimage site located on the western coast of Gujarat. The temple has been rebuilt several times after being destroyed by invaders. \n" +

"\n" +

"Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Gir National Park**:  \n" +

"\n" +

"   The only place in the world where Asiatic lions can be found, Gir National Park is a major wildlife sanctuary and a must-visit for wildlife enthusiasts. \n" +

"\n" +

"Entry Fee: ₹800 for safari. \n" +

"\n" +

" \n" +

"\n" +

"- **Statue of Unity**:  \n" +

"\n" +

"   The tallest statue in the world, the Statue of Unity is dedicated to Sardar Vallabhbhai Patel. It stands tall at 182 meters and offers a panoramic view of the surrounding area. \n" +

"\n" +

"Entry Fee: ₹150–₹350. \n" +

"\n" +

" \n" +

"\n" +

"- **Rann of Kutch**:  \n" +

"\n" +

"   Known for its salt flats, the Rann of Kutch is a seasonal salt marsh located in the Thar Desert. The Rann Utsav, held every winter, showcases the region’s rich culture. \n" +

"\n" +

"   Entry Fee: ₹100 during Rann Utsav. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    // Method to open the gallery window with popular places

    // Method to add images and labels to the gallery panel

    // Method to open a new interface on image click

    // Method to open the packages window (implement this method as needed)

//Method to open Andhra Pradesh

  

     

     //Method to open Gujarat

          

             //Method to open Arunachal Pradesh

             public static void openPopularPlacesHimachalPradesh()

     {

       JFrame frame = new JFrame("Explore Himachal Pradesh");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Himachal Pradesh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/hp1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Himachal Pradesh: Where Nature Meets Serenity</html>");

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

                openGalleryWindow9(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow9() {

        JFrame galleryFrame = new JFrame("Popular places of Himachal Pradesh");

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

        JLabel titleLabel = new JLabel("Popular places of Himachal Pradesh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/hp6.jpg", // Replace with actual paths

            "src/icons/hp5.webp",

            "src/icons/hp4.jpg",

            "src/icons/hp3.jpg",

            "src/icons/hp2.jpg",

            "src/icons/hp1.jpg"

        };

 

        String[] labels = {"  Manali", "Shimla Ridge", "Rohtang Pass", "Dharamshala", "Dalhousie", "Spiti Valley"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel9(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel10(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel9(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface9(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface9(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Spiti Valley</li><li>Manali</li><li>Shimla Ridge</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("March - June ");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow9(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel10(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface9(labelText);

            }

        });

}

     private static void openPackagesWindow9() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>Shimla**:  \n" +

"\n" +

"   The capital of Himachal Pradesh and one of the most popular hill stations in India, Shimla is known for its colonial architecture, scenic beauty, and the toy train ride. \n" +

"\n" +

"Entry Fee: Free, ₹550 for toy train ride. \n" +

"\n" +

" \n" +

"\n" +

"- **Manali**:  \n" +

"\n" +

"   A hub for adventure sports, Manali offers trekking, paragliding, and river rafting. It is also known for its scenic beauty and as a gateway to Leh-Ladakh. \n" +

"\n" +

"Entry Fee: Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Rohtang Pass**:  \n" +

"\n" +

"   Rohtang Pass is a high mountain pass connecting Manali to the Lahaul-Spiti Valley. It offers breathtaking views of snow-capped mountains and is a popular tourist destination. \n" +

"\n" +

"Entry Fee: ₹500 for vehicle permit.</html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    

     public static void openPopularPlacesKarnataka()

     {

       JFrame frame = new JFrame("Explore Karnataka");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Karnataka");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/karnataka1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Karnataka: One State, Many Worlds</html>");

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

                openGalleryWindow11(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow11() {

        JFrame galleryFrame = new JFrame("Popular places of Karnataka");

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

        JLabel titleLabel = new JLabel("Popular places of Karnataka");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/karnataka1jpg", // Replace with actual paths

            "src/icons/karnataka2.jpg",

            "src/icons/karnataka3.jpg",

            "src/icons/karnataka4.jpg",

            "src/icons/karnataka5.jpg",

            "src/icons/karnataka6jpg"

        };

 

        String[] labels = {" Mysore Palace", "Hampi Ruins", " Coorg", " Gokarna Beach", "Jog Falls", "Bannerghatta National Park"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel11(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel12(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel11(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface11(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface11(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Mysore Palace</li><li> Coorg</li><li>Gokarna Beach</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow11(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel12(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface11(labelText);

            }

        });

}

     private static void openPackagesWindow11() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'>ysore Palace**:   \n" +

"\n" +

"   A stunning example of Indo-Saracenic architecture, the Mysore Palace is a royal residence of the Wadiyar dynasty. It is illuminated beautifully during the Dussehra festival. \n" +

"\n" +

"Entry Fee: ₹70. \n" +

"\n" +

" \n" +

"\n" +

"- **Hampi**:   \n" +

"\n" +

"   A UNESCO World Heritage site, Hampi was the capital of the Vijayanagara Empire. Its ruins include ancient temples, palaces, and forts spread across a rocky landscape. \n" +

"\n" +

"   Entry Fee: ₹30. \n" +

"\n" +

" \n" +

"\n" +

"- **Coorg**:   \n" +

"\n" +

"   Known as the Scotland of India, Coorg is famous for its coffee plantations, lush greenery, and pleasant weather. It is a popular destination for trekking and nature lovers. \n" +

"\n" +

"Entry Fee:  Free. \n" +

"\n" +

" \n" +

"\n" +

"- **Bannerghatta National Park**:   \n" +

"\n" +

"   Located near Bangalore, this national park is home to a variety of wildlife, including tigers, lions, and elephants. It also features a butterfly park and a zoo. \n" +

"\n" +

"   Entry Fee: ₹260–₹500 for safari. </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

    

 

            

             //Method to open Andhra Pradesh

            

             //Method to open Andhra Pradesh

     public static void openPopularPlacesChhattisgarh()

     {

       JFrame frame = new JFrame("Explore Chattisgarh");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

 

        // Center the frame on the screen

        frame.setLocationRelativeTo(null);

 

        // Create a panel for the content

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);

 

        // Create a title label at the top

        JLabel titleLabel = new JLabel("Exploring Chattisgarh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2; // Span across two columns

        gbc.insets = new Insets(10, 0, 20, 0); // Padding around the title

        panel.add(titleLabel, gbc);

 

        // Specify the image path (use the correct absolute path here)

        String imagePath = "src/icons/chattisgarh1.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        JLabel textLabel = new JLabel("<html>Chhattisgarh: Unexplored Beauty, Rich Heritage</html>");

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

                openGalleryWindow5(); // This will open the second part of the code (Popular Places)

            }

        });

 

        // Add the panel to the frame

        frame.add(panel);

 

        // Make the frame visible

        frame.setVisible(true);

     }

        private static void openGalleryWindow5() {

        JFrame galleryFrame = new JFrame("Popular places of Chattisgarh");

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

        JLabel titleLabel = new JLabel("Popular places of Chattisgarh");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 3; // Span across three columns

        gbc.insets = new Insets(20, 0, 20, 0); // Padding

        panel.add(titleLabel, gbc);

 

        // Define the image paths and labels for popular places

        String[] imagePaths = {

            "src/icons/chattisgarh1.jpg", // Replace with actual paths

            "src/icons/chattisgarh2.jpg",

            "src/icons/chattisgarh3.jpg",

            "src/icons/chattisgarh4.jpg",

            "src/icons/chattisgarh5.jpg",

            "src/icons/chattisgarh6.jpg"

        };

 

        String[] labels = {" Chitrakoot Waterfalls", " Barnawapara Wildlife Sanctuary", "Kanger Valley National Park", "Bhoramdeo Temple", "Sirpur Heritage Site", "Maitri Bagh Zoo"};

 

        // Add the first row of three images horizontally

        for (int i = 0; i < 3; i++) {

            addImageWithLabel5(panel, gbc, i, 1, imagePaths[i], labels[i]);

        }

 

        // Add the second row of three images horizontally

        for (int i = 3; i < 6; i++) {

            addImageWithLabel6(panel, gbc, i - 3, 3, imagePaths[i], labels[i]);

        }

 

        // Add the scroll pane to the gallery frame

        galleryFrame.add(scrollPane);

 

        // Make the gallery frame visible

        galleryFrame.setVisible(true);

        }

         private static void addImageWithLabel5(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface5(labelText);

            }

        });

    }

 

    // Method to open a new interface on image click

    private static void openNewInterface5(String placeName) {

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Maitri Bagh Zoo</li><li>Chitrakoot Waterfalls</li><li> Sirpur Heritage Site</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

       bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - March");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow5(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

   

    }

 

    // Method to add images and labels to the gallery panel

    private static void addImageWithLabel6(JPanel panel, GridBagConstraints gbc, int gridx, int gridy, String imagePath, String labelText) {

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

                openNewInterface5(labelText);

            }

        });

}

     private static void openPackagesWindow5() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'></html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }

             //Method to open Andhra Pradesh

            

 

 

 

 

    

 
// Method to open the popular places in Maharashtra

    public static void openPopularPlacesMaharashtra() {

        // PopularPlacesMaharashtra code begins here

        // Create the frame for exploring Maharashtra

        JFrame frame = new JFrame("Explore Maharashtra");

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        String imagePath = "src/icons/Maharashtra.jpg"; // Replace with your correct image path

 

        // Check if the file exists

        File imgFile = new File(imagePath);

        if (!imgFile.exists()) {

            System.out.println("Image file not found at the specified path: " + imagePath);

            return; // Exit if the image doesn't exist

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

        // PopularPlacesMaharashtra code ends here

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

            "src/icons/Maharashtra.jpg", // Replace with actual paths

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

        JLabel mostVisitedLabel = new JLabel("Most Visited Places:");

        mostVisitedLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel, gbc);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

 

        gbc.gridy++; // Move to the next row for the list Trimbakeshwar Temple, Panchavati, Sula Vineyards

        JLabel mostVisitedLabel1 = new JLabel("<html><ul style='text-align:center;'><li>Trimbakeshwar Temple</li><li> Panchavati</li><li> Sula Vineyards</li></ul></html>");

        mostVisitedLabel1.setFont(new Font("Arial", Font.PLAIN, 16));

        mostVisitedLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        mostVisitedPanel.add(mostVisitedLabel1, gbc);

 

        // Add the most visited panel to the main panel

        panel.add(mostVisitedPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap below

 

        // Best time to visit information

        JLabel bestTimeLabel = new JLabel("Best time to visit:");

        bestTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bestTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(bestTimeLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Gap below

 

        JLabel timePeriodLabel = new JLabel("October - December");

        timePeriodLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timePeriodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(timePeriodLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap below

 

        // Button to see packages

        JButton packagesButton = new JButton("See Packages");

        packagesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(packagesButton);

 

        // Add action listener to the packages button

        packagesButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openPackagesWindow(); // Open the packages window

            }

        });

 

        // Add the panel to the new frame

        newFrame.add(panel, BorderLayout.CENTER);

 

        // Make the new frame visible

        newFrame.setVisible(true);

    }

 

    // Method to open the packages window (implement this method as needed)

    private static void openPackagesWindow() {

        // Code for opening packages window

        JFrame packagesFrame = new JFrame("Packages");

        packagesFrame.setSize(500, 500);

        packagesFrame.setLocationRelativeTo(null);

        packagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 

        // You can customize this window as needed

         JLabel packageInfoLabel = new JLabel("<html><ul style='text-align:center;'><li>Day 1: Arrival and Sightseeing</li>\n" +

"<li>Pickup from Nashik Railway Station or Airport</li>\n" +

"<li>Check-in to a 3-star hotel.</li>\n" +

"<li>Visit:</li>\n" +

"<li>Trimbakeshwar Temple (One of the 12 Jyotirlingas).</li>\n" +

"<li>Panchavati (Ramkund, Sita Gufa, Kalaram Temple).</li>\n" +

"<li>Anjneri Hills (Believed to be the birthplace of Lord Hanuman).</li>\n" +

"<li>Day 2: Vineyard Tour</li>\n" +

"<li>Visit:</li>\n" +

"<li>Sula Vineyards (Wine tasting, guided tour).</li>\n" +

"<li>York Winery (Wine tasting, leisure time by the vineyards).</li>\n" +

"<li>Gangapur Dam (Relax by the serene water).</li>\n </html>");

       

        packageInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        packageInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      packagesFrame.add(packageInfoLabel);

     packagesFrame.add(Box.createRigidArea(new Dimension(0, 30)));

    

        // Gap below

 

        packagesFrame.add(packageInfoLabel);

 

        packagesFrame.setVisible(true);

    }
public static class Contactus extends JFrame {

    private JLabel imageLabel;

    private int imageIndex = 0;

    private Timer timer;

    // Array of image file paths for the slideshow
    private String[] images = {
        "src/icons/bihar5.jpg", 
        "src/icons/dest6.jpg", 
        "src/icons/dest7.jpg", 
        "src/icons/dest5.jpg"
    };

    // Background image path
    private String bgImage = "src/icons/bg2.jpg";

 public Contactus() {
        // Frame settings
        setTitle("Contact Travel Agencies");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the frame

        // Set the background color of the frame to lilac
        getContentPane().setBackground(new java.awt.Color(200, 162, 200)); // Lilac color

        // Panel for content with background image
        JPanel contentPanel = new BackgroundPanel();
        contentPanel.setLayout(new BorderLayout());

        // Contact Details Section
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new GridLayout(10, 1, 10, 15));
        contactPanel.setBorder(BorderFactory.createTitledBorder("Available Travel Agencies"));
        contactPanel.setOpaque(false); // Allow transparency

        // Add details of travel agencies
        contactPanel.add(new JLabel("1. XYZ Travels"));
        contactPanel.add(new JLabel("   Phone: +91 9876543210"));
        contactPanel.add(new JLabel("   Email: contact@xyztravels.com"));
        contactPanel.add(new JLabel("2. ABC Tours & Travels"));
        contactPanel.add(new JLabel("   Phone: +91 9123456780"));
        contactPanel.add(new JLabel("   Email: support@abctours.com"));
        contactPanel.add(new JLabel("3. India Explorer Travels"));
        contactPanel.add(new JLabel("   Phone: +91 9988776655"));
        contactPanel.add(new JLabel("   Email: info@indiaexplorer.com"));
        contactPanel.add(new JLabel("4. GlobeTrekker Agency"));
        contactPanel.add(new JLabel("   Phone: +91 9898989898"));
        contactPanel.add(new JLabel("   Email: booking@globetrekker.com"));
        contactPanel.add(new JLabel("5. Wanderlust Getaways"));
        contactPanel.add(new JLabel("   Phone: +91 9870012345"));
        contactPanel.add(new JLabel("   Email: wander@wanderlustgetaways.com"));

        // Image Slideshow Section
        JPanel slideshowPanel = new JPanel();
        slideshowPanel.setLayout(new BoxLayout(slideshowPanel, BoxLayout.Y_AXIS));
        slideshowPanel.setOpaque(false); // To make it transparent to see the background image

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        slideshowPanel.add(imageLabel);

        // Add both panels to the content panel horizontally
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(contactPanel, BorderLayout.WEST);
        mainPanel.add(slideshowPanel, BorderLayout.CENTER);

        // Add the main panel to the content panel
        contentPanel.add(mainPanel, BorderLayout.CENTER);

        // Start the slideshow
        startSlideshow();

        // Adding content panel to the main frame
        add(contentPanel);
        setVisible(true);
    }
  private void startSlideshow() {
        // Display the first image permanently
        ImageIcon firstIcon = new ImageIcon(images[0]);
        Image firstImage = firstIcon.getImage().getScaledInstance(800, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(firstImage));

        // Start the timer for the rest of the images with a 1-second delay
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imageIndex = (imageIndex + 1) % images.length;
                ImageIcon icon = new ImageIcon(images[imageIndex]);
                Image image = icon.getImage().getScaledInstance(800, 300, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(image));
            }
        });

        timer.start();
    }

    class BackgroundPanel extends JPanel {

        private Image bg;

        public BackgroundPanel() {
            // Load the background image
            bg = new ImageIcon(bgImage).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image, scaled to fit the frame
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

}



    

