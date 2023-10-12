package easy.tuto.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText username1,password1;
    Button login;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username1=(EditText) findViewById(R.id.username1);
        password1=(EditText) findViewById(R.id.password1);
        login=(Button) findViewById(R.id.login);
        String newusername=getIntent().getStringExtra("email");
        String newpwd=getIntent().getStringExtra("userpwd");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getusername=username1.getText().toString();
                String getpassword=password1.getText().toString();
                if(newusername.matches(getusername) && newpwd.matches(getpassword)){
                    Toast.makeText(SignIn.this,"Login successfull",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(SignIn.this,MainActivity.class);
                    startActivity(intent);
                    username1.setText("");
                    password1.setText("");
                }
                else{
                    count++;
                    Toast.makeText(SignIn.this, "Login Failed "+count, Toast.LENGTH_LONG).show();
                    if(count==3)
                    {
                        login.setEnabled(false);
                        Toast.makeText(SignIn.this, "Login Failed "+count, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}