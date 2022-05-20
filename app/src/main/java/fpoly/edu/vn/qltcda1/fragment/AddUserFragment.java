package fpoly.edu.vn.qltcda1.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import fpoly.edu.vn.qltcda1.Adapter.AddUserAdapter;
import fpoly.edu.vn.qltcda1.DAO.NguoiDungDAO;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.model.NguoiDung;


public class AddUserFragment extends Base {
    ListView lv;
    ArrayList<NguoiDung> listTT;
    Dialog dialog;
    EditText edUser,edHoTen,edPass,edRePass;
    Button btnSave,btnCancel;

    AddUserAdapter adapter;
    NguoiDung item;
    NguoiDungDAO dao;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v= inflater.inflate(R.layout.fragment_add_user, container, false);
        lv = v.findViewById(R.id.lv);

        dao = new NguoiDungDAO(getActivity());
        capNhatLv();

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            item = listTT.get(position);
            openDialog(getActivity(), 1);
            return false;
        });


        return v;
    }

    private void openDialog(Context context, int type) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_dangki);
        edUser = dialog.findViewById(R.id.edUserName);
        edHoTen=dialog.findViewById(R.id.edName);
        edPass= dialog.findViewById(R.id.edPassWord1);
        edRePass = dialog.findViewById(R.id.edRePassWord);

        if (type != 0) {
            edUser.setText(item.maNguoidung);
            edHoTen.setText(item.hoTen);
            edPass.setText(item.matKhau);
            edRePass.setText(item.matKhau);
        }
        btnCancel.setOnClickListener(v -> dialog.dismiss());


        btnSave.setOnClickListener(v -> {

            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.maNguoidung = edUser.getText().toString();
            nguoiDung.hoTen=edHoTen.getText().toString();
            nguoiDung.matKhau = edPass.getText().toString();
//                dao.insert(thuThu);
            if (validate()>0){
                if (dao.insert(nguoiDung)>0){
                    showMsgF("Thêm Thành Công");
                    edUser.setText("");
                    edHoTen.setText("");
                    edPass.setText("");
                    edRePass.setText("");
                }else {
                    showMsgF("Thêm Thất Bại");
                }
            }
            capNhatLv();
            dialog.dismiss();
        });
        dialog.show();
    }

    public int validate(){
        int check  = 1;

        if (edUser.getText().length()==0 || edHoTen.getText().length()==0 ||edPass.getText().length()==0||edRePass.getText().length()==0){
            showMsgF("Không Được Để Trống");
            check = -1;
        }
        else {
            String pass = edPass.getText().toString();
            String rePass = edRePass.getText().toString();
            if (!pass.equals(rePass)){
                showMsgF("Mật khẩu Không Trùng Khớp");
                check = -1;
            }
        }
        return check;
    }

    public void xoa(final String Id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xóa");
        builder.setMessage("Bạn Có Muốn Xóa Không ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Có", (dialog, id) -> {
            dao.delete(Id);
            Toast.makeText(getContext(),"Xóa Thành Công",Toast.LENGTH_LONG).show();
            capNhatLv();
            dialog.cancel();
        });
        builder.setNegativeButton("Không", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        builder.show();
    }
    void capNhatLv() {
        listTT = (ArrayList<NguoiDung>) dao.getAll();
        adapter = new AddUserAdapter(getActivity(),this,listTT);
        lv.setAdapter(adapter);
    }
}