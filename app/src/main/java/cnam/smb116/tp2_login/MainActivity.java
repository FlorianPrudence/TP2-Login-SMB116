package cnam.smb116.tp2_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_LOGIN) != PackageManager.PERMISSION_GRANTED) {
            CharSequence text = "Vous ne disposez pas de la permission d'exécuter ce composant";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLogin(View view){
        Intent intent = new Intent();
        final EditText usernameInput = findViewById(R.id.inputUserName);
        final EditText passwordInput = findViewById(R.id.inputPassword);
        intent.putExtra("username", usernameInput.getText().toString());
        intent.putExtra("password", passwordInput.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void doCancel(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED);
        finish();
    }
}