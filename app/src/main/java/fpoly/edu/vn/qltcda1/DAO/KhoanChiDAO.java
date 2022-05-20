package fpoly.edu.vn.qltcda1.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class KhoanChiDAO {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private SQLiteDatabase db;
    private Context context;
    public KhoanChiDAO(Context context){
        this.context=context;
        SQLite dbHelper = new SQLite(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(KhoanChi obj){
        ContentValues values = new ContentValues();
        values.put("tenKhoanChi",obj.getTenKhoanChi());
        values.put("sotienkhoanChi",obj.getSoTienKhoanchi());
        values.put("ngayChi", sdf.format(obj.getNgayChi()));
        values.put("maLoaiChi",obj.getMaLoaiChi());
        return db.insert("KhoanChi",null,values);
    }
    public int update(KhoanChi obj) {
        ContentValues values = new ContentValues();
        values.put("tenKhoanChi",obj.getTenKhoanChi());
        values.put("sotienkhoanChi",obj.getSoTienKhoanchi());
        values.put("ngayChi", sdf.format(obj.getNgayChi()));
        values.put("maLoaiChi",obj.getMaLoaiChi());
        return db.update("KhoanChi",values,"maKhoanChi=?",new String[]{String.valueOf(obj.maKhoanChi)});
    }
    public int delete(String id){
        Toast.makeText(context.getApplicationContext(), "Xóa Thành công",Toast.LENGTH_SHORT).show();
        return db.delete("KhoanChi","maKhoanChi=?",new String[]{id});
    }

    //get data nhieu tham so
    @SuppressLint("Range")
    private List<KhoanChi> getData(String sql, String...selectionArgs){

        List<KhoanChi> list = new ArrayList<KhoanChi>();

        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            KhoanChi obj = new KhoanChi();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            obj.setMaKhoanChi( Integer.parseInt(c.getString(c.getColumnIndex("maKhoanChi"))));
            obj.setTenKhoanChi( c.getString(c.getColumnIndex("tenKhoanChi")));
            try {
                obj.setNgayChi(sdf.parse(c.getString(c.getColumnIndex("ngayChi"))));
            }catch (ParseException e){
                e.printStackTrace();
            }
            obj.setSoTienKhoanchi(Integer.parseInt(c.getString(c.getColumnIndex("sotienKhoanChi"))));
            obj.setMaLoaiChi(Integer.parseInt(c.getString(c.getColumnIndex("maLoaiChi"))));



            list.add(obj);
        }
        return list;
    }


//    public Cursor GetDate(String sql){
//        SQLite sqLite = getReadableDatabase();
//        return database.rawQuery(sql,null);
//    }
    //get all
    public List<KhoanChi>getAll(){
        String sql = "SELECT * FROM KhoanChi";
        return getData(sql);
    }
    //getdata theo id
    public KhoanChi getID(String id){
        String sql = "SELECT * FROM KhoanChi WHERE maKhoanChi=?";
        List<KhoanChi>list=getData(sql,id);
        return list.get(0);
    }



    @SuppressLint("Range")
    public  int getThongKeChi(String tuNgay,String denNgay){
        String sqlThongKeChi= "SELECT  SUM(sotienKhoanChi) as thongKeChi FROM KhoanChi WHERE ngayChi Between ? AND ? ";
        List<Integer>list = new ArrayList<Integer>();
        Cursor c = db.rawQuery(sqlThongKeChi,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try{
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("thongKeChi"))));
            }
            catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }
    @SuppressLint("Range")
    public double getTongChi(){
        int tongChi=0;
     String sqlTongChi="SELECT SUM(sotienKhoanChi) From KhoanChi as TongChi";

     Cursor c= db.rawQuery(sqlTongChi,null);
     c.moveToFirst();
     while(c.isAfterLast()==false){
     tongChi=c.getInt(0);
     c.moveToNext();
     }
        c.close();
     return tongChi;
    }

    @SuppressLint("Range")
    public List<TopKhoanChi>getTopKC(){

        String sqlTopKC = " SELECT maKhoanChi, SUM(sotienKhoanChi) as Tong FROM KhoanChi GROUP BY maKhoanChi ORDER BY Tong DESC LIMIT 20 ";
        List<TopKhoanChi>list= new ArrayList<TopKhoanChi>();
        KhoanChiDAO khoanChiDAO = new KhoanChiDAO(context);
        Cursor c= db.rawQuery(sqlTopKC,null);
        while (c.moveToNext()){
            TopKhoanChi topKhoanChi = new TopKhoanChi();
            KhoanChi khoanChi =khoanChiDAO.getID(c.getString(c.getColumnIndex("maKhoanChi")));
            topKhoanChi.setTenKhoanChi(khoanChi.getTenKhoanChi());
            topKhoanChi.setSoTienChi(Integer.parseInt(c.getString(c.getColumnIndex("Tong"))));
            list.add(topKhoanChi);
        }
        return list;
    }
}
