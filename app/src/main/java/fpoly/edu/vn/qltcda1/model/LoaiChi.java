package fpoly.edu.vn.qltcda1.model;

public class LoaiChi {
    public int maLoaiChi;
    public String tenLoaiChi;

    public LoaiChi() {
    }

    public LoaiChi(int maLoaiChi, String tenLoaiChi) {
        this.maLoaiChi = maLoaiChi;
        this.tenLoaiChi = tenLoaiChi;
    }

    public int getMaLoaiChi() {
        return maLoaiChi;
    }

    public void setMaLoaiChi(int maLoaiChi) {
        this.maLoaiChi = maLoaiChi;
    }

    public String getTenLoaiChi() {
        return tenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }
}
