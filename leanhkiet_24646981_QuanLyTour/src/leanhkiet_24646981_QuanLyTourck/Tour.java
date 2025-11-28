package leanhkiet_24646981_QuanLyTourck;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract  class Tour {
	protected final String maChuyenDi ; 
	protected String tenTour; 
	protected LocalDate ngayKH ; 
	protected LocalDate ngayKT; 
	protected double giaCoBan ;
	public Tour(String maChuyenDi, String tenTour, LocalDate ngayKH, LocalDate ngayKT, double giaCoBan) {
		if(maChuyenDi ==  null | maChuyenDi.trim().isEmpty()) {
			throw new IllegalArgumentException("maChuyenDi khong hop le ") ; 
		}
		if(tenTour ==  null | tenTour.trim().isEmpty()) {
			throw new IllegalArgumentException("tenTour khong hop le ") ; 
		}
		if(ngayKT.isBefore(ngayKH)) {
			throw new IllegalArgumentException("ngayKT khong hop le ") ; 
		}
		if(giaCoBan < 0 ) {
			throw new IllegalArgumentException("giaCoBan khong hop le ") ;
		}
		
		this.maChuyenDi = maChuyenDi;

		setTenTour(tenTour) ; 

		setNgayKH(ngayKH) ; 
		setNgayKT(ngayKT) ; 

		setGiaCoBan(giaCoBan);
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public LocalDate getNgayKH() {
		return ngayKH;
	}
	public void setNgayKH(LocalDate ngayKH) {
		this.ngayKH = ngayKH;
	}
	public LocalDate getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(LocalDate ngayKT) {
		this.ngayKT = ngayKT;
	}
	public double getGiaCoBan() {
		return giaCoBan;
	}
	public void setGiaCoBan(double giaCoBan) {
		this.giaCoBan = giaCoBan;
	}
	public String getMaChuyenDi() {
		return maChuyenDi;
	}
	public long soNgayDi() { 
		 return ChronoUnit.DAYS.between(ngayKH , ngayKT) ; 
	}
	public abstract double thanhTien() ; 
	
	
	@Override
	public String toString() {
		
		DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd/MM/yyyy") ; 
		DecimalFormat d = new DecimalFormat("#,###" + " VND") ; 
		return String.format("|%12s | %15s | %10s | %12s | %13s | %15s | %10s"
				, this.maChuyenDi, this.tenTour , df.format(ngayKH) , df.format(ngayKT)
				, this.giaCoBan , this.soNgayDi() , d.format(this.thanhTien())
				) ; 
	}
	


	
	
	
	

}
