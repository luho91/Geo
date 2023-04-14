/**
 * Abstract class for geometrical shapes.
 */
public abstract class Figur {

    private String farbe;

    /**
     * Constructor with color parameter.
     *
     * @param farbe The object's color.
     */
    public Figur(String farbe) {
        this.farbe = farbe;
    }

    /**
     * Getter for attribute {@link #farbe}.
     *
     * @return The object's current value of {@link #farbe}.
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * Setter for attribute {@link #farbe}.
     *
     * @param newColor The new color value.
     */
    public void setFarbe(String newColor) {
        this.farbe = newColor;
    }

    /**
     * Abstract method to calculate the shape's circumference.
     *
     * @return The calculated value of the shape's circumference.
     */
    public abstract double umfang();

    /**
     * Abstract method to calculate the shape's area.
     *
     * @return The calculated value of the shape's area.
     */
    public abstract double flaeche();

    /**
     * Abstract method to override the toString method.
     *
     * @return A human readable string describing the shape.
     */
    @Override
    public abstract String toString();
}
