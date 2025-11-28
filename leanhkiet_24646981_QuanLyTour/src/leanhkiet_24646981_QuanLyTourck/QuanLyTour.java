package leanhkiet_24646981_QuanLyTourck;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuanLyTour {
	private List<Tour> dst ;

	public QuanLyTour() {
		
	 dst = new ArrayList<>() ; 
	}

	public List<Tour> getDst() {
		return dst;
	}

	public void setDst(List<Tour> dst) {
		this.dst = dst;
	} 
	public String inTieuDe() { 
	    return String.format("|%12s | %15s | %10s | %12s | %13s | %15s | %10s ", // <--- BỎ SPECIFIER CUỐI
	            "Ma CH" , "Ten Tour" ,  " Ngay KH" , "Ngay KT" , "Gia co ban " , " so ngay di " , "thanh Tien") ; 
	}
	
	public void inds() {  
	    // 1. Kiểm tra và dừng nếu danh sách rỗng
	    if (dst.isEmpty()) {
	        System.out.println("Danh sách Tour rỗng."); 
	        return; // Dừng hàm ngay lập tức
	    }

	    // 2. In tiêu đề (chỉ khi danh sách không rỗng)
	    System.out.println(inTieuDe());
	    
	    // 3. In từng phần tử
	    for (Tour d : dst) {  
	        // Đảm bảo rằng phương thức toString() trong class Tour đã được override
	        System.out.println(d); 
	    }
	}
	
	public boolean themTour(Tour t ) {  
		for(Tour d : dst) { 
			if(d.getMaChuyenDi().equalsIgnoreCase(t.maChuyenDi)) { 
				 throw new  IllegalArgumentException("Ma trung " + t.getMaChuyenDi()) ; 
			}
		}
		dst.add(t);
		System.out.println("them thanh cong ");
		return true ; 
	}
	public boolean xoaTour(String code ) { 
		Iterator <Tour> i = dst.iterator() ; 
		while(i.hasNext()) { 
			if(i.next().equals(code)) { 
				System.out.println("ma xoa thanh cong ");
				i.remove();  
				 
				 return true ; 
				 
			}
		}
		System.out.println("khong tim thay ma  ");
		return false; 

	}
	public double  tinhTongDoanhThu(int thang , int nam ) { 
		return dst.stream()
				.filter(k->k.getNgayKH().getMonthValue() == thang && k.getNgayKH().getYear() == nam )
				.mapToDouble(Tour :: thanhTien)
				.sum() ;
	}
	public List<TourQuocTe> dsTourQuocTeCoThoiGianDi(int n )  { 
			return dst.stream().
					filter(k->k instanceof TourQuocTe)
					.map(k->(TourQuocTe) k )
					.filter(t->t.soNgayDi()>n )
					.sorted(Comparator.comparing(TourQuocTe::getNgayKH))
					.collect(Collectors.toList()); 
	}
	
	public boolean  capNhatThoiGian(String maChuyen , LocalDate ngayMoi) { 
		 LocalDate today  = LocalDate.now() ; 
		 for(Tour d : dst) { 
			  if(d.getMaChuyenDi().equalsIgnoreCase(maChuyen)) { 
				  if(!d.getNgayKH().isAfter(today)) { 
					   System.out.println("khong the cap nhat tour dang dien ra ");
					   return false; 
				  }
				  try {

					  d.setNgayKH(ngayMoi);
					 System.out.println(" cap nhat thanh cong ");
					  
					  return true ; 
					  
					  
					  
					  
					
				} catch (Exception e) {
				System.out.println("loi "+ e.getMessage());
				}
			  }
		 }
		 
		 System.out.println("khong co ma de cap nhat ");

		 return false;  
	}
	
	
	

}
