package fpoly.edu.vn.qltcda1.Adapter;

import android.app.Dialog;
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

import fpoly.edu.vn.qltcda1.DAO.KhoanThuDAO;
import fpoly.edu.vn.qltcda1.DAO.LoaiKhoanThuDAO;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.fragment.ThuFragment;
import fpoly.edu.vn.qltcda1.model.KhoanChi;
import fpoly.edu.vn.qltcda1.model.KhoanThu;
import fpoly.edu.vn.qltcda1.model.LoaiThu;
import fpoly.edu.vn.qltcda1.model.NguoiDung;

public class KhoanThuAdapter extends ArrayAdapter<KhoanThu> {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Context context;
    ThuFragment fragment1;
    private ArrayList<KhoanThu> list;
    TextView tvMa_khoan_thu,tvTen_Khoan_Thu,tv_Tien_Khoan_Thu,tv_NgayThu_Khoan_Thu,tv_LoaiThu,tvPhanTramThu;
    ImageView imgDel_KhoanThu,imgUpdate_KhoanThu;
    public KhoanThuAdapter(@NonNull  Context context,ThuFragment fragment1, ArrayList<KhoanThu> list) {
        super(context, 0,list);
        this.context = context;
        this.fragment1 = fragment1;
        this.list = list;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v= inflater.inflate(R.layout.khoan_thu_item,null);

        }
        final KhoanThu item = list.get(position);

        if (item != null){
            KhoanThuDAO khoanThuDAO= new KhoanThuDAO(context);
            LoaiKhoanThuDAO loaiKhoanThuDAO = new LoaiKhoanThuDAO(context);
            LoaiThu loaiThu = loaiKhoanThuDAO.getID(String.valueOf(item.getMaLoaiThu()));
            tvPhanTramThu= v.findViewById(R.id.tvPhanTramThu);
            tvPhanTramThu.setText("("+Math.round(((item.getSoTienKhoanthu())/ (khoanThuDAO.getTongThu()))*100 )+" % )");

            tvMa_khoan_thu=v.findViewById(R.id.tvMaKhoanThu);
            tvMa_khoan_thu.setText("");
            tvTen_Khoan_Thu=v.findViewById(R.id.tvTenKhoanThu_1);
            tvTen_Khoan_Thu.setText(""+item.getTenKhoanThu());

            tv_Tien_Khoan_Thu=v.findViewById(R.id.tvGiaTienThu_1);
            tv_Tien_Khoan_Thu.setText(item.getSoTienKhoanthu()+" VND ");

            tv_NgayThu_Khoan_Thu  = v.findViewById(R.id.tvNgayThu_1);
            tv_NgayThu_Khoan_Thu.setText(""+sdf.format(item.getNgayThu()));
            tv_LoaiThu =v.findViewById(R.id.tvLoaiKhoanThu_1);
            tv_LoaiThu.setText(""+loaiThu.getTenLoaiThu());

            imgDel_KhoanThu=v.findViewById(R.id.img_delete_khoanThu);
        }
        imgDel_KhoanThu.setOnClickListener(v1 -> fragment1.xoa(String.valueOf(item.getMaKhoanThu())));
        return v;
    }

}
