package com.example.englishtometricconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //DECLARATION
    DecimalFormat formatDec = new DecimalFormat("#.##");

    double userNumber;
    int grpNum;
    double convertTotal;
    double convertRate;
    String groupChoice;
    String spinnerString;
    String userInputString;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// GET EVERYTHING GRAPHICALLY TO LINK UP TO THE BACK END
    final EditText number = (EditText)findViewById(R.id.txtNumber);
    final Spinner group = (Spinner)findViewById(R.id.txtGroup);
    final TextView result = ((TextView)findViewById(R.id.txtDisplay));

//And Then......
    Button convert = (Button)findViewById(R.id.btnConvert);

    convert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            groupChoice = number.getText().toString();
            userInputString = number.getText().toString();
            userNumber = Double.parseDouble(userInputString);

            if (! TextUtils.isEmpty(groupChoice)){
                grpNum = group.getSelectedItemPosition();
                spinnerString = group.getSelectedItem().toString();

                switch (grpNum){
                    case 0:
                        convertRate = 25.4;
                        break;
                    case 1:
                        convertRate = 0.3;
                        break;
                    case 2:
                        convertRate = 1.6;
                        break;

                    case 3:
                        convertRate = 28.3;
                        break;
                    case 4:
                        convertRate = .45359237;
                        break;

                    default:
                        convertRate = 0;
                        break;


                }
                convertTotal = (convertRate * userNumber);
                result.setText("Conversion Type: " + spinnerString + "\nYour Input: " + userInputString + "\nMetric Conversion: " + (formatDec.format(convertTotal)));


            }

        }
    });
    }
}

