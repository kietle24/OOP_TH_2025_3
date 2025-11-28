package leanhkiet_24646981_QuanLyTourck;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		QuanLyTour qlt = new QuanLyTour() ; 
		qlt.themTour(new TourTrongNuoc("T01" , "Dalat", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 12) ,4500000 ,3000000  ));
		qlt.themTour(new TourTrongNuoc("T02" , "HCM", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 23) ,6500000 ,12000000  ));
		qlt.themTour(new TourTrongNuoc("T03" , "HN", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 3, 12) ,700000 ,32000000  ));
		qlt.themTour(new TourQuocTe("T04" , "Ca Mau", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 3, 12) ,700000 ,3000000  , 40900));
		qlt.themTour(new TourQuocTe("T05" , "Bac Lieu", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 3, 12) ,700000 ,34400000  , 1230900 ));
		qlt.inds();
		System.out.println("Tong Doanh Thu Cua ");
		System.out.println(qlt.tinhTongDoanhThu(1, 2025));

		System.out.println("Xoa Tai lieu T04"); 
		qlt.xoaTour("T04"); 
		qlt.inds();
		
	}

}
