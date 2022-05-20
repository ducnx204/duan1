package fpoly.edu.vn.qltcda1.model;

public class NguoiDung {
    public String maNguoidung;
    public String hoTen;
    public String matKhau;

    public NguoiDung() {
    }

    public NguoiDung(String maNguoidung, String soDienthoai, String hoTen, String matKhau) {
        this.maNguoidung = maNguoidung;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
    }

    public String getMaNguoidung() {
        return maNguoidung;
    }

    public void setMaNguoidung(String maNguoidung) {
        this.maNguoidung = maNguoidung;
    }



    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
