package ck;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class TaiLieuSo {
	protected final String maTL ; 
	protected String tieuDe ; 
	protected LocalDate ngayPH ; 
	protected double giaCoBan  ;
	public TaiLieuSo() {
		this.maTL = "" ; this.tieuDe ="" ;  this.ngayPH = null ;  this.giaCoBan =0.0  ; 
		
	}
	
	public TaiLieuSo(String maTL, String tieuDe, LocalDate ngayPH, double giaCoBan) {
		if(ngayPH.isBefore(LocalDate.now())) { 
			throw new IllegalArgumentException("ngay PH khong hop le ") ; 
		}
		if(maTL ==null || maTL.trim().isEmpty() || !maTL.startsWith("TD") ) {
			throw new IllegalArgumentException("maTL khong hop le ");
			
		}
		if(tieuDe ==null || tieuDe.trim().isEmpty()) {
			throw new IllegalArgumentException("tieuDe khong hop le ");
			
		} 
		if(giaCoBan < 0 ) { 
			 throw new IllegalArgumentException("giaCoBan khong hop le ") ; 
		}
		this.maTL = maTL;
		setTieuDe(tieuDe) ; 
		setNgayPH(ngayPH) ; 
		setGiaCoBan(giaCoBan) ; 
	}

	public String getMaTL() {
		return maTL;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public LocalDate getNgayPH() {
		return ngayPH;
	}

	public double getGiaCoBan() {
		return giaCoBan;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public void setNgayPH(LocalDate ngayPH) {
		this.ngayPH = ngayPH;
	}

	public void setGiaCoBan(double giaCoBan) {
		this.giaCoBan = giaCoBan;
	}
	public abstract double tinhThanhTien() ;

	@Override
	public String toString() {
		DecimalFormat d = new  DecimalFormat("#,### " + "VND") ; 
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("|%-15S | %-20s | %12s | %14s | %12s", this.maTL , this.tieuDe , dt.format(ngayPH) , d.format(giaCoBan), d.format(tinhThanhTien())) ; 
		
	} 
	
	
	

}
