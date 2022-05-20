package fpoly.edu.vn.qltcda1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fpoly.edu.vn.qltcda1.database.SQLite;
import fpoly.edu.vn.qltcda1.model.KhoanChi;
import fpoly.edu.vn.qltcda1.model.KhoanThu;
import fpoly.edu.vn.qltcda1.model.TopKhoanChi;
import fpoly.edu.vn.qltcda1.model.TopKhoanThu;

public class ThongKeDAO {
    private SQLiteDatabase db;
    private Context context;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ThongKeDAO(Context context) {
        this.context = context;
        SQLite dbHelper = new SQLite(context);
        db = dbHelper.getWritableDatabase();
    }

    //     Thong ke top Khoan Chi
    public List<TopKhoanChi> getTop() {
        String sqlTop = "SELECT maKhoanChi,count(maKhoanChi) as soTienThu FROM KhoanChi GROUP BY maKhoanChi ORDER BY soTienThu DESC LIMIT 10";
        List<TopKhoanChi> list = new ArrayList<TopKhoanChi>();
        KhoanChiDAO khoanChiDAO = new KhoanChiDAO(context);
        Cursor c = db.rawQuery(sqlTop, null);

        while (c.moveToNext()) {
            TopKhoanChi topKhoanChi = new TopKhoanChi();
            KhoanChi khoanChi = khoanChiDAO.getID(c.getString(c.getColumnIndex("maKhoanChi")));
            topKhoanChi.tenKhoanChi=khoanChi.tenKhoanChi;
            topKhoanChi.SoTienChi = Integer.parseInt(c.getString(c.getColumnIndex("SoTienThu")));
            list.add(topKhoanChi);
        }
        return list;
    }
    //     Thong ke top Khoan Thu


    public int getDoanhThu(String tuNgay , String denNgay){
        //"SELECT b.lid,b.ten,sum(a.tien)"
        String sqlDoanhThu = "SELECT SUM(SoTienThu) as doanhThu FROM KhoanThu WHERE ngay BETWEEN ? AND ? ";
        List<Integer>list = new ArrayList<Integer>();
        Cursor c = db.rawQuery(sqlDoanhThu,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("KhoanThu"))));
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }

    //chi
    public int getDoanhThu1(String tuNgay , String denNgay){

        String sqlChi = "SELECT SUM(SoTienChi) as doanhThu FROM KhoanChi WHERE ngay BETWEEN ? AND ? ";
        List<Integer>list = new ArrayList<Integer>();
        Cursor c = db.rawQuery(sqlChi,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("KhoanChi"))));
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }
    //so du
    public int getSodu(String tuNgay , String denNgay){
        String sqlSodu = "SELECT -SUM(SoDu) as DoanhThu FROM SoDu WHERE ngay BETWEEN ? AND ?";
        List<Integer>list = new ArrayList<Integer>();
        Cursor c = db.rawQuery(sqlSodu,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("SoDu"))));
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }


}