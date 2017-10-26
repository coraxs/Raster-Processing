package com.corax.transformations.posterize;

import java.awt.image.WritableRaster;

import com.corax.transformations.callers.ITransformationInvoker;

/**
 * Invokes posterization transformation
 * 
 * @author Corax
 *
 */
public class PosterizeInvoker implements ITransformationInvoker {
	/**
	 * Default posterization algorithm
	 */
	public static final IPosterize DEFAULT_POSTERIZATION = new Posterize();
	
	private float posterizeIntensity;
	private IPosterize posterization;
	
	
	/**
	 * Constructor
	 * 
	 * @param posterization posterization algorithm
	 * @param posterizeIntensity posterization intensity
	 */
	public PosterizeInvoker(IPosterize posterization, float posterizeIntensity) {
		super();
		if (posterization == null) {
			throw new IllegalArgumentException();
		}
		if (posterizeIntensity < 0.0f || posterizeIntensity > 1.0f) {
			throw new IllegalArgumentException();
		}
		this.posterizeIntensity = posterizeIntensity;
		this.posterization = posterization;
	}

	/**
	 * Constructor.
	 * 
	 * @param posterizeIntensity posterization intensity
	 */
	public PosterizeInvoker(float posterizeIntensity) {
		this(DEFAULT_POSTERIZATION, posterizeIntensity);
	}


	@Override
	public WritableRaster transform(WritableRaster source) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		return posterization.posterize(source, posterizeIntensity);
	}

}
