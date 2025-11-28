package ck;

public enum LuongCanBan {
	LUONG_CAN_BAN(1800000); 
	private double giaTri ;

	 LuongCanBan(double giaTri) {
		this.giaTri = giaTri;
	}

	 public double getGiaTri() {
		return giaTri;
	}

	 public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	} 
	 
	

	

}
