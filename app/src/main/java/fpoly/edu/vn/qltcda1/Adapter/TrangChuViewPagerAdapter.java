package fpoly.edu.vn.qltcda1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fpoly.edu.vn.qltcda1.fragment.BieuDoFragment;
import fpoly.edu.vn.qltcda1.fragment.ThongKeFragment;

public class TrangChuViewPagerAdapter extends FragmentStatePagerAdapter {

    public TrangChuViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return  new BieuDoFragment();
            case 1:
                return new ThongKeFragment();
            default:
                return new BieuDoFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return " Biểu Đồ " ;
            case 1 :
                return " Thống Kê "  ;

            default:
                return " Biểu Đồ " ;

        }
    }
}
