package main;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberDTO;
import service.CourseService;
import service.MemberService;
import service.MentService;

public class MainMenu {
	private MemberService MemberService = null;
	private CourseService CourseService = null;
	private MentService MentService = null;
	private MemberDTO user = null;
	Scanner in = new Scanner(System.in);
		MainMenu(){
//		login();
		menu();

		}
		private void menu() {
			System.out.println("1. 관리자");
			System.out.println("2. 사용자");
			while(true) {
				System.out.println("선택해주세요");
			int sel = in.nextInt(); 
			in.nextLine();
			if(sel == 1) {
				System.out.println("관리자로 접속함");	
				CourseService();
			}else if(sel == 2) {
				System.out.println("사용자로 접속함");
				MemberService();
			}
		}
	}
		
		private void menu1() {
			System.out.println("1. 수강생 정보");
			System.out.println("2. 강의 정보");
			System.out.println("3. 수강신청");
				while(true) {
					Scanner in = new Scanner(System.in);	
					System.out.println("원하시는 항목을 선택해주세요");
	//				menu();
			int selNum = in.nextInt();
			in.nextLine();
			if(selNum == 1) {
				MemberService();
			} else if(selNum == 2) {
				CourseService();
			} else if(selNum == 3) {
				MentService();
			} else if(selNum == 0) {
				break;
			}
		}
		
	}
		
		private void MemberService() {
			 new MemberService();
//			MemberService.menu();
		}
		private void CourseService() {
			CourseService = new CourseService();
//			CourseService.menu();
		}
		private void MentService() {
			MentService = new MentService();
//			MentService.menu();
		}
		private void login() {
			int cnt = 0;
			Scanner in = new Scanner(System.in);
			System.out.println("ID 입력");
			String ID = in.nextLine();
			System.out.println("Pwd 입력");
			String Pwd = in.nextLine();
			if(user == null) {
				System.out.println("아이디가 존재하지 않습니다.");
				membership();
			}else {
				System.out.println("로그인성공 | 메인으로 이동");
				menu();
			}
//			for(int i = 0; i < Mlist.size(); i++ ) {
//				if(Mlist.get(i).getID().equals(ID) && Mlist.get(i).getPwd().equals(Pwd) ) {
//					System.out.println("로그인이 정상적으로 완료되었습니다.");
//					cnt = 1;
//				}
//			}
//			if(cnt == 0) {
//				System.out.println("입력하신 정보는 없습니다.");
//				membership();
//		}
		}
		// 회원가입
		private void membership() {
			ArrayList<MemberDTO> Mlist = new ArrayList<>();
			Scanner in = new Scanner(System.in);
			System.out.println("회원가입창입니다.");
			System.out.println();
			MemberDTO member = new MemberDTO();
			System.out.println("아이디를 입력하세요");
			String ID = in.nextLine();
			member.setUserID(ID);
			System.out.println("비밀번호를 입력하세요");
			String Pwd = in.nextLine();
			member.setUserPwd(Pwd);
			System.out.println("이름을 입력하세요");
			String Name = in.nextLine();
			member.setUserName(Name);
			System.out.println("핸드폰 번호를 입력하세요");
			String Phone = in.nextLine();
			member.setUserPhone(Phone);
			System.out.println("생일을 입력하세요");
			String Birth = in.nextLine();
			member.setUserBirth(Birth);
			System.out.println("이메일을 입력하세요");
			String Email = in.nextLine();
			member.setUserEmail(Email);
			Mlist.add(member);
			System.out.println("회원가입이 완료되었습니다.");
//			login();
			menu1();
		}
	}


