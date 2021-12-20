package telran.util;

public class Length implements Comparable<Length> {
	// V.R. Cool! Exactly so!
	private static final float FLT_EPSILON = 0.00001f;
	float amount;
	LengthUnit unit;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	/**
	 * equals two length objects according to LengthUnit 10m == 10000mm
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO done!
		if(obj == null ||!getClass().equals(obj.getClass())) {
			return false;
		}
		/* V.R.
		 * 1. The casting has to be placed AFTER cheking
		 * 2. The compateTo call is unnecessary
		 */
		Length object = (Length) obj;
		if (this == obj || compareTo(object) == 0) {
			return true;
		}
		/* V.R.
		 *  It is better to convert only objects have to be converted. Foe example,
		 *  if(object.unit != unit) {
		 *		object = object.convert(unit);
		 *	}
		 */
		return Math.abs(this.amount - object.convert(this.unit).amount) < FLT_EPSILON;
	}

	@Override
	public int compareTo(Length o) {
		// 1m>1mm
		// 10000m>1km
		// TODO !done
		// V.R. ??? Math.abs()
		// V.R. Pay attention to using this!
		return this.unit == o.unit ? Float.compare(this.amount, o.amount):
			Float.compare(amount, o.convert(unit).amount);
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		// TODO done
		return new Length(amount * this.unit.getValue()/ unit.getValue(), unit);
	}

	/**
	 * return string with amount and length unit pinned to amount with no space
	 * Example 20M (string expression of length obj designed 20 meters)
	 */
	@Override
	public String toString() {
		// TODO DONE
	return String.format("%.2f", this.amount) + this.unit.toString();
	}

}
