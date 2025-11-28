package CK;

public enum TrangThaiVanDon {
	DANG_XU_LY("Dang xu ly") ,  
	DANG_VAN_CHUYEN ("Dang vann chuyen")  , 
	DA_GIAO_HANG("Da Giao hang ") ; 
	
	private String moTa;

	private TrangThaiVanDon(String moTa) {
		this.moTa = moTa;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	} 
	

}
