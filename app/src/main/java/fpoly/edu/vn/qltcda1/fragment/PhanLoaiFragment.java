package fpoly.edu.vn.qltcda1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import fpoly.edu.vn.qltcda1.Adapter.PhanLoaiViewPagerAdapter;
import fpoly.edu.vn.qltcda1.LoginActivity;
import fpoly.edu.vn.qltcda1.MainActivity;
import fpoly.edu.vn.qltcda1.R;


public class PhanLoaiFragment extends Fragment {
private TabLayout tabLayout;
private ViewPager viewPager;
private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_phan_loai, container, false);
        tabLayout = mView.findViewById(R.id.tab_layout_PhanLoai);
        viewPager = mView.findViewById(R.id.PhanLoai_viewPager);
        PhanLoaiViewPagerAdapter adapter = new PhanLoaiViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
       
        return mView;
    }

}