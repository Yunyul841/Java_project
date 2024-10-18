package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class StuService {
	private UserDAO userdao = UserDAO.getInstance();
	public StuService() {
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
			case 1: StuAdd(); break;
			case 2: StuMod(); break;
			case 3: StuAll(); break;
			case 4: StuDel(); break;
			case 5: break;
			}
		}
	}
	private void StuAdd() { // 등록
		UserDTO userdto = new UserDTO();
		Scanner in = new Scanner(System.in);
		System.out.println("수강생의 ID를 입력하세요");
		String UserID = in.nextLine();
		System.out.println("수강생의 Password를 입력하세요");
		String Password = in.nextLine();
		System.out.println("수강생의 Name를 입력하세요");
		String Name = in.nextLine();
		System.out.println("수강생의 Phone를 입력하세요");
		String Phone = in.nextLine();
		System.out.println("수강생의 Email를 입력하세요");
		String Email = in.nextLine();
//		System.out.println("수강생의 JoinDate를 입력하세요");
//		String JoinDate = in.nextLine();
		userdto.setUserID(UserID);
		userdto.setPassword(Password);
		userdto.setName(Name);
		userdto.setPhone(Phone);
		userdto.setEmail(Email);
//		userdto.setJoinDate(JoinDate);
		userdao.insert(userdto);
	}
	private void StuMod() { // 수정
		userlist();
		UserDTO userdto = new UserDTO();
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 번호 입력");
		int num = in.nextInt();
		in.nextLine();
		userdto.setNum(num);
		System.out.println("수정할 ID 입력");
		String UID = in.nextLine();
		userdto.setUserID(UID);
		System.out.println("수정할 Password 입력");
		String Pwd = in.nextLine();
		userdto.setPassword(Pwd);
		System.out.println("수정할 Name 입력");
		String Na = in.nextLine();
		userdto.setName(Na);
		System.out.println("수정할 Phone 입력");
		String Pho = in.nextLine();
		userdto.setPhone(Pho);
		System.out.println("수정할 Email 입력");
		String Emil = in.nextLine();
		userdto.setEmail(Emil);
		userdao.update(userdto);
		
	}
	private void StuAll() { // 전체보기
		userlist();
//		ArrayList<UserDTO> userlist = userdao.selectAll();
//		for(UserDTO t : userlist) {
//			System.out.println(t.toString());
//			System.out.println("num:" + t.getNum());
//	}
			
	}
	private void StuDel() { // 삭제
		userlist();
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 번호를 입력");
		String  delNum = in.nextLine();
		userdao.delete(delNum);
	}
	private void userlist() {
		ArrayList<UserDTO> userlist = userdao.selectAll();
		for(UserDTO U : userlist) {
			System.out.println( " 번호 > " + U.getNum() +  " : " +" 아이디 : " + U.getUserID() + " : " +  " 패스워드 : " + U.getPassword() + " 이름 > 2 " + U.getName()
									+ " : " + "핸드폰 번호 : " + U.getPhone() + " : " +" 이메일 : " + U.getEmail());
		}
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

