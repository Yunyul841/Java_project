package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CourseDAO;
import dto.CourseDTO;

public class CourseService {

	private CourseDAO coursedao = CourseDAO.getInstance();
	public CourseService() {
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
			case 1: CouAdd(); break;
			case 2: CouMod(); break;
			case 3: CouAll(); break;
			case 4: CouDel(); break;
			case 5: flag = false; break;
			}
		}
		in.close();
	}

	private void CouAdd() {
		CourseDTO coursedto = new CourseDTO();
		Scanner in = new Scanner(System.in);
		System.out.println("강의 ID를 입력하세요");
		String CourseID = in.nextLine();
		System.out.println("강의명을 입력하세요");
		String CourseName = in.nextLine();
		System.out.println("언어를 입력하세요");
		String Language = in.nextLine();
		System.out.println("과정종류를 입력하세요");
		String CourseType = in.nextLine();
		System.out.println("수강료를 입력하세요");
		String Money = in.nextLine();
		System.out.println("지역을 입력하세요");
		String Region = in.nextLine();
		coursedto.setCourseID(CourseID);
		coursedto.setCourseName(CourseName);
		coursedto.setLanguage(Language);
		coursedto.setCourseType(CourseType);
		coursedto.setMoney(Money);
		coursedto.setRegion(Region);
		coursedao.insert(coursedto);
	}

	private void CouMod() {
		Scanner in = new Scanner(System.in);
		CourseDTO coursedto = new CourseDTO();
		courseliset();
		System.out.println("수정할 번호를 입력");
		int Num = in.nextInt();
		in.nextLine();
		coursedto.setNum(Num);
		System.out.println("수정할 강의ID 입력");
		String Cid = in.nextLine();
		coursedto.setCourseID(Cid);
		System.out.println("수정할 강의명 입력");
		String CName = in.nextLine();
		coursedto.setCourseName(CName);
		System.out.println("수정할 언어를 입력");
		String Lang = in.nextLine();
		coursedto.setLanguage(Lang);
		System.out.println("수정할 과정종류를 입력");
		String CType = in.nextLine();
		coursedto.setCourseType(CType);
		System.out.println("수정할 수강료 입력");
		String Mon = in.nextLine();
		coursedto.setMoney(Mon);
		System.out.println("수정할 지역 입력");
 		String Reg = in.nextLine();
 		coursedto.setRegion(Reg);
 		coursedao.update(coursedto);
	}

	private void CouAll() {
		ArrayList<CourseDTO> courselist = coursedao.selectAll();
		courseliset();
//		for(CourseDTO A : courselist) {
//			System.out.println(A.toString());
//		}
	}

	private void CouDel() {
		courseliset();
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 번호 입력");
		String delNum = in.nextLine();
		coursedao.delete(delNum);
		
	}
	private void courseliset() {
		ArrayList<CourseDTO> courselist = coursedao.selectAll();
		for(CourseDTO T : courselist) {
			System.out.println( "번호 : " +  T.getNum() +" | " + "강의 ID : " + T.getCourseID() + " | "+ "강의명 : " + T.getCourseName() + " | "
								+ "언어 : " + T.getLanguage() + " | " + " 과정종류 : " + T.getCourseType()+ " | "
								+ "수강료 : " + T.getMoney() +" | " + "지역 : " + T.getRegion());
		}
	}
	
}
