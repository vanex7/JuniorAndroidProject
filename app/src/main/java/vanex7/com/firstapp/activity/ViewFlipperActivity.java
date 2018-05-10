package vanex7.com.firstapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import vanex7.com.firstapp.R;


public class ViewFlipperActivity extends Activity {

    private static final int MIN_MOVE = 200;
    private ViewFlipper viewFlipper = null;
    private GestureDetector gestureDetector;
    private MyGestureListener myGestureListener = new MyGestureListener();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfippler);

        viewFlipper = findViewById(R.id.activity_viewflipper);
//        viewFlipper.startFlipping();
        gestureDetector = new GestureDetector(ViewFlipperActivity.this, myGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            int dist = (int) (e2.getX() - e1.getX());
            if (Math.abs(dist) > MIN_MOVE) {
                if (dist < 0) {
//                left to right
                    viewFlipper.setInAnimation(ViewFlipperActivity.this, R.anim.anim_viewflipper_right_in);
                    viewFlipper.setOutAnimation(ViewFlipperActivity.this, R.anim.anim_viewflipper_right_out);
                    viewFlipper.showNext();
                } else {
//                right to left
                    viewFlipper.setInAnimation(ViewFlipperActivity.this, R.anim.anim_viewflipper_left_in);
                    viewFlipper.setOutAnimation(ViewFlipperActivity.this, R.anim.anim_viewflipper_left_out);
                    viewFlipper.showPrevious();
                }
                return true;
            }
            return false;
        }
    }
}
