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

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import fpoly.edu.vn.qltcda1.DAO.KhoanChiDAO;
import fpoly.edu.vn.qltcda1.DAO.LoaiKhoanChiDAO;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.fragment.ChiFragment;
import fpoly.edu.vn.qltcda1.model.KhoanChi;
import fpoly.edu.vn.qltcda1.model.LoaiChi;

public class KhoanChiAdapter extends ArrayAdapter<KhoanChi> {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Context context;
    ChiFragment fragment;
    private ArrayList<KhoanChi> lists;
    TextView tvMaLC,tvTenLc,tvTienChi,tvNgayChi,tvloaichi,tvPhanTramChi;
    ImageView imgDel;
    KhoanChiDAO khoanChiDAO;
    KhoanChi item;

    public KhoanChiAdapter(@NonNull  Context context, ChiFragment fragment, ArrayList<KhoanChi> lists) {
        super(context, 0,lists);
        this.context = context;
        this.fragment = fragment;
        this.lists = lists;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.khoan_chi_item,null);
        }
        final KhoanChi item = lists.get(position);
        if (item != null){
            LoaiKhoanChiDAO loaiKhoanChiDAO =new LoaiKhoanChiDAO(context);
            LoaiChi loaiChi = loaiKhoanChiDAO.getID(String.valueOf(item.getMaLoaiChi()));
            KhoanChiDAO khoanChiDAO = new KhoanChiDAO(context);
            tvPhanTramChi= v.findViewById(R.id.tvPhanTramChi);
            tvPhanTramChi.setText("("+Math.round(((item.getSoTienKhoanchi())/ (khoanChiDAO.getTongChi()))*100 )+" % )");
            tvMaLC=v.findViewById(R.id.maKhoanChi);
            tvMaLC.setText("");
            tvTenLc = v.findViewById(R.id.tvTenKhoanChi1);
            tvTenLc.setText(""+item.getTenKhoanChi());

            tvTienChi = v.findViewById(R.id.tvSotienChi);
            tvTienChi.setText(item.getSoTienKhoanchi()+" VND ");

            tvloaichi  = v.findViewById(R.id.tvTenLoaiChi);
            tvloaichi.setText(""+loaiChi.getTenLoaiChi());

            tvNgayChi = v.findViewById(R.id.tvNgayChi);
            tvNgayChi.setText(""+sdf.format(item.getNgayChi()));

            imgDel = v.findViewById(R.id.imgxoa);

        }
                imgDel.setOnClickListener(v1 -> {
                    fragment.xoa(String.valueOf(item.getMaKhoanChi()));
                });
        return v;
    }

}
