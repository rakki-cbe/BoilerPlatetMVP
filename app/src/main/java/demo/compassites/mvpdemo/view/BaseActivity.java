package demo.compassites.mvpdemo.view;


import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public class BaseActivity extends AppCompatActivity {
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}