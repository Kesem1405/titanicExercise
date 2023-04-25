import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageScreen extends JPanel {
    private JComboBox<String> passengerClassComboBox;
    private List<Passenger> passengers;

    public ManageScreen(int x, int y, int width, int height) {
        TitanicDataLoader dataLoader = new TitanicDataLoader(Constants.PATH_TO_DATA_FILE);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

        JLabel passengerClassLabel = new JLabel("Passenger Class:");
        passengerClassLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(passengerClassLabel);

        this.passengerClassComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerClassComboBox.setBounds(passengerClassLabel.getX() + passengerClassLabel.getWidth() + 1, passengerClassLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerClassComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(this.passengerClassComboBox.getX() + this.passengerClassComboBox.getWidth() + Constants.MARGIN_BETWEEN_CONTROLS, this.passengerClassComboBox.getY(), Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.add(searchButton);

        searchButton.addActionListener((e) -> {
            String selectedClass = (String) this.passengerClassComboBox.getSelectedItem();
            List<Passenger> searchResults;
            if (selectedClass.equals("All")) {
                searchResults = this.passengers;
            } else {
                searchResults = searchByClass(selectedClass, this.passengers);
            }

            displaySearchResults(searchResults);
        });
    }

    public List<Passenger> searchByClass(String selectedClass, List<Passenger> passengers) {
        if (passengers == null) {
            return null;
        }
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (selectedClass.equals("All") || passenger.getPClass() == Integer.parseInt(selectedClass)) {
                results.add(passenger);
            }
        }
        return results;
    }

    private void displaySearchResults(List<Passenger> searchResults) {
        // Replace with your own implementation of displaying search results
        for (Passenger passenger : searchResults) {
            System.out.println(passenger.getFormattedName());
        }
    }
}