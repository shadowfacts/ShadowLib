package net.shadowfacts.shadowlib.util;

import java.util.Collection;
import java.util.function.ToIntFunction;

/**
 * Simple brute-force nearest-neighbor solver
 *
 * @author shadowfacts
 */
public class NearestColor {

	/**
	 * Find the nearest color to {@code needle} in {@code haystack}
	 * @param needle The color to find the nearest neighbor to, in RGB.
	 * @param haystack The collection of all values to search in.
	 *                 This should be kept small as this method uses a simple brute-force solution.
	 * @param toInt Function used to convert each {@code T} object to its corresponding color in RGB.
	 * @param <T> The entry object type.
	 * @return The closest color from {@code haystack} to {@code needle}
	 */
	public static <T> T find(int needle, T[] haystack, ToIntFunction<T> toInt) {
		int needleR = needle >> 16 & 255;
		int needleG = needle >> 8 & 255;
		int needleB = needle & 255;

		double minDist = Integer.MAX_VALUE;
		T min = null;

		for (T t : haystack) {
			int color = toInt.applyAsInt(t);
			int r = color >> 16 & 255;
			int g = color >> 8 & 255;
			int b = color & 255;

//			double dist = distance(needleR, needleG, needleB, r, g, b);

			double dist = Math.sqrt(
					Math.pow(needleR - r, 2) +
					Math.pow(needleG - g, 2) +
					Math.pow(needleB - b, 2)
			);

			if (dist < minDist) {
				minDist = dist;
				min = t;
			}
		}

		return min;
	}

	private static double distance(int r1, int g1, int b1, int r2, int g2, int b2) {
		int deltaR = r1 - r2;
		int deltaG = g1 - g2;
		int deltaB = b1 - b2;
		return Math.sqrt(
				2 * deltaR * deltaR +
				4 * deltaG * deltaG +
				2 * deltaB * deltaB
		);
	}

}
