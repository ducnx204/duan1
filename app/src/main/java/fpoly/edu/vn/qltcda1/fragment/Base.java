package fpoly.edu.vn.qltcda1.fragment;

import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Base extends Fragment {
    Context context;
    public void showMsgF(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
}}
