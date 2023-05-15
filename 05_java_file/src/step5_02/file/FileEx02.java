package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 파일 출력 (로드, Output)

public class FileEx02 {

	public static void main(String[] args) {
		
		
		File file = new File("ex01.txt"); 				// 파일 객체 생성
		FileReader fr = null;
		BufferedReader br = null;
		
		// exists) : 파일이 존재하면 true를 반환하고 존재하지 않으면 false를 반환한다.
		if (file.exists()) {
			
			try {
				
				fr = new FileReader(file);					// 파일 읽어오기
				br = new BufferedReader(fr); 				// 내용(텍스트) 읽어오기		
				
				String data = br.readLine(); // readLine(); 한 줄을 읽어온다.
				System.out.println(data);
				System.out.println();
				
				data = br.readLine(); 
				System.out.println(data);
				System.out.println();
				
				//전체 텍스트를 읽어오는 예시 
				while (true) {
					data = br.readLine();
					if ( data == null ) {  	// 읽어올 라인이 없으면 null을 반환한다.
						break;
					}
					System.out.println(data);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 나중에 open한 객체를 먼저 close() 한다.
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
			}
		}
		
		
		
		
		
		
	}

}
