package entity;

import java.util.Scanner;

public class Sach {
    public static final String KHTN = "Khoa học tự nhiên";
    public static final String VHNT = "Văn học - Nghệ thuật";
    public static final String DTVT = "Điện tử viễn thông";
    public static final String CNTT = "Công nghệ thông tin";
    private static int AUTO_ID = -1;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private String namXuatBan;
    private String tinhTrang;

    public Sach() {
        if(AUTO_ID==-1){
            AUTO_ID=10000;
            this.maSach=++AUTO_ID;
            return;
        }this.maSach=++AUTO_ID;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString(){
        return "entity.Sach{" +
                "Mã sách=" + maSach +
                ", Tên sách='" + tenSach + '\'' +
                ", Tác giả='" + tacGia + '\'' +
                ", Chuyên ngành='" + chuyenNganh + '\'' +
                ", Năm xuất bản='" + namXuatBan + '\'' +
                ", Tình trạng='" + tinhTrang + '\'' +
                '}';
    }

    public void inputInfo(){
        System.out.print("Nhập tên sách : ");
        this.tenSach=new Scanner(System.in).nextLine();
        System.out.print("Nhập tên tác giả: ");
        this.tacGia=new Scanner(System.in).nextLine();
        System.out.print("Nhập năm xuất bản sách: ");
        this.namXuatBan=new Scanner(System.in).nextLine();
        System.out.print("Nhập tình trạng của sách: ");
        this.tinhTrang=new Scanner(System.in).nextLine();
        System.out.println("Nhập chuyên ngành là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. KHoa học tự nhiên");
        System.out.println("2. Văn học - Nghệ thuật");
        System.out.println("3. Điện tử viễn thông");
        System.out.println("4. Công nghệ thông tin");
        int choice=-1;
        do{
            choice=new Scanner(System.in).nextInt();
            if(choice>=1 && choice<=4){
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại");
        }while(choice>4 || choice<1);
        switch (choice){
            case 1:
                this.chuyenNganh = Sach.KHTN;
                break;
            case 2:
                this.chuyenNganh=Sach.VHNT;
                break;
            case 3:
                this.chuyenNganh=Sach.DTVT;
                break;
            case 4:
                this.chuyenNganh=Sach.CNTT;
                break;
        }

    }
}
