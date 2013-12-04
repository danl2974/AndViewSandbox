package com.dl2974.andviewsandbox;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;




public class MyView extends View {
	
	
	 public MyView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	        requestFocus();
	        
	        Bitmap bmp = Bitmap.createBitmap(300, 300, Config.ARGB_8888);
	        Random rgbRand = new Random();
	        for (int x = 0; x < 300; x += 1)
	        {	        	 
	        	 for (int y = 0; y < 300; y+=1){
	        		
	        	   if (y > 100 && y < 200 && x > 100 && x < 200)
	        	   {
	        	     bmp.setPixel(x, y, Color.rgb(rgbRand.nextInt() * 255,  0,  rgbRand.nextInt() * 255) );
	        	   }
	        	   else if(y <= 100)
	        	   {
	        		  bmp.setPixel(x, y, Color.rgb(0, rgbRand.nextInt() * 255, 0) ); 
	        	   }
	        	   else if(y >= 200)
	        	   {
	        		  bmp.setPixel(x, y, Color.rgb(rgbRand.nextInt() * 127, rgbRand.nextInt() * 128,  rgbRand.nextInt() * 127) ); 
	        	   }
	        	   else
	        	   {
	        	     bmp.setPixel(x, y, Color.rgb(rgbRand.nextInt() * 255,  rgbRand.nextInt() * 255, rgbRand.nextInt() * 255) );
	        	   }
	        	}
	        }

	        
	        
	        //setBackgroundDrawable( getResources().getDrawable(R.drawable.shape) );
	        setBackgroundDrawable( new BitmapDrawable(bmp) );
	        
	 }
	 
	 
	 
	 @Override
	 protected void onDraw(Canvas canvas) {
	        super.onDraw(canvas);
	        
	        Paint mPaint = new Paint();
	        mPaint.setColor(0xFFFFFFFF);
            mPaint.setTextSize(32);
            mPaint.setTypeface(Typeface.DEFAULT_BOLD);
	        
	        Date timeNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat ("E - MMM d, yyyy' at' h:mm:ss a");
	        ft.setTimeZone(TimeZone.getTimeZone("EST"));
	        String msg = ft.format(timeNow);
	        
	        canvas.drawText(msg, 0, msg.length(), 25, 150, mPaint);
	        
	        /*
	        Path path = new Path();
	        path.moveTo(10, 10);
	        
	        Random rand = new Random();
	        
	        Paint mPaint = new Paint();
	        mPaint.setColor(0xFFFFFFFF);
            mPaint.setTextSize(26);
	        
	        Date timeNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat ("E - MMM d, yyyy' at' h:mm:ss a");
	        ft.setTimeZone(TimeZone.getTimeZone("EST"));
	        String msg = ft.format(timeNow);
	        
	        canvas.drawText(msg, 0, msg.length(), 50, 150, mPaint);
	          
	        Paint mLinePaint = new Paint();
	        mLinePaint.setColor(0xFFFFFFFF);
	        mLinePaint.setStrokeWidth(1);
	        mLinePaint.setStyle(Style.STROKE);
	        
	        int endLines = getHeight();
	        
	        for (int i = 10; i <= endLines; i +=10){
	        	
	        canvas.drawLine(500, i, 600, i, mLinePaint);
	        
	        canvas.drawLine(10, i-5, 50, i-5, mLinePaint);
	        
	        path.lineTo((rand.nextFloat() * getWidth() ), (rand.nextFloat() * getHeight() ));
	        
	        
	        }
	        
	        canvas.drawPath(path, mLinePaint);
	        */
	 }
	 
	 
	 
	   @Override
	   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	        // Keep the view squared
	        int w = MeasureSpec.getSize(widthMeasureSpec);
	        int h = MeasureSpec.getSize(heightMeasureSpec);
	        //int d = w == 0 ? h : h == 0 ? w : w < h ? w : h;
	        setMeasuredDimension(w, h);
	    }
	
	
}