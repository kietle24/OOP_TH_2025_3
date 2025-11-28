package ck;
import java.text.DecimalFormat;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		QuanLyNhanVien qlnv = new QuanLyNhanVien()  ;
		
		try {
			qlnv.themNhanVien(new NhanVienBanHang("BH01", "A" ,"1" , 21000001)); 
			qlnv.themNhanVien(new NhanVienBanHang("BH02", "B" ,"2" ,1500000)); 
			qlnv.themNhanVien(new NhanVienBanHang("BH03", "C" ,"2" , 1000000)); 
			qlnv.themNhanVien(new NhanVienVanPhong("BH04", "D" ,"3" , 2)); 
			qlnv.themNhanVien(new NhanVienVanPhong("BH05", "E" ,"4" , 5)); 
			qlnv.themNhanVien(new NhanVienVanPhong("BH06", "F" ,"5" , 6)); 
			
			System.out.println("Danh Sach Them ");
			qlnv.inDanhSach();
		
			System.out.println("Xoa ma Nhan VIen BH06");
			qlnv.xoaNhanVien("BH06") ; 
			
			qlnv.inDanhSach();
			System.out.println("Thong Ke Nhan Vien Theo Loai :  ");

			qlnv.layThongKeTrungBinhLuongNhanVien()
			.forEach((nv , loai) -> System.out.println(nv + " : " + loai+  "VND" ));
			
			System.out.println("Danh Sach Nhan Vien uu tu:");
			qlnv.getDSNhanVienUuTu().forEach(System.out::println);
			
			System.out.println("Danh Sach Nhan Vien Co DS lonhat ");
			qlnv.getDSLonNhat().forEach(System.out::println);
			
		} catch (Exception e) {
			System.out.println("Loi" + e.getMessage());
		}
		
		 System.out.println("\nCap nhat he so luong NV01 len 5.5...");
		 qlnv.capNhatHeSoluong("BH04", 5.5);
		 qlnv.inDanhSach();
	
	
		
	}

}
