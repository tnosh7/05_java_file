package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제2

public class FileEx04_풀이 {

	public static void main(String[] args) {
		
		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		String[] names = {"momk", "megait", "github"};
		String[] pws   = {"1111",   "2222",   "3333"};
		int[]    moneys= { 20000,    30000,    40000};
		
		String fileName = "fileTest02.txt";
		
		String data = "";
		
		FileWriter fw = null;
		
		for (int i = 0; i < moneys.length; i++) {
			data += names[i] + "/" + pws[i] + "/" + moneys[i] + "\n";
			//data += names[i] ; 이런식으로 
			//data +=  "/";   하나씩 . 
		}
		
		try {													//변수저장할 때 try /catch문 밖에서 하기 . 
			
			fw = new FileWriter(fileName);
			
			//System.out.print(data + " ");	확인용
			
			fw.write(data);
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally { try {fw.close();} catch (IOException e) {e.printStackTrace();}
		}
		
		

	}

}
