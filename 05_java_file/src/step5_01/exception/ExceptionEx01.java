package step5_01.exception;

/*
 * 
 * # 예외 (Exception) 처리
 * 
 * - 오류를 발생시킬수 있는 내용 및 자바와 외부 모듈과의 컨넥션을 맺는 경우는 try , catch구문을 사용 하여 오류를 제어한다.
 * 
 * 	- [구성]
 *    try   : 오류가 나지 않을 경우 정상적으로 실행 될 명령어
 * 	  catch : try{} 안의 명령어가 실행되는 중 오류가 발생할 경우 분기되는 명령어
 * 
 *  - try없이 catch구문이 단독으로 올 수 없고 , catch구문 없이 try구문이 단독으로 올 수 없다.
 * 
 * */

public class ExceptionEx01 {

	public static void main(String[] args) {
		
		try {
			int[] testArr = new int[5];		
			//System.out.println(testAtrr[0]);
			//System.out.println(testArr[999]);
			System.out.println(testArr[0] / 0);			//에러 동시에 불가 
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과 에러 catch");
			e.printStackTrace();
			
		} catch (ArithmeticException e) {
			System.out.println("연산 에러 catch");
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("모든 에러 catch");
			e.printStackTrace();
		}
	
	
	
	}

}
