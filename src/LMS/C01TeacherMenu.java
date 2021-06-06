package LMS;

import java.util.ArrayList;
import java.util.Scanner;

class C01Teacher
{
	String TID;
	String Name;
	String Subject;
	String Email;
}

public class C01TeacherMenu {
	
	//출석부용
	C01StudentMenu S;
	C01Teacher tch = new C01Teacher();
	
	//생성자를 이용해서 메인메뉴에서 만든 학생객체의 주소를 받아
	//S에 저장 
	
	ArrayList<C01Teacher> Tchlist = new ArrayList();
	C01Teacher CurIdx;	// 현재 로그인한 교수 Idx 저장
	
	Scanner sc = new Scanner(System.in);
	String str;
	void run() {
		while(true)
		{
		System.out.println("------------ 교수메뉴 -------------");
		System.out.println("1.교수 가입");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.출 석 부 ");
		System.out.println("5.정보 변경");
		System.out.println("6.계정 삭제");
		System.out.println("7.종료");
		System.out.println("------------ 교수메뉴 -------------");
		System.out.print("입력 :");
		str = sc.next();
		switch(str)
		{
		case "1":
			//계정 가입
			//C01Teacher객체 만들고 각멤버에 값 넣어서 
			//(교수ID , 교수이름 , 교수과목, 이메일주소)
			//ArrayList에 저장
			System.out.print("교수 ID : ");
			tch.TID = sc.next();
			System.out.print("교수 이름 : ");
			tch.Name = sc.next();
			System.out.print("교수 과목 : ");
			tch.Subject = sc.next();
			System.out.print("이메일 주소 : ");
			tch.Email = sc.next();
			Tchlist.add(tch);
			System.out.println("계정 등록 완료!");
			break;
		case "2":
			//로그인
			//ArrayList에 해당 TId가 있는 idx를 CurIdx에 저장
			sc.nextLine();
			System.out.print("교수 ID : ");
		    String id = sc.nextLine();
		    
		    for(C01Teacher teacher : Tchlist) {
		        if(teacher.TID.equals(id)) {
			        System.out.println("[" + teacher.TID + "]님께서 로그인 하셨습니다.");
			        CurIdx = teacher;
		        } else {
			        System.out.println("등록되지 않은 ID입니다.");
		        } 
		    }
			break;
		case "3":
			//로그아웃
			//CurIdx 에 9999값 넣음 
			CurIdx = null;
			System.out.println("로그아웃합니다");
			return;
		case "4":
			//출석부
			//S안에 있는 내용 참고해서 idx에 있는 교수과목과 동일한
			//과목을 듣는 학생리스트를 출력 
			break;
		case "5":
			//정보변경
			//해당 idx에 있는 정보 변경 
			System.out.println("교수 정보를 수정합니다.(ID제외)");
			System.out.print("교수 이름 : ");
			CurIdx.Name = sc.next();
			System.out.print("교수 과목 : ");
			CurIdx.Subject = sc.next();
			System.out.print("이메일 주소 : ");
			CurIdx.Email = sc.next();
			System.out.println("수정 완료!");
			break;
		case "6":
			//계정삭제
			//해당 idx에 있는 정보 삭제
			System.out.print("ID를 입력해주세요 : ");
			String delID = sc.next();
			try {
				if(CurIdx.TID.equals(delID)) {
					System.out.println("정말로 삭제 하시겠습니까?(\"네\"라고 입력)");
					String confirm = sc.next();
					if(confirm.equals("네")) {
						Tchlist.remove(CurIdx);
						System.out.println("계정 삭제 완료");
						CurIdx = null;
					}
		        } else {
			        System.out.println("ID가 틀립니다.");
		        }
			} catch (Exception e) {
		        System.out.println("ID가 틀립니다.");
			}
			break;
		case "7":
			//종료
			System.out.println("종료합니다");
			return;
		default :
			//잘못입력 다시
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
		}
		
		}
	}
}
