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
import fpoly.edu.vn.qltcda1.model.LoaiChi;

public class LoaiChiSpinnerAdapter extends ArrayAdapter<LoaiChi> {
    private Context context;
    private ArrayList<LoaiChi> list;
    TextView tvMaLoaiChiSP,tvTenLoaiChiSP;

    public LoaiChiSpinnerAdapter(@NonNull  Context context, ArrayList<LoaiChi> list) {
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
            v =inflater.inflate(R.layout.loai_chi_spiner_item,null);
        }
        final LoaiChi item =list.get(position);
        if (item !=null){
            tvMaLoaiChiSP = v.findViewById(R.id.spMaLoaiChi_KhoanChi);
            tvMaLoaiChiSP.setText(item.maLoaiChi+".");

            tvTenLoaiChiSP = v.findViewById(R.id.spTenLoaiChi_KhoanChi);
            tvTenLoaiChiSP.setText(item.tenLoaiChi);
        }
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable  View convertView, @NonNull  ViewGroup parent) {
        View v = convertView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v =inflater.inflate(R.layout.loai_chi_spiner_item,null);
        }
        final LoaiChi item =list.get(position);
        if (item !=null){
            tvMaLoaiChiSP = v.findViewById(R.id.spMaLoaiChi_KhoanChi);
            tvMaLoaiChiSP.setText(item.maLoaiChi+".");
            tvTenLoaiChiSP = v.findViewById(R.id.spTenLoaiChi_KhoanChi);
            tvTenLoaiChiSP.setText(item.tenLoaiChi);
        }
        return v;
    }
}
