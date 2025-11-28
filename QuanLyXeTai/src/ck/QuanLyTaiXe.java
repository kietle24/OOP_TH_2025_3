package ck;
import java.util.*;
import java.util.stream.Collectors;
public class QuanLyTaiXe {
	private List<TaiXe> dstx ;

	public QuanLyTaiXe() {
		
	dstx = new ArrayList<>();
	}

	public List<TaiXe> getDstx() {
		return dstx;
	}

	public void setDstx(List<TaiXe> dstx) {
		this.dstx = dstx;
	}
	public void inDanhSach() { 
		  if(dstx.isEmpty()) {
			  System.out.println("Danh sach rong ");
			  return  ; 
		  }
		  System.out.println(inTieuDe());
		  for(TaiXe d : dstx) {
			   System.out.println(d);
		  }
	}
	public String inTieuDe() { 
		return String.format("|%12s | %15s | %15s | %15s | %20s " , "MS" , "Ho ten " , "SDT" , "Luong Cung" , "Tinh Luong" ) ; 
	}
	public boolean themTaiXe(TaiXe tx) {
		for(TaiXe d : dstx) { 
			 if(d.getMaSo().equalsIgnoreCase(tx.getMaSo())) {
				 throw new IllegalArgumentException("trung ma " + tx ); 
			
			 }
		}
		dstx.add(tx); 
		return true; 
	}
	public Map<String ,Double > layThongKeTrungBinh() { 
		 return dstx.stream().collect(Collectors.groupingBy(k->k.getClass().getSimpleName(),Collectors.averagingDouble(k->k.tinhLuong()))); 
	}
	
	public List<TaiXe> layDsTaiXeKhongDuocThuong() { 
		return dstx.stream()
				.filter(k-> k instanceof TaiXeGiaoHang)
				.map(k->(TaiXeGiaoHang) k)
				.filter(k-> k.tinhLuong() < 3000000)
				.sorted((a,b) -> Double.compare(b.getTienThuHo() , a.getTienThuHo()))
				.collect(Collectors.toList() ); 

		
	}
	public List<TaiXe> laydsTaiXeGiaoHangTongTienThuHoCaoNhat() {
	    double max = dstx.stream()
	            .filter(k -> k instanceof TaiXeGiaoHang)
	            .mapToDouble(c -> ((TaiXeGiaoHang)c).getTienThuHo())
	            .max().orElse(0);

return dstx.stream().filter(k -> k instanceof TaiXeGiaoHang &&
		((TaiXeGiaoHang)k).getTienThuHo() == max)
		   .collect(Collectors.toList());
	}
	
	public void capNhatHeSo(String maSo, double heSoMoi) { 
		if(heSoMoi < 1.5|| heSoMoi > 5) { 
			throw new  IllegalArgumentException(" he so tham nien khong hop le ") ; 
			
		}
		for(TaiXe d  : dstx) { 
			if(d instanceof TaiXeDuongDai && d.getMaSo().equalsIgnoreCase(maSo)){
				((TaiXeDuongDai) d ).setHeSoThamNien(heSoMoi);
				return ; 
			}
				
			}
		System.out.println("trung ma " + maSo);

		}
		
		
		
		
		
		
	}

	
	



