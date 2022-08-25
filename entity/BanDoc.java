package entity;

import java.util.Scanner;

public class BanDoc {

    //dùng static final tạo 3 giá trị cho loại bạn đọc
    public static final String SV="Sinh viên";
    public static final String HVCH="Học viên cao học";
    public static final String GV="Giangr viên";
    private static int AUTO_ID=-1;
    private int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String loaiBanDoc;

    public BanDoc(){
        if(AUTO_ID==-1){
            AUTO_ID=10000;
            this.maBanDoc=++AUTO_ID;
            return;
        }
        this.maBanDoc=++AUTO_ID;
    }

    public int getMaBanDoc(){
        return maBanDoc;
    }

    public String getHoTen(){
        return hoTen;
    }

    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(String loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    @Override

    public String toString(){
        return "entity.BanDoc{" +
                "Mã bạn đọc=" + maBanDoc +
                ", Họ tên='" + hoTen + '\'' +
                ", Địa chỉ='" + diaChi + '\'' +
                ", Số điện thoại='" + sdt + '\'' +
                ", Loại bạn đọc='" + loaiBanDoc + '\'' +
                '}';
    }

    public void inputInfo(){
        System.out.print("Nhập tên bạn đọc: ");
        this.hoTen=new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ bạn đọc: ");
        this.diaChi=new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại bạn đọc: ");
        this.sdt=new Scanner(System.in).nextLine();
        System.out.println("Nhập loại bạn đọc là 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giảng viên");
        int choice=-1;
        do{
            choice=new Scanner(System.in).nextInt();
            if(choice>=1 && choice<=3){
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại");
        }while(choice>3 || choice<1);
        switch (choice){
            case 1:
                this.loaiBanDoc = BanDoc.SV;
                break;
            case 2:
                this.loaiBanDoc=BanDoc.HVCH;
                break;
            case 3:
                this.loaiBanDoc=BanDoc.GV;
                break;
        }

    }
}
