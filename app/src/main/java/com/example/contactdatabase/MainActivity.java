package com.example.contactdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            return insets;
        });
    }

    private void saveDetails(){
        DatabaseHelper dpHelper = new DatabaseHelper(this);

        EditText nameText = findViewById(R.id.inputName);
        EditText dobText = findViewById(R.id.inputDoB);
        EditText emailText = findViewById(R.id.inputEmail);

        String name = nameText.getText().toString();
        String dob = dobText.getText().toString();
        String email = emailText.getText().toString();

        Person p = new Person(name,dob,email);

        long personId = dpHelper.insertDetails(p);

        Toast.makeText(this, "Person has been created with id: " + personId, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    public void handleSaveButtonClick(View view){
        saveDetails();
    }
    public void handleViewButtonClick(View view){
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}