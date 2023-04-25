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

    public int getSurvived() {
        return survived;
    }

    public int getPClass() {
        return pClass;
    }

    public String getName() {
        return name;
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
    public String getFormattedName() {
        String[] nameParts = this.name.split(", ");
        return nameParts[1] + " " + nameParts[0];
    }

    // getters and setters
}