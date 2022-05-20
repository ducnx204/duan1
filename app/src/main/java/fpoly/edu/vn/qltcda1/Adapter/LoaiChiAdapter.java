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

import java.util.ArrayList;
import java.util.List;

import fpoly.edu.vn.qltcda1.DAO.LoaiKhoanChiDAO;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.fragment.LoaiChiFragment;
import fpoly.edu.vn.qltcda1.model.LoaiChi;

public class LoaiChiAdapter extends ArrayAdapter<LoaiChi> {
    private Context context;
    LoaiChiFragment fragment;
    private ArrayList<LoaiChi> lists;
    TextView tvIdLoaiChi,tvNameLoaiChi;
    ImageView imgDel;

    public LoaiChiAdapter(@NonNull Context context,LoaiChiFragment fragment, ArrayList<LoaiChi>lists ) {
        super(context, 0, lists);
         this.context = context;
         this.fragment = fragment;
         this.lists = lists;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.loai_chi_item,null);
        }
        final LoaiChi item = lists.get(position);
        if (item != null){
            LoaiKhoanChiDAO loaiKhoanChiDAO = new LoaiKhoanChiDAO(context);
            LoaiChi loaiChi = loaiKhoanChiDAO.getID(String.valueOf(item.maLoaiChi));
            tvNameLoaiChi = v.findViewById(R.id.tvNameLC);
            tvNameLoaiChi.setText(" "+item.tenLoaiChi);
            imgDel = v.findViewById(R.id.imgdeleteLoaiChi);
        }
        imgDel.setOnClickListener(v1 -> fragment.xoa(String.valueOf(item.maLoaiChi)));
        return v;
    }

}
