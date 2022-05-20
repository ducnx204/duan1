package fpoly.edu.vn.qltcda1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import fpoly.edu.vn.qltcda1.DAO.NguoiDungDAO;
import fpoly.edu.vn.qltcda1.model.NguoiDung;

public class dangkiActivity extends AppCompatActivity {
    EditText edUser,edHoTen,edPass,edRePass;
    ImageView imgquaylai;
    Button btndangki;
    NguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        nguoiDungDAO = new NguoiDungDAO(getApplicationContext());

        edUser = findViewById(R.id.edUserName);
        edHoTen=findViewById(R.id.edName);
        edPass= findViewById(R.id.edPassWord1);
        edRePass = findViewById(R.id.edRePassWord);
        btndangki = findViewById(R.id.btdangki);
        imgquaylai = findViewById(R.id.img_quaylai);

        resetForm();
        btndangki.setOnClickListener(v -> {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.maNguoidung = edUser.getText().toString();
            nguoiDung.hoTen=edHoTen.getText().toString();
            nguoiDung.matKhau = edPass.getText().toString();
            if (validate()>0){
                if (nguoiDungDAO.insert(nguoiDung)>0){
                    Toast.makeText(getApplicationContext(),"Đăng Ký Thành Công",Toast.LENGTH_LONG).show();
                    edUser.setText("");
                    edHoTen.setText("");
                    edPass.setText("");
                    edRePass.setText("");
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Đăng Ký Thất Bại",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void resetForm() {
        edUser.setOnClickListener(v -> {
            edUser.setText("");
        });
        edHoTen.setOnClickListener(v -> {
            edHoTen.setText("");
        });
        edPass.setOnClickListener(v -> {
            edPass.setText("");
        });
        edRePass.setOnClickListener(v -> {
            edRePass.setText("");
        });
        imgquaylai.setOnClickListener(v -> {
           finish();
        });
    }

    public int validate(){
        int check  = 1;
        if (edUser.getText().length()==0 || edHoTen.getText().length()==0 ||edPass.getText().length()==0||edRePass.getText().length()==0){
            Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
            check = -1;
        }else {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String userOld= pref.getString("USERNAME","");
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            String user= edUser.getText().toString();
            if(user.equals(userOld)){
                Toast.makeText(getApplicationContext(),"Tên đăng nhập đã tồn tại",Toast.LENGTH_LONG).show();
            }
            if (!pass.equals(rePass)){
                Toast.makeText(getApplicationContext(),"Mật Khẩu Không Trùng Khớp",Toast.LENGTH_LONG).show();
                check = -1;
            }


        }
        return check;
    }
}
