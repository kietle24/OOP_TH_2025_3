package CK;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class VanDon {
	protected final String maVanDon ; 
	protected String tenNguoiNhan ; 
	protected LocalDate ngayGui ; 
	protected LocalDate ngayNhanDuKien; 
	protected TrangThaiVanDon trangThai = TrangThaiVanDon.DANG_XU_LY ; 
	public static final double THUE_VAT = 0.08 ;
	public VanDon(String maVanDon, String tenNguoiNhan, LocalDate ngayGui, LocalDate ngayNhanDuKien,
			TrangThaiVanDon trangThai) {
		if(maVanDon == null || maVanDon.trim().isEmpty()|| !maVanDon.startsWith("VD")) {
			throw new IllegalArgumentException("maVanDon khong hop le ") ; 
			
		}
		if(tenNguoiNhan == null || tenNguoiNhan.trim().isEmpty()) {
			throw new IllegalArgumentException("tenNguoiNhan khong hop le ") ; 
			
		}
		if(ngayNhanDuKien.isBefore(ngayGui)) {
			throw new IllegalArgumentException("ngayNhanDuKien khong hop le ") ;
		}
		
	
		this.maVanDon = maVanDon;

		setTenNguoiNhan(tenNguoiNhan) ; 

		setNgayGui(ngayGui);
			setNgayNhanDuKien(ngayNhanDuKien) ; 

		setTrangThai(trangThai);
	}
	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}
	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	public LocalDate getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(LocalDate ngayGui) {
		this.ngayGui = ngayGui;
	}
	public LocalDate getNgayNhanDuKien() {
		return ngayNhanDuKien;
	}
	public void setNgayNhanDuKien(LocalDate ngayNhanDuKien) {
		this.ngayNhanDuKien = ngayNhanDuKien;
	}
	public TrangThaiVanDon getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiVanDon trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaVanDon() {
		return maVanDon;
	}
	public static double getThueVat() {
		return THUE_VAT;
	} 
	
	public long soNgayVanChuyen() { 
		 return ChronoUnit.DAYS.between(ngayGui, ngayNhanDuKien) ; 
		 
	}
	public abstract double tinhCuocPhi()  ;
	@Override
	public String toString() {
		DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd/MM/yyyy") ; 
		DecimalFormat dft = new DecimalFormat("#,### " + "VND");
		return String.format("|%12s | %15s | %15s  | %12s   | %12s |%12s | %12s"
				, this.maVanDon , this.tenNguoiNhan , df.format(ngayGui) ,
				df.format(ngayNhanDuKien) , this.soNgayVanChuyen() , dft.format(tinhCuocPhi()) , trangThai.getMoTa() 
				
				);
	} 
	public String inTD() {
		return String.format("|%12s | %15s | %15s  | %12s | %12s |%12s | %12s"
				
				, "Ma VD" , "Ten ND" , " Ngay Gui" , " Ngay Nhan DK " , " so ngay VC", " cuoc phi ", " TT"
				
				);
		 
	}
	
	
	
}
