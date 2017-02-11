/**
 * 
 */
package lumaCalculation;

import java.awt.Color;

/** A 'LumaModel' represents a luminosity mathematical function that is based upon
 * a weighted sum of the R-G-B values for a color.
 * 
 * @author aarongaba
 *
 */
public class LumaModel {

	/**
	 * The weight of red component in the RGB color space
	 */
	private double redWeight;
	
	/**
	 * The weight of the green component in the RGB color space
	 */
	private double greenWeight;
	
	/**
	 * The weight of the blue component in the RGB color space
	 */
	private double blueWeight;
	
	/**
	 * Constructs a luminosity mathematical functions with the given R-G-B weights.
	 * Each weight must be non-negative and their sum must be one.
	 * @param redWeight - The weight of the red component
	 * @param greenWeight - The weight of the green component
	 * @param blueWeight - The weight of the blue component
	 */
	public LumaModel(double redWeight, double greenWeight, double blueWeight) {
		//Check that all weights are non-negative
		//Then check that all weights equal 1.0
		if ((redWeight < 0) || (greenWeight < 0) || (blueWeight < 0)) {
			throw new IllegalArgumentException("Cannot have negative weight(s) in luminosity model.");
		} else if ((redWeight + greenWeight + blueWeight) != 1.0) {
			throw new IllegalArgumentException("Sum of weights must be equal to 1.0");
		} else {
			this.redWeight = redWeight;
			this.greenWeight = greenWeight;
			this.blueWeight = blueWeight;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LumaModel [redWeight=" + redWeight + ", greenWeight=" + greenWeight + ", blueWeight=" + blueWeight
				+ "]";
	}

	/**
	 * @return the redWeight
	 */
	public double getRedWeight() {
		return redWeight;
	}

	/**
	 * @return the greenWeight
	 */
	public double getGreenWeight() {
		return greenWeight;
	}

	/**
	 * @return the blueWeight
	 */
	public double getBlueWeight() {
		return blueWeight;
	}
	
	/**
	 * Given a color, compute its (perceived) luminosity.
	 * @param myColor
	 * @return luma - The (perceived) luminosity of the given color.
	 */
	public double computeLuma(Color myColor) {
		double redComponent = (double) myColor.getRed() * this.redWeight;
		double greenComponent = (double) myColor.getGreen() * this.greenWeight;
		double blueComponent = (double) myColor.getBlue() * this.blueWeight;
		
		double luma = redComponent + greenComponent + blueComponent;
		return luma;
	}

}
