package co.lucjay.newInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterfaceSeviceImpl implements InterfaceService {
	public PreparedStatement psmt;
	public ResultSet rs;

	private String SELECT = "select * from countries where country_id = ?";
	private String ALL_SELECT = "select * from countries";

	@Override
	public List<?> allSelect() throws SQLException { // ?사용하고 사용할것을 집어넣음 커넥션풀이면 throws익셉션을
		CountryDao dao = new CountryDao(); // 상속안받았기때문에 새로 인스턴스생성
		CountryDto dto;
		List<CountryDto> list = new ArrayList<CountryDto>();
		psmt = dao.conn.prepareStatement(ALL_SELECT);
		rs = psmt.executeQuery();
		while (rs.next()) {
			dto = new CountryDto();// 초기화
			dto.setCountry_id(rs.getString("country_id"));
			dto.setCountry_name(rs.getString("country_name"));
			dto.setRegion_id(rs.getInt("region_id"));
			list.add(dto);
		}
		return list;

	}

	@Override
	public Object select(Object o) throws SQLException {
		CountryDao dao = new CountryDao();
		CountryDto dto = new CountryDto();
		psmt = dao.conn.prepareStatement(SELECT); // 결합도가 높아짐 결합도 높은프로그램은 나빠요
		psmt.setString(1, (String) o); // 형변환 포장해서 던져
		rs = psmt.executeQuery();
		if (rs.next()) {
			dto.setCountry_id(rs.getString("country_id"));
			dto.setCountry_name(rs.getString("country_name"));
			dto.setRegion_id(rs.getInt("region_id"));
		}
		return dto;
	}

	@Override
	public int insert(Object o) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object o) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object o) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
