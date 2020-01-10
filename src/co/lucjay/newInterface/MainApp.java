package co.lucjay.newInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		InterfaceService service = new InterfaceSeviceImpl();
		CountryDto dto = new CountryDto();
		try {
			dto = (CountryDto) service.select("CA"); // 케스케이딩 받아서 포장벳겨 그래서 형변환선호하지않음
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print(dto.getCountry_id() + " | ");
		System.out.print(dto.getCountry_name() + " | ");
		System.out.println(dto.getRegion_id() + " | ");
		System.out.println("==============전체 리스트==============");
		allSelectPrint();
	}

	private static void allSelectPrint() {
		InterfaceService service = new InterfaceSeviceImpl();
		List<?> list = new ArrayList<CountryDto>(); // =null;
		try {// 트라이캐치는 예외처리문
			list = service.allSelect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Object dto : list) {
			System.out.print(((CountryDto) dto).getCountry_id() + " | ");
			System.out.print(((CountryDto) dto).getCountry_name() + " | ");
			System.out.println(((CountryDto) dto).getRegion_id() + " | ");
		}
	}
}
