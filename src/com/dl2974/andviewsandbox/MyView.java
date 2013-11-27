package com.dl2974.andviewsandbox;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;




public class MyView extends View {
	
	
	 public MyView(Context context, AttributeSet attrs) {
	        super(context, attrs);
	        requestFocus();
	        setBackgroundDrawable( getResources().getDrawable(R.drawable.shape) );
	        
	 }
	 
	 
	 
	 @Override
	 protected void onDraw(Canvas canvas) {
	        super.onDraw(canvas);
	        
	        Paint mPaint = new Paint();
	        mPaint.setColor(0xFFFFFFFF);
            mPaint.setTextSize(26);
	        
	        Date timeNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	        String msg = ft.format(timeNow);
	        
	        canvas.drawText(msg, 0, msg.length(), 50, 150, mPaint);
	        
	 }
	
	
}