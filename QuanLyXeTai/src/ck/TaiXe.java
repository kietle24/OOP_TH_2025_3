package ck;

import java.text.DecimalFormat;

public abstract class TaiXe {
	protected final String maSo ; 
	protected String hoVaTen ; 
	protected String soDienThoai; 
	protected double luongCung = 3000000;
	public TaiXe() {

		this.maSo = "";
		this.hoVaTen = "";
		this.soDienThoai = null;
		this.luongCung = 0.0;
	} 
	
	
	public TaiXe(String maSo, String hoVaTen, String soDienThoai, double luongCung) {
		if(maSo == null || maSo.trim().isEmpty()) {
			throw new IllegalArgumentException("maSo khong hop le ") ; 
		}
		if(hoVaTen == null || hoVaTen.trim().isEmpty()) {
			throw new IllegalArgumentException("hoVaTen khong hop le ") ; 
		}
		
		this.maSo = maSo;

		setHoVaTen(hoVaTen) ;

		setSoDienThoai(soDienThoai) ; 

		setLuongCung(luongCung) ; 
	}


	public String getMaSo() {
		return maSo;
	}


	public String getHoVaTen() {
		return hoVaTen;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public double getLuongCung() {
		return luongCung;
	}


	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public void setLuongCung(double luongCung) {
		this.luongCung = luongCung;
	}
	public abstract double tinhLuong() ; 


	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("#,###" + "VND" ) ; 
		return String.format("|%12s | %15s | %15s | %15s | %20s "
				,this.maSo , this.hoVaTen  , this.soDienThoai , d.format(luongCung) , d.format(tinhLuong()) 
				) ;
	} 
	

	
	
	
	
	
}
