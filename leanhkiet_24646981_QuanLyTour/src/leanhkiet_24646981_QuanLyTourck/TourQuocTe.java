package leanhkiet_24646981_QuanLyTourck;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TourQuocTe extends Tour {
	private double phiVisa ; 
	private double phuThuBaoHiem ;
	public TourQuocTe(String maChuyenDi, String tenTour, LocalDate ngayKH, LocalDate ngayKT, double giaCoBan,
			double phiVisa, double phuThuBaoHiem) {
		super(maChuyenDi, tenTour, ngayKH, ngayKT, giaCoBan);
		this.phiVisa = phiVisa;
		this.phuThuBaoHiem = phuThuBaoHiem;
		
		
	}
	public double getPhiVisa() {
		return phiVisa;
	}
	public void setPhiVisa(double phiVisa) {
		this.phiVisa = phiVisa;
	}
	public double getPhuThuBaoHiem() {
		return phuThuBaoHiem;
	}
	public void setPhuThuBaoHiem(double phuThuBaoHiem) {
		this.phuThuBaoHiem = phuThuBaoHiem;
	}
	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###" + " VND") ; 
		return super.toString() 
				+ String.format("| Phi Visa : %s | Phu thu BH : %s " , d.format(phiVisa), 
						d.format(phuThuBaoHiem)); 
	}
	@Override
	public double thanhTien() {
		 double thanhTien = this.giaCoBan + this.phiVisa + (this.phuThuBaoHiem * this.soNgayDi()) ; 
		 if(this.soNgayDi() > 7 )  { 
			 thanhTien += 2000000 ; 
		 }
		return thanhTien;
	} 
	

}
