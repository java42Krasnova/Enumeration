package telran.util;

public class Length implements Comparable<Length> {
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
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Length object = (Length) obj;
		if (object.unit != unit) {
			object = object.convert(unit);
		}
		return Math.abs(amount - object.amount) < FLT_EPSILON;

	}

	@Override
	public int compareTo(Length o) {
		// 1m>1mm
		// 10000m>1km
		// TODO !done
		if (o.unit != unit) {
			o = o.convert(unit);
		}
		if (Math.abs(amount - o.amount) < FLT_EPSILON) {
			return 0;
		}
		return Float.compare(amount, o.amount);
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		// TODO done
		return new Length(amount * this.unit.getValue() / unit.getValue(), unit);
	}

	/**
	 * return string with amount and length unit pinned to amount with no space
	 * Example 20M (string expression of length obj designed 20 meters)
	 */
	@Override
	public String toString() {
		// TODO DONE
		return String.format("%.2f", amount) + unit.toString();
	}

}
