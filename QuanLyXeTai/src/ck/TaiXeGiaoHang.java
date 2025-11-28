package ck;

public class TaiXeGiaoHang extends TaiXe{

	private double tienThuHo  ;

	public TaiXeGiaoHang(String maSo, String hoVaTen, String soDienThoai, double luongCung, double tienThuHo) {
		
		
		super(maSo, hoVaTen, soDienThoai, luongCung);
		if(tienThuHo <  0 ) { 
			throw new IllegalArgumentException("tienThuHo khong hop le ") ; 
		}

		setTienThuHo(tienThuHo) ; 
	}

	public double getTienThuHo() {
		return tienThuHo;
	}

	public void setTienThuHo(double tienThuHo) {
		this.tienThuHo = tienThuHo;
	}

	@Override
	public double tinhLuong() {
		double tienThuong  = 0; 
		if(this.tienThuHo >= 300000000) {
			 tienThuong  = this.tienThuHo *0.05  ; 
		}
		double tienThucNhan = this.luongCung + tienThuong ; 
		
		return tienThucNhan ; 
	}

	@Override
	public String toString() {
		return super.toString() + String.format("|Tien thu ho : %s" , this.tienThuHo);
	}
	
	
	
}
