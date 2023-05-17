package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[3단계] : 장바구니

public class FileEx08_풀이 {
	
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] cart = new int[MAX_SIZE][2];
		
		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		while (true) {
			
			System.out.println("============");
			for (int i = 0; i < ids.length; i++) {
				System.out.print(ids[i] + " : " + pws[i] + " : ");
				for (int j = 0; j < count; j++) {
					if(cart[j][0] == i) {
						if (cart[j][1]==1) System.out.print("사과");
						else if (cart[j][1]==2) System.out.print("바나나");
						else if (cart[j][1]==3) System.out.print("딸기");
						System.out.print("/");
					}
				System.out.println();
				}
				
			}
			System.out.println("============");
			if (log == -1) System.out.println("상태 : 로그아웃 ");
			else System.out.println("상테 : " + ids[log] + "님, 로그인");
			System.out.println("============");
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
			int check = 0;
			int idx =0;
			if (selectMenu == 1) {
				if (log == -1 ) {
					System.out.print("[로그인]ID 입력 : ");
					String logId =scan.next();
					System.out.print("[로그인]PW 입력 : ");
					String logPw =scan.next();
			
					for (int i = 0; i < ids.length; i++) {
						if (ids[i].equals(logId) && pws[i].equals(logPw)) {
							check = 1;
							log = i;
						}
						
					}
					if(check ==1) {
						System.out.println("[메세지]" + ids[log] + "님, 환영합니다.");
					}
					
					else System.out.println("[메세지]아이디와 비밀번호를 확인해주세요");
				}
				else System.out.println("[메세지]로그아웃 후에 이용가능합니다.");
			}
			else if (selectMenu == 2) {
				if (log != -1) {
					System.out.println("[메세지]로그아웃 되었습니다.");
					log =-1;
				}
				else System.out.println("[메세지]로그인 후에 이용가능합니다.");
			}
			else if (selectMenu == 3) {
				if (log != -1) { 
					for (int i = 0; i < items.length; i++) {
						System.out.println((i+1) + "." + items[i] );
					}
					System.out.print("[쇼핑]상품번호를 선택하세요 : ");
					int itemIdx = scan.nextInt();
					
					cart[count][0] = log;
					cart[count][1] = itemIdx;
					count++;
				}	
			}
			else if (selectMenu == 4) {
				if (log != -1) { 
					int j =0;
					for (int i = 0; i < count; i++) {
						if (log == cart[i][0]) {
							System.out.print((j+1) + " ");
							if(cart[i][1]== 1)System.out.print("사과");
							else if(cart[i][1]== 2)System.out.print("바나나");
							else if(cart[i][1]== 3)System.out.print("딸기");
							j++;
						}
						System.out.println();
					}
				}
				else System.out.println("[메세지]로그인 이후에 사용가능");
			}
			else if (selectMenu == 5) {
				String data = "";
				
				for (int i = 0; i < count; i++) {
					data+= cart[i][0];
					data+= "/";
					data+= cart[i][1];
					data+= "\n";
					
				}
				data = data.substring(0, data.length()-1);
				System.out.println(data);
				
				FileWriter fw = null;
				
				try {
				fw = new FileWriter(fileName);
				fw.write(data);
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if (fw != null) {try {fw.close();} catch (IOException e) {e.printStackTrace();}}
				}
				System.out.println("[메세지]저장을 완료했습니다.");
			}
			else if (selectMenu == 6) {
				File file = new File(fileName);
				
				if (file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						count =0;
						String line = br.readLine();
						while(line != null) {
							String[]tmp = line.split("/");
							cart[count][0] = Integer.parseInt(tmp[0]);
							cart[count][1] = Integer.parseInt(tmp[1]);
							count++;
							
							line = br.readLine();
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} finally {
						if (fr != null) {try {fr.close();} catch (IOException e) {e.printStackTrace();}}
						if (br != null) {try {br.close();} catch (IOException e) {e.printStackTrace();}}
					}
				}
			}
			else if (selectMenu == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
