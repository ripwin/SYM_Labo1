package ch.heigvd.sym.template;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class SuccessActivity extends AppCompatActivity {

    // For logging purposes
    private static final String TAG = SuccessActivity.class.getSimpleName();

    private TextView email = null;
    private TextView imei = null;
    private ImageView mImageView;
    private Button sendData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        this.email = (TextView) findViewById(R.id.email);
        this.imei  = (TextView) findViewById(R.id.imei);
        this.sendData = (Button)findViewById(R.id.sendDataBack);

        // Get email from MainActivity
        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        // Display email
        this.email.setText(text);

        TelephonyManager tel =
            (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        this.imei.setText(tel.getDeviceId());

        // Display image
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(path, "dead.jpg");
        mImageView = (ImageView) findViewById(R.id.imageViewId);
        mImageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));

        /*
            Question 4: Register a listener to send data back to the MainActivity.
         */
        sendData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("activityResponse", "I come from the Success activity.");
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });

    }

    @Override
    protected void onPause(){
        Log.i(TAG,"SuccesActivity onPause");
        super.onPause();
    }

    @Override
    protected void onResume(){
        Log.i(TAG, "SuccesActivity onResume");
        super.onResume();
    }

    @Override
    protected void onStart(){
        Log.i(TAG, "SuccesActivity onStart");
        super.onStart();
    }

    @Override
    protected void onStop(){
        Log.i(TAG, "SuccesActivity onStop");
        super.onStop();
    }

    @Override
    protected void onRestart(){
        Log.i(TAG, "SuccesActivity onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy(){
        Log.i(TAG, "SuccesActivity onDestroy");
        super.onDestroy();
    }


}
