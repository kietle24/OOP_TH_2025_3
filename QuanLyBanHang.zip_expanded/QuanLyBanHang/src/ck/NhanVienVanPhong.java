package ck;

import java.text.NumberFormat;
import java.util.Locale;

public class NhanVienVanPhong extends NhanVien  {
	private double heSoLuong ;

	public NhanVienVanPhong(
			String maSo, String hoTen, String dienThoai, double heSoLuong) {
		super(maSo, hoTen, dienThoai);
		if(heSoLuong < 1.86 || heSoLuong > 8.69)
		{
			throw new IllegalArgumentException("hesoluong khong hop le ") ;  
		}
		setHeSoLuong(heSoLuong) ; 
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("he so Luong : %s", this.heSoLuong); 
	}

	@Override
	public double thuNhap() {
		double tienLuong =0  ; 
		tienLuong = LUONG_CAN_BAN.getGiaTri()*heSoLuong ; 
		return tienLuong  ; 
	} 
	
		



}
