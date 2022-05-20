package fpoly.edu.vn.qltcda1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import fpoly.edu.vn.qltcda1.Adapter.SoChiTieuViewAdapter;
import fpoly.edu.vn.qltcda1.R;


public class SoChiTieuFragment extends Fragment {
private TabLayout tabLayout;
private ViewPager viewPager;
private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_so_chi_tieu, container, false);
        tabLayout=mView.findViewById(R.id.tab_layout_so_chi_tieu);
        viewPager= mView.findViewById(R.id.soChiTieu_viewPager);
        SoChiTieuViewAdapter adapter = new SoChiTieuViewAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return mView;
    }
}