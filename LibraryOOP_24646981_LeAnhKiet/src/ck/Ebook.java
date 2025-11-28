package ck;

import java.time.LocalDate;

public class Ebook  extends TaiLieuSo{
	private int soTrang ;

	public Ebook(String maTL, String tieuDe, LocalDate ngayPH, double giaCoBan, int soTrang) {
		super(maTL, tieuDe, ngayPH, giaCoBan);
		this.soTrang = soTrang;
	}
	
	

	public int getSoTrang() {
		return soTrang;
	}



	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}



	@Override
	public String toString() {
		return super.toString() + String.format("|So Trang : %s", this.soTrang) ; 
	}

	@Override
	public double tinhThanhTien() {
		// TODO Auto-generated method stub
		
		double thanhTien = this.giaCoBan +(100 * this.soTrang) ; 
		if(!this.ngayPH.isBefore(LocalDate.now().minusDays(30)) || !this.ngayPH.isAfter(LocalDate.now())) {
			 thanhTien += (thanhTien*0.1); 
		}
		
		return thanhTien; 
	} 
	

}
