import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageScreen extends JPanel {
    private final JComboBox<String> pClassComboBox;
    private JComboBox<String> passengerClassComboBox;

    private JTextField minPassengerNumberField;
    private JTextField maxPassengerNumberField;
    private JTextField passengerNameField;
    private JTextField siblingsField;
    private JTextField childrenParentsField;
    private JTextField minPassengerTicketFareField;
    private JTextField maxPassengerTicketFareField;
    private JTextField ticketNumberField;
    private JTextField passengerCabinField;
    private JComboBox<String> passengerEmbarkedComboBox;
    private JComboBox<String> sexOfPassengerComboBox;
    private BufferedImage titanicImage;
    private JComboBox<Integer> passengerId;
    private List<Passenger> passengers;

    public ManageScreen(int x, int y, int width, int height) {
        List<Passenger> passengers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(Constants.PATH_TO_DATA_FILE))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Passenger passenger = new Passenger(line);
                passengers.add(passenger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.passengers = passengers;
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        JLabel pClassLabel = new JLabel("Passenger Class: ");
        pClassLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, pClassLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(pClassLabel);

        this.pClassComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.pClassComboBox.setBounds(pClassLabel.getX() + pClassLabel.getWidth() + 1, pClassLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.pClassComboBox);

        JLabel minPassengerIdLabel = new JLabel("Minimum Passenger ID: ");
        minPassengerIdLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, this.pClassComboBox.getY() + Constants.MARGIN_FROM_TOP + this.pClassComboBox.getHeight(),
                minPassengerIdLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(minPassengerIdLabel);

        this.minPassengerNumberField = new JTextField();
        this.minPassengerNumberField.setBounds(minPassengerIdLabel.getX() + minPassengerIdLabel.getWidth() + 1, minPassengerIdLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(minPassengerNumberField);

        JLabel maxPassengerIdLabel = new JLabel("Maximum Passenger ID: ");
        maxPassengerIdLabel.setBounds(this.minPassengerNumberField.getX() + this.minPassengerNumberField.getWidth() + Constants.MARGIN_FROM_LEFT, minPassengerIdLabel.getY(), maxPassengerIdLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(maxPassengerIdLabel);

        this.maxPassengerNumberField = new JTextField();
        this.maxPassengerNumberField.setBounds(maxPassengerIdLabel.getX() + maxPassengerIdLabel.getWidth() + 1, maxPassengerIdLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.maxPassengerNumberField);

        JLabel passengerNameLabel = new JLabel("Passenger Name: ");
        passengerNameLabel.setBounds(minPassengerIdLabel.getX(), this.minPassengerNumberField.getY() + this.minPassengerNumberField.getHeight() + Constants.MARGIN_FROM_TOP, passengerNameLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(passengerNameLabel);

        this.passengerNameField = new JTextField();
        this.passengerNameField.setBounds(minPassengerIdLabel.getX() + passengerNameLabel.getWidth() + 1, passengerNameLabel.getY(), Constants.PASSENGER_NAME_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerNameField);

        JLabel sexOfPassengerLabel = new JLabel("Sex of Passenger: ");
        sexOfPassengerLabel.setBounds(minPassengerIdLabel.getX(), this.passengerNameField.getY() + Constants.COMBO_BOX_HEIGHT + Constants.MARGIN_FROM_TOP, sexOfPassengerLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(sexOfPassengerLabel);

        this.sexOfPassengerComboBox = new JComboBox<>(Constants.PASSENGER_SEX_OPTIONS);
        this.sexOfPassengerComboBox.setBounds(minPassengerIdLabel.getX() + sexOfPassengerLabel.getWidth() + 1, sexOfPassengerLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(sexOfPassengerComboBox);

        JLabel sibSpPassengerLabel = new JLabel("Siblings or Spouses Count: ");
        sibSpPassengerLabel.setBounds(minPassengerIdLabel.getX(), this.sexOfPassengerComboBox.getY() + sexOfPassengerComboBox.getHeight() + Constants.MARGIN_FROM_TOP, sibSpPassengerLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(sibSpPassengerLabel);

        this.siblingsField = new JTextField();
        this.siblingsField.setBounds(minPassengerIdLabel.getX() + sibSpPassengerLabel.getWidth() + 1, sibSpPassengerLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(siblingsField);

        JLabel parchPassengerLabel = new JLabel("Passenger Parch: ");
        parchPassengerLabel.setBounds(minPassengerIdLabel.getX(), siblingsField.getY() + siblingsField.getHeight() + Constants.MARGIN_FROM_TOP, parchPassengerLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(parchPassengerLabel);

        this.childrenParentsField = new JTextField();
        this.childrenParentsField.setBounds(minPassengerIdLabel.getX() + parchPassengerLabel.getWidth() + 1, parchPassengerLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(childrenParentsField);

        JLabel minPassengerTicketFareLabel = new JLabel("Minimum Ticket Cost: ");
        minPassengerTicketFareLabel.setBounds(minPassengerIdLabel.getX(), childrenParentsField.getY() + childrenParentsField.getHeight() + Constants.MARGIN_FROM_TOP, minPassengerTicketFareLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(minPassengerTicketFareLabel);

        this.minPassengerTicketFareField = new JTextField();
        this.minPassengerTicketFareField.setBounds(minPassengerIdLabel.getX() + minPassengerTicketFareLabel.getWidth() + 1, minPassengerTicketFareLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(minPassengerTicketFareField);

        JLabel maxPassengerTicketFareLabel = new JLabel("Maximum Ticket Cost: ");
        maxPassengerTicketFareLabel.setBounds(minPassengerTicketFareField.getX() + minPassengerTicketFareField.getWidth() + Constants.MARGIN_FROM_LEFT, minPassengerTicketFareField.getY(), maxPassengerTicketFareLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(maxPassengerTicketFareLabel);

        this.maxPassengerTicketFareField = new JTextField();
        this.maxPassengerTicketFareField.setBounds(maxPassengerTicketFareLabel.getX() + maxPassengerTicketFareLabel.getWidth() + 1, maxPassengerTicketFareLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(maxPassengerTicketFareField);

        JLabel passengerTicketLabel = new JLabel("Passenger Ticket Number: ");
        passengerTicketLabel.setBounds(minPassengerIdLabel.getX(), maxPassengerTicketFareField.getY() + maxPassengerTicketFareField.getHeight() + Constants.MARGIN_FROM_TOP, passengerTicketLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(passengerTicketLabel);

        this.ticketNumberField = new JTextField();
        this.ticketNumberField.setBounds(passengerTicketLabel.getX() + passengerTicketLabel.getWidth() + 1, passengerTicketLabel.getY(), Constants.PASSENGER_TICKET_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(ticketNumberField);

        JLabel passengerCabinLabel = new JLabel("Passenger cabin number: ");
        passengerCabinLabel.setBounds(minPassengerIdLabel.getX(), ticketNumberField.getY() + ticketNumberField.getHeight() + Constants.MARGIN_FROM_TOP, passengerCabinLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(passengerCabinLabel);

        this.passengerCabinField = new JTextField();
        this.passengerCabinField.setBounds(passengerCabinLabel.getX() + passengerCabinLabel.getWidth() + 1, passengerCabinLabel.getY(), Constants.TEXT_FIELD_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(passengerCabinField);

        JLabel passengerEmbarkedLabel = new JLabel("Passenger Embarked: ");
        passengerEmbarkedLabel.setBounds(minPassengerIdLabel.getX(), passengerCabinField.getY() + passengerCabinField.getHeight() + Constants.MARGIN_FROM_TOP, passengerEmbarkedLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT, Constants.LABEL_HEIGHT);
        this.add(passengerEmbarkedLabel);

        this.passengerEmbarkedComboBox = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.passengerEmbarkedComboBox.setBounds(minPassengerIdLabel.getX() + passengerEmbarkedLabel.getWidth() + 1, passengerEmbarkedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(passengerEmbarkedComboBox);


        JButton filter = new JButton("Filter results");
        int buttonWidth = filter.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT;
        filter.setBounds((this.getWidth() - buttonWidth) / 2, passengerEmbarkedComboBox.getY() + passengerEmbarkedComboBox.getHeight() + Constants.MARGIN_FROM_TOP, buttonWidth, Constants.COMBO_BOX_HEIGHT);
        this.add(filter);

        JButton statistics = new JButton("Calculate statistics");
        int statisticButtonWidth = statistics.getPreferredSize().width+Constants.LABEL_PADDING_RIGHT;
        statistics.setBounds(passengerEmbarkedLabel.getX()+Constants.LABEL_PADDING_RIGHT, filter.getY(),statisticButtonWidth,Constants.COMBO_BOX_HEIGHT);
        this.add(statistics);

        JLabel searchResultLabel = new JLabel("Total passengers: --- \n Survived: --- \n Died: --- ");
        int searchResultLabelWidth = searchResultLabel.getPreferredSize().width + Constants.LABEL_PADDING_RIGHT;
        searchResultLabel.setBounds((this.getWidth() - searchResultLabelWidth) / 2, filter.getY() + filter.getHeight(), searchResultLabelWidth, Constants.LABEL_HEIGHT);
        searchResultLabel.setVisible(true);
        this.add(searchResultLabel);

        filter.addActionListener((e) -> {
            String minStr = minPassengerNumberField.getText().trim();
            String maxStr = maxPassengerNumberField.getText().trim();
            String name = passengerNameField.getText().trim();
            String childrenParentsStr = childrenParentsField.getText().trim();
            String ticketNumberStr = ticketNumberField.getText().trim();
            String minTicketCostStr = minPassengerTicketFareField.getText().trim();
            String maxTicketCostStr = minPassengerTicketFareField.getText().trim();
            String passengerCabinStr = passengerCabinField.getText().trim();
            String passengerEmbarkedStr = (String) passengerEmbarkedComboBox.getSelectedItem();
            String passengerClassStr = (String) pClassComboBox.getSelectedItem();
            String sexOfPassengerStr = (String) sexOfPassengerComboBox.getSelectedItem();
            List<Passenger> filteredResults = this.passengers;
            filteredResults = validateUserData(minStr,maxStr,name,childrenParentsStr,ticketNumberStr,minTicketCostStr,maxTicketCostStr,passengerCabinStr,passengerEmbarkedStr,
                    passengerClassStr,sexOfPassengerStr,this.passengers);
            int numSurvived = Constants.ZERO;
            int numDied = Constants.ZERO;
            for (Passenger passenger : filteredResults) {
                if (passenger.isSurvived()) {
                    numSurvived++;
                } else {
                    numDied++;
                }
            }
            int numTotal = filteredResults.size();
            String resultLabelText = numSurvived +" passengers survived, \n"+numDied+" passengers died, \n"+numTotal+"  passengers in total";
            searchResultLabel.setText(resultLabelText);
        });

        statistics.addActionListener((e) -> {
            try {
                FileWriter writer = new FileWriter("Statistics.txt");
                calculateAgeStatistics(this.passengers,writer);
                calculateSurvivalByFamilyMembers(this.passengers, writer);
                calculateSurvivalByTicketCost(this.passengers,writer);
                calculateSurvivalByEmbarkationPort(this.passengers,writer);
                calculateSurvivalByGender(this.passengers,writer);
                calculateSurvivalByClass(this.passengers,writer);
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error, file not working.");
            }
        });
    }



    public List<Passenger> searchByClass(String selectedClass, List<Passenger> passengers){
        if (passengers == null) {
            return null;
        }
        String classString = selectedClass.replaceAll("[^0-9]+", "");
        int classNumber = Integer.parseInt(classString);
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (selectedClass.equals("All") || passenger.getPClass() == classNumber) {
                results.add(passenger);
                try {
                    writeToFile(results);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return results;
    }
    private List<Passenger> validateUserData(String minStr, String maxStr , String name , String childrenParentsStr, String ticketNumberStr, String minTicketCostStr, String maxTicketCostStr,
                                  String passengerCabinStr, String passengerEmbarkedStr, String passengerClassStr, String sexOfPassengerStr,
                                  List<Passenger> filteredResults){
        try {
            if (!passengerClassStr.equals(Constants.PASSENGER_CLASS_OPTIONS[0])) {
                filteredResults = searchByClass(passengerClassStr, filteredResults);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if (!minStr.isEmpty()) {
            try {
                int minPassengerNumber = Integer.parseInt(minStr);
                filteredResults = searchByPassengerNumberRange(minPassengerNumber, Integer.MAX_VALUE, filteredResults);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid minimum passenger number.");
                return null;
            }
        }
        if (!maxStr.isEmpty()) {
            try {
                int maxPassengerNumber = Integer.parseInt(maxStr);
                filteredResults = searchByPassengerNumberRange(Constants.FIRST_PASSENGER, maxPassengerNumber, filteredResults);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid maximum passenger number.");
                return null;
            }
        }
        if (!name.isEmpty()) {
            filteredResults = searchByName(name, filteredResults);
        }
        if (!siblingsField.getText().isEmpty()) {
            try {
                int numSiblings = Integer.parseInt(siblingsField.getText());
                filteredResults = searchByNumSiblings(numSiblings, filteredResults);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number of siblings.");
                return null;
            }
        }
        if (!childrenParentsStr.isEmpty()) {
            try {
                int childrenParents = Integer.parseInt(childrenParentsStr);
                filteredResults = searchByChildrenParents(childrenParents, filteredResults);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number of children or parents.");
                return null;
            }
        }
        if (!sexOfPassengerStr.equals(Constants.PASSENGER_SEX_OPTIONS[0])) {
            filteredResults = searchBySex(sexOfPassengerStr, filteredResults);
        }
        try {
            if (!ticketNumberStr.isEmpty()) {
                filteredResults = searchByTicket(ticketNumberStr, filteredResults);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of ticket.");

        }
        if (!minTicketCostStr.isEmpty() || !maxTicketCostStr.isEmpty()) {
            try {
                double minTicketCost = Double.parseDouble(minTicketCostStr);
                double maxTicketCost = Double.parseDouble(maxTicketCostStr);
                if (minTicketCost > maxTicketCost) {
                    JOptionPane.showMessageDialog(this, "Minimum ticket cost cannot be higher than maximum ticket cost.");
                    return null;
                }
                filteredResults = searchByTicketFare(minTicketCost, maxTicketCost, filteredResults);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid ticket costs.");
                return null;
            }
        }
        if (!passengerCabinStr.isEmpty()) {
            try {
                int passengerCabin = Integer.parseInt(passengerCabinStr);
                filteredResults = searchByPassengerCabin(String.valueOf(passengerCabin), filteredResults);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid passenger cabin number.");
                return null;
            }
        }
        if (!passengerEmbarkedStr.equals(Constants.PASSENGER_EMBARKED_OPTIONS[0])) {
            filteredResults = searchByEmbarked(passengerEmbarkedStr, filteredResults);
        }
        try {
            writeToFile(filteredResults);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return filteredResults;
    }

    private List<Passenger> searchByPassengerNumberRange(int minPassengerNumber, int maxPassengerNumber, List<Passenger> passengers) {
        if (passengers == null) {
            return null;
        }
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            int passengerNumber = passenger.getPassengerId();
            if (passengerNumber >= minPassengerNumber && passengerNumber <= maxPassengerNumber) {
                results.add(passenger);
            }
        }
        return results;
    }

    private List<Passenger> searchByName(String passengerNameToSearch, List<Passenger> passengers) {
        if (passengers == null) {
            return null;
        }
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            String passengerName = passenger.getName();
            if (passengerName.contains(passengerNameToSearch)) {
                results.add(passenger);
            }
        }
        return results;
    }

    private List<Passenger> searchByNumSiblings(int numSiblings, List<Passenger> passengers) {
        List<Passenger> results = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getSibSp() == numSiblings) {
                results.add(p);
            }
        }
        return results;
    }

    private List<Passenger> searchByChildrenParents(int childrenParents, List<Passenger> passengers) {
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            int numChildrenParents = passenger.getParch();
            if (numChildrenParents == childrenParents) {
                results.add(passenger);
            }
        }

        return results;
    }

    public List<Passenger> searchBySex(String sexStr, List<Passenger> passengers) {
        List<Passenger> filteredPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getSex().equals(sexStr.toLowerCase().trim())) {
                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }

    private List<Passenger> searchByTicket(String userTicketNumber, List<Passenger> passengers) {
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getTicket().equals(userTicketNumber)) {
                results.add(passenger);
            }
        }
        return results;
    }

    private List<Passenger> searchByTicketFare(Double minInput, double maxInput, List<Passenger> passengers) {
        List<Passenger> results = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getFare() <= maxInput && passenger.getFare() >= minInput) {
                results.add(passenger);
            }
        }
        return results;
    }
    public List<Passenger> searchByPassengerCabin(String cabinNumber, List<Passenger> passengers) {
        List<Passenger> filteredPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getCabin().equals(cabinNumber)) {
                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }

    public List<Passenger> searchByEmbarked(String embarkedLocation, List<Passenger> passengers) {
        List<Passenger> filteredPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getEmbarked().equals(embarkedLocation)) {
                filteredPassengers.add(passenger);
            }
        }
        return filteredPassengers;
    }
    private void calculateAgeStatistics(List<Passenger> passengers, FileWriter writer) throws IOException {
        int[] ageGroupTotals = new int[6];
        int[] ageGroupSurvivors = new int[6];
        for (Passenger passenger : passengers) {
            double age = passenger.getAge();
            if (age >= Constants.FIRST_GROUP_MINIMUM && age <= Constants.FIRST_GROUP_MAXIMUM) {
                ageGroupTotals[0]++;
                if (passenger.isSurvived()) {
                    ageGroupSurvivors[0]++;
                }
            } else if (age >= Constants.SECOND_GROUP_MINIMUM && age <= Constants.SECOND_GROUP_MAXIMUM) {
                ageGroupTotals[1]++;
                if (passenger.isSurvived()) {
                    ageGroupSurvivors[1]++;
                }
            } else if (age >= Constants.THIRD_GROUP_MINIMUM && age <= Constants.THIRD_GROUP_MAXIMUM) {
                ageGroupTotals[2]++;
                if (passenger.isSurvived()) {
                    ageGroupSurvivors[2]++;
                }
            } else if (age >= Constants.FOURTH_GROUP_MINIMUM && age <= Constants.FOURTH_GROUP_MAXIMUM) {
                ageGroupTotals[3]++;
                if (passenger.isSurvived()) {
                    ageGroupSurvivors[3]++;
                }
            } else if (age >= Constants.FIFTH_GROUP_MINIMUM && age <= Constants.FIFTH_GROUP_MAXIMUM) {
                ageGroupTotals[4]++;
                if (passenger.isSurvived()) {
                    ageGroupSurvivors[4]++;
                }
            } else {
                ageGroupTotals[5]++;
                if (passenger.isSurvived()) {
                    ageGroupSurvivors[5]++;
                }
            }
        }
        writer.write("Survival percentages by age group:\n");
        for (int i = 0; i < ageGroupTotals.length; i++) {
            int total = ageGroupTotals[i];
            int survivors = ageGroupSurvivors[i];
            double percentage = (double) survivors / total * Constants.MAXIMUM_PERCENTAGE;
            String ageGroupString = i == 0 ? "0-10" : (i == 1 ? "11-20" : (i == 2 ? "21-30" : (i == 3 ? "31-40" : (i == 4 ? "41-50" : "51+"))));
            String output = ageGroupString+ " years: "+percentage+" ("+survivors+"/"+total+")\n";
            writer.write(output);
        }
        writer.write("\n");

    }

    public void calculateSurvivalByFamilyMembers(List<Passenger> passengers, FileWriter writer) {
        int totalPassengersWithFamilyMembers = Constants.ZERO;
        int totalSurvivorsWithFamilyMembers = Constants.ZERO;
        int totalPassengersWithoutFamilyMembers = Constants.ZERO;
        int totalSurvivorsWithoutFamilyMembers = Constants.ZERO;

        for (Passenger passenger : passengers) {
            if (passenger.getSibSp() > 0) {
                totalPassengersWithFamilyMembers++;
                if (passenger.isSurvived()) {
                    totalSurvivorsWithFamilyMembers++;
                }
            } else {
                totalPassengersWithoutFamilyMembers++;
                if (passenger.isSurvived()) {
                    totalSurvivorsWithoutFamilyMembers++;
                }
            }
        }

        double percentageSurvivorsWithFamilyMembers = ((double) totalSurvivorsWithFamilyMembers / (double) totalPassengersWithFamilyMembers) * Constants.MAXIMUM_PERCENTAGE;
        double percentageSurvivorsWithoutFamilyMembers = ((double) totalSurvivorsWithoutFamilyMembers / (double) totalPassengersWithoutFamilyMembers) * Constants.MAXIMUM_PERCENTAGE;

        String output = "Survival percentages by family: \n";
        output += "With family members -"+  percentageSurvivorsWithFamilyMembers + "%\n";
        output +="Without family members -"+ percentageSurvivorsWithoutFamilyMembers + "%";
        output += "\n";
        try {
            writer.write(output);
            writer.flush();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void calculateSurvivalByTicketCost(List<Passenger> passengers, FileWriter writer) throws IOException {
        int totalPassengersUnder10Pounds = Constants.ZERO;
        int totalSurvivorsUnder10Pounds = Constants.ZERO;
        int totalPassengers11to30Pounds = Constants.ZERO;
        int totalSurvivors11to30Pounds = Constants.ZERO;
        int totalPassengersOver30Pounds = Constants.ZERO;
        int totalSurvivorsOver30Pounds = Constants.ZERO;

        for (Passenger passenger : passengers) {
            double ticketCost = passenger.getFare();
            if (ticketCost < Constants.LOWEST_TICKET_FARE) {
                totalPassengersUnder10Pounds++;
                if (passenger.isSurvived()) {
                    totalSurvivorsUnder10Pounds++;
                }
            } else if (ticketCost >= Constants.LOWEST_TICKET_FARE && ticketCost <= Constants.AVERGAE_TICKET_FARE) {
                totalPassengers11to30Pounds++;
                if (passenger.isSurvived()) {
                    totalSurvivors11to30Pounds++;
                }
            } else {
                totalPassengersOver30Pounds++;
                if (passenger.isSurvived()) {
                    totalSurvivorsOver30Pounds++;
                }
            }
        }

        double percentageSurvivorsUnder10Pounds = ((double) totalSurvivorsUnder10Pounds / (double) totalPassengersUnder10Pounds) * Constants.MAXIMUM_PERCENTAGE;
        double percentageSurvivors11to30Pounds = ((double) totalSurvivors11to30Pounds / (double) totalPassengers11to30Pounds) * Constants.MAXIMUM_PERCENTAGE;
        double percentageSurvivorsOver30Pounds = ((double) totalSurvivorsOver30Pounds / (double) totalPassengersOver30Pounds) * Constants.MAXIMUM_PERCENTAGE;

        String output = "\nSurvival percentages by ticket cost: \n";
        output += "Under 10 pounds - " + percentageSurvivorsUnder10Pounds + "%\n";
        output += "Between 11 and 30 pounds - " + percentageSurvivors11to30Pounds + "%\n";
        output += "Over 30 pounds - " + percentageSurvivorsOver30Pounds + "%\n";

        writer.write(output);
        writer.flush();
    }

    public void calculateSurvivalByEmbarkationPort(List<Passenger> passengers, FileWriter writer) throws IOException {
        int[] totalPassengersByPort = new int[Constants.EMBARKATION_OPTIONS_SIZE];
        int[] totalSurvivorsByPort = new int[Constants.EMBARKATION_OPTIONS_SIZE];

        for (Passenger passenger : passengers) {
            if (passenger.getEmbarked().equals(Constants.PASSENGER_EMBARKED_OPTIONS[1])) {
                totalPassengersByPort[0]++;
                if (passenger.isSurvived()) {
                    totalSurvivorsByPort[0]++;
                }
            } else if (passenger.getEmbarked().equals(Constants.PASSENGER_EMBARKED_OPTIONS[2])) {
                totalPassengersByPort[1]++;
                if (passenger.isSurvived()) {
                    totalSurvivorsByPort[1]++;
                }
            } else if (passenger.getEmbarked().equals(Constants.PASSENGER_EMBARKED_OPTIONS[3])) {
                totalPassengersByPort[2]++;
                if (passenger.isSurvived()) {
                    totalSurvivorsByPort[2]++;
                }
            }
        }

        double[] percentageSurvivorsByPort = new double[Constants.EMBARKATION_OPTIONS_SIZE];
        for (int i = 0; i < percentageSurvivorsByPort.length; i++) {
            if (totalPassengersByPort[i] > 0) {
                percentageSurvivorsByPort[i] = ((double) totalSurvivorsByPort[i] / (double) totalPassengersByPort[i]) * Constants.MAXIMUM_PERCENTAGE;
            } else {
                percentageSurvivorsByPort[i] = Constants.ZERO;
            }
        }

        String output = "\nSurvival percentages by embarkation port:\n";
        output += "Southampton - " + percentageSurvivorsByPort[0] + "%\n";
        output += "Charbourg - " + percentageSurvivorsByPort[1] + "%\n";
        output += "Queenstown - " + percentageSurvivorsByPort[2] + "%\n";
        writer.write(output);
        writer.flush();
    }

    public void calculateSurvivalByClass(List<Passenger> passengers, FileWriter writer) throws IOException {
        int[] totalPassengersByClass = new int[3];
        int[] totalSurvivorsByClass = new int[3];

        for (Passenger passenger : passengers) {
            if (passenger.getPClass() == 1) {
                totalPassengersByClass[0]++;
                if (passenger.isSurvived()) {
                    totalSurvivorsByClass[0]++;
                }
            } else if (passenger.getPClass() == 2) {
                totalPassengersByClass[1]++;
                if (passenger.isSurvived()) {
                    totalSurvivorsByClass[1]++;
                }
            } else if (passenger.getPClass() == 3) {
                totalPassengersByClass[2]++;
                if (passenger.isSurvived()) {
                    totalSurvivorsByClass[2]++;
                }
            }
        }

        double[] percentageSurvivorsByClass = new double[3];

        for (int i = 0; i < 3; i++) {
            percentageSurvivorsByClass[i] = ((double) totalSurvivorsByClass[i] / (double) totalPassengersByClass[i]) * Constants.MAXIMUM_PERCENTAGE;
        }

        String output = "\nSurvival percentages by class (excluding crew members): \n";
        output += "Class 1 - "+  percentageSurvivorsByClass[0] + "%\n";
        output +="Class 2 - "+ percentageSurvivorsByClass[1] + "%\n";
        output +="Class 3 - "+ percentageSurvivorsByClass[2] + "%\n";

        writer.write(output);
        writer.flush();
    }

    public void calculateSurvivalByGender(List<Passenger> passengers, FileWriter writer) throws IOException {
        int totalMales = Constants.ZERO;
        int totalFemale = Constants.ZERO;
        int totalMaleSurvivors = Constants.ZERO;
        int totalFemaleSurvivors = Constants.ZERO;

        for (Passenger passenger : passengers) {
            if (passenger.getSex().equals("male")) {
                totalMales++;
                if (passenger.isSurvived()) {
                    totalMaleSurvivors++;
                }
            } else {
                totalFemale++;
                if (passenger.isSurvived()) {
                    totalFemaleSurvivors++;
                }
            }
        }

        double percentageMaleSurvivors = ((double) totalMaleSurvivors / (double) totalMales) * Constants.MAXIMUM_PERCENTAGE;
        double percentageFemaleSurvivors = ((double) totalFemaleSurvivors / (double) totalFemale) * Constants.MAXIMUM_PERCENTAGE;

        String output = "\nSurvival percentages by gender: \n";
        output += "Males - " + percentageMaleSurvivors + "%\n";
        output += "Females - " + percentageFemaleSurvivors + "%\n";
        writer.write(output);
        writer.flush();
    }
    private void displaySearchResults(List<Passenger> searchResults) {
        for (Passenger passenger : searchResults) {
            System.out.println(passenger.getName());
        }
    }

    private void writeToFile(List<Passenger> results) throws IOException {
        File resultsFile = new File("search_results_" + System.currentTimeMillis() + ".txt");
        FileWriter fileWriter = new FileWriter(resultsFile);
        for (Passenger passenger : results) {
            fileWriter.write(passenger.toString() + '\n');
        }
        fileWriter.close();
    }
}