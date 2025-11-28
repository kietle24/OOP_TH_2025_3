package CK;

import java.time.LocalDate;

public class VanChuyenDuongHangKhong extends VanDon {
	private double trongLuong ; 
	private double theTich ;
	public VanChuyenDuongHangKhong(String maVanDon, String tenNguoiNhan, LocalDate ngayGui, LocalDate ngayNhanDuKien,
			TrangThaiVanDon trangThai, double trongLuong, double theTich) {
		super(maVanDon, tenNguoiNhan, ngayGui, ngayNhanDuKien, trangThai);
		this.trongLuong = trongLuong;
		this.theTich = theTich;
	}
	public double getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(double trongLuong) {
		this.trongLuong = trongLuong;
	}
	public double getTheTich() {
		return theTich;
	}
	public void setTheTich(double theTich) {
		this.theTich = theTich;
	}
	@Override
	public String toString() {
		return super.toString() + String.format("|TL: %s | TT:  %s", this.trongLuong , this.theTich);
		 
		}
	@Override
	public double tinhCuocPhi() {
		double giaCoBan = this.trongLuong * 200000 ; 
		if(this.soNgayVanChuyen() <= 1   ) { 
			giaCoBan += 500000 ; 
		}
	
		return giaCoBan + (giaCoBan * VanDon.THUE_VAT);
	} 

	
	
	
	
	
	
}
