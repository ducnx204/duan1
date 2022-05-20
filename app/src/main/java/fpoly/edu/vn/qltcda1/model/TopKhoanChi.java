package fpoly.edu.vn.qltcda1.model;

public class TopKhoanChi {
    public String tenKhoanChi;
    public int SoTienChi;

    public TopKhoanChi() {
    }

    public TopKhoanChi(String tenKhoanChi, int soTienChi) {
        this.tenKhoanChi = tenKhoanChi;
        SoTienChi = soTienChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public int getSoTienChi() {
        return SoTienChi;
    }

    public void setSoTienChi(int soTienChi) {
        SoTienChi = soTienChi;
    }
}
