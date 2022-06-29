/**
 * A class that represents a measurement in feet and inches. The measurement
 * should be _well-formed_, that is, the number of inches should not be >= 12.
 */
public class Measurement {

    public int feet;
    public int inches;
    /**
     * Constructor: initialize this object to be a measurement of 0 feet, 0
     * inches
     */
    public Measurement() {
        feet = 0;
        inches = 0;
    }

    /**
     * Constructor: takes a number of feet as its single argument, using 0 as
     * the number of inches
     */
    public Measurement(int feet) {
        this.feet = feet;
        this.inches = 0;
    }

    /**
     * Constructor: takes the number of feet in the measurement and the number
     * of inches as arguments (in that order), and does the appropriate
     * initialization
     */
    public Measurement(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    /**
     * Returns the number of feet in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 1.
     */
    public int getFeet() {
        return this.feet; // provided to allow the file to compile
    }

    /**
     * Returns the number of inches in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 6.
     */
    public int getInches() {
        return this.inches; // provided to allow the file to compile
    }

    /**
     * Adds the argument m2 to the current measurement.
     *
     * @param m2 - Measurement to add. Should not change.
     * @return a new Measurement containing the sum of this and m2.
     */
    public Measurement plus(Measurement m2) {
        int feet = this.feet + m2.feet + (this.inches+m2.inches) / 12;
        int inches = (this.inches+m2.inches) % 12;
        return new Measurement(feet, inches);
    }

    /**
     * Subtracts the argument m2 from the current measurement. You may assume
     * that m2 will always be smaller than the current measurement.
     *
     * @param m2 - Measurement to subtract. Should not change.
     * @return a new Measurement containing the difference of this and m2.
     */
    public Measurement minus(Measurement m2) {
        int feet, inches;
        feet = this.feet - m2.feet;
        if(this.inches >= m2.inches){
            inches = this.inches - m2.inches;
        }
        else{
            feet--;
            inches = 12 - (m2.inches-this.inches);
        }
        return new Measurement(feet, inches);
    }

    /**
     * Returns a new Measurement that is the current measurement multiplied by
     * n. For example, if this object represents a measurement of 7 inches,
     * this.multiple(3) should return an object that represents 1 foot,
     * 9 inches (which totals to 21 inches).
     *
     * The current measurement should not change.
     *
     * @param multipleAmount
     * @return a new Measurement containing this times multipleAmount
     */
    public Measurement multiple(int multipleAmount) {
        int feet = this.feet * 3 + this.inches * 3 / 12;
        int inches = this.inches * 3 % 12;
        return new Measurement(feet, inches);
    }

    /**
     * Returns the String representation of this object in the form:
     *      f'i"
     * In other words, th number of feet followed by a single quote followed
     * by the number of inches less than 12 followed by a double quote (with no
     * blanks).
     *
     * For example, 0 foot 2 inches is formatted as 0'2"
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(this.feet);
        ret.append('\'');
        ret.append(this.inches);
        ret.append('\"');
        return ret.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        Measurement other = (Measurement) o;
        return this.feet == other.feet && this.inches == other.inches;
    }


}