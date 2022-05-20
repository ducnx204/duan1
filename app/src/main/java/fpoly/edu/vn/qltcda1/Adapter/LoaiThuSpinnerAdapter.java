package fpoly.edu.vn.qltcda1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.model.LoaiThu;

public class LoaiThuSpinnerAdapter extends ArrayAdapter<LoaiThu> {
    private Context context;
    private ArrayList<LoaiThu> list;
    TextView tvMaLoaiThuSP,tvTenLoaiThuSP;

    public LoaiThuSpinnerAdapter(@NonNull  Context context, ArrayList<LoaiThu> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v  = convertView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v =inflater.inflate(R.layout.loai_thu_spiner_item,null);
        }
        final LoaiThu item =list.get(position);
        if (item !=null){
            tvMaLoaiThuSP = v.findViewById(R.id.spMaLoaiThu_KhoanThu);
            tvMaLoaiThuSP.setText(item.maLoaiThu+".");

            tvTenLoaiThuSP = v.findViewById(R.id.spTenLoaiThu_KhoanThu);
            tvTenLoaiThuSP.setText(item.tenLoaiThu);
        }
        return v;
    }

    @Override
    public View getDropDownView(int position,  View convertView, @NonNull  ViewGroup parent) {
        View v  = convertView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v =inflater.inflate(R.layout.loai_thu_spiner_item,null);
        }
        final LoaiThu item =list.get(position);
        if (item !=null){
            tvMaLoaiThuSP = v.findViewById(R.id.spMaLoaiThu_KhoanThu);
            tvMaLoaiThuSP.setText(item.maLoaiThu+".");

            tvTenLoaiThuSP = v.findViewById(R.id.spTenLoaiThu_KhoanThu);
            tvTenLoaiThuSP.setText(item.tenLoaiThu);
        }
        return v;
    }
}
