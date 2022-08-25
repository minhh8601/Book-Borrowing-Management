package entity;

public class QLMuonSach {
    // 1 bạn đọc có thể mượn 1 hoặc nhiều đầu sách khác nhau nhưng số luọng nhất định

    private BanDoc banDoc;
    private QLChiTiet[]QLCT;

    public BanDoc getBanDoc(){
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc){
        this.banDoc=banDoc;
    }

    public QLChiTiet[] getQLCT(){
        return QLCT;
    }
    public void setQLCT(QLChiTiet[]QLCT){
        this.QLCT=QLCT;
    }
}
