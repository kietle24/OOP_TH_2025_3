package leanhkiet_24646981_QuanLyTourck;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TourTrongNuoc extends Tour {
	private double huongDanVienTip ;

	public TourTrongNuoc(String maChuyenDi, String tenTour, LocalDate ngayKH, LocalDate ngayKT, double giaCoBan,
			double huongDanVienTip) {
		super(maChuyenDi, tenTour, ngayKH, ngayKT, giaCoBan);
		this.huongDanVienTip = huongDanVienTip;
	}

	public double getHuongDanVienTip() {
		return huongDanVienTip;
	}

	public void setHuongDanVienTip(double huongDanVienTip) {
		this.huongDanVienTip = huongDanVienTip;
	}

	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###" + " VND") ; 
		return super.toString() + String.format("| Tip HGV : %s" , d.format(huongDanVienTip)); 
	}

	@Override
	public double thanhTien() {
		LocalDate today= LocalDate.now() ; 
		 double thanhTien = this.giaCoBan + (this.huongDanVienTip * this.soNgayDi()) ; 
		 if(ngayKH.isBefore(today) && ngayKH.minusDays(5).isBefore(today)) { 
			 thanhTien = thanhTien*0.9 ; 
		 }
		 return thanhTien ; 
		
	} 
	
	
	
	

}
