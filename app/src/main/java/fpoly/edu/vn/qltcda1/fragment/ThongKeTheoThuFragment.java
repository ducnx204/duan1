package fpoly.edu.vn.qltcda1.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


import fpoly.edu.vn.qltcda1.DAO.KhoanThuDAO;
import fpoly.edu.vn.qltcda1.R;


public class ThongKeTheoThuFragment extends Fragment {
    Button btnTuNgay,btnDenNgay,btnThongKeThu;
    TextView tvThongKeThu;
    EditText edTuNgay,edDenNgay;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    int mYear,mMonth,mDay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_thong_ke_theo_thu, container, false);
        edTuNgay=v.findViewById(R.id.edTuNgay);
        edDenNgay=v.findViewById(R.id.edDenNgay);
        tvThongKeThu =v.findViewById(R.id.tvThongKeThu);
        btnTuNgay=v.findViewById(R.id.btnTuNgay);
        btnDenNgay=v.findViewById(R.id.btnDenNgay);
        btnThongKeThu=v.findViewById(R.id.btnThongKeThu);
        btnTuNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                mYear=c.get(Calendar.YEAR);
                mMonth=c.get(Calendar.MONTH);
                mDay=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d= new DatePickerDialog(getActivity(),0,mDateTuNgay,mYear,mMonth,mDay);
                d.show();
            }
        });
        btnDenNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                mYear=c.get(Calendar.YEAR);
                mMonth=c.get(Calendar.MONTH);
                mDay=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d= new DatePickerDialog(getActivity(),0,mDateDenNgay,mYear,mMonth,mDay);
                d.show();
            }
        });
        btnThongKeThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tuNgay=edTuNgay.getText().toString();
                String denNgay=edDenNgay.getText().toString();
                KhoanThuDAO khoanThuDAO = new KhoanThuDAO(getActivity());
                tvThongKeThu.setText("Thống Kê : "+khoanThuDAO.getThongKeThu(tuNgay,denNgay)+"VND");

            }
        });
        return v ;
    }
    DatePickerDialog.OnDateSetListener mDateTuNgay= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear= year;
            mMonth=monthOfYear;
            mDay = dayOfMonth;
            GregorianCalendar c= new GregorianCalendar(mYear,mMonth,mDay);
            edTuNgay.setText(sdf.format(c.getTime()));
        }
    };
    DatePickerDialog.OnDateSetListener mDateDenNgay= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear= year;
            mMonth=monthOfYear;
            mDay = dayOfMonth;
            GregorianCalendar c= new GregorianCalendar(mYear,mMonth,mDay);
            edDenNgay.setText(sdf.format(c.getTime()));
        }
    };
}