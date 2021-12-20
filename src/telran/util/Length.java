package telran.util;

public class Length implements Comparable<Length> {
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
		Length object = (Length) obj;
		if (this.unit == object.unit && Float.compare(this.amount, object.amount) == 0) {
			return true;
		}
		return Math.abs(this.amount - object.convert(this.unit).amount) < 0.00001;

	}

	@Override
	public int compareTo(Length o) {
		// 1m>1mm
		// 10000m>1km
		// TODO !done
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
