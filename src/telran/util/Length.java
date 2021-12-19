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
		return compareTo((Length) obj) == 0;
	}

	@Override
	public int compareTo(Length o) {
		// 1m>1mm
		// 10000m>1km
		// TODO !done
		// return Float.compare(amount, o.convert(unit).amount);
		return (int) (amount - o.convert(unit).amount);
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		// TODO done
		float lenght = (amount * this.unit.getValue()) / unit.value;
		return new Length(lenght, unit);
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
