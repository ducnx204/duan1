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
import fpoly.edu.vn.qltcda1.model.LoaiThu;

public class LoaiKhoanThuDAO {

    private SQLiteDatabase db;
    private Context context;
    public LoaiKhoanThuDAO(Context context){
        this.context = context;
        SQLite dbHelper = new SQLite(context);
        db = dbHelper.getWritableDatabase();

    }

    public long insert(LoaiThu obj){
        ContentValues values = new ContentValues();

        values.put("tenLoaiThu",obj.tenLoaiThu);
        return db.insert("LoaiThu",null,values);
    }
    public int update(LoaiThu obj){
        ContentValues values = new ContentValues();
        values.put("maLoaiThu",obj.maLoaiThu);
        values.put("tenLoaiThu",obj.tenLoaiThu);
        return db.update("LoaiThu",values,"maLoaiThu=?",new String[]{String.valueOf(obj.maLoaiThu)});
    }

    public int delete(String id){
        Toast.makeText(context.getApplicationContext(), "Xóa Thành công",Toast.LENGTH_SHORT).show();

        return db.delete("LoaiThu","maLoaiThu=?",new String[]{id});
    }


    //get tat ca data
    public List<LoaiThu> getAll(){
        String sql = "SELECT * FROM LoaiThu";

        return getData(sql);
    }
    //get tat ca theo id
    public LoaiThu getID(String id){
        String sql = "SELECT * FROM LoaiThu WHERE maLoaiThu=?";
        List<LoaiThu>list = getData(sql,id);
        return list.get(0);
    }
    //get data nhieu tham so
    @SuppressLint("Range")
    private List<LoaiThu>getData(String sql,String...selectionArgs){

        List<LoaiThu>list = new ArrayList<LoaiThu>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            LoaiThu obj = new LoaiThu();
           obj.setMaLoaiThu(Integer.parseInt( c.getString(c.getColumnIndex("maLoaiThu"))));
            obj.setTenLoaiThu(c.getString(c.getColumnIndex("tenLoaiThu")));
            list.add(obj);
        }
        return list;
    }
}
