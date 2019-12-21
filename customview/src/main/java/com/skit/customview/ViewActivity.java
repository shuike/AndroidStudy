package com.skit.customview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skit.lib_common.base.BaseActivity;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/11/25.
 * PS:
 */
public class ViewActivity extends BaseActivity {
    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        //手指轻触并松开
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        //长按
        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        //按下并拖动
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        //按下触碰长按并松开
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        //手指轻触屏幕的一瞬间，尚未松开
        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        //手指轻触屏幕的一瞬间
        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }

        //双击
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return super.onDoubleTap(e);
        }

        //发生双击并松开
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            return super.onContextClick(e);
        }
    };
    private static final int MESSAGE_SCROLL_TO = 1;
    private static final int FRAME_COUNT = -300;
    private static final int DELAYED_TIME = 2;
    private int mCount = 0;

    private View view;
/*
    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MESSAGE_SCROLL_TO:
                    Toast.makeText(ViewActivity.this, "shoudaole", Toast.LENGTH_SHORT).show();
                    mCount++;
                    if (mCount >= FRAME_COUNT) {
                        float fraction = mCount / FRAME_COUNT;
                        int scrollX = (int) (fraction * 100);
                        view.scrollTo(scrollX, 0 );
                        mHandler.sendEmptyMessageDelayed(MESSAGE_SCROLL_TO, DELAYED_TIME);
                    }
                    break;
            }
            return false;
        }
    });
*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main_activity);
//        final GestureDetector gestureDetector = new GestureDetector(this, simpleOnGestureListener);
        view = findViewById(R.id.view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Message message = new Message();
//                message.what = MESSAGE_SCROLL_TO;
//                mHandler.sendMessage(message);
                Toast.makeText(ViewActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();

//                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
//                params.leftMargin += 100;
//                view.requestLayout();
//                view.setLayoutParams(params);
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"translationX",0,100).setDuration(1000);
//                objectAnimator.start();
                Animation animation = AnimationUtils.loadAnimation(ViewActivity.this,R.anim.view_translate);
                view.setAnimation(animation);
                view.startAnimation(animation);
            }
        });
//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return gestureDetector.onTouchEvent(event);
//            }
//        });
    }
}
