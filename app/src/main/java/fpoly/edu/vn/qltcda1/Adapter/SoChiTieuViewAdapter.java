package fpoly.edu.vn.qltcda1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fpoly.edu.vn.qltcda1.fragment.ChiFragment;
import fpoly.edu.vn.qltcda1.fragment.ThuFragment;

public class SoChiTieuViewAdapter extends FragmentStatePagerAdapter {
    public SoChiTieuViewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0 : return new ChiFragment();
           case 1 : return new ThuFragment();
           default:return  new ChiFragment();

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
            case 0 : return " Khoản Chi ";
            case 1 : return " Khoản Thu " ;
            default: return " Khoản Chi ";
        }
    }
}
