import java.text.DecimalFormat;

/**
 * A circle shape is a shape ({@link Figur}) that also has a {@link #radius}.
 */
public class Kreis extends Figur {
    private double radius;

    /**
     * Constructor adding radius to every circle, getting {@link #getFarbe()} from super.
     *
     * @param farbe The color of this shape.
     * @param radius The radius of this circle.
     */
    public Kreis(String farbe, double radius) {
        super(farbe);
        if (radius <= 0) {
            this.radius = 1;
        }
        else {
            this.radius = radius;
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the circumference using pi and the radius.
     *
     * @return The circle object's circumference.
     */
    @Override
    public double umfang() {
        return 2 * Math.PI * this.getRadius();
    }

    /**
     * Calculates the area using pi and the radius.
     *
     * @return The circle object's area.
     */
    @Override
    public double flaeche() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    /**
     * @return A human-readable description of the current circle object.
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        return getFarbe() + "Kreis mit dem Radius: " + getRadius() + "\n"
                + "Kreisumfang: " + df.format(umfang()) + "\n"
                + "Kreisfläche: " + df.format(flaeche()) + "\u001B[0m";
    }
}
