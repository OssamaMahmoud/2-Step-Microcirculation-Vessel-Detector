/*
 * #%L
 * Ridge Detection plugin for ImageJ
 * %%
 * Copyright (C) 2014 - 2015 Thorsten Wagner (ImageJ java plugin), 1996-1998 Carsten Steger (original C code), 1999 R. Balasubramanian (detect lines code to incorporate within GRASP)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


// TODO: Auto-generated Javadoc
/**
 * The Class Normal.
 */
public class Normal {

	/** The Constant SQRTPI. */
	private static final double SQRTPI = 1.772453850905516027;

	/** The Constant UPPERLIMIT. */
	private static final double UPPERLIMIT = 20.0;

	/** The Constant P10. */
	private static final double P10 = 242.66795523053175;

	/** The Constant P11. */
	private static final double P11 = 21.979261618294152;

	/** The Constant P12. */
	private static final double P12 = 6.9963834886191355;

	/** The Constant P13. */
	private static final double P13 = -.035609843701815385;

	/** The Constant Q10. */
	private static final double Q10 = 215.05887586986120;

	/** The Constant Q11. */
	private static final double Q11 = 91.164905404514901;

	/** The Constant Q12. */
	private static final double Q12 = 15.082797630407787;

	/** The Constant Q13. */
	private static final double Q13 = 1.0;

	/** The Constant P20. */
	private static final double P20 = 300.4592610201616005;

	/** The Constant P21. */
	private static final double P21 = 451.9189537118729422;

	/** The Constant P22. */
	private static final double P22 = 339.3208167343436870;

	/** The Constant P23. */
	private static final double P23 = 152.9892850469404039;

	/** The Constant P24. */
	private static final double P24 = 43.16222722205673530;

	/** The Constant P25. */
	private static final double P25 = 7.211758250883093659;

	/** The Constant P26. */
	private static final double P26 = .5641955174789739711;

	/** The Constant P27. */
	private static final double P27 = -.0000001368648573827167067;

	/** The Constant Q20. */
	private static final double Q20 = 300.4592609569832933;

	/** The Constant Q21. */
	private static final double Q21 = 790.9509253278980272;

	/** The Constant Q22. */
	private static final double Q22 = 931.3540948506096211;

	/** The Constant Q23. */
	private static final double Q23 = 638.9802644656311665;

	/** The Constant Q24. */
	private static final double Q24 = 277.5854447439876434;

	/** The Constant Q25. */
	private static final double Q25 = 77.00015293522947295;

	/** The Constant Q26. */
	private static final double Q26 = 12.78272731962942351;

	/** The Constant Q27. */
	private static final double Q27 = 1.0;

	/** The Constant P30. */
	private static final double P30 = -.00299610707703542174;

	/** The Constant P31. */
	private static final double P31 = -.0494730910623250734;

	/** The Constant P32. */
	private static final double P32 = -.226956593539686930;

	/** The Constant P33. */
	private static final double P33 = -.278661308609647788;

	/** The Constant P34. */
	private static final double P34 = -.0223192459734184686;

	/** The Constant Q30. */
	private static final double Q30 = .0106209230528467918;

	/** The Constant Q31. */
	private static final double Q31 = .191308926107829841;

	/** The Constant Q32. */
	private static final double Q32 = 1.05167510706793207;

	/** The Constant Q33. */
	private static final double Q33 = 1.98733201817135256;

	/** The Constant Q34. */
	private static final double Q34 = 1.0;

	/** The Constant SQRT2. */
	private static final double SQRT2 = 1.41421356237309504880;

	/**
	 * Gets the normal.
	 *
	 * @param x
	 *            the x
	 * @return the normal
	 */
	public static double getNormal(double x) {
		int sn;
		double R1, R2, y, y2, y3, y4, y5, y6, y7;
		double erf, erfc, z, z2, z3, z4;
		double phi;

		if (x < -UPPERLIMIT)
			return 0.0;
		if (x > UPPERLIMIT)
			return 1.0;

		y = x / SQRT2;
		if (y < 0) {
			y = -y;
			sn = -1;
		} else
			sn = 1;

		y2 = y * y;
		y4 = y2 * y2;
		y6 = y4 * y2;

		if (y < 0.46875) {
			R1 = P10 + P11 * y2 + P12 * y4 + P13 * y6;
			R2 = Q10 + Q11 * y2 + Q12 * y4 + Q13 * y6;
			erf = y * R1 / R2;
			if (sn == 1)
				phi = 0.5 + 0.5 * erf;
			else
				phi = 0.5 - 0.5 * erf;
		} else if (y < 4.0) {
			y3 = y2 * y;
			y5 = y4 * y;
			y7 = y6 * y;
			R1 = P20 + P21 * y + P22 * y2 + P23 * y3 + P24 * y4 + P25 * y5 + P26 * y6 + P27 * y7;
			R2 = Q20 + Q21 * y + Q22 * y2 + Q23 * y3 + Q24 * y4 + Q25 * y5 + Q26 * y6 + Q27 * y7;
			erfc = Math.exp(-y2) * R1 / R2;
			if (sn == 1)
				phi = 1.0 - 0.5 * erfc;
			else
				phi = 0.5 * erfc;
		} else {
			z = y4;
			z2 = z * z;
			z3 = z2 * z;
			z4 = z2 * z2;
			R1 = P30 + P31 * z + P32 * z2 + P33 * z3 + P34 * z4;
			R2 = Q30 + Q31 * z + Q32 * z2 + Q33 * z3 + Q34 * z4;
			erfc = (Math.exp(-y2) / y) * (1.0 / SQRTPI + R1 / (R2 * y2));
			if (sn == 1)
				phi = 1.0 - 0.5 * erfc;
			else
				phi = 0.5 * erfc;
		}

		return phi;
	}

}
