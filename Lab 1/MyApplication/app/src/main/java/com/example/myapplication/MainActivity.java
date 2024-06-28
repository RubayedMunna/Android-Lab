package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameTextView = findViewById(R.id.name);
        TextView rollNumberTextView = findViewById(R.id.roll_number);
        TextView batchTextView = findViewById(R.id.batch);
        TextView departmentTextView = findViewById(R.id.department);
        TextView bloodGroupTextView = findViewById(R.id.blood_group);

        // Set text for each TextView
        nameTextView.setText("Rubayed All Islam");
        rollNumberTextView.setText("Roll Number: 370");
        batchTextView.setText("Batch: 49");
        departmentTextView.setText("Computer Science & Engineering");
        bloodGroupTextView.setText("Blood Group: O (+ve)");

        // Apply blue color to all text in each TextView using SpannableString
        applyBlueColor(nameTextView);
        applyBlueColor(rollNumberTextView);
        applyBlueColor(batchTextView);
        applyBlueColor(departmentTextView);
        applyBlueColor(bloodGroupTextView);
    }

    private void applyBlueColor(TextView textView) {
        SpannableString spannableString = new SpannableString(textView.getText().toString());
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }
}
