package step5_01.exception;

/*
 * 
 * # 예외 (Exception) 처리 throws
 * 
 *  - try ~ catch 와 같이  오류를 처리하나 상위 메서드로 오류에 대한 제어를 전가한다.
 * 
 * */

public class ExceptionEx03 {

	public static void main(String[] args) throws Exception {
		
		int[] testArr = new int[5];
		//System.out.println(testArr[0]);
		//System.out.println(testArr[999]);
		System.out.println(testArr[0] / 0);
		
		
					
	}

}
