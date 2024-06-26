package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 어레이리스트

public class FileEx06_정답예시 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] arrayList = null;
		int elementCnt = 0;
		
		String fileName = "arrayList.txt";
		
		while (true) {
			
			for (int i = 0; i < elementCnt; i++) {
				System.out.print(arrayList[i] + " ");
			}
			System.out.println();
			
			System.out.println("[어레이리스트 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				if (elementCnt == 0) {
					arrayList = new int[elementCnt + 1];
				}
				else if (elementCnt > 0) {
					int[] temp = arrayList;
					arrayList = new int[elementCnt + 1];
					
					for (int i = 0; i < elementCnt; i++) {
						arrayList[i] = temp[i];
					}
					temp = null;					//초기화 잊지말기 
				}
				System.out.print("[추가]데이터 입력 : ");
				int data = scan.nextInt();
				
				arrayList[elementCnt] = data;
				elementCnt++;
				
			}
			else if (sel == 2) {
				
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = scan.nextInt();
				
				if (elementCnt - 1 < delIdx || delIdx < 0) {			//인덱스 길이에서 -1 꼭 해주기   
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				
				if (elementCnt == 1) {
					arrayList = null;
				}
				else if (elementCnt > 1) {
					int[] temp = arrayList;
					arrayList = new int[elementCnt - 1];
					
					int j = 0;
					for (int i = 0; i < elementCnt; i++) {
						if (i != delIdx) {					//delIdx 제외시키기 !!!!
							arrayList[j] = temp[i];
							j++;
						}
					}
					temp = null;//
				}
				elementCnt--;
				
			}
			else if(sel == 3) {		
				
				String data = "";
				if (elementCnt > 0) {							//인덱스 없을때는 동작안함 
					for (int i = 0; i < elementCnt; i++) {
						data += arrayList[i];
						data += "\n";
					}
					data = data.substring(0, data.length() - 1); //이거 왜하지?
					
					FileWriter fw = null;
					try {
						fw = new FileWriter(fileName);
						fw.write(data);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {fw.close();} catch (IOException e) {e.printStackTrace();}
					}
				} 
				else {
					System.out.println("[메세지]저장할 데이터가 없습니다.");	
				}
				
			}
			else if (sel == 4) {
				
				String data = "";
				File file = new File(fileName);
				
				if (file.exists()) {
					
					FileReader fr = null;
					BufferedReader br = null;
					
					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while (true) {
							String line = br.readLine();
							if (line == null) {
								break;
							}
							data += line;			//data에 옮기기 근데 뭐하러 ? 
							data += "\n";			//개행 
						}
						data = data.substring(0, data.length() - 1);// ??
						
						String[] temp = data.split("\n");
						elementCnt = temp.length;					//인덱스 길이 
						
						arrayList = new int[elementCnt];
						
						for (int i = 0; i < elementCnt; i++) {		
							arrayList[i] = Integer.parseInt(temp[i]);	//숫자로 형변환해주기 
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
						try {fr.close();} catch (IOException e) {e.printStackTrace();}
					}
				}
				
			}
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
