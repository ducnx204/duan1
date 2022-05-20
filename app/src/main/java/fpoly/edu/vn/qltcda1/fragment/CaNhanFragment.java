package fpoly.edu.vn.qltcda1.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;

import fpoly.edu.vn.qltcda1.DAO.KhoanChiDAO;
import fpoly.edu.vn.qltcda1.DAO.KhoanThuDAO;
import fpoly.edu.vn.qltcda1.DAO.NguoiDungDAO;
import fpoly.edu.vn.qltcda1.DoiMatKhau_Activity;
import fpoly.edu.vn.qltcda1.GioiThieu_Activity;
import fpoly.edu.vn.qltcda1.LoginActivity;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.TroGiup_Activity;
import fpoly.edu.vn.qltcda1.model.NguoiDung;

public class CaNhanFragment extends Fragment {
    KhoanChiDAO dao;
    KhoanThuDAO dao2;
    NguoiDungDAO nguoiDungDAO;
    TextView tvSoDu,tvdoimatkhau,tvdangxuat,tvtrogiup,tvgioithieu,tvUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_ca_nhan, container, false);
        dao= new KhoanChiDAO(getActivity());
        dao2=new KhoanThuDAO(getActivity());


        tvUser = v.findViewById(R.id.tvUserName);
        nguoiDungDAO = new NguoiDungDAO(getContext());
        Intent i = getActivity().getIntent();
        String user = i.getStringExtra("user");
        NguoiDung nguoiDung = nguoiDungDAO.getID(user);
        String UserName = nguoiDung.hoTen;
        tvUser.setText(UserName+"");

        tvSoDu=v.findViewById(R.id.tv_soducanhan);

        tvSoDu.setText("Số Dư : "+(dao2.getTongThu()-dao.getTongChi())+" VND ");

        tvdangxuat = v.findViewById(R.id.tvdangxuat);
        tvdoimatkhau = v.findViewById(R.id.tvdoimatkhau);
        tvtrogiup = v.findViewById(R.id.tvtrogiup);
        tvgioithieu = v.findViewById(R.id.tvgioithieuapp);

        tvgioithieu.setOnClickListener(v1 -> {
            Intent intent =new Intent(getActivity(), GioiThieu_Activity.class);
            startActivity(intent);
            return;
        });
        tvtrogiup.setOnClickListener(v1 -> {
            Intent intent = new Intent(getActivity(), TroGiup_Activity.class);
            startActivity(intent);
            return;
        });

        tvdoimatkhau.setOnClickListener(v1 -> {
            Intent intent = new Intent(getActivity(), DoiMatKhau_Activity.class);
            startActivity(intent);
            return;

        });
        tvdangxuat.setOnClickListener(v1 -> {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
            Toast.makeText(getContext(),"Đăng Xuất Thành Công",Toast.LENGTH_SHORT).show();
            return;
        });
        return v;
    }





}