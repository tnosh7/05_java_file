package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제2

public class FileEx04_문제2 {

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
			data += names[i];
			data += "/";
			data += pws[i];
			data += "/";
			data += moneys[i];
			if (i != moneys.length-1) {
				data+="\n";
			}
		}
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
