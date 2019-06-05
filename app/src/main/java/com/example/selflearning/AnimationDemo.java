package com.example.selflearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class AnimationDemo extends AppCompatActivity implements View.OnClickListener {
    private Button btnTransparent;
    private Button btnRotate;
    private Button btnMove;
    private Button btnZoom;
    private Button btnMix;
    private Button btnCustom;
    private AlphaAnimation alphaAnimation;
    private RotateAnimation rotateAnimation;
    private TranslateAnimation translateAnimation;
    private ScaleAnimation scaleAnimation;
    private CustomAnimation customAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);
        setTitle(getIntent().getStringExtra("title"));

        btnTransparent = findViewById(R.id.btn_transparent);
        btnTransparent.setOnClickListener(this);
//                alphaAnimation = new AlphaAnimation(0, 1);
//                alphaAnimation.setDuration(500);
        btnRotate = findViewById(R.id.btn_rotate);
        btnRotate.setOnClickListener(this);
//                    rotateAnimation = new RotateAnimation(0, 360,
//                            Animation.RELATIVE_TO_SELF, 0.5f,
//                            Animation.RELATIVE_TO_SELF, 0.5f);
//                    rotateAnimation.setDuration(500);
        btnMove = findViewById(R.id.btn_move);
        btnMove.setOnClickListener(this);
//        translateAnimation = new TranslateAnimation(0, 200, 0, 200);
//        translateAnimation.setDuration(500);
        btnZoom = findViewById(R.id.btn_zoom);
        btnZoom.setOnClickListener(this);
//        scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f);
//        scaleAnimation.setDuration(500);
        btnMix = findViewById(R.id.btn_mix);
        btnMix.setOnClickListener(this);
        btnCustom = findViewById(R.id.btn_custom_anim);
        btnCustom.setOnClickListener(this);
        customAnimation = new CustomAnimation();
        customAnimation.setDuration(500);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_transparent:
//                btnTransparent.startAnimation(alphaAnimation);
                btnTransparent.startAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.trans_animation));

                break;
            case R.id.btn_rotate:
//                    rotateAnimation = new RotateAnimation(0, 360,
//                            Animation.RELATIVE_TO_SELF, 0.5f,
//                            Animation.RELATIVE_TO_SELF, 0.5f);
//                    rotateAnimation.setDuration(500);
//                    btnRotate.startAnimation(rotateAnimation);
                btnRotate.startAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.rotate_animation));
                break;
            case R.id.btn_move:
//                    btnMove.startAnimation(translateAnimation);
                btnMove.startAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.move_animation));
                break;
            case R.id.btn_zoom:
//                    btnZoom.startAnimation(scaleAnimation);
                btnZoom.startAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.zoom_animation));
                break;
            case R.id.btn_mix:
                Animation animation = AnimationUtils.loadAnimation(this,
                        R.anim.mixed_animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(AnimationDemo.this, "Animation Ended!",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btnMix.startAnimation(animation);
                break;
            case R.id.btn_custom_anim:
                btnCustom.startAnimation(customAnimation);
                break;
        }
    }
}
