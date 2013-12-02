package com.dl2974.andviewsandbox;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;




public class MyView extends View {
	
	
	 public MyView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	        requestFocus();
	        setBackgroundDrawable( getResources().getDrawable(R.drawable.shape) );
	        
	 }
	 
	 
	 
	 @Override
	 protected void onDraw(Canvas canvas) {
	        super.onDraw(canvas);
	        
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
	        
	        //path.lineTo((rand.nextFloat() * getWidth() ), (rand.nextFloat() * getHeight() ));
	        path.lineTo((rand.nextFloat() * getWidth() ), i);
	        
	        }
	        
	        canvas.drawPath(path, mLinePaint);
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