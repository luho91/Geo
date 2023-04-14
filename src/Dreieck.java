import java.text.DecimalFormat;

/**
 * A triangle is a shape ({@link Figur}) that also has three sides ({@link #seiteA}, {@link #seiteB}, {@link #seiteC}).
 */
public class Dreieck extends Figur {

    private double seiteA;
    private double seiteB;
    private double seiteC;

    /**
     * Constructor adding sides a, b, c to every triangle, getting {@link #getFarbe()} from super.
     *
     * @param farbe The color of this shape.
     * @param a Side "a" of this triangle.
     * @param b Side "b" of this triangle.
     * @param c Side "c" of this triangle.
     */
    public Dreieck(String farbe, double a, double b, double c) {
        super(farbe);
        this.seiteA = a;
        this.seiteB = b;
        this.seiteC = c;
    }

    public double getSeiteA() {
        return this.seiteA;
    }
    public double getSeiteB() {
        return this.seiteB;
    }
    public double getSeiteC() {
        return this.seiteC;
    }

    public void setSeiteA(double seiteA) {
        this.seiteA = seiteA;
    }
    public void setSeiteB(double seiteB) {
        this.seiteB = seiteB;
    }
    public void setSeiteC(double seiteC) {
        this.seiteC = seiteC;
    }

    /**
     * Calculates the angle alpha according to the given sides.
     *
     * @return The triangle object's angle alpha.
     */
    public double alpha() {
        return Math.acos(((seiteC * seiteC) + (seiteB * seiteB) - (seiteA * seiteA)) / (2 * seiteB * seiteC));
    }

    /**
     * Calculates the angle beta according to the given sides.
     *
     * @return The triangle object's angle beta.
     */
    public double beta() {
        return Math.acos(((seiteA * seiteA) + (seiteC * seiteC) - (seiteB * seiteB)) / (2 * seiteA * seiteC));
    }

    /**
     * Calculates the angle gamma according to the given sides.
     *
     * @return The triangle object's angle gamma.
     */
    public double gamma() {
        return Math.acos(((seiteA * seiteA) + (seiteB * seiteB) - (seiteC * seiteC)) / (2 * seiteA * seiteB));
    }

    /**
     * Calculates the height on {@link #seiteA}.
     *
     * @return The height A.
     */
    public double hoeheA() {
        return this.getSeiteC() * Math.sin(beta());
    }

    /**
     * Calculates the height on {@link #seiteB}.
     *
     * @return The height B.
     */
    public double hoeheB() {
        return this.getSeiteC() * Math.sin(alpha());
    }

    /**
     * Calculates the height on {@link #seiteC}
     *
     * @return The height C.
     */
    public double hoeheC() {
        return this.getSeiteA() * Math.sin(beta());
    }

    /**
     * Calculates the triangle object's circumference using its three sides.
     *
     * @return The object's circumference.
     */
    @Override
    public double umfang() {
        return this.getSeiteA() + this.getSeiteB() + this.getSeiteC();
    }

    /**
     * Calculates the triangle object's area using (?)
     *
     * @return The object's area.
     */
    @Override
    public double flaeche() {
        return 0.5 * this.getSeiteC() * this.hoeheC();
    }

    /**
     * @return A human-readable description of the current triangle object.
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        String result = getFarbe() + "Dreieck Seitenlänge A: " + getSeiteA() + " B: "
                + getSeiteB() + " C: " + getSeiteC() + "\n";

        result += istDreieck()
                ? "Dreieck Winkel Alpha: " + df.format(grad(alpha())) + "°" + " Beta: " +
                df.format(grad(beta())) + "°" + " Gamma: " + df.format(grad(gamma())) +
                "° \n" + "Dreieck Höhen h_a: " + df.format(hoeheA()) + " h_b: " +
                df.format(hoeheB()) + " h_c: " + df.format(hoeheC()) + "\n" +
                "Dreiecksumfang: " + df.format(umfang()) + "\n" + "Dreiecksfläche: " +
                df.format(flaeche()) + "\u001B[0m"
                :
                "Keine gültigen Seitenlängen für ein Dreieck.";
        return result;
    }

    /**
     * Calculate a rad value to degrees.
     *
     * @param rad The value in rad to be changed to degrees.
     * @return The calculated result in degrees.
     */
    public double grad(double rad) {
        return rad / Math.PI * 180;
    }

    /**
     * Determines whether the given sides can form a proper triangle or not.
     *
     * @return The result of checking the sides for proper triangle lengths.
     */
    public boolean istDreieck() {
        return alpha() != 0 && beta() != 0 && gamma() != 0 && !Double.isNaN(alpha()) && !Double.isNaN(beta()) && !Double.isNaN(gamma());
    }
}
