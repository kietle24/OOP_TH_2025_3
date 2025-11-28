package CK;

import java.time.LocalDate;

public class VanChuyenDuongBo  extends VanDon{
	public static final double DON_GIA_KM = 15000; 
	private double khoangCach ; 
	private String loaiXe;
	public VanChuyenDuongBo(String maVanDon, String tenNguoiNhan, LocalDate ngayGui, LocalDate ngayNhanDuKien,
			TrangThaiVanDon trangThai, double khoangCach, String loaiXe) {
		super(maVanDon, tenNguoiNhan, ngayGui, ngayNhanDuKien, trangThai);
		this.khoangCach = khoangCach;
		this.loaiXe = loaiXe;
	}
	public double getKhoangCach() {
		return khoangCach;
	}
	public void setKhoangCach(double khoangCach) {
		this.khoangCach = khoangCach;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public static double getDonGiaKm() {
		return DON_GIA_KM;
	}
	@Override
	public String toString() {
		return super.toString() + String.format("| KM : %s | loai xe : %s" , this.khoangCach , this.loaiXe  ) ; 
	}
	@Override
	public double tinhCuocPhi() {
		double giaChuaThue = this.khoangCach * this.DON_GIA_KM ; 
		if(this.khoangCach >= 300) { 
			giaChuaThue = giaChuaThue *0.95 ; 
		}
		double thanhTien = giaChuaThue + (giaChuaThue * VanDon.THUE_VAT);
		return thanhTien;
	} 
	
	
	
	
	
	

}
