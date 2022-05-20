package fpoly.edu.vn.qltcda1.model;

public class LoaiThu {
    public int  maLoaiThu;
    public String tenLoaiThu;


    public LoaiThu() {
    }

    public LoaiThu(int maLoaiThu, String tenLoaiThu) {
        this.maLoaiThu = maLoaiThu;
        this.tenLoaiThu = tenLoaiThu;

    }



    public int getMaLoaiThu() {
        return maLoaiThu;
    }

    public void setMaLoaiThu(int maLoaiThu) {
        this.maLoaiThu = maLoaiThu;
    }

    public String getTenLoaiThu() {
        return tenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }
}
