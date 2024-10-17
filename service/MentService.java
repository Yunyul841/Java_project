package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MentDAO;
import dto.MentDTO;

public class MentService {
	private MentDAO mentdao = MentDAO.getInstance();
	public MentService() {
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
			case 1: MentAdd(); break;
			case 2: MentMod(); break;
			case 3: MentAll(); break;
			case 4: MentDel(); break;
			case 5: break;
			}
		}
	}

	private void MentAdd() {
		MentDTO mentdto = new MentDTO();
		Scanner in = new Scanner(System.in);
		System.out.println("수강생의 ID를 입력하세요");
		String UserID = in.nextLine();
		System.out.println("강의 ID를 입력하세요");
		String CourseID = in.nextLine();
		System.out.println("신청일을 입력하세요");
		String EnrollmentDate = in.nextLine();
		System.out.println("현재 상태를 입력하세요");
		String Status = in.nextLine();
		mentdto.setUserID(UserID);
		mentdto.setCourseID(CourseID);
		mentdto.setEnrollmentDate(EnrollmentDate);
		mentdto.setStatus(Status);
		mentdao.insert(mentdto);
	}

	private void MentMod() {
		MentDTO mentdto = new MentDTO();
		Scanner in = new Scanner(System.in);
		mentlist();
		System.out.println("수정할 번호를 입력하세요");
		int Num = in.nextInt();
		in.nextLine();
		mentdto.setNum(Num);
		System.out.println("수정할 수강생ID를 입력하세요");
		String UiD = in.nextLine();
		mentdto.setUserID(UiD);
		System.out.println("수정할 강의ID를 입력하세요");
		String CID = in.nextLine();
		mentdto.setCourseID(CID);
		System.out.println("수정할 신청일을 입력하세요");
		String Edte = in.nextLine();
		mentdto.setEnrollmentDate(Edte);
		System.out.println("수정할 현재 상태를 입력하세요");
		String St = in.nextLine();
		mentdto.setStatus(St);
		mentdao.update(mentdto);
	}

	private void MentAll() {
		ArrayList<MentDTO> mentlist = mentdao.selectAll();
		for(MentDTO J : mentlist) {
			System.out.println(J.toString());
		}
	}

	private void MentDel() {
		mentlist();
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 번호를 입력하세요");
		String delNum = in.nextLine();
		mentdao.delete(delNum);
	}
	
	private void mentlist() {
		ArrayList<MentDTO> mentlist = mentdao.selectAll();
		for(MentDTO M : mentlist) {
			System.out.println(" 수강생 ID : " + M.getUserID() + " 강의ID : " + M.getCourseID()
								+ " 신청일 : " + M.getEnrollmentDate() + " 현재상태 : " + M.getStatus());
		}
	}
	
	
}
