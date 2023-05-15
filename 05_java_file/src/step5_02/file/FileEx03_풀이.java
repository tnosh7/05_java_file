package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제1

//finally 안쓰면 입력 안됨 .ㄴㅇ. 
public class FileEx03_풀이 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이만수", "이영희"};
		int[] ages     = {	   20,     30,     40};
		
		String fileName = "fileTest01.txt";
		
		String data = "";
		FileWriter fw = null;
		
		for (int j = 0; j < names.length; j++) {
			data += names[j] + "/" + ages[j];
			if (j != names.length-1 ) {
				data += "," ;
			}
		}
		//System.out.print(data); 확인용
		try {
			
			fw = new FileWriter(fileName);
			
			
			fw.write(data);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { try { fw.close(); } catch (IOException e) {	e.printStackTrace();}
		}

		
		
	}

}
