package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	private MemberDAO logindao = MemberDAO.getInstance();
	Scanner in = new Scanner(System.in);
	MemberDTO logindto = new MemberDTO(); 
	public MemberService() {
		menu();
	}
//	ArrayList<LoginDTO> Llist = new ArrayList<>(); 
	
	public void menu() {
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
		MemberDTO logindto = new MemberDTO(); 
		System.out.println("ID를 입력하세요");
		String ID = in.nextLine();
		System.out.println("Pwd를 입력하세요");
		String Pwd = in.nextLine();
		System.out.println("Name를 입력하세요");
		String Name = in.nextLine();
		System.out.println("Birth를 입력하세요");
		String Birth = in.nextLine();
		System.out.println("Phone를 입력하세요");
		String Phone = in.nextLine();
		logindto.setID(ID);
		logindto.setPwd(Pwd);
		logindto.setName(Name);
		logindto.setBirth(Birth);
		logindto.setPhone(Phone);
		logindao.insert(logindto); 
	}
	private void userMod() {
		System.out.println("수정할 Num 입력");
		int Num = in.nextInt();
		in.nextLine();
		logindto.setNum(Num);
		System.out.println("수정할 ID 입력");
		String ID = in.nextLine();
		logindto.setID(ID);
		System.out.println("수정할 Pwd 입력");
		String Pwd = in.nextLine();
		logindto.setPwd(Pwd);
//		System.out.println("수정할 Name 입력");
//		String Name = in.nextLine();
//		logindto.setName(Name);
//		System.out.println("수정할 Birth 입력");
//		String Birth = in.nextLine();
//		logindto.setName(Name);
//		System.out.println("수정할 Phone 입력");
//		String Phone = in.nextLine();
//		logindto.setPhone(Phone);
		logindao.update(logindto);
	}
	private void userAll() {
		ArrayList<MemberDTO> loginlist = logindao.selectAll();
		loginlist();
	}
	
	private void userDel() {
		loginlist();
		System.out.println("삭제할 번호 입력");
		String logNum = in.nextLine();
		logindao.delete(logNum); 
	}
	private void loginlist() {
		ArrayList<MemberDTO> loginlist = logindao.selectAll();
		for(MemberDTO A : loginlist) {
			System.out.println("번호 : "+ A.getNum() + "| " + "아이디 : " + A.getID() + " | " + "페스워드 : " + A.getPwd() + " | " + "이름 : " + A.getName()+" | "
								+ "생일 : " + A.getBirth()+ " | "  + "핸드폰번호 : " + A.getPhone());
		}
	}
}
