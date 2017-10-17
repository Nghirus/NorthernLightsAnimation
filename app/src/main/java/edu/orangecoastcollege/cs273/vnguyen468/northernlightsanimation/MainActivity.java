package edu.orangecoastcollege.cs273.vnguyen468.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //AnimationDrawable used for frame animation
    private AnimationDrawable frameAnim; // Currently null

    //Animation used for Tween animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View v)
    {
        if (frameAnim == null) {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View v)
    {
        if (rotateAnim == null)
        {
            rotateAnim = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
            //connect to imageview;
            lightsImageView.startAnimation(rotateAnim);
        }
        if (!rotateAnim.hasStarted() || rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim);
        else
            lightsImageView.clearAnimation();
    }

    public void toggleShakeAnim(View v)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }
}
