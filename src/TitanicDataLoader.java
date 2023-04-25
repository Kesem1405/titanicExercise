import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class TitanicDataLoader {
        private String pathToFile;

        public TitanicDataLoader(String pathToFile) {
            this.pathToFile = pathToFile;
        }

        public List<Passenger> loadPassengers() throws IOException {
            List<Passenger> passengers = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File(this.pathToFile))) {
                scanner.nextLine(); // skip header line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    int passengerId = Integer.parseInt(parts[0]);
                    int survived = Integer.parseInt(parts[1]);
                    int pClass = Integer.parseInt(parts[2]);
                    String name = parts[3];
                    String sex = parts[4];
                    double age = parts[5].isEmpty() ? 0.0 : Double.parseDouble(parts[5]);
                    int sibSp = Integer.parseInt(parts[6]);
                    int parch = Integer.parseInt(parts[7]);
                    String ticket = parts[8];
                    double fare = Double.parseDouble(parts[9]);
                    String cabin = parts[10];
                    String embarked = parts[11];
                    Passenger passenger = new Passenger(passengerId, survived, pClass, name, sex, age, sibSp, parch, ticket, fare, cabin, embarked);
                    passengers.add(passenger);
                }
            }
                return passengers;
            }


    private float parseAge(String ageStr) {
        if (ageStr.isEmpty()) {
            return -1; // Return -1 if age is missing
        }
        try {
            return Float.parseFloat(ageStr);
        } catch (NumberFormatException e) {
            System.err.println("Invalid age format: " + ageStr);
            return -1;
        }
    }
}