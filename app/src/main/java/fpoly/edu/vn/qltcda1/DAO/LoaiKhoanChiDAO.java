package fpoly.edu.vn.qltcda1.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

import fpoly.edu.vn.qltcda1.database.SQLite;
import fpoly.edu.vn.qltcda1.model.LoaiChi;

public class LoaiKhoanChiDAO {

    private SQLiteDatabase db;
    private Context context;
    public LoaiKhoanChiDAO(Context context){
        this.context = context;
        SQLite dbHelper = new SQLite(context);
        db = dbHelper.getWritableDatabase();

    }

    public long insert(LoaiChi obj){
        ContentValues values = new ContentValues();
        values.put("tenLoaiChi",obj.getTenLoaiChi());
        return db.insert("LoaiChi",null,values);
    }
    public int update(LoaiChi obj){
        ContentValues values = new ContentValues();
        values.put("maLoaiChi",obj.getMaLoaiChi());
        values.put("tenLoaiChi",obj.getTenLoaiChi());
        return db.update("LoaiChi",values,"maLoaiChi=?",new String[]{String.valueOf(obj.maLoaiChi)});
    }

        public int delete(String id){
        Toast.makeText(context.getApplicationContext(), "Xóa Thành công",Toast.LENGTH_SHORT).show();

        return db.delete("LoaiChi","maLoaiChi=?",new String[]{id});
    }


    //get tat ca data
    public List<LoaiChi> getAll(){
        String sql = "SELECT * FROM LoaiChi";

        return getData(sql);
    }
    //get tat ca theo id
    public LoaiChi getID(String id){
        String sql = "SELECT * FROM LoaiChi WHERE maLoaiChi=?";
        List<LoaiChi>list = getData(sql,id);
        return list.get(0);
    }
    //get data tham so
    @SuppressLint("Range")
    private List<LoaiChi>getData(String sql,String...selectionArgs){

        List<LoaiChi>list = new ArrayList<LoaiChi>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            LoaiChi obj = new LoaiChi();
            obj.setMaLoaiChi(Integer.parseInt(c.getString(c.getColumnIndex("maLoaiChi"))));
            obj.setTenLoaiChi(  c.getString(c.getColumnIndex("tenLoaiChi")));

            list.add(obj);
        }
        return list;
    }
    @SuppressLint("Range")
    public double getSoLoaiChi(){
        int tongSoLoaiChi=0;
        String sqlTongLoaiChi="SELECT count(tenLoaiChi) From LoaiChi as TongLoaiChi";

        Cursor c= db.rawQuery(sqlTongLoaiChi,null);
        c.moveToFirst();
        while(c.isAfterLast()==false){
            tongSoLoaiChi=c.getInt(0);
            c.moveToNext();
        }
        c.close();
        return tongSoLoaiChi;
    }
}
