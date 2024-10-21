package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	private MemberDAO memberdao = MemberDAO.getInstance();
	
	MemberDTO memberdto = new MemberDTO();
	public MemberService() {
		menu();
	}
	
	private void menu() {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1.등록, 2.수정, 3.전체보기, 4.삭제, 5.종료" );
			int selNum = in.nextInt();
			in.nextLine();
			switch (selNum) {
			case 1: userAdd(); break; 
			case 2: userMod(); break;
			case 3: userAll(); break;
			case 4: userDel(); break;
			case 5: break;
			}
		}
	}

	private void userAdd() {
		Scanner in = new Scanner(System.in);
		MemberDTO memberdto = new MemberDTO(); 
		System.out.println("ID를 입력하세요");
		String ID = in.nextLine();
		System.out.println("Pwd를 입력하세요");
		String Pwd = in.nextLine();
		System.out.println("Name를 입력하세요");
		String Name = in.nextLine();
		System.out.println("Phone를 입력하세요");
		String Phone = in.nextLine();
		System.out.println("Birth를 입력하세요");
		String Birth = in.nextLine();
		System.out.println("Email을 입력하세요");
		String Email = in.nextLine();
//		System.out.println("Date를 입력하세요");
//		String Date = in.nextLine();
		memberdto.setUserID(ID);
		memberdto.setUserPwd(Pwd);
		memberdto.setUserName(Name);
		memberdto.setUserPhone(Phone);
		memberdto.setUserBirth(Birth);
		memberdto.setUserEmail(Email);
//		logindto.setDate(Date);
		memberdao.insert(memberdto); 
		
	}
	private void userMod() {
		memberlist();
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 Num 입력");
		int Num = in.nextInt();
		in.nextLine();
		memberdto.setNum(Num);
		System.out.println("수정할 ID 입력");
		String ID = in.nextLine();
		memberdto.setUserID(ID);
		System.out.println("수정할 Pwd 입력");
		String Pwd = in.nextLine();
		memberdto.setUserPwd(Pwd);
		memberdao.update(memberdto);
//		System.out.println("수정할 Name 입력");
//		String Name = in.nextLine();
//		logindto.setName(Name);
//		System.out.println("수정할 Birth 입력");
//		String Birth = in.nextLine();
//		logindto.setName(Name);
//		System.out.println("수정할 Phone 입력");
//		String Phone = in.nextLine();
//		logindto.setPhone(Phone);
	}
	private void userAll() {
		memberlist();
		ArrayList<MemberDTO> memlist = memberdao.selectAll();
//		System.out.println("1");
//		System.out.println("2");
	}
	
	private void userDel() {
		memberlist();
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 번호 입력");
		String MNum = in.nextLine();
		memberdao.delete(MNum);
	}
	private void memberlist() {
		ArrayList<MemberDTO> memlist = memberdao.selectAll();
		for(MemberDTO A : memlist) {
			System.out.println("번호 : " + A.getNum() + " | " + "아이디 : " + A.getUserID() + " | " + "페스워드 : " + A.getUserPwd() + " | " + "이름 : " + A.getUserName()+ " | "
								+ "생일 : " + A.getUserBirth() + " | "  + "핸드폰번호 : " + A.getUserPhone());
		}
	}
}
