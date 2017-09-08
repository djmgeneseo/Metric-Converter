package com.example.metricconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
        1m = 39.3701 in
    */

    private Button convertButton;
    private EditText enterMeters;
    private TextView inchesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = (Button) findViewById(R.id.convertButtonId);
        enterMeters = (EditText) findViewById(R.id.metersText);
        inchesTextView = (TextView) findViewById(R.id.inchesTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Conversion logic
                double multiplier = 39.37;
                double result = 0.0;

                // Check if meters field is empty
                if (enterMeters.getText().toString().equals("")) {
                    inchesTextView.setTextColor(Color.RED);
                    inchesTextView.setText(R.string.error_message);
                }else {
                    inchesTextView.setTextColor(Color.DKGRAY);
                    // Convert string (from EditText) into double
                    double meterValue = Double.parseDouble(enterMeters.getText().toString());
                    result = meterValue*multiplier;

                    // Convert string to double. TextView must ALWAYS be passed a string
                    //inchesTextView.setText(Double.toString(result)+ " Inches");
                    // Format result to two decimal places (TEST: 4555)
                    inchesTextView.setText(String.format("%.2f", result) + " Inches");
                }

            }
        }); // OnClickListener

    }
}
