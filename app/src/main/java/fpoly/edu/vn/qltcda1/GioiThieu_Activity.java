package fpoly.edu.vn.qltcda1;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GioiThieu_Activity extends AppCompatActivity {
    ImageView Image_thoat_gioithieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu);
        Image_thoat_gioithieu = findViewById(R.id.Image_thoat_gioithieu);
        Image_thoat_gioithieu.setOnClickListener(v -> {
            finish();
        });
    }
}