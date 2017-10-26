package com.corax.transformations.contrast;

import java.awt.image.WritableRaster;

import com.corax.transformations.TransformationUtils;

/**
 * Contrast algorithm
 * 
 * @author Corax
 *
 */
class Contrast implements IContrast {
	private static final int STEP = 128;

	@Override
	public WritableRaster contrast(WritableRaster raster, float intensity) {
		if (raster == null) {
			throw new IllegalArgumentException();
		}

		int[] rgb = new int[3];
		intensity += 1.0f;
		WritableRaster target = raster.createCompatibleWritableRaster();

		for (int y = 0; y < raster.getHeight(); y++) {
			for (int x = 0; x < raster.getWidth(); x++) {
				raster.getPixel(x, y, rgb);

				rgb[0] = TransformationUtils.saturate((int) ((rgb[0] - STEP) * intensity + STEP));
				rgb[1] = TransformationUtils.saturate((int) ((rgb[1] - STEP) * intensity + STEP));
				rgb[2] = TransformationUtils.saturate((int) ((rgb[2] - STEP) * intensity + STEP));

				target.setPixel(x, y, rgb);
			}

		}
		return target;
	}

}
