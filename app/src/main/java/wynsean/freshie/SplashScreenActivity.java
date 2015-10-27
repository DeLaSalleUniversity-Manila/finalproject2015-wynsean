package wynsean.freshie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startAnimating();
    }

    private void startAnimating() {
        // Fade in top title
        TextView logo1 = (TextView) findViewById(R.id.textViewSplashScreenTitle);
        Animation fade1 = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.fade_in);
        logo1.startAnimation(fade1);
        // Fade in bottom title after a built-in delay.
        ImageView logo2 = (ImageView) findViewById(R.id.imageViewSplashScreenLogo);
        Animation fade2 = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.fade_in2);
        logo2.startAnimation(fade2);
        // Transition to Main Menu when bottom title finishes animating
        fade2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                // The animation has ended, transition to the Main Menu screen
                Intent i = new Intent(SplashScreenActivity.this,
                        MainMenu.class);
                startActivity(i);
                SplashScreenActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }


        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        // Stop the animation
        TextView logo1 = (TextView) findViewById(R.id.textViewSplashScreenTitle);
        logo1.clearAnimation();
        ImageView logo2 = (ImageView) findViewById(R.id.imageViewSplashScreenLogo);
        logo2.clearAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Start animating at the beginning so we get the full splash screen
        // experience
        startAnimating();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
