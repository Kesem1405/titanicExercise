
public class Passenger {
    private int passengerId;
    private int survived;
    private int pClass;
    private String name;
    private String sex;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;

    public int getPassengerId() {
        return passengerId;
    }

    public boolean isSurvived() {
        return this.survived == 1;
    }

    public int getPClass() {
        return pClass;
    }

    public String getSex() {
        return sex;
    }

    public double getAge() {
        return age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public int getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

        public Passenger(int passengerId, int survived, int pClass, String name, String sex, double age, int sibSp, int parch, String ticket, double fare, String cabin, String embarked) {
            this.passengerId = passengerId;
            this.survived = survived;
            this.pClass = pClass;
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.sibSp = sibSp;
            this.parch = parch;
            this.ticket = ticket;
            this.fare = fare;
            this.cabin = cabin;
            this.embarked = embarked;
        }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Pass ID-" + passengerId +
                ",  " + getName() +
                ", Sex - " + sex +
                ", Age -" + age +
                ", Class - " + pClass +
                ", Ticket - " + ticket +
                ", Fare - " + fare +
                ", Cabin -" + cabin +
                ", Port of Embarkation -" + embarked +
                ", Siblings/Spouses -" + sibSp +
                ", Parents/Children -" + parch +
                ", Survived - " + survived +
                "\n";
    }

    public Passenger(String line) {
        String[] parts = line.split(",");
       this.passengerId = Integer.parseInt(parts[0]);
        this.survived = Integer.parseInt(parts[1]);
        this.pClass = Integer.parseInt(parts[2]);
        String firstName = parts[4];
        String lastName = parts[3];
        this.name = getFormattedName(lastName,firstName);
       this.sex = parts[5];
       this.age = parts[6].isEmpty() ? 0.0 : Double.parseDouble(parts[6]);
        this.sibSp = Integer.parseInt(parts[7]);
        this.parch = Integer.parseInt(parts[8]);
        this.ticket = parts[9];
        this.fare = Double.parseDouble(parts[10]);
        this.cabin = parts[11];
        this.embarked = "";
        if(parts.length > 12){
            embarked = parts[12];
        }
    }

    private String getFormattedName(String lastName, String firstName) {
        firstName = firstName.substring(firstName.indexOf('.')+1).trim();
        String fullName = firstName.substring(0,firstName.length()-1) + " " + lastName.substring(1);
        fullName = fullName.replace("\"\"", "\"");
        return fullName;
    }
}