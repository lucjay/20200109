package co.lucjay.methodExam;

public class ExamMethod {
	public void exam01() {
		System.out.println("리턴 타입이 없는 기본 메소드 입니다.");
	}

	public int sum(int n, int m) {
		System.out.println("전달인자 두개를 받아서 두수의 합을 구함");
		int result = n + m;
		System.out.println("전달된 N 값 : " + n);
		return result;
	}

	public String str() {
		System.out.println("문자열을 돌려주는 메소드");
		String msg = "문자만돌려줘요";
		return msg;
	}

}
