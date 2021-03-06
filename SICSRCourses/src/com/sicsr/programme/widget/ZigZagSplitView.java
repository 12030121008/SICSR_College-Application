
package com.sicsr.programme.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sicsr.programme.R;

public class ZigZagSplitView extends View
{

	private static float height;
	private static float width;
	//private static final Boolean c = Boolean.valueOf(false);
	private int fill_color;
	private float pin_start_height;
	private float pin_height;
	private float pin_width;
	private boolean inverse;

	public ZigZagSplitView(Context context)
	{
		super(context);
		init(context, null);
	}

	public ZigZagSplitView(Context context, AttributeSet attributeset)
	{
		super(context, attributeset);
		init(context, attributeset);
	}

	public ZigZagSplitView(Context context, AttributeSet attributeset, int i)
	{
		super(context, attributeset, i);
		init(context, attributeset);
	}

	private void init(Context context, AttributeSet attributeset)
	{

		if(isInEditMode()){
			return;
		}
		/*height = 7F; //getResources().getDimension(R.dimen.margin);
		width = 10F;//getResources().getDimension(R.dimen.margin);
		fill_color =  getResources().getColor(R.color.fs_background_dark_green);
		pin_start_height = 0.5F;
		pin_height = height;
		pin_width = width;
		inverse = false;*/
		height = 7F;  
		width = 10F;
		TypedArray typedarray = context.obtainStyledAttributes(attributeset,R.styleable.ZigZagSplitView);
		try
		{
			fill_color = typedarray.getColor(R.styleable.ZigZagSplitView_fill_color, -1);
			pin_start_height = typedarray.getFloat(R.styleable.ZigZagSplitView_pin_height, 0.5F);
			pin_height = typedarray.getDimension(R.styleable.ZigZagSplitView_pin_height, height);
			pin_width = typedarray.getDimension(R.styleable.ZigZagSplitView_pin_height, width);
			inverse = typedarray.getBoolean(R.styleable.ZigZagSplitView_inverse, false);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			Log.getStackTraceString(exception);
			//Utils.log("ZigZagView Exception", Log.getStackTraceString(exception));
		}
		typedarray.recycle();
	}

	protected void onDraw(Canvas canvas)
	{
		int i;
		float f1;
		float f2;
		Paint paint;
		Path path;
		float f3;
		int j;
		float f4;
		i = 1;

		super.onDraw(canvas);

		f1 = getHeight();
		f2 = getWidth();
		paint = new Paint(i);
		paint.setColor(fill_color);
		paint.setStrokeWidth(1.0F);
		paint.setStyle(android.graphics.Paint.Style.FILL);
		path = new Path();
		f3 = f2 / 2.0F - pin_width * (float)Math.floor(f2 / 2.0F / pin_width);
		j = (int)Math.ceil(f2 / pin_width);
		f4 = pin_height;
		/*if (paddingBorder >= f / f1)
		{

			//break MISSING_BLOCK_LABEL_224;
		}*/
		path.moveTo(f3 - pin_width, 2.0F * pin_height);
		path.close();
		canvas.drawPath(path, paint);

		if (pin_start_height > 1.0F - pin_height / f1)
		{
			path.moveTo(f3 - pin_width, f1);
			while (i <= j + 1) 
			{
				f4 *= -1F;
				path.lineTo(f3 + (float)(i - 1) * pin_width, (f4 + f1) - pin_height);
				i++;
			}
		} else
		{
			path.moveTo(f3 - pin_width, f1 * pin_start_height + pin_height);
			while (i <= j + 1) 
			{
				f4 *= -1F;
				path.lineTo(f3 + (float)(i - 1) * pin_width, f4 + f1 * pin_start_height);
				i++;
			}
		}

		if (inverse)
		{
			path.lineTo(f2, 0.0F);
			path.lineTo(0.0F, 0.0F);
		} else
		{
			path.lineTo(f2, f1 + 1.0F);
			path.lineTo(0.0F, f1 + 1.0F);
		}
		path.close();
		canvas.drawPath(path, paint);
	}

	public void setFillColor(int i)
	{
		fill_color = i;
		invalidate();
	}

}
