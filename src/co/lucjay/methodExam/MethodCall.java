package co.lucjay.methodExam;

public class MethodCall {
	public void run() {
		ExamMethod exam = new ExamMethod();
		exam.exam01();

		int result = exam.sum(10, 5);
		int n = 20;
		int m = 60;
		int hap = exam.sum(n, m);

		String msg = exam.str();

		System.out.println("처음 호출한 결과 : " + result);
		System.out.println("두번째 호출한 결과 : " + hap);
		System.out.println("str() 호출 : " + msg);
	}
}
