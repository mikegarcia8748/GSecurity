package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_CreateAccount extends AppCompatActivity {

    EditText name1Etv,name2Etv,name3Etv,emailEtv,numberEtv,password1Etv,password2Etv;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name1Etv=findViewById(R.id.name1etv);
        name2Etv=findViewById(R.id.name2etv);
        name3Etv=findViewById(R.id.name3etv);
        emailEtv=findViewById(R.id.emailEtv);
        password1Etv=findViewById(R.id.password1Etv);
        password2Etv=findViewById(R.id.password2Etv);
        numberEtv=findViewById(R.id.numberEtv);
        submitBtn=findViewById(R.id.SubmitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name1Etv.getText().toString();
                String name2=name2Etv.getText().toString();
                String name3=name3Etv.getText().toString();
                String email=emailEtv.getText().toString();
                String password1etv=password1Etv.getText().toString();
                String password2etv=password2Etv.getText().toString();
                String number=numberEtv.getText().toString();



              boolean check = validateinfo(name1,name2,name3,email,password1etv,number);

              if (check==true){
                  Toast.makeText(Activity_CreateAccount.this, "Log in Successful!", Toast.LENGTH_SHORT).show();

              }
              else {
                  Toast.makeText(getApplicationContext(),"Sorry check information again",Toast.LENGTH_SHORT).show();
              }
            }
        });

    }

    private boolean validateinfo(String name1,String name2,String name3, String email, String password1etv, String number) {

        if(name1.length()==0){
            name1Etv.requestFocus();
            name1Etv.setError("Field Cannot be Empty");
            return false;}

            else if (!name1.matches("[a-zA-Z]+")){
                name1Etv.requestFocus();
                name1Etv.setError("Enter only alphabetical character");
                return false;


        }
        if(name2.length()==0){
            name2Etv.requestFocus();
            name2Etv.setError("Field Cannot be Empty");
            return false;}

        else if (!name2.matches("[a-zA-Z]+")){
            name2Etv.requestFocus();
            name2Etv.setError("Enter only alphabetical character");
            return false;


        }
        if(name3.length()==0){
            name3Etv.requestFocus();
            name3Etv.setError("Field Cannot be Empty");
            return false;}

        else if (!name3.matches("[a-zA-Z]+")){
            name3Etv.requestFocus();
            name3Etv.setError("Enter only alphabetical character");
            return false;


        }


        else if (email.length()==0){
            emailEtv.requestFocus();
            emailEtv.setError("Field Cannot be empty");
            return false;

        }
        else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            emailEtv.requestFocus();
            emailEtv.setError("Enter Valid Email!");
            return false;
        }
        else if(number.length()==0){
            numberEtv.requestFocus();
            numberEtv.setError("Field Cannot be Empty");
            return false;
        }
         else if (number.length() != 11 || !number.startsWith("09")) {
            numberEtv.requestFocus();
            numberEtv.setError("Correct Format : +09#########");
            return false;
        }
        else if (password1Etv.length() < 8 || password1Etv.length() > 16) {
            password1Etv.requestFocus();
            password1Etv.setError("Password must be between 8 and 16 characters");
            return false;


        } else if  (password2Etv.length() < 8 || password2Etv.length() > 16){
            password2Etv.requestFocus();
            password2Etv.setError("Password must be between 8 and 16 characters");
            return false;


        } else  {
            return true;
        }
    }
}