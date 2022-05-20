package fpoly.edu.vn.qltcda1.model;

import java.util.Date;

public class KhoanChi {
    public int maKhoanChi;
    public String tenKhoanChi;
    public Date ngayChi;
    public int soTienKhoanchi;
    public int maLoaiChi;

    public KhoanChi() {
    }

    public KhoanChi(int maKhoanChi, String tenKhoanChi, Date ngayChi, int soTienKhoanchi, int maLoaiChi) {
        this.maKhoanChi = maKhoanChi;
        this.tenKhoanChi = tenKhoanChi;
        this.ngayChi = ngayChi;
        this.soTienKhoanchi = soTienKhoanchi;
        this.maLoaiChi = maLoaiChi;
    }

    public int getMaKhoanChi() {
        return maKhoanChi;
    }

    public void setMaKhoanChi(int maKhoanChi) {
        this.maKhoanChi = maKhoanChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public int getSoTienKhoanchi() {
        return soTienKhoanchi;
    }

    public void setSoTienKhoanchi(int soTienKhoanchi) {
        this.soTienKhoanchi = soTienKhoanchi;
    }

    public int getMaLoaiChi() {
        return maLoaiChi;
    }

    public void setMaLoaiChi(int maLoaiChi) {
        this.maLoaiChi = maLoaiChi;
    }
}
