package fpoly.edu.vn.qltcda1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

import fpoly.edu.vn.qltcda1.Adapter.TrangChuViewPagerAdapter;
import fpoly.edu.vn.qltcda1.DAO.KhoanChiDAO;
import fpoly.edu.vn.qltcda1.DAO.KhoanThuDAO;
import fpoly.edu.vn.qltcda1.R;


public class TrangChuFragment extends Fragment  {
private TabLayout tabLayout;
private ViewPager viewPager;
private View mView;
TextView tvSoDu,tvngay_tc;
KhoanChiDAO dao;
KhoanThuDAO dao2;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.fragment_trang_chu, container, false);

        tabLayout = mView.findViewById(R.id.tab_layout_trang_chu);
        viewPager=mView.findViewById(R.id.trangChu_viewPager);

        TrangChuViewPagerAdapter adapter = new TrangChuViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tvngay_tc = mView.findViewById(R.id.tvNgay_tc);
        tvngay_tc.setText(""+sdf.format(new Date()));

        dao= new KhoanChiDAO(getActivity());
        dao2=new KhoanThuDAO(getActivity());
        tvSoDu = mView.findViewById(R.id.tv_sodu_home);
        tvSoDu.setText("Số Dư : "+(dao2.getTongThu()-dao.getTongChi())+" VND ");

        return mView;
    }
}