package main;
import java.util.ArrayList;
import java.util.Scanner;

import dao.CourseDAO;
import dao.MemberDAO;
import dto.MemberDTO;
import service.CourseService;
import service.MemberService;
import service.MentService;

public class MainMenu {
    private MemberService memberService = null;
    private CourseService courseService = null;
    private MentService mentService = null;
    private MemberDTO user = null;
    private ArrayList<MemberDTO> Mlist = new ArrayList<>(); // 회원 정보를 저장하는 리스트
    private MemberDAO memberdao = MemberDAO.getInstance();
    Scanner in = new Scanner(System.in);

    public MainMenu() {
        // 관리자 또는 사용자를 선택하게 함
        selectUserType();
    }

    // 관리자와 사용자 구분
    private void selectUserType() {
        System.out.println("1. 관리자");
        System.out.println("2. 사용자");
        System.out.print("선택하세요: ");
        int selection = in.nextInt();
        in.nextLine(); 

        if (selection == 1) {
            System.out.println("관리자로 로그인합니다.");
            adminLogin();
        } else if (selection == 2) {
            System.out.println("사용자로 로그인합니다.");
            login();
        } else {
            System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            selectUserType();
        }
    }

    // 관리자 로그인 처리
    private void adminLogin() {
        System.out.println("관리자 ID 입력:");
        String id = in.nextLine();
        System.out.println("관리자 비밀번호 입력:");
        String password = in.nextLine();
        System.out.println("관리자 로그인 성공!");
//        adminMenu();
//        userMenu();
        adminMenu1();
    }

    // 관리자 메뉴
    private void adminMenu() {
        System.out.println("관리자 메뉴");
        // 관리자 메뉴 항목 추가 가능
        System.out.println("로그아웃 하시겠습니까? (y/n): ");
        String choice = in.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("로그아웃 완료");
            selectUserType();
        } else {
            adminMenu();
        }
    }

    // 사용자 로그인 처리
    private void login() {
    	MemberDTO memberdto = new MemberDTO(); 
        System.out.println("ID 입력:");
        String ID = in.nextLine();
        System.out.println("비밀번호 입력:");
        String Pwd = in.nextLine();
//        memberdto.setUserID(ID);
//        memberdto.setUserPwd(Pwd);
//        memberdao.insert(memberdto);
        // 사용자 리스트에서 ID를 찾음
        boolean userFound = false;
        for (MemberDTO member : Mlist) {
            if (member.getUserID().equals(ID) && member.getUserPwd().equals(Pwd)) {
                user = member; // 로그인한 사용자 정보 저장
                userFound = true;
                break;
            }
        }

        if (userFound) {
            System.out.println("로그인 성공 | 메인으로 이동");
            userMenu();
        } else {
            System.out.println("아이디가 존재하지 않습니다. 회원가입으로 이동합니다.");
            membership();
        }
    }

    // 사용자 회원가입
    private void membership() {
        System.out.println("회원가입 창입니다.");
        MemberDTO member = new MemberDTO();
        System.out.print("아이디를 입력하세요: ");
        String ID = in.nextLine();
        member.setUserID(ID);
        System.out.print("비밀번호를 입력하세요: ");
        String Pwd = in.nextLine();
        member.setUserPwd(Pwd);
        System.out.print("이름을 입력하세요: ");
        String Name = in.nextLine();
        member.setUserName(Name);
        System.out.print("핸드폰 번호를 입력하세요: ");
        String Phone = in.nextLine();
        member.setUserPhone(Phone);
        System.out.print("생일을 입력하세요: ");
        String Birth = in.nextLine();
        member.setUserBirth(Birth);
        System.out.print("이메일을 입력하세요: ");
        String Email = in.nextLine();
        member.setUserEmail(Email);
        Mlist.add(member); // 리스트에 회원 정보 저장
        System.out.println("회원가입이 완료되었습니다.");

        // 회원가입 후 다시 로그인
        login();
    }

    // 사용자 메뉴
    private void userMenu() {
        while (true) {
            System.out.println("1. 수강생 정보");
            System.out.println("2. 강의 정보");
            System.out.println("3. 수강신청");
            System.out.println("4. 이전버튼");
            System.out.println("0. 로그아웃");
            System.out.print("원하시는 항목을 선택해주세요: ");
            int selNum = in.nextInt();
            in.nextLine(); 

            switch (selNum) {
                case 1:MemberService();break; // 수강생
                case 2:CourseService();break; // 강의
                case 3:MentService();break; // 수강신청
                case 0: System.out.println("로그아웃 완료");selectUserType();break;
                case 9: System.out.println("이전화면으로 이동");return;
//                default:System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
    private void adminMenu1() {
    	while(true) {
    		System.out.println("1. 수강생 정보");
    		System.out.println("2. 수강 신청 정보");
    		System.out.println("0. 로그아웃");
    		int selNum = in.nextInt();
    		in.nextLine();
    		switch (selNum) {
    		case 1:MemberService(); break;
    		case 2:MentService(); break;
    		case 0: System.out.println("로그아웃 완료"); selectUserType(); break;
    		}
    		
    	}
    }
    private void MemberService() {
        memberService = new MemberService();
        // memberService.menu(); // 실제 구현이 필요
    }

    private void CourseService() {
        courseService = new CourseService();
        // courseService.menu(); // 실제 구현이 필요
    }

    private void MentService() {
        mentService = new MentService();
        // mentService.menu(); // 실제 구현이 필요
    }
}


