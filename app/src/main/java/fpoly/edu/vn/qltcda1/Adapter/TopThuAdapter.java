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

import fpoly.edu.vn.qltcda1.fragment.BieuDoFragment;
import fpoly.edu.vn.qltcda1.model.TopKhoanThu;

public class TopThuAdapter extends ArrayAdapter<TopKhoanThu> {
    private Context context;
    BieuDoFragment bieuDoFragment;
    ArrayList<TopKhoanThu> list;
    TextView tvLoaiThu,tvSoTien;

    public TopThuAdapter(@NonNull Context context, BieuDoFragment bieuDoFragment, ArrayList<TopKhoanThu> list) {
        super(context,0,list);
        this.context = context;
        this.bieuDoFragment = bieuDoFragment;
        this.list = list;
        this.tvLoaiThu = tvLoaiThu;
        this.tvSoTien = tvSoTien;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.top_item_thu,null);

        }
        final TopKhoanThu item= list.get(position);
        if (item!=null){
            tvLoaiThu=v.findViewById(R.id.tvTenLoaiT);
            tvLoaiThu.setText(""+item.getTenKhoanThu());
            tvSoTien= v.findViewById(R.id.tvSTT);
            tvSoTien.setText(item.getSoTienThu()+" VND ");
        }
        return v;
    }
}
