package com.corax.transformations.zoomblur;

import java.awt.image.WritableRaster;

public interface IZoomBlur {
	WritableRaster zoomBlur(WritableRaster source, float strenght);
}
