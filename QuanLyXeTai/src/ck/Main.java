package ck;

public class Main {
	public static void main(String[] args) {
		QuanLyTaiXe qltx = new QuanLyTaiXe()  ; 
		
		qltx.themTaiXe(new TaiXeGiaoHang("T01", "A" ,"1" , 300000 , 500000)) ; 
		qltx.themTaiXe(new TaiXeGiaoHang("T02", "B" ,"2" , 12 , 213132)) ; 
		qltx.themTaiXe(new TaiXeGiaoHang("T03", "C" ,"3" , 12000000 ,3000)) ; 
		qltx.themTaiXe(new TaiXeDuongDai("T04", "D" ,"4" , 12312312, 5)) ; 
		qltx.themTaiXe(new TaiXeDuongDai("T05", "E" ,"5" , 232323232, 5)) ; 
		qltx.themTaiXe(new TaiXeDuongDai("T06", "F" ,"6" , 12312300 , 5)) ; 
		qltx.inDanhSach();
		
		qltx.layThongKeTrungBinh()
		.forEach((nv , loai) -> System.out.println(nv + " : " +  loai  ));
		
		qltx.layDsTaiXeKhongDuocThuong().forEach(System.out::println);
		
		System.out.println("Tai Xe tien thu ho cap nhat ");
		qltx.laydsTaiXeGiaoHangTongTienThuHoCaoNhat().forEach(System.out::println); 
		
		System.out.println("Cap Nhat he so T06");
		qltx.capNhatHeSo("T06", 3);
		qltx.inDanhSach();
		
		
		
		
	}

}
