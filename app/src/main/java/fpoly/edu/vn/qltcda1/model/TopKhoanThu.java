package fpoly.edu.vn.qltcda1.model;

public class TopKhoanThu {
    public String tenKhoanThu;
    public int SoTienThu;

    public TopKhoanThu() {
    }

    public TopKhoanThu(String tenKhoanThu, int soTienThu) {
        this.tenKhoanThu = tenKhoanThu;
        this.SoTienThu = soTienThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public int getSoTienThu() {
        return SoTienThu;
    }

    public void setSoTienThu(int soTienThu) {
        SoTienThu = soTienThu;
    }
}
