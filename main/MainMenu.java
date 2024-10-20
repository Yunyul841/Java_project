package main;
import java.util.Scanner;

import dto.MemberDTO;
import service.CourseService;
import service.MemberService;
import service.MentService;

public class MainMenu {
	private MemberService MemberService = null;
	private CourseService CourseService = null;
	private MentService MentService = null;
	private String user = null;
	
	MainMenu(){
		while(true) {
//			menu();
			Scanner in = new Scanner(System.in);	
				System.out.println("메뉴선택");
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
			MemberService = new MemberService();
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
			Scanner in = new Scanner(System.in);
			System.out.println("ID 입력");
			String ID = in.nextLine();
			System.out.println("Pwd 입력");
			String Pwd = in.nextLine();
			
			
			
		}
//		private void menu() {
//			System.out.println("수강생");
//			System.out.println("강의");
//			System.out.println("수강신청");
//			
//		}
	}


