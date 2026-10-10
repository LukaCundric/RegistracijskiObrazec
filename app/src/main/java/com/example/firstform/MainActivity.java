
package com.example.registracijskiobrazec;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registracijskiobrazec.R;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etFullName, etCountry;
    EditText etEmail, etPhone, etPassword;

    RadioGroup rgGender;
    CheckBox cbTerms;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etFullName = findViewById(R.id.etFullName);
        etCountry = findViewById(R.id.etCountry);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);

        rgGender = findViewById(R.id.rgGender);
        cbTerms = findViewById(R.id.cbTerms);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String fullName = etFullName.getText().toString();
                String country = etCountry.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();

                int selectedId = rgGender.getCheckedRadioButtonId();
                String gender = "Not selected";

                if (selectedId != -1) {
                    RadioButton selectedRadioButton =
                            findViewById(selectedId);

                    gender = selectedRadioButton.getText().toString();
                }

                String terms;

                if (cbTerms.isChecked()) {
                    terms = "Yes";
                } else {
                    terms = "No";
                }

                String details =
                        "Username: " + username +
                                "\nFull name: " + fullName +
                                "\nCountry: " + country +
                                "\nEmail: " + email +
                                "\nPhone number: " + phone +
                                "\nPassword: " + password +
                                "\nGender: " + gender +
                                "\nTerms Accepted: " + terms;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Registration Details")
                        .setMessage(details)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
