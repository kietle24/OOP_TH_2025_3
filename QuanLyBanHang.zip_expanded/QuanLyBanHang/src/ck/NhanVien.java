package ck;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

public abstract class NhanVien {
	protected final String maSo ; 
	protected String hoTen;
	protected String dienThoai;
	protected static final LuongCanBan LUONG_CAN_BAN = LuongCanBan.LUONG_CAN_BAN ;
	public NhanVien(String maSo, String hoTen, String dienThoai) {
		if(maSo == null || maSo.trim().isEmpty()) {
			throw new IllegalArgumentException("maSo khong hop le "); 
		}
		if(hoTen == null || hoTen.trim().isEmpty()) {
			throw new IllegalArgumentException("hoTen khong hop le "); 
		}
		
		this.maSo = maSo;
		setHoTen(hoTen) ; 
		this.dienThoai = dienThoai;
	}
	public String getMaSo() {
		return maSo;
	}
	public String getHoTen() {
		return hoTen;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public static LuongCanBan getLuongCanBan() {
		return LUONG_CAN_BAN;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###" + "VNĐ") ; 
		return String.format("|%10s | %15s | %15s | %15s", this.maSo , this.hoTen , this.dienThoai ,
				d.format(this.thuNhap())
				); 
	}
	
	public abstract double  thuNhap() ; 
	


	
	
	
			
	}
	
	
	


