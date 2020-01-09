package co.lucjay.newInterface;

import java.sql.SQLException;

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
	}

}
