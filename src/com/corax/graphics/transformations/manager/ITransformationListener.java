package com.corax.graphics.transformations.manager;

import java.awt.image.WritableRaster;

import com.corax.graphics.callers.IProcessingInvoker;

/**
 * Interface that represent listener, which implementation invokes after every transformation in multiple transformation routine 
 * @author Corax
 *
 */
public interface ITransformationListener {
	/**
	 * Routine after transformation
	 * 
	 * @param transformationInvoker
	 * @param result
	 */
	void action(IProcessingInvoker transformationInvoker, WritableRaster result);
}
