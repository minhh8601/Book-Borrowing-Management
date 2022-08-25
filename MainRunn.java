import entity.BanDoc;
import entity.QLChiTiet;
import entity.Sach;
import entity.QLMuonSach;
import java.util.Scanner;
public class MainRunn {
    private static BanDoc[] READERS= new BanDoc[100]; //tập hợp bạn đọc;
    private static Sach[] BOOKS= new Sach[100]; //tập hợp sách trong thư viện;
    private static QLMuonSach[] BORROW= new QLMuonSach[100];

    private static QLChiTiet[] DETAIL=new QLChiTiet[100];

    public static void main(String[] args) {
        Menu();
    }

    private static void Menu(){
        while(true){
            int funtionChoice = funtionChoice();
            switch (funtionChoice){
                case 1:
                    nhapBanDocMoi();
                    break;
                case 2:
                    hienthiBanDoc();
                    break;
                case 3:
                    nhapSachMoi();
                    break;
                case 4:
                    hienthiSach();
                    break;
                case 5:
                    taoPhieuMuon();
                    hienDSPhieuMuon();
                    break;
                case 6:
                    hienDSPhieuMuon();

                    break;
                case 7:
                    sapxepPhieuMuon();
                    break;
                case 8:
                    timkiemTen();
                    break;
                case 9:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi");
                    return;
            }
        }
    }

    private static int funtionChoice(){
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ MƯỢN SÁCH =====\n\n");
        System.out.println("1. Nhập danh sách bạn đọc mới.");
        System.out.println("2. In ra danh sách bạn đọc trong hệ thống.");
        System.out.println("3. Nhập danh sách sách mới.");
        System.out.println("4. In ra danh sách sách trong hệ thống.");
        System.out.println("5. Lập phiếu mượn sách cho bạn đọc.");
        System.out.println("6. Sắp xếp danh sách quản lý theo họ tên bạn đọc.");
        System.out.println("7. Sắp xếp danh sách quản lý theo số lượng mượn giảm dần.");
        System.out.println("8. Tìm kiếm  theo họ tên bạn đọc.");
        System.out.println("9. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int funtionChoice=-1;
        do{
            funtionChoice=new Scanner(System.in).nextInt();
            if(funtionChoice>=1 && funtionChoice<=9){
                break;
            }
            System.out.print("Chức năng chọn không họp lệ, vui lòng chọn lại: ");
        }while(funtionChoice>9||funtionChoice<1);
        return funtionChoice;
    }

    //Nhập bạn đọc mới
    private static void nhapBanDocMoi() {
        System.out.print("Nhập số lượng bạn đọc mới muốn thêm: ");
        int newBanDocMoi = new Scanner(System.in).nextInt();
        for (int i = 0; i < newBanDocMoi; i++) {
            System.out.println("Nhập thông tin cho bạn đọc thứ " + (i + 1));
            // nhập thông tin cho bạn đọc
            BanDoc banDoc = new BanDoc();
            banDoc.inputInfo();

            // lưu vào hệ thống ==> thêm vào mảng READERS đã khai báo ở teên
            luuBanDoc(banDoc);
        }
    }
    // Lưu thông tin bạn đọc
    private static void luuBanDoc(BanDoc banDoc){
        for(int j=0;j<READERS.length;j++){
            if(READERS[j]==null){
                READERS[j]=banDoc;
                break;
            }
        }
    }

    // Hiển thị danh sách bạn đọc

    private static void hienthiBanDoc(){
        for(int i=0;i<READERS.length;i++){
            if(READERS[i]==null){
                continue;
            }
            System.out.println(READERS[i]);
        }
    }

    //Nhập sách mới.

    private static void nhapSachMoi() {
        System.out.print("Nhập số lượng sách mới muốn thêm: ");
        int newSachMoi = new Scanner(System.in).nextInt();
        for (int i = 0; i < newSachMoi; i++) {
            System.out.println("Nhập thông tin cho cuốn sách thứ " + (i + 1));
            // nhập thông tin cho sách mới
            Sach sach = new Sach();
            sach.inputInfo();

            // lưu vào hệ thống ==> thêm vào mảng BOOKS đã khai báo ở teên
            luuSachMoi(sach);
        }
    }
    // Lưu thông tin sách mới
    private static void luuSachMoi(Sach sach){
        for(int j=0;j<BOOKS.length;j++){
            if(BOOKS[j]==null){
                BOOKS[j]=sach;
                break;
            }
        }
    }

    // Hiển thị tất cả sách

    private static void hienthiSach(){
        for(int i=0;i<BOOKS.length;i++){
            if(BOOKS[i]==null){
                continue;
            }
            System.out.println(BOOKS[i]);
        }
    }

    // Tạo Phiếu Mượn
    private static void taoPhieuMuon(){
        //Kiểm tra danh sách bạn đọc và danh sách sách có dữu liệu chưa
        if(!checkData()){
            System.out.println("Chưa có dữ liệu để thao tác, vui lòng nhập thêm ");
            return;
        }

        //0. Nhập số lượng bạn đọc muốn mượn sách
        System.out.print("Nhập số lượng bạn đọc muốn mượn sách: ");
        int newBanDoc = new Scanner(System.in).nextInt();
        for(int i=0;i< newBanDoc;i++){
            QLMuonSach phieumuon= new QLMuonSach();
            //1. Xác định bạn đọc nào là người mượn
            //=> Phải nhập id bạn đọc để xác định
            BanDoc banDoc=nhapBanDoc(i);
            // Lưu bạn đọc vào phiếu mượn
            phieumuon.setBanDoc(banDoc);
            //2.Xác định bạn đọc này mượn sách nào
            QLChiTiet[] QLCTS = taoQLCT();
            phieumuon.setQLCT(QLCTS);
            // Lưu vào danh sách phiếu muọn

            savePhieuMuon(phieumuon);
        }
    }
    private static boolean checkData(){
        boolean CSDLBanDoc = false;
        for(int i=0; i< READERS.length;i++){
            if(READERS[i]!=null){
                CSDLBanDoc=true;
                break;
            }
        }
        boolean CSDLSach = false;
        for(int i=0;i< BORROW.length;i++){
            if(BOOKS[i]!=null){
                CSDLSach=true;
                break;
            }
        }
        return CSDLBanDoc && CSDLSach;
    }
    private static QLChiTiet[] taoQLCT(){
        System.out.print("Nhập số lượng sách  muốn mượn: ");
        int soluongSach = new Scanner(System.in).nextInt();
        QLChiTiet[] QLCTS= new QLChiTiet[soluongSach];
        for(int j=0;j<soluongSach;j++){
            QLChiTiet QLCT = new QLChiTiet();
            //2.1 Xác định bạn đọc mượn sách nào
            //=> người dùng phải nhập id sách muốn mua
            Sach sach = nhapSach(j);
            // Lưu sách tìm đuọc vào hóa đơn
            QLCT.setSach(sach);

            System.out.print("Nhập số lượng muốn mượn: ");
            int soluong;
            do{
                soluong = new Scanner(System.in).nextInt();
                if(soluong>0 && soluong <=15){
                    break;
                }
                System.out.print("Số lượng mượn phải lớn hơn 0 và không quá 15 cuốn, vui lòng nhập lại:");
            }while(true);
            QLCT.setSoLuong(soluong);

            // Lưu chi tiết phiếu mượn vào phiêu mượn
            for(int i=0;i<QLCTS.length;i++){
                if(QLCTS[i]==null){
                    QLCTS[i]=QLCT;
                    break;
                }
            }
        }
        return QLCTS;

    }
    private static BanDoc nhapBanDoc(int index){
        System.out.print("Xin mời nhập mã bạn đọc "+(index+1)+ "muốn mượn sách");
        int idBanDoc;
        BanDoc banDoc;
        do{
            idBanDoc=new Scanner(System.in).nextInt();
            banDoc= timBanDoctheoId(idBanDoc);
            if(banDoc!=null){
                break;
            }
            System.out.print("Không tồm tại bạn đọc có id là:"+idBanDoc+", vui lòng nhập lại:");
        }while(true);
        return banDoc;
    }

    private static Sach nhapSach(int index) {
        System.out.print("Xin mời nhập ID của sách thứ " + (index + 1) + " mà bạn đọc này muốn mượn: ");
        int idSach;
        Sach sach;
        do {
            idSach = new Scanner(System.in).nextInt();
            sach = timkiemSachtheoId(idSach);
            if (sach != null) {
                break;
            }
            System.out.print("Không tồn tại sách có ID là " + idSach + ", vui lòng nhập lại: ");
        } while (true);
        return sach;
    }

    private static void savePhieuMuon(QLMuonSach phieumuon){
        for(int i=0;i<BORROW.length;i++){
            if(BORROW[i]==null){
                BORROW[i]=phieumuon;
                return;
            }
        }
    }

    private static Sach timkiemSachtheoId(int idSach){
        for (int i = 0; i < BOOKS.length; i++) {
            Sach sach = BOOKS[i];
            if (sach != null && sach.getMaSach() == idSach) {
                return sach;
            }
        }
        return null;
    }

    private static BanDoc timBanDoctheoId(int idBanDoc){
        for (int i = 0; i < READERS.length; i++) {
            BanDoc banDoc = READERS[i];
            if (banDoc != null && banDoc.getMaBanDoc() == idBanDoc) {
                return banDoc;
            }
        }
        return null;
    }

    private static void hienDSPhieuMuon(){
        for (int i = 0; i < BORROW.length; i++) {
            QLMuonSach phieumuon = BORROW[i];
            if (phieumuon != null) {
                System.out.println("Bạn đọc " + phieumuon.getBanDoc().getHoTen() + " đã mượn sách: ");
                for (int j = 0; j < phieumuon.getQLCT().length; j++) {
                    System.out.println(phieumuon.getQLCT()[j]);
                }
                System.out.println("-------------------------------");
            }
        }

    }
    private static void sapxepPhieuMuon(){
        boolean CSDLPhieuMuon= false;
        for(int i=0;i<BORROW.length;i++){
            if(BORROW[i]!=null){
                CSDLPhieuMuon=true;
            }
        }
        if(!CSDLPhieuMuon){
            System.out.println("Dữ liệu rỗng, vui lòng tạo thêm phiếu mượn");
            return;
        }
        sapXepPhieuMuontheoTen();
        hienDSPhieuMuon();
    }
    private static void sapXepPhieuMuontheoTen() {
        for (int i = 0; i < BORROW.length - 1; i++) {
            QLMuonSach phieumuon1 = BORROW[i];
            for (int j = i+1; j < BORROW.length; j++) {
                QLMuonSach phieumuon2 = BORROW[j];
                if (phieumuon1.getBanDoc().getHoTen().compareTo(phieumuon2.getBanDoc().getHoTen()) > 0){
                    QLMuonSach temp = phieumuon1;
                    BORROW[i]= phieumuon2;
                    BORROW[j]= temp;
                }
            }
        }
    }
    private static void sapxeptheoSLSach() {
        for (int i = 0; i < DETAIL.length - 1; i++) {
            QLChiTiet phieuchitiet1 = DETAIL[i];
            for (int j = i+1; j < DETAIL.length; j++) {
                QLChiTiet phieuchitiet2 = DETAIL[j];
                    if (phieuchitiet1.getSoLuong()<phieuchitiet2.getSoLuong()){
                        QLChiTiet temp = phieuchitiet1;
                        DETAIL[i]= phieuchitiet2;
                        DETAIL[j]= temp;
                    }

            }
        }
    }

    private static void timkiemTen(){
        System.out.print("Nhập tên bạn đọc cần tìm:");
        String tenBanDoc= new Scanner(System.in).nextLine();
        System.out.println("Danh sách bạn đọc mượn sách:");
        for(int i=0;i<BORROW.length;i++){
            QLMuonSach phieumuon=BORROW[i];
            if(phieumuon!=null){
                if(BORROW[i].getBanDoc().getHoTen().toLowerCase().contains(tenBanDoc)==true){
                    System.out.println("Bạn đọc"+phieumuon.getBanDoc().getHoTen()+" đã mượn");
                    for(int j=0;j<phieumuon.getQLCT().length;j++){
                        System.out.println(phieumuon.getQLCT()[j]);
                    }
                    System.out.println("______________________________________");

                }

            }
        }

    }



}
