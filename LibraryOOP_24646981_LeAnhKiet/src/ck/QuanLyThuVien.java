package ck;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;
public class QuanLyThuVien {
	private List<TaiLieuSo> ds  ;

	public QuanLyThuVien() {
		ds = new ArrayList<>() ; 
	}

	public List<TaiLieuSo> getDs() {
		return ds;
	}

	public void setDs(List<TaiLieuSo> ds) {
		this.ds = ds;
	}
	public String inTieuDe() { 
		return String.format("|%-15S | %-20s | %12s | %14s | %12s", "Ma TL", "Tieu De" , "Ngay PH" , "Gia CB", "Thanh Tien") ; 
	}
	public void inDanhSach() { 
		 if(ds.isEmpty()) {
			 System.out.println("danh sach rong ");
		 }
		 System.out.println(inTieuDe()); 
		 for(TaiLieuSo d : ds) { 
			  System.out.println(d);
		 }
		 
	}
	// them  
	public boolean themTaiLieu(TaiLieuSo code) { 
		for(TaiLieuSo d : ds) {
			 if(d.getMaTL().equalsIgnoreCase(code.maTL)) {
				 throw new IllegalArgumentException("Trung ma " + code.maTL) ; 
			 }
		}
		ds.add(code); 
		return true ; 
	}
	// xoa
	public boolean xoaTaiLieu(String code ) {  
	    Iterator<TaiLieuSo> d = ds.iterator(); 

	    while (d.hasNext()) {
	        TaiLieuSo tl = d.next();  // LẤY OBJECT RA

	        // So sánh MÃ (String) với code
	        if (tl.getMaTL().equalsIgnoreCase(code)) {
	            System.out.println("Xoa thanh cong ma " + code);
	            d.remove();
	            return true; 
	        }
	    }

	    System.out.println("Khong tim thay ma " + code);
	    return false; 
	}


	// cap nhat 
	public TaiLieuSo timMa(String code ) { 
		  for(TaiLieuSo d : ds ) {
			  if(d.getMaTL().equalsIgnoreCase(code)) {
				  return d;  
				  
			  }
			  
		  }
		  return  null ; 
	}
	public void capNhatGiaCoBan(String ma , double giaCobanMoi) { 
		TaiLieuSo tl = timMa(ma) ; 
		if(tl == null ){
			throw new IllegalArgumentException("Khong tim thay ma ");
		}
		  tl.setGiaCoBan(giaCobanMoi);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	// gom nhom 
	public List<TaiLieuSo> layDoanhThu(int thang , int nam )  { 
		return ds.stream().filter(k-> k.getNgayPH().getMonthValue() == thang && k.ngayPH.getYear() ==nam)
				.collect(Collectors.toList()) ;
				}
	
	
	

}
