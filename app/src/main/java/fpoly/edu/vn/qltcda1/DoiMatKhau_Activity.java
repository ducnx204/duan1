package fpoly.edu.vn.qltcda1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import fpoly.edu.vn.qltcda1.DAO.NguoiDungDAO;
import fpoly.edu.vn.qltcda1.model.NguoiDung;

public class DoiMatKhau_Activity extends AppCompatActivity {
    TextInputEditText edPassOld,edPass,edRepass;
    ImageView img_quaylai_doimatkhau;
    Button btnSave;
    NguoiDungDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Đổi Mật Khẩu");
        setContentView(R.layout.activity_doi_mat_khau);
        dao= new NguoiDungDAO(getApplicationContext());
        edPassOld=findViewById(R.id.edPassOld);
        edPass=findViewById(R.id.edPasschange);
        edRepass=findViewById(R.id.edRePassChange);
        btnSave=findViewById(R.id.btnSaveUserChange);
        img_quaylai_doimatkhau = findViewById(R.id.img_quaylai_doimatkhau);


        edPassOld.setOnClickListener(v -> {
            edPassOld.setText("");
        });
        edPass.setOnClickListener(v -> {
            edPass.setText("");
        });
        edRepass.setOnClickListener(v -> {
            edRepass.setText("");
        });

        img_quaylai_doimatkhau.setOnClickListener(v -> {
         finish();
        });


        btnSave.setOnClickListener(v -> {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String user= pref.getString("USERNAME","");
            if(validate()>0){
                NguoiDung nguoiDung=dao.getID(user);
                nguoiDung.setMatKhau(edPass.getText().toString());
                if (dao.updatePass(nguoiDung)>0){
                    Toast.makeText(getApplicationContext(), "Thay đổi mật khẩu thành công ", Toast.LENGTH_SHORT).show();
                    edPassOld.setText("");
                    edPass.setText("");
                    edRepass.setText("");
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Thay đổi mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                }
            }

        });
        return;
    }
    public int validate(){
        int check=1;
        if(edPassOld.getText().length()==0 || edPass.getText().length()==0 || edRepass.getText().length()==0){
            Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
            check=-1;
        }else{
            SharedPreferences pref = getApplicationContext().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String passOld= pref.getString("PASSWORD","");
            String pass= edPass.getText().toString();
            String rePass= edRepass.getText().toString();
            if (!passOld.equals(edPassOld.getText().toString())){
                Toast.makeText(getApplicationContext(), "Mật khẩu cũ sai", Toast.LENGTH_SHORT).show();
                check=-1;
            }
            if(pass.equals(passOld)){
                Toast.makeText(getApplicationContext(),"mật khẩu mới không được trùng mật khẩu cũ ",Toast.LENGTH_SHORT).show();
                check=-1;
            }
            if (!pass.equals(rePass)){
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check=-1;
            }

        }
        return check;
    }
}