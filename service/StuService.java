package service;

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
		System.out.println("수강생의 JoinDate를 입력하세요");
		String JoinDate = in.nextLine();
		userdto.setUserID(UserID);
		userdto.setPassword(Password);
		userdto.setName(Name);
		userdto.setPhone(Phone);
		userdto.setEmail(Email);
		userdto.setJoinDate(JoinDate);
//		userdao.in
		
		
		
		
	}
	private void StuMod() { // 수정
		
	}
	private void StuAll() { // 전체보기
		
	}
	private void StuDel() { // 삭제
		
	}
}

