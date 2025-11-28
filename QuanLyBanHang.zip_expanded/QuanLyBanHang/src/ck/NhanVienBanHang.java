package ck;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NhanVienBanHang  extends NhanVien{
	private double doanhSoBanHang ;

	public NhanVienBanHang(
			String maSo, String hoTen, String dienThoai, double doanhSoBanHang) {
		super(maSo, hoTen, dienThoai);
		if(doanhSoBanHang < 0 ) { 
			throw new IllegalArgumentException("Doanh so Ban Hang khong hop le ") ; 
		}
		setDoanhSoBanHang(doanhSoBanHang); 	
	}

	public double getDoanhSoBanHang() {
		return doanhSoBanHang;
	}

	public void setDoanhSoBanHang(double doanhSoBanHang) {
		this.doanhSoBanHang = doanhSoBanHang;
	}

	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###" + "VNĐ") ; 
		return super.toString() + String.format("| Doanh So Ban hang : %s ",  d.format(doanhSoBanHang) ); 
	}

	@Override
//	public double thuNhap() {
//		double thuNhapThem  = this.doanhSoBanHang *0.03 ; 
//		double tienLuong = this.doanhSoBanHang* LUONG_CAN_BAN.getGiaTri() ;
//		if(this.doanhSoBanHang > 20000000) {
//			 tienLuong = LUONG_CAN_BAN.getGiaTri() + thuNhapThem ; 
//		}
//		return tienLuong ; 
//		
//	
//	}
	public  double thuNhap() {  
		double tienLuong = this.LUONG_CAN_BAN.getGiaTri() ; 
		double thuNhaptangThem = this.doanhSoBanHang *0.03 ; 
		if(this.doanhSoBanHang >= 20000000) {
			 tienLuong = tienLuong + thuNhaptangThem ; 
		}
		return tienLuong; 
		
		
		
	}
	
	
	
	

	

}
