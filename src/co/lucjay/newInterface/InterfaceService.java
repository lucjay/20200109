package co.lucjay.newInterface;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceService {
	default void run() { // 디폴트보이드는 인터페이스에서만 사용가능 (인터페이스에서 몸체(구현됫것)를 가질수 있다.)
		System.out.println("인터페이스가 가지고 있는 메소드");
	}

	List<?> allSelect() throws SQLException; // 인터페이스에서 범위지시자를 사용안하면 퍼블릭이라는것

	Object select(Object o) throws SQLException;

	int insert(Object o) throws SQLException;

	int update(Object o) throws SQLException;

	int delete(Object o) throws SQLException;

}
