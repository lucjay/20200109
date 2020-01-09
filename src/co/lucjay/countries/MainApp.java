package co.lucjay.countries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		List<CountryDto> list = new ArrayList<CountryDto>();
		CountryServiceImpl country = new CountryServiceImpl();
		list = country.allSelect();
		toPrint(list);
//		searchSelect();
//		insert();
//		update();
		delete();

	}

	private static void toPrint(List<CountryDto> list) {
		for (CountryDto dto : list) {
			System.out.print(dto.getCountry_id() + " : ");
			System.out.print(dto.getCountry_name() + " : ");
			System.out.println(dto.getRegion_id() + " : ");
		}
	}

	private static void searchSelect() {
		CountryServiceImpl con = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 할 사용자 ID를 입력행");
		String key = sc.nextLine();
		try {
			dto = con.select(key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.toString();
		sc.close();
	}

	private static void insert() {
		CountryServiceImpl con = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		dto.setCountry_id("KO");
		dto.setCountry_name("KOREA");
		dto.setRegion_id(1);
		try {
			int n = con.insert(dto);
			if (n != 0)
				System.out.println("정상적으로 등록쓰");
			else
				System.out.println("입력안됐졍");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void update() {
		CountryServiceImpl con = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("업뎃할사용자 아이디 입력해바");
		String key = sc.nextLine();
		try {
			dto = con.select(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("변경 할 country name 입력행");
		dto.setCountry_name(sc.nextLine());
		try {
			int n = con.update(dto);
			if (n != 0)
				System.out.println("정삭적으로 변경됐져~~~");
			else
				System.out.println("변경 안됐눈뎅~~~~~");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sc.close();

	}

	private static void delete() {
		CountryServiceImpl con = new CountryServiceImpl();
		CountryDto dto = new CountryDto();
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 할 사용자 입력행");
		dto.setCountry_id(sc.nextLine());
		try {
			int n = con.delete(dto);
			if (n != 0)
				System.out.println("정상적으로 삭제 됨");
			else
				System.out.println("삭제 안됐졍");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
