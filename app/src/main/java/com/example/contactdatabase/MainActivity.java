package com.example.contactdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private int[] avatarIdList;
    private int pos; // avatar image position
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        avatarIdList = new int[] {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
        imageView = (ImageView)findViewById(R.id.imageView);

        pos = 0;
        imageView.setImageResource(avatarIdList[pos]);

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
        int avatar = avatarIdList[pos];

        Person p = new Person(name,dob,email,avatar);

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

    public void handleForwardButton(View view){
        pos+= 1;
        if(pos >= avatarIdList.length){
            pos = 0;
        }
        displayAvatar(view,pos);
    }

    public void handleBackwardButton(View view){
        pos-= 1;
        if(pos < 0){
            pos = avatarIdList.length -1;
        }
        displayAvatar(view,pos);
    }

    public void displayAvatar(View view, int pos){
        imageView.setImageResource(avatarIdList[pos]);
        Snackbar.make(view, "Avatar changed",Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }
}