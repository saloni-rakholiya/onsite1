package com.example.myrectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class custom2 extends View {

    private RectF mRect;

    private Paint mColor;
    private Rect mrect,newrect;
    private Paint mpaint;
    private Paint newpaint;
    int rwidth,rheight;
    float hw,hr;
    float midx,midy;
    float x1=100f,x2=100f,y1=200f,y2=200f;
    float width=50f,height=50f;
    int k=0;
    private boolean counter=true;
    private float newrectwidth, newrectheight;
    private Rect mybase;
    private Paint basec;
   /* private boolean counter = true;*/

    public custom2(Context context) {
        super(context);


        init(null);
    }

    public custom2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public custom2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public custom2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    private void init(@Nullable AttributeSet set)
    {


        mrect=new Rect();
        newrect=new Rect();
        mRect = new RectF();
        mpaint=new Paint();
        mybase = new Rect();
        newpaint=new Paint();
        rwidth=300;
        rheight=400;
        mColor = new Paint(Paint.ANTI_ALIAS_FLAG);
        basec = new Paint(Paint.ANTI_ALIAS_FLAG);
        basec.setColor(Color.BLUE);
        mColor.setColor(Color.GREEN);
        newrectwidth = 300;
        newrectheight = 300;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

          canvas.drawColor(Color.BLACK);

          hw=newrectwidth/2;
          hr=newrectheight/2;

   /*    mrect.left=10;
        mrect.top=10;
        mrect.right=mrect.left+100;
        mrect.bottom=mrect.top+100;*/

        mpaint.setColor(Color.RED);

        if (counter==true) {
            mRect.top=(float)getHeight()/2-newrectheight/2;
            mRect.bottom=(float)getHeight()/2+newrectheight/2;
              /* height=midy-y;
                        mrect.left=(int)(midx-width);
                        mrect.right=(int)(midx+width);
                        mrect.top=(int)(midy-height);
                        mrect.bottom=(int)(midy+height);}*/
            mRect.left=(float)getWidth()/2-newrectwidth/2;
            mRect.right=(float)getWidth()/2+newrectwidth/2;
        }
        /*if(x1==0 && y1==0 && x2==0 && y2==0)*/
        // { x1=100;x2=100;y1=200;y2=200;}
        canvas.drawRect(mRect,mColor);


        if(counter==true)
        { mybase.top=(int)(getHeight()/2-newrectheight/2);
            mybase.bottom=(int)(getHeight()/2+newrectheight/2);
            mybase.left=(int)(getWidth()/2-newrectwidth/2);
            /* height=midy-y;
                        mrect.left=(int)(midx-width);
                        mrect.right=(int)(midx+width);
                        mrect.top=(int)(midy-height);
                        mrect.bottom=(int)(midy+height);}*/
            mybase.right = (int)(getWidth()/2+newrectwidth/2);}
        canvas.drawRect(mybase, basec);

        if(k==0)
        { canvas.drawRect(100,100,200,200,mpaint);
            x1=100;x2=100;y1=200;y2=200;}
        else if(k==1)
        {
            canvas.drawRect(midx-width+10,midy-height+10,midx+width+10,midy+height+10,mpaint);
        }
        else if(k==2)
           { canvas.drawRect(mrect,mpaint);}

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean val = super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:{

            }

            case MotionEvent.ACTION_MOVE: {

                if (x>mRect.left-20 && x<mRect.left+20 &&y>mRect.top && y<mRect.bottom && x + 20 < mRect.right) {
                    newrectwidth = mRect.right - x;
                    mRect.left = x;
                    mybase.left = (int) x;
                    counter = false;
                    postInvalidate();
                    return true;
                }

              /*  if((x>newrect.left && x<newrect.right)&&(y>newrect.bottom && y<newrect.bottom+20) && y>newrect.top+20)
                {
                    rheight= (int) (y-newrect.top);
                    newrect.bottom= (int) y;
                    counter=false;
                    postInvalidate();

                    return true;
                }*/



                if (x>mRect.right-20 && x<mRect.right+20 &&y>mRect.top && y<mRect.bottom && mRect.left + 20 < x) {
                    mRect.right=x;
                    mybase.right=(int)x;newrectwidth=x-mRect.left;
                    counter=false;
                    postInvalidate();
                    return true;
                }



                // x>80 && x<100 && y>100 &&y<200

                if (y>mRect.bottom-20 && y<mRect.bottom+20 &&x>mRect.left && x<mRect.right && mRect.top + 20 < y) {
                    newrectheight=y-mRect.top;
                    mRect.bottom=y;mybase.bottom=(int)y;
                    counter=false;
                    postInvalidate();
                    return true;
                }

                if (y>mRect.top-20 && y<mRect.top+20&& x>mRect.left && x<mRect.right && y + 20< mRect.bottom) {
                    newrectheight = mRect.bottom - y;
                    mRect.top=y;mybase.top=(int)y;
                    counter=false;
                    postInvalidate();
                    return true;
                }




                if (x>mRect.left+20&& x<mRect.right-20 &&y>mRect.top+20 && y<mRect.bottom-20)
                {
                    mRect.top=y-newrectheight/2;
                  mRect.bottom=y+newrectheight/2;
                  //here
                    mybase.bottom=(int)(y+newrectheight/2);
                    mybase.left=(int)(x-newrectwidth/2);
                    mRect.left=x-newrectwidth/2;
                    mRect.right=x+newrectwidth/2;
                    mybase.top=(int)(y-newrectheight/2);
                    mybase.right=(int)(x+newrectwidth/2);
                    counter=false;
                    //tohereend
                    postInvalidate();
                    return true;
                }

//k==0 && x>midx-70 && x<midx-50 && y>midy-50&&y<midy+50
                if( x>midx-width-60 && x<midx-width && y>midy-height&&y<midy+height)
                {
                    k=2;

                    //midx=midx+x;

                    {
                        width=midx-x;
                        mrect.left=(int)(midx-width);
                        mrect.right=(int)(midx+width);
                        mrect.top=(int)(midy-height);
                        mrect.bottom=(int)(midy+height);}



                    postInvalidate();
                    return true;
                }
                else   if( x>midx+width && x<midx+width+60 && y>midy-height&&y<midy+height)
                {
                    k=2;

                    //midx=midx+x;

                    {
                        width=x-midx;
                        mrect.left=(int)(midx-width);
                        mrect.right=(int)(midx+width);
                        mrect.top=(int)(midy-height);
                        mrect.bottom=(int)(midy+height);}



                    postInvalidate();
                    return true;
                }
                else if(x>midx-width &&x<midx+width && y>midy-height-60 && y<midy-height)
                {
                    k=2;
                    {
                        height=midy-y;
                        mrect.left=(int)(midx-width);
                        mrect.right=(int)(midx+width);
                        mrect.top=(int)(midy-height);
                        mrect.bottom=(int)(midy+height);}

                    postInvalidate();
                    return true;

                }

                else if(x>midx-width &&x<midx+width && y>midy+height && y<midy+height+60)
                {
                    k=2;
                    {
                        height=y-midy;
                        mrect.left=(int)(midx-width);
                        mrect.right=(int)(midx+width);
                        mrect.top=(int)(midy-height);
                        mrect.bottom=(int)(midy+height);}

                    postInvalidate();
                    return true;

                }

                else  if(k!=0 && x>midx-width && x<midx+width && y<midy+height && y>midy-height)
                {
                    k=1;
                    midx=x;
                    midy=y;
                    postInvalidate();
                    return true;
                }


                else if(k==0 && x>100 && x<200 && y>100 &&y<200)
                {   k=1;
                    midx=x;midy=y;
                /*    x1=x+100;
                    y1=y+100;
                    x2=x+200;
                    y2=y+200;*/

                    postInvalidate();
                    return true;
                }

                return val;
            }
        }
        return val;
    }
    }

