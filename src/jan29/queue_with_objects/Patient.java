package jan29.queue_with_objects;

public class Patient {

    private String name;

    private String idNumber;

    private int numberInLine;

    public Patient() {
        this("Unknown", "000000000", 0);
    }

    public Patient(String name, String idNumber) {
        this(name, idNumber, 0);
    }

    public Patient(String name, String idNumber, int numberInLine) {
        this.name = name;
        this.idNumber = idNumber;
        this.numberInLine = numberInLine;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getNumberInLine() {
        return this.numberInLine;
    }

    public void setNumberInLine(int numberInLine) {
        this.numberInLine = numberInLine;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Patient) {
            Patient otherPatient = ((Patient) other);
            boolean sameName = this.name.equals(otherPatient.name);
            boolean sameId = this.idNumber.equals(otherPatient.idNumber);
            boolean samePlace = this.numberInLine == otherPatient.numberInLine;
            return sameName && sameId && samePlace;
        } else {
            return super.equals(other);
        }
    }

    @Override
    public String toString() {
        return "{" + this.name + ", " + this.idNumber + ", " + this.numberInLine + "}";
    }

}
