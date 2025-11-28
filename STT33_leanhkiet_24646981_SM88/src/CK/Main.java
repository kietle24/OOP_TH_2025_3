package CK;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		QuanLyVanChuyen qlvd  = new QuanLyVanChuyen()  ; 
		
		qlvd.themDon(new VanChuyenDuongBo("VD01" , "A" , LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 1) , TrangThaiVanDon.DANG_XU_LY  , 30 , "A" ));
		qlvd.themDon(new VanChuyenDuongBo("VD02" , "B" , LocalDate.of(2025, 1, 2), LocalDate.of(2025, 1, 3) , TrangThaiVanDon.DANG_VAN_CHUYEN, 300 , "B" ));
		qlvd.themDon(new VanChuyenDuongHangKhong("VD04" , "C" , LocalDate.of(2025, 1, 2), LocalDate.of(2025, 8, 1) , TrangThaiVanDon.DANG_VAN_CHUYEN, 30 , 300  ));
		qlvd.themDon(new VanChuyenDuongHangKhong("VD05" , "D" , LocalDate.of(2025, 1, 2), LocalDate.of(2025, 4, 1) , TrangThaiVanDon.DANG_VAN_CHUYEN, 500 , 400 ));
		
		qlvd.inDS();
		System.out.println("Cap Nhat VD05");
		qlvd.capNhapTrangThaiVanDon("VD05", TrangThaiVanDon.DA_GIAO_HANG);
		qlvd.inDS();
		System.out.println("Lay Doanh thu Theo loai ");
		System.out.println("Doanh thu Duong Bo: " + qlvd.layDoanhThuTheoLoaiVanChuyenDuongBo());
		System.out.println("Doanh thu Hang Khong: " + qlvd.layDoanhThuTheoVanChuyenDuongHangKhong());
		
		
		System.out.println("tim Hang Can Giao Gap Ngay Mai :  ");
		qlvd.timHangCanGiaoGapNgayMai().forEach(System.out::println);
		
		
		try {
			System.out.println("TH sai format: ");
			qlvd.themDon(new VanChuyenDuongHangKhong("Vt05" , "D" , LocalDate.of(2025, 1, 2), LocalDate.of(2025, 4, 1) , TrangThaiVanDon.DANG_VAN_CHUYEN, 500 , 400 ));

			
		} catch (Exception e) {
			System.out.println("Loi" + e.getMessage());
		}
		
		try {
			qlvd.themDon(new VanChuyenDuongBo("VD06" , "B" , LocalDate.of(2025, 1, 2), LocalDate.of(2025, 1, 3) , TrangThaiVanDon.DANG_VAN_CHUYEN, 1000 , "A" ));
			qlvd.inDS();
			
			
		} catch (Exception e) {
			System.out.println("Loi" + e.getMessage());
		}
		
		

		
		
	}

}

