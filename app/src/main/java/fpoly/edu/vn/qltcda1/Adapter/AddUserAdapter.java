package fpoly.edu.vn.qltcda1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import fpoly.edu.vn.qltcda1.DAO.NguoiDungDAO;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.fragment.AddUserFragment;
import fpoly.edu.vn.qltcda1.model.NguoiDung;

public class AddUserAdapter extends ArrayAdapter<NguoiDung> {
    private Context context;
    AddUserFragment fragment;
    private ArrayList<NguoiDung> lists;
    TextView tvTenDN,tvTenThuthu,tvMatKhau;
    ImageView imgDel;
    public AddUserAdapter(@NonNull @NotNull Context context, AddUserFragment fragment, ArrayList<NguoiDung> lists) {
        super(context, 0,lists);
        this.context = context;
        this.fragment = fragment;
        this.lists = lists;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.nguoi_dung_item, null);
        }
        final NguoiDung item = lists.get(position);
        if (item != null){
            NguoiDungDAO nguoiDungDAO =new NguoiDungDAO(context);
            NguoiDung nguoiDung =   nguoiDungDAO.getID(String.valueOf(item.maNguoidung));
            tvTenDN = v.findViewById(R.id.tvIdDN);
            tvTenDN.setText("Tên Đăng Nhập: "+item.maNguoidung);
            tvTenThuthu= v.findViewById(R.id.tvNameDN);
            tvTenThuthu.setText("Họ Và Tên: "+item.hoTen);
            tvMatKhau = v.findViewById(R.id.tvMatKhau);
            tvMatKhau.setText("Mật Khẩu: "+item.matKhau);
            imgDel = v.findViewById(R.id.imgdeletenguoidung);

        }
//
        imgDel.setOnClickListener(v1 -> fragment.xoa(String.valueOf(item.maNguoidung)));
        return v;
    }

}
