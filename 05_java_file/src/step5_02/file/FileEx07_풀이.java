package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//# 파일 컨트롤러[2단계] : ATM

public class FileEx07_풀이 {
	
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		
		int atmSize = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[atmSize];
		String[]  pws = new String[atmSize];
		int[]  moneys = new int[atmSize];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println("----------");
			if (accsCnt > 0) {
				for (int i = 0; i < accsCnt; i++) {
					System.out.println(accs[i] + " : " + pws[i] + " : " + moneys[i]);
				}
			}
			System.out.println("----------");
			if (identifier == -1 ) {
				System.out.println("상태 : 로그아웃");
			}
			else if (identifier == 1) {
				System.out.println("상태 : " + accs[identifier] + "님, 로그인");
			}
			System.out.println("----------");
			
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
				
				if (accsCnt != atmSize) {
					System.out.print("[가입]계좌번호 입력 : ");
					String acc = scan.next();
					
					System.out.print("[가입]비밀번호 입력 : ");
					String pw = scan.next();
					
					accs[accsCnt] = acc;
					pws[accsCnt] = pw;
					moneys[accsCnt] = 1000;
					accsCnt++;
				}
				else if (identifier != -1){
					System.out.println("로그아웃 후에 사용 가능합니다.");
					continue;
				}
				else System.out.println("더이상 가입 불가능");
			}
			else if (sel == 2) {
				if (identifier != -1 && accsCnt > 0) {
					System.out.println("[메세지]탈퇴되었습니다.");
					
					String []tmp = accs; 
					accs = new String[accsCnt -1]; 
					int k = 0;
					for (int i = 0; i < accsCnt; i++) {
						if (i != identifier) {
							accs[k] = tmp[i];
						}
					}
					accsCnt--;
					tmp = null;
					
					tmp = pws; 
					pws = new String[accsCnt -1]; 
					k = 0;
					for (int i = 0; i < accsCnt; i++) {
						if (i != identifier) {
							pws[k] = tmp[i];
						}
					}
					tmp = null;
				}
				else System.out.println("로그인 후에 이용가능");
			}
			else if (sel == 3) {
				int check = 0;
				
				if (identifier == -1) {
					System.out.print("[로그인]계좌번호 입력 : ");
					String loginAcc = scan.next();
					System.out.print("[로그인]비밀번호 입력 : ");
					String loginPw = scan.next();
				  
					for (int i = 0; i < accsCnt; i++) {
						if (accs[i].equals(loginAcc) && pws[i].equals(loginPw)) {
							check = 1;
							identifier = i;
						}
					}
					if (check == 1) {
						System.out.println(accs[identifier] + "님 환영합니다.");
					}
					else {
						System.out.println("계좌번호와 비밀번호를 확인해주세요");
					}
				}
				else {
					System.out.println("로그인 후에 이용가능");
					continue;
				}
			}
			else if (sel == 4) {
				if (identifier != -1) {
					System.out.println("[메세지]로그아웃 되었습니다.");
					identifier = -1;
				}
				else {
					System.out.println("로그인 후에 이용가능");
					continue;
				}
			}
			else if (sel == 5) {
				if (accsCnt == 0) { 
					System.out.println("회원가입 후에 이용가능");
				}
				else {
					if (identifier != -1) {
						System.out.print("[입금]금액 입력 : ");
						int addMoney = scan.nextInt();
						
						moneys[identifier] += addMoney;
						System.out.println("[메세지]입금을 완료하였습니다.");
						continue;
					}
					else {
						System.out.println("로그인 후에 이용가능");
						continue;
					}
				}
			}
			else if (sel == 6) {
				if (accsCnt == 0) { 
					System.out.println("회원가입 후에 이용가능");
				}
				else {
					if (identifier != -1) {
						System.out.print("[출금]금액 입력 : ");
						int drawMoney = scan.nextInt();
						
						if (moneys[identifier] < drawMoney) {
							System.out.println("출금 금액이 부족합니다.");
						}
						else System.out.println("[메세지]출금을 완료하였습니다.");
					}
					else  {
						System.out.println("로그인 후에 이용가능");
						continue;
					}
				}
			}
			else if (sel == 7) {
				int check = 0;
				int idx = 0;
				if (accsCnt == 0) { 
					System.out.println("회원가입 후에 이용가능");
				}
				else {
					if (identifier != -1) {
						System.out.print("[이체]계좌번호 입력 : ");
						String awayAcc = scan.next();
						
						for (int i = 0; i < accs.length; i++) {
							if (accs[i].equals(awayAcc)) {
								check = 1;
								idx = i;
							}
							else check = 2;
						}
						if (check == 1) {
							System.out.print("[이체]금액 입력 : ");
							int awayMoney = scan.nextInt();
							
							if (moneys[identifier] < awayMoney) {
								System.out.println("이체 금액이 부족합니다.");
							}
							else {
								System.out.println("[메세지]이체를 완료하였습니다.");
								moneys[identifier] -= awayMoney;
								moneys[idx] += awayMoney;
							}
						}
						else {
							System.out.println("계좌번호를 확인해주세요");
							continue;
						}
					}
					else  {
						System.out.println("로그인 후에 이용가능");
						continue;
					}
				}
			}
			else if (sel == 8) {
				if (accsCnt == 0) { 
					System.out.println("회원가입 후에 이용가능");
				}
				else {
					if (identifier != -1) {
						System.out.println("상태 : " + accs[identifier] + "님의 계좌잔액은 " + moneys[identifier] + "원 입니다.");
					}
				}
			}
			else if (sel == 9) {
				String data = "";
				FileWriter fw = null;
				
				for (int i = 0; i < accsCnt; i++) {
					data += accs[i];
					data += "/";
					data += pws[i];
					data += "/";
					data += moneys[i];
					data += "\n";
				}
				data = data.substring(0, data.length()-1);//
				
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {fw.close();} catch (IOException e) {e.printStackTrace();}
				}
			}
			else if (sel == 10) {
				File file = new File(fileName);
				if (file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
				
					try {
						
						String data = "";
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						int i = 0;
						while (true) {
							String line = br.readLine();
							if (line == null) {
								break;
							}
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);//
						
						
						String[] temp = data.split("\n");
						accsCnt = temp.length;//
						
						for (int j = 0; j < accsCnt; j++) {
							String[]temp2 =temp[i].split("/");							
							accs[i] = temp2[0];
							pws[i] = temp2[1];
							moneys[i] = Integer.parseInt(temp2[2]);
							
							System.out.println(accs[i] + " : " + pws[i] + " : " + moneys[i]);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
					}
						try {fr.close();} catch (IOException e) {e.printStackTrace();}
					}
				else if (sel == 0) {
					break;
				}
				
			}
		}
	}

	private static String readline() {
		// TODO Auto-generated method stub
		return null;
	}
}
