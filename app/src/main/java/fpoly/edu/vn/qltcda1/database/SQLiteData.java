package fpoly.edu.vn.qltcda1.database;

public class SQLiteData {

    public static final String INSERT_NGUOI_DUNG = "Insert into NguoiDung(maNguoidung,HoTen,MatKhau) values " +
            "('admin','nhóm 2','123'),"+
            "('tri','Trí','123'),"+
            "('nhatanh','HN.Anh','123'),"+
            "('duc','X.Đức','123'),"+
            "('dat','Q.Đạt','123'),"+
            "('ducanh','ND.Anh','123')";
   public static final String  INSERT_LOAI_THU="Insert into LoaiThu(maLoaiThu,tenLoaiThu) values " +
          "('1','Lương'),"+
            "('2','Lãi Bitcoin'),"+
            "('3','Lãi bán hàng')";

//    public static final String  INSERT_KHOAN_THU="Insert into KhoanThu(maKhoanThu,tenKhoanThu,ngayThu,sotienKhoanThu,maLoaiThu) values " +
//           "('1','Luong','07-07-2021','9000','1'),"+
//            "('2','Lãi Bitcoin','07-07-2021','4000','2')";


    public static final String INSERT_LOAI_CHI="Insert into LoaiChi(maLoaiChi,tenLoaiChi) values"+
            "('1','Ăn'),"+
            "('2','Nhậu'),"+
            "('3','Du Lich')";

//    public static final String INSERT_KHOAN_CHI="Insert into KhoanChi(maKhoanChi,tenKhoanChi,ngayChi,sotienKhoanChi,maLoaiChi) values"+
//            "('1','Ăn Cơm gà','10-10-2021','3000','1'),"+
//            "('2','Ăn Cháo','09-08-2021','2000','1'),"+
//            "('3','Nhậu sambaidj','10-08-2021','90000','2')";

}
