package fpoly.edu.vn.qltcda1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fpoly.edu.vn.qltcda1.fragment.ThongKeTheoChiFragment;
import fpoly.edu.vn.qltcda1.fragment.ThongKeTheoThuFragment;

public class ThongKeViewPagerAdapter extends FragmentStatePagerAdapter {
    public ThongKeViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return  new ThongKeTheoChiFragment();
            case 1 :
                return  new ThongKeTheoThuFragment();
            default:
                return new ThongKeTheoChiFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position){
            case 0 :
                title = " Chi ";
                break;
            case 1 :
                title = " Thu ";
                break;
        }
        return title;
    }
}
