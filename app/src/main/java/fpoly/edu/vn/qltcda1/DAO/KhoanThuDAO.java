package fpoly.edu.vn.qltcda1.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fpoly.edu.vn.qltcda1.database.SQLite;
import fpoly.edu.vn.qltcda1.model.KhoanChi;
import fpoly.edu.vn.qltcda1.model.KhoanThu;
import fpoly.edu.vn.qltcda1.model.TopKhoanChi;
import fpoly.edu.vn.qltcda1.model.TopKhoanThu;

public class KhoanThuDAO {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private SQLiteDatabase db;
    private Context context;
    public KhoanThuDAO(Context context){
        this.context=context;
        SQLite dbHelper = new SQLite(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insert(KhoanThu obj){
        ContentValues values = new ContentValues();
        values.put("tenKhoanThu",obj.getTenKhoanThu());
        values.put("ngayThu", sdf.format(obj.getNgayThu()));
        values.put("sotienKhoanThu",obj.getSoTienKhoanthu());
        values.put("maLoaiThu",obj.getMaLoaiThu());
        return db.insert("KhoanThu",null,values);
    }
    public int update(KhoanThu obj) {
        ContentValues values = new ContentValues();
        values.put("tenKhoanThu",obj.getTenKhoanThu());
        values.put("ngayThu", sdf.format(obj.getNgayThu()));
        values.put("sotienKhoanThu",obj.getSoTienKhoanthu());
        values.put("maLoaiThu",obj.getMaLoaiThu());
        return db.update("KhoanThu",values,"maKhoanThu=?",new String[]{String.valueOf(obj.maKhoanThu)});
    }
    public int delete(String id){
        Toast.makeText(context.getApplicationContext(), "Xóa Thành công",Toast.LENGTH_SHORT).show();
        return db.delete("KhoanThu","maKhoanThu=?",new String[]{id});
    }

    //get all
    public List<KhoanThu>getAll(){
        String sql = "SELECT * FROM KhoanThu";
        return getData(sql);
    }

    //getdata theo id
    public KhoanThu getID(String id){
        String sql = "SELECT * FROM KhoanThu WHERE maKhoanThu=?";
        List<KhoanThu>list=getData(sql,id);
        return list.get(0);
    }

    //get data nhieu tham so
    @SuppressLint("Range")
    private List<KhoanThu> getData(String sql, String...selectionArgs){

        List<KhoanThu> list = new ArrayList<KhoanThu>();

        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            KhoanThu obj = new KhoanThu();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            obj.setMaKhoanThu(Integer.parseInt(c.getString(c.getColumnIndex("maKhoanThu"))));
            obj.setTenKhoanThu( c.getString(c.getColumnIndex("tenKhoanThu"))) ;
            try {
                obj.setNgayThu(sdf.parse(c.getString(c.getColumnIndex("ngayThu"))));
            }catch (ParseException e){
                e.printStackTrace();
            }
            obj.setSoTienKhoanthu(Integer.parseInt(c.getString(c.getColumnIndex("sotienKhoanThu"))));
            obj.setMaLoaiThu(Integer.parseInt(c.getString(c.getColumnIndex("maLoaiThu"))));
            list.add(obj);
        }
        return list;
    }


    @SuppressLint("Range")
    public List<TopKhoanThu>getTopKT(){
        String sqlTopKT = " SELECT maKhoanThu, SUM(sotienKhoanThu) as Tong FROM KhoanThu GROUP BY maKhoanThu ORDER BY Tong DESC LIMIT 20";
        List<TopKhoanThu>list= new ArrayList<TopKhoanThu>();
        KhoanThuDAO khoanThuDAO = new KhoanThuDAO(context);
        Cursor c= db.rawQuery(sqlTopKT,null);
        while (c.moveToNext()){
            TopKhoanThu topKhoanThu = new TopKhoanThu();
            KhoanThu khoanThu =khoanThuDAO.getID(c.getString(c.getColumnIndex("maKhoanThu")));
            topKhoanThu.setTenKhoanThu(khoanThu.getTenKhoanThu());
            topKhoanThu.setSoTienThu(Integer.parseInt(c.getString(c.getColumnIndex("Tong"))));
            list.add(topKhoanThu);
        }
        return list;
    }




    @SuppressLint("Range")
    public  int getThongKeThu(String tuNgay,String denNgay){
        String sqlThongKeThu= "SELECT SUM(sotienKhoanThu) as thongKeThu FROM KhoanThu WHERE ngayThu Between ? AND ? ";
        List<Integer>list = new ArrayList<Integer>();
        Cursor c = db.rawQuery(sqlThongKeThu,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try{
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("thongKeThu"))));
            }
            catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }

    @SuppressLint("Range")
    public double getTongThu(){
        int tongThu=0;
        String sqlTongThu="SELECT SUM(sotienKhoanThu) From KhoanThu as TongThu";

        Cursor c= db.rawQuery(sqlTongThu,null);
        c.moveToFirst();
        while(c.isAfterLast()==false){
            tongThu=c.getInt(0);
            c.moveToNext();
        }
        c.close();
        return tongThu;
    }
}
