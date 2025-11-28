package CK;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
public class QuanLyVanChuyen {
	private List<VanDon> dsvd ;

	public QuanLyVanChuyen() {
	
		dsvd = new ArrayList<>();
	}

	public List<VanDon> getDsvd() {
		return dsvd;
	}

	public void setDsvd(List<VanDon> dsvd) {
		this.dsvd = dsvd;
	} 
	public VanDon timTheoDonHang(String code) {  
		for(VanDon d : dsvd) {  
			if(d.getMaVanDon().equalsIgnoreCase(code)) { 
				System.out.println("Ma trung " + code);
				 return d ;  
			}
		}
		return null; 
	}
	public void inDS() { 
		 if(dsvd.isEmpty()) {
			 System.out.println("DS rong  ");
		 }
		 System.out.println(inTD());
		 for(VanDon d : dsvd) {  
			 System.out.println(d);
		 }
	}
	
	
	
	public String inTD() {
		return String.format("|%12s | %15s | %15s  | %12s | %12s |%12s | %s"
				
				, "Ma VD" , "Ten ND" , " Ngay Gui" , " Ngay Nhan DK " , " so ngay VC", " cuoc phi ", " TT"
				
				);
		 
	}
	public boolean themDon(VanDon vd) {
		for(VanDon d : dsvd) { 
			if(d.getMaVanDon().equalsIgnoreCase(vd.getMaVanDon())){ 
				System.out.println("ma da bi trung "); 
				return false; 
				
			}
		}
		dsvd.add(vd) ; 
		return true; 
		}

	public void capNhapTrangThaiVanDon(String maVanDon , TrangThaiVanDon trangThaiMoi ) { 
		 VanDon dh = timTheoDonHang(maVanDon);
		if(dh == null) {
			 throw new IllegalArgumentException("Tim Thay ma ") ; 
		}
		TrangThaiVanDon hienTai = dh.getTrangThai() ; 
		if(trangThaiMoi.ordinal() < hienTai.ordinal()) {  
			throw new IllegalArgumentException("Sai quy tat nghiep vu  "); 
			
		}
		
		dh.setTrangThai(trangThaiMoi);

	}
	
	public double layDoanhThuTheoLoaiVanChuyenDuongBo() { 
		return dsvd.stream()
				.filter(vd -> vd instanceof VanChuyenDuongBo).mapToDouble(VanDon ::tinhCuocPhi).sum() ; 
		

	}
	public double layDoanhThuTheoVanChuyenDuongHangKhong() { 
		return dsvd.stream()
				.filter(vd -> vd instanceof VanChuyenDuongHangKhong).mapToDouble(VanDon ::tinhCuocPhi).sum() ; 
		
	}
	public List<VanChuyenDuongHangKhong> timHangCanGiaoGapNgayMai() {
	    LocalDate ngayMai = LocalDate.now().plusDays(1);

	    return dsvd.stream()
	            .filter(vd -> vd instanceof VanChuyenDuongHangKhong)                 // lọc đúng loại
	            .map(vd -> (VanChuyenDuongHangKhong) vd)                              // cast về VanDonHangKhong
	            .filter(vd -> vd.getNgayNhanDuKien().isEqual(ngayMai))        // ngày dự kiến nhận = ngày mai
	            .sorted(Comparator.comparingDouble(VanChuyenDuongHangKhong::getTrongLuong)
	                              .reversed())                                // sắp xếp giảm dần theo trọng lượng
	            .collect(Collectors.toList());
	}


	

	
	

}
