package fpoly.edu.vn.qltcda1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import fpoly.edu.vn.qltcda1.DAO.LoaiKhoanChiDAO;
import fpoly.edu.vn.qltcda1.fragment.LoaiChiFragment;
import fpoly.edu.vn.qltcda1.fragment.LoaiThuFragment;

public class PhanLoaiViewPagerAdapter extends FragmentStatePagerAdapter
{
    public PhanLoaiViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0 : return  new LoaiChiFragment();
            case 1 : return  new LoaiThuFragment();
            default: return new LoaiChiFragment();
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
            case  0 : return " Loại Chi ";
            case  1 : return " Loại Thu ";
            default : return " Loại Chi ";

        }
    }
}
