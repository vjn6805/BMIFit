package com.example.bmifit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            //Making Variables
            EditText edtweight,edtheightft,edtheightin;
            Button btn1;
            TextView txtResult;
            LinearLayout main;

            //Finding and refrencing ID
            edtweight=findViewById(R.id.edtweight);
            edtheightft=findViewById(R.id.edtheightft);
            edtheightin=findViewById(R.id.edtheightin);
            btn1=findViewById(R.id.btn1);
            txtResult=findViewById(R.id.txtResult);
            main=findViewById(R.id.main);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Getting values from user
                    int wt=Integer.parseInt(edtweight.getText().toString());
                    int ft=Integer.parseInt(edtheightft.getText().toString());
                    int in=Integer.parseInt(edtheightin.getText().toString());

                    //Logic for BMI
                    int totalIn=ft*12 + in;
                    double totalCm=totalIn*2.53;
                    double totalM=totalCm/100;

                    double bmi=wt/(totalM*totalM);

                    if(bmi>25) {
                        txtResult.setText("You are OVERWEIGHT!!");
                        main.setBackgroundColor(getResources().getColor(R.color.Over));
                    }
                    else if(bmi<18) {
                        txtResult.setText("You are UNDERWEIGHT!!");
                        main.setBackgroundColor(getResources().getColor(R.color.Under));
                    }
                    else{
                        txtResult.setText("You are HEALTHY!!");
                        main.setBackgroundColor(getResources().getColor(R.color.Healthy));
                    }
                }
            });

            return insets;
        });
    }
}