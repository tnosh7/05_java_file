package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



//# 파일 컨트롤러[2단계] : ATM

public class FileEx07_풀이 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int atmSize = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[atmSize];
		String[]  pws = new String[atmSize];
		int[]  moneys = new int[atmSize];
		
		String fileName = "atm.txt";
		
		
		while(true) {
			int check = 0;
			int idx = 0;
			System.out.println("------------");
			if (identifier == -1) {
				System.out.println("상태 : 로그아웃 ");
				System.out.println("------------");
				
			}
			else {
				System.out.println(accs[idx] + " : " + pws[idx] + " : " + moneys[idx]);
				System.out.println("------------");
				System.out.println("상태 : " + accs[idx] + "님 로그인중"); //나중에 인덱스 넣기 
			}
			System.out.println("------------");
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				if (identifier != -1) {
					System.out.println("로그아웃 후에 사용해주세요.");
					continue;
				}
				else if (accsCnt == atmSize) {
					System.out.println("더이상 회원가입이 불가능합니다.");
					continue;
				}
				else {
					System.out.print("[가입]계좌번호 입력 : ");
					String acc = scan.next();
					
					for (int i = 0; i < accs.length; i++) {
						if (acc.equals(accs[i])) {
							check = 1;
						}
					}
					if (check == 1) {
						System.out.println("계좌번호를 확인해주세요.");
						continue;
					}
					else {
						System.out.print("[가입]비밀번호 입력 : ");
						String pw = scan.next();
						accs[accsCnt] = acc;
						pws[accsCnt] = pw;
						accsCnt++;
						moneys[accsCnt] = 10000;
					}
				}
			}
			else if (sel == 2) {
				idx = 0;
				if (identifier == -1) {
					System.out.println("로그인 후에 사용해주세요.");
				}
				else {
					System.out.print("[탈퇴]계좌번호를 입력해주세요");
					String delAcc = scan.next();
					
					for (int i = 0; i < accs.length; i++) {
						if (accs[i].equals(delAcc)) {
							check = 1; 
							idx = i;
						}
						else check = 2;
					}
					
					if (check == 1) {
						System.out.print("[탈퇴]비밀번호 입력 : ");
						String delPw = scan.next();
						
						if (pws[idx].equals(delPw)) {
							System.out.println("탈퇴완료");
							
							identifier = -1;
							accsCnt--;
							continue;
						}
					}
					else check = 2; 
					if (check == 2) {
						System.out.println("계좌번호와 비밀번호를 확인해주세요.");
						continue;
					}
				}
				check = 0;
			}
			else if (sel == 3) {
				
				if (identifier != -1 ) {
					System.out.println("로그아웃 후에 사용가능");
				}
				else { 
					System.out.print("[로그인]계좌번호를 입력해주세요");
					String loginAcc = scan.next();
					
					System.out.print("[로그인]비밀번호 입력 : ");
					String loginPw = scan.next();
					for (int i = 0; i < accs.length; i++) {
						if (pws[idx].equals(loginPw) && accs[i].equals(loginAcc)) {
							check = 1; 
							idx = i;
						}
						else check = 2;
					}
						
					if (check == 1) {
						System.out.println(accs[idx]+ "님 환영합니다.");
						identifier = idx;
						continue;
					}
					if (check == 2) {
						System.out.println("계좌번호와 비밀번호를 확인해주세요.");
						continue;
					}
				}
				check = 0;
			}
			else if (sel == 4) {
				if (identifier == -1) {
					System.out.println("로그인 후에 사용가능");
					continue;
				}
				else {
					System.out.println("로그아웃 성공");
					identifier = -1;
				}
			}
			else if (sel == 5) {
				if (identifier == -1) {
					System.out.println("로그인 후에 사용가능");
					continue;
				}
				else {
					System.out.print("입금할 금액을 입력해주세요 ");
					int addMoney = scan.nextInt();
				
					moneys[idx] += addMoney;
				}
			}
			else if (sel == 6) {
				if (identifier == -1) {
					System.out.println("로그인 후에 사용가능");
					continue;
				}
				else {
					System.out.print("출금할 금액을 입력해주세요 ");
					int putMoney = scan.nextInt();
					
					if (putMoney > moneys[idx]) {
						System.out.println("잔액이 부족합니다.");
						continue;
					}
					
					else {
						moneys[idx] -= putMoney;
					}
				}
			}
			else if (sel == 7) {
				if (identifier == -1) {
					System.out.println("로그인 후에 사용가능");
					continue;
				}
				else {
					System.out.print("이체할 계좌번호를 입력해주세요 ");
					String drawAcc = scan.next();
					
					for (int i = 0; i < accs.length; i++) {
						if (accs[i].compareTo(drawAcc) != 0) {
							check = -1;
						}
						else check = i;
					}
					if (check == -1) {
						System.out.println("이체할 계좌번호를 확인해주세요");
						continue;
					}
					System.out.print("이체할 금액을 입력해주세요 ");
					int drawMoney = scan.nextInt();
					
					if (drawMoney > moneys[idx]) {
						System.out.println("이체할 금액이 부족합니다.");
						continue;
					}
					else {
						moneys[idx] -= drawMoney;
						moneys[check] += drawMoney;
					}
				}
				check = 0;
			}
			else if (sel == 8) {
				if (identifier == -1) {
					System.out.println("로그인 후에 사용가능");
					continue;
				}
				else {
					System.out.println(accs[idx] + "님의 계좌잔액은 " + moneys[idx] + "원 입니다.");
				}
			}
			else if (sel == 9) {
				
				FileWriter fw = null;
				String data = "";
				String[] temp = new String[accsCnt];
				try {
					
					fw = new FileWriter(fileName);
					
					for (int i = 0; i < accsCnt; i++) {
						temp[0] += accs[i];
						temp[1] += pws[i];
						temp[2] += moneys[i];
					}
					for (int i = 0; i < temp.length; i++) {
						data = temp[i];
					}
					
					fw.write(data);
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally {try {fw.close();} catch (IOException e) {e.printStackTrace();}
				}
			
			}
			else if (sel == 10) {
				File file = new File(fileName);
				
				FileReader fr = null; 
				BufferedReader br = null; 
				
				if (file.exists()) {
					
					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while (true) {
							String line = br.readLine();
							if (line == null) {
								break;
							}
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
						try {fr.close();} catch (IOException e) {e.printStackTrace();}
					}
				}
			}
			else if (sel == 0) {
				break;
			}
			
		}
		scan.close();
	}
		
}
