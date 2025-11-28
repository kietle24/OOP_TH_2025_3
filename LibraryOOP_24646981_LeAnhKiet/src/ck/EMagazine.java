package ck;

import java.time.LocalDate;

public class EMagazine extends TaiLieuSo{
	private int soKy ;

	public EMagazine(String maTL, String tieuDe, LocalDate ngayPH, double giaCoBan, int soKy) {
		super(maTL, tieuDe, ngayPH, giaCoBan);
		this.soKy = soKy;
	}
	

	public int getSoKy() {
		return soKy;
	}


	public void setSoKy(int soKy) {
		this.soKy = soKy;
	}


	@Override
	public String toString() {
		return super.toString() +  String.format("| So Ky : %s" ,this.soKy); 
	}

	@Override
	public double tinhThanhTien() {
		 double thanhTien = this.giaCoBan +  (this.soKy * 5000); 
		 if(this.soKy > 12 ) {
			 thanhTien += 50000 ; 
		 }
		// TODO Auto-generated method stub
		return thanhTien;
	} 
	
	
	

}
