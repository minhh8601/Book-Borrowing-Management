package entity;

public class QLChiTiet {

    private Sach sach;
    private int soLuong;


    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString(){
        return "QLChiTiet{" +
                "Sách=" + sach +
                ", Số lượng=" + soLuong +
                '}';
    }
}
