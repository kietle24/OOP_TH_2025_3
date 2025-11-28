package ck;

public class TaiXeDuongDai extends TaiXe{
	private double heSoThamNien ;

	public TaiXeDuongDai(String maSo, String hoVaTen, String soDienThoai, double luongCung, double heSoThamNien) {
		super(maSo, hoVaTen, soDienThoai, luongCung);
		if(heSoThamNien< 1.5 || heSoThamNien > 5 ) {
			 throw new IllegalArgumentException("heSoThamNien khong hop le "); 
		}
		setHeSoThamNien(heSoThamNien) ;
	}

	public double getHeSoThamNien() {
		return heSoThamNien;
	}

	public void setHeSoThamNien(double heSoThamNien) {
		this.heSoThamNien = heSoThamNien;
	} 
	@Override
	public String toString() {
		return super.toString() + String.format("|heSoThamNien : %s" , this.heSoThamNien);
	}

	@Override
	public double tinhLuong() {
		double tienThucNhan = this.luongCung +  this.heSoThamNien ; 
		return tienThucNhan;
	}
	
	

}
