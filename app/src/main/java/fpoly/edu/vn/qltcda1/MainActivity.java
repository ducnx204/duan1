package fpoly.edu.vn.qltcda1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fpoly.edu.vn.qltcda1.fragment.CaNhanFragment;
import fpoly.edu.vn.qltcda1.fragment.PhanLoaiFragment;
import fpoly.edu.vn.qltcda1.fragment.SoChiTieuFragment;
import fpoly.edu.vn.qltcda1.fragment.TrangChuFragment;
import fpoly.edu.vn.qltcda1.news.NewsActivity;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        FragmentManager manager = getSupportFragmentManager();
        TrangChuFragment trangChuFragment = new TrangChuFragment();
        manager.beginTransaction().replace(R.id.flContent, trangChuFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            FragmentManager manager1 = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.bottom_trang_chu:
                    setTitle("Trang Chủ");
                    TrangChuFragment trangChuFragment1 = new TrangChuFragment();
                    manager1.beginTransaction().replace(R.id.flContent, trangChuFragment1).commit();
                    break;
                case R.id.bottom_so_chi_tieu:
                    setTitle("Sổ chi tiêu ");
                    SoChiTieuFragment soChiTieuFragment = new SoChiTieuFragment();
                    manager1.beginTransaction().replace(R.id.flContent, soChiTieuFragment).commit();
                    break;
                case R.id.bottom_phan_loai:
                    setTitle("Phân Loại ");
                    PhanLoaiFragment phanLoaiFragment = new PhanLoaiFragment();
                    manager1.beginTransaction().replace(R.id.flContent, phanLoaiFragment).commit();
                    break;
                case R.id.bottom_ca_nhan:
                    setTitle("Cá nhân");
                    CaNhanFragment caNhanFragment = new CaNhanFragment();
                    manager1.beginTransaction().replace(R.id.flContent, caNhanFragment).commit();
                    break;
                case R.id.bottom_news:
                    setTitle("Tin tức ");
                    startActivity(new Intent(getApplicationContext(), NewsActivity.class));
                    break;
            }
            return true;
        });

    }}