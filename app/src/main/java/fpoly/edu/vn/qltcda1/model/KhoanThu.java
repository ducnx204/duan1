package fpoly.edu.vn.qltcda1.model;

import java.util.Date;

public class KhoanThu {
    public int maKhoanThu;
    public String tenKhoanThu;
    public Date ngayThu;
    public int soTienKhoanthu;
    public int maLoaiThu;

    public KhoanThu() {
    }

    public KhoanThu(int maKhoanThu, String tenKhoanThu, Date ngayThu, int soTienKhoanthu, int maLoaiThu) {
        this.maKhoanThu = maKhoanThu;
        this.tenKhoanThu = tenKhoanThu;
        this.ngayThu = ngayThu;
        this.soTienKhoanthu = soTienKhoanthu;
        this.maLoaiThu = maLoaiThu;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

    public int getSoTienKhoanthu() {
        return soTienKhoanthu;
    }

    public void setSoTienKhoanthu(int soTienKhoanthu) {
        this.soTienKhoanthu = soTienKhoanthu;
    }

    public int getMaLoaiThu() {
        return maLoaiThu;
    }

    public void setMaLoaiThu(int maLoaiThu) {
        this.maLoaiThu = maLoaiThu;
    }
}
