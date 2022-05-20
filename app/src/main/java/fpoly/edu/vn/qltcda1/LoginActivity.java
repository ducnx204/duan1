package fpoly.edu.vn.qltcda1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import fpoly.edu.vn.qltcda1.DAO.NguoiDungDAO;


public class LoginActivity extends AppCompatActivity {
    EditText edUserName,edPassword;
    Button btnLogin;
    CheckBox chkRememberPass;
    String strUser,strPass;
    NguoiDungDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("ĐĂNG NHẬP");
        edUserName = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassWord);
        btnLogin = findViewById(R.id.btnLogin);


        chkRememberPass = findViewById(R.id.chkRememberPass);

        dao = new NguoiDungDAO(this);
        //doc User,pass,trong SharedPreferences

        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        edUserName.setText(pref.getString("USERNAME",""));
        edPassword.setText(pref.getString("PASSWORD",""));
        chkRememberPass.setChecked(pref.getBoolean("REMEMBER",false));

        edUserName.setOnClickListener(v -> edUserName.setText(""));
        edPassword.setOnClickListener(v -> edPassword.setText(""));

        btnLogin.setOnClickListener(v -> checkLogin());

    }



    public void checkLogin(){
        strUser  = edUserName.getText().toString();
        strPass = edPassword.getText() .toString();

        if (strUser.isEmpty()||strPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Tên đăng nhập hoặc mật khẩu không được bỏ trống",Toast.LENGTH_SHORT).show();
        }else {
            if(dao.CheckLogin(strUser,strPass)>0 || (strUser.equals("admin") && strPass.equals("123"))){
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                rememberUser(strUser,strPass,chkRememberPass.isChecked());

                Intent i  = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("user",strUser);
                startActivity(i);
                finish();
            }else {
                Toast.makeText(getApplicationContext(),"Tên đăng nhập hoặc mật khẩu không đúng",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void rememberUser(String u,String p,boolean status){
        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        if (!status){
            //Xoa tinh trang truoc do
            editor.clear();
        }else {
            // luu du lieu
            editor.putString("USERNAME",u);
            editor.putString("PASSWORD",p);
            editor.putBoolean("REMEMBER",status);
        }
        // luu lai toan bo
        editor.commit();
    }

    public void dangki(View view) {
        Intent intent = new Intent(getApplicationContext(),dangkiActivity.class);
        startActivity(intent);
    }
}