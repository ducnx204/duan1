package fpoly.edu.vn.qltcda1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TroGiup_Activity extends AppCompatActivity {
    ImageView Image_thoat_trogiup;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tro_giup);
        setTitle("Trợ Giúp");
        linearLayout =findViewById(R.id.linearLayout);
        Image_thoat_trogiup=findViewById(R.id.Image_thoat_trogiup);
        Image_thoat_trogiup.setOnClickListener(v -> {
            finish();
        });
    }
}