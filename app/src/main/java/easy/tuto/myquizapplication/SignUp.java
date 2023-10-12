package easy.tuto.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    EditText username,pwd;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=(EditText) findViewById(R.id.username);
        pwd=(EditText) findViewById(R.id.password);
        register=(Button) findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=username.getText().toString();
                String userpwd=pwd.getText().toString();
                if(email.matches("")){
                    Toast.makeText(SignUp.this,"Username Cannot Be Empty",Toast.LENGTH_LONG).show();
                }else if(!isValidPassword(userpwd)){
                    Toast.makeText(SignUp.this,"Invalid Password",Toast.LENGTH_LONG).show();
                }
                Intent intent=new Intent(SignUp.this,SignIn.class);
                intent.putExtra("email",email);
                intent.putExtra("userpwd",userpwd);
                startActivity(intent);

            }
        });
    }
    Pattern uppercase= Pattern.compile("^.*[A-Z].*$");
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern special=Pattern.compile("^.*[@{}_%&*#!?].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");

    private boolean isValidPassword(String userpwd) {
        if(userpwd.length()<8){
            return false;
        }
        if(!lowercase.matcher(userpwd).matches()){
            return false;
        }
        if(!uppercase.matcher(userpwd).matches()){
            return false;
        }
        if(!number.matcher(userpwd).matches()){
            return false;
        }
        if(!special.matcher(userpwd).matches()){
            return false;
        }
        return true;
    }

}