package fpoly.edu.vn.qltcda1.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import fpoly.edu.vn.qltcda1.Adapter.LoaiThuAdapter;
import fpoly.edu.vn.qltcda1.DAO.LoaiKhoanThuDAO;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.model.LoaiThu;


public class LoaiThuFragment extends Base {
    ListView lv;
    ArrayList<LoaiThu> listLT;
    FloatingActionButton fab_LoaiThu;
    Dialog dialog;
    EditText edIdLoaiThu,edNameLoaiThu;
    Button btnSave,btnCancel;
    static LoaiKhoanThuDAO dao;
    LoaiThuAdapter adapter;
    LoaiThu item;
    TextView tvTitle;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_loai_thu, container, false);
        lv = v.findViewById(R.id.lvLoaiThu);
        tvTitle = v.findViewById(R.id.tv_title);
        fab_LoaiThu=v.findViewById(R.id.fab_LoaiThu);
        fab_LoaiThu.setOnClickListener(v1 -> openDialog(getActivity(), 0));
        dao= new LoaiKhoanThuDAO(getActivity());
        capNhatLv();
        animation();
        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            item = listLT.get(position);
            openDialog(getActivity(), 1);
            return false;
        });
        return v;
    }
    private void setTitleToolbar() {
        tvTitle.setText("Loại Thu");

    }
    private void openDialog(Context context, int type) {
        dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.dialog_loaithu);
        edIdLoaiThu = dialog.findViewById(R.id.edIdLoaiThu);
        edNameLoaiThu = dialog.findViewById(R.id.edNameLoaiThu);
        btnSave = dialog.findViewById(R.id.btnSaveLT);
        btnCancel = dialog.findViewById(R.id.btnCancelLT);
        edIdLoaiThu.setEnabled(false);



        if (type != 0) {
            edIdLoaiThu.setText(String.valueOf(item.maLoaiThu));
            edNameLoaiThu.setText(item.tenLoaiThu);
        }

        // rs ten loai sách

        edNameLoaiThu.setOnClickListener(v -> edNameLoaiThu.setText(""));

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        btnSave.setOnClickListener(v -> {
            item = new LoaiThu();
            item.tenLoaiThu = edNameLoaiThu.getText().toString();
            if (validate() >0){
                if (type == 0) {
                    if (dao.insert(item) > 0) {
                        showMsgF("Lưu Thành Công");
                    } else {
                        showMsgF("Lưu Thất Bại");
                    }

                } else {
                    item.setMaLoaiThu(Integer.parseInt(edIdLoaiThu.getText().toString()));
                    if (dao.update(item) > 0) {
                        showMsgF("Sửa Thành Công");
                    } else {
                        showMsgF("Sửa Thất Bại");
                    }
                }
                capNhatLv();
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    //===========================================//
    public void xoa(final String Id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xóa");
        builder.setMessage("Bạn Có Muốn Xóa Không ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Có", (dialog, id) -> {
            dao.delete(Id);
            capNhatLv();
            dialog.cancel();
        });
        builder.setNegativeButton("Không", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        builder.show();
    }

    void capNhatLv() {
        listLT = (ArrayList<LoaiThu>) dao.getAll();
        adapter = new LoaiThuAdapter(getActivity(),this,listLT);
        lv.setAdapter(adapter);
    }
    //
    public int validate() {
        int check = 1;
        if (edNameLoaiThu.getText().length() == 0) {
            showMsgF("Không Được Để Trống");
            check = -1;
        }
        return check;
    }
    public void animation(){
        Animation animationHour2 = AnimationUtils.loadAnimation(getActivity(),R.anim.iconxoaxoay);
        fab_LoaiThu.startAnimation(animationHour2);
    }
}