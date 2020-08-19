package com.example.myrectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class customview extends View {

    private Rect mrect,newrect;
    private Paint mpaint;
    private Paint newpaint;
    int rwidth,rheight;
    float midx,midy;
     float x1=100f,x2=100f,y1=200f,y2=200f;
     float width=50f,height=50f;
     int k=0;
     private boolean counter=true;

    public customview(Context context) {
        super(context);
        init(null);

    }

    public customview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public customview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public customview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    private void init(@Nullable AttributeSet set)
    {
        mrect=new Rect();
        newrect=new Rect();
        mpaint=new Paint();

        newpaint=new Paint();
        rwidth=300;
        rheight=400;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      //  canvas.drawColor(Color.BLUE);


   /*    mrect.left=10;
        mrect.top=10;
        mrect.right=mrect.left+100;
        mrect.bottom=mrect.top+100;*/

   newpaint.setColor(Color.BLUE);
        mpaint.setColor(Color.RED);
       // canvas.drawRect(mrect,mpaint);


if(counter){
    newrect.top = (int) getHeight() / 2 - rheight / 2;
    newrect.bottom = (int) getHeight() / 2 + rheight / 2;
    newrect.left = (int) getWidth() / 2 - rwidth / 2;
    newrect.right = (int) getWidth() / 2 + rwidth / 2;
}

        canvas.drawRect(newrect,newpaint);
/*if(x1==0 && y1==0 && x2==0 && y2==0)*/
  // { x1=100;x2=100;y1=200;y2=200;}
     if(k==0)
         { canvas.drawRect(100,100,200,200,mpaint);
             x1=100;x2=100;y1=200;y2=200;}
      else if(k==1)
          {canvas.drawRect(midx-width+10,midy-height+10,midx+width+10,midy+height+10,mpaint);
          }
      else if(k==2)
         canvas.drawRect(mrect,mpaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value= super.onTouchEvent(event);

        float forxtouch,forytouch;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
//                return true;
            }

            case MotionEvent.ACTION_MOVE:{

                float x=event.getX();
                float y=event.getY();

                //formoving
                if((x<newrect.left-20 && x<newrect.left+20)&&(y>newrect.top && y<newrect.bottom) && x+20<newrect.right)
                {
                    rwidth= (int) (newrect.right-x);
                    newrect.left= (int) x;
                    counter=false;
                    postInvalidate();

                    return true;
                }

                if((x>newrect.right-20 && x<newrect.right+20)&&(y>newrect.top && y<newrect.bottom) && x>newrect.left+20)
                {
                    rwidth= (int) (x=newrect.left);
                    newrect.right= (int) x;
                    counter=false;
                    postInvalidate();

                    return true;
                }
                if((x>newrect.left && x<newrect.right)&&(y>newrect.top-20 && y<newrect.top+20) && y+20<newrect.bottom)
                {
                    rheight= (int) (newrect.bottom-y);
                    newrect.top= (int) y;
                    counter=false;
                    postInvalidate();

                    return true;
                }
                if((x>newrect.left && x<newrect.right)&&(y>newrect.bottom && y<newrect.bottom+20) && y>newrect.top+20)
                {
                    rheight= (int) (y-newrect.top);
                    newrect.bottom= (int) y;
                    counter=false;
                    postInvalidate();

                    return true;
                }




                    //formoving



                    // x>80 && x<100 && y>100 &&y<200
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



            }

return value;
        }
        return value;
    }
}
