package fpoly.edu.vn.qltcda1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {
    static final String dbName = "QLTC";
    static final int dbVersion = 1;

        //tao bang Nguoidung
         static final String CREATE_TABLE_NGUOI_DUNG =
                "create table Nguoidung("+
                        "maNguoidung TEXT PRIMARY KEY,"+
                        "hoTen TEXT NOT NULL,"+
                        "matKhau TEXT NOT NULL)";


        // tao bang Loai Thu
        static final String CREATE_TABLE_LOAI_THU =
                "create table LoaiThu("+
                        "maLoaiThu INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "tenLoaiThu TEXT NOT NULL)";

        // tao bang khoan thu

    static final String CREATE_TABLE_KHOAN_THU=
                "create table KhoanThu("+
                        "maKhoanThu INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "tenKhoanThu TEXT NOT NULL,"+
                        "ngayThu DATE NOT NULL,"+
                        "sotienKhoanThu INTEGER NOT NULL," +
                        "maLoaiThu INTEGER REFERENCES LoaiThu(maLoaiThu))";


        // tao bang Loai Chi
        static final String CREATE_TABLE_LOAI_CHI =
                "create table LoaiChi("+
                        "maLoaiChi INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "tenLoaiChi TEXT NOT NULL)";

        // tao bang khoan chi
        static final String CREATE_TABLE_KHOAN_CHI=
                "create table KhoanChi("+
                        "maKhoanChi INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "tenKhoanChi TEXT NOT NULL,"+
                        "ngayChi DATE NOT NULL,"+
                        "sotienKhoanChi INTEGER NOT NULL,"+
                        "maLoaiChi INTEGER REFERENCES LoaiChi(maLoaiChi))";
    public SQLite(Context context){super(context,dbName,null,dbVersion);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NGUOI_DUNG);
        db.execSQL(CREATE_TABLE_LOAI_THU);
        db.execSQL(CREATE_TABLE_KHOAN_THU);
        db.execSQL(CREATE_TABLE_LOAI_CHI);
        db.execSQL(CREATE_TABLE_KHOAN_CHI);
        //insert into Loại Khoản
        db.execSQL(SQLiteData.INSERT_NGUOI_DUNG);
        db.execSQL(SQLiteData.INSERT_LOAI_THU);
//        db.execSQL(SQLiteData.INSERT_KHOAN_THU);
        db.execSQL(SQLiteData.INSERT_LOAI_CHI);
//        db.execSQL(SQLiteData.INSERT_KHOAN_CHI);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String dropTableNguoidung = "drop table if exists Nguoidung";
        db.execSQL(dropTableNguoidung);
        String dropTableLoaiThu = "drop table if exists LoaiThu";
        db.execSQL(dropTableLoaiThu);
        String dropTableKhoanThu = "drop table if exists KhoanThu";
        db.execSQL(dropTableKhoanThu);
        String dropTableKhoanChi = "drop table if exists KhoanChi";
        db.execSQL(dropTableKhoanChi);
        String dropTableLoaiChi = "drop table if exists LoaiChi";
        db.execSQL(dropTableLoaiChi);
        onCreate(db);
    }
}
