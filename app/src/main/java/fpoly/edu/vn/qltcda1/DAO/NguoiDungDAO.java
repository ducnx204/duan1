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
import fpoly.edu.vn.qltcda1.model.NguoiDung;

public class NguoiDungDAO {
    private SQLiteDatabase db;
    private Context context;
    public NguoiDungDAO(Context context){
        this.context=context;
        SQLite dbHelper = new SQLite(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insert(NguoiDung obj){
        ContentValues values = new ContentValues();
        values.put("maNguoidung",obj.getMaNguoidung());
        values.put("hoTen",obj.getHoTen());
        values.put("matKhau",obj.getMatKhau());
        return db.insert("Nguoidung",null,values);
    }
    public int updatePass(NguoiDung obj){
        ContentValues values = new ContentValues();
        values.put("maNguoidung",obj.getMaNguoidung());
        values.put("hoTen",obj.getHoTen());
        values.put("matKhau",obj.getMatKhau());
        return db.update("Nguoidung",values,"maNguoidung=?",new String[]{String.valueOf(obj.maNguoidung)});

    }

    public int delete(String id){
        Toast.makeText(context.getApplicationContext(), "Xóa Thành công",Toast.LENGTH_SHORT).show();
        return db.delete("Nguoidung","maNguoidung=?",new String[]{id});
    }


    //get tat ca data
    public List<NguoiDung> getAll(){
        String sql = "SELECT * FROM Nguoidung";
        return getData(sql);
    }
    //get tat ca theo id
    public NguoiDung getID(String id){
        String sql = "SELECT * FROM Nguoidung WHERE maNguoidung = ?";
        List<NguoiDung>list = getData(sql,id);
        return list.get(0);
//
    }
    //get data tham so
    @SuppressLint("Range")
    private List<NguoiDung>getData(String sql,String...selectionArgs){
//        Cursor c = db.rawQuery(sql,selectionArgs);
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        List<NguoiDung>list = new ArrayList<NguoiDung>();

        while (cursor.moveToNext()){
            NguoiDung obj = new NguoiDung();
            obj.setMaNguoidung( cursor.getString(cursor.getColumnIndex("maNguoidung")));
            obj.setHoTen(cursor.getString(cursor.getColumnIndex("hoTen")));
            obj.setMatKhau(cursor.getString(cursor.getColumnIndex("matKhau")));
            list.add(obj);
        }
        return list;
    }

    //check login
    public int CheckLogin(String id,String password){
        String sql = "SELECT * FROM Nguoidung WHERE maNguoidung=? AND matkhau=?";
        List<NguoiDung>list = getData(sql,id,password);
        if (list.size()==0)
            return -1;
        return 1;

    }

}
