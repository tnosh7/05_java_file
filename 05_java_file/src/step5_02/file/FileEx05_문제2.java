package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//# 파일 로드하기 : 연습문제


public class FileEx05_문제2 {

	public static void main(String[] args) {
		
		
		// 4번 연습문제에서 작성된 텍스트파일을 읽어들여와 아래 배열에 저장하시오.
		
		String[] names = new String[3];			// momk , megait , github
		String[] pws   = new String[3];			// 1111 , 2222   , 3333
		int[] moneys   = new int[3];			// 20000, 30000 , 40000
		
		String fileName = "fileTest02.txt";
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader bf = null;
		
		try {
			fr = new FileReader(file);
			bf = new BufferedReader(fr);
			
			while (true) {
				String line = bf.readLine();
				if (line == null) break;
					
				String[]tmp = line.split("/");
				for (int i = 0; i < tmp.length; i++) {
					names[i] = tmp[0];
					pws[i] = tmp[1];
					moneys[i] = Integer.parseInt(tmp[2]);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
