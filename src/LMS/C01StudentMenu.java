package LMS;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.Subject;

class C01Student
{
	String stdId;
	String stdName;
	String stdAddr;
	String stdPhone;
	String Subject[];	//수강신청과목 저장 
}
public class C01StudentMenu {
	
	ArrayList<C01Student> Stdlist = new ArrayList();
	C01Student CurIdx;	// 현재 로그인한 학생 객체 저장  
	C01TeacherMenu T;
	Scanner sc = new Scanner(System.in);
	String str;
	void run(C01TeacherMenu t) {
		this.T=t;
		while(true)
		{
		System.out.println("------------ 학생메뉴 -------------");
		System.out.println("1.계정 등록");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.내 강의실");
		System.out.println("5.수강 신청");
		System.out.println("6.신청 취소");
		System.out.println("7.정보 수정");
		System.out.println("8.계정 삭제");
		System.out.println("9.종료");
		System.out.println("------------ 학생메뉴 -------------");
		System.out.print("입력 : ");
		str = sc.next();
		switch(str)
		{
		case "1":
			//C01StudentMenu객체를 만들고
			C01Student stu = new C01Student();
			//각정보 입력한 후
			System.out.print("ID : ");
			stu.stdId = sc.next();
			System.out.print("이름 : ");
			stu.stdName = sc.next();
			System.out.print("주소 : ");
			stu.stdAddr = sc.next();
			System.out.print("전화번호 : ");
			stu.stdPhone = sc.next();
			//ArrayList에 추가합니다
			Stdlist.add(stu);
			System.out.println("계정 등록 완료!");
			break;
		case "2":
			//로그인
			sc.nextLine();
			System.out.print("ID : ");
		    String id = sc.nextLine();
		    
		    for(C01Student student : Stdlist) {
		        if(student.stdId.equals(id)) {
			        System.out.println("[" + student.stdId + "]님께서 로그인 하셨습니다.");
			        CurIdx = student;
		        } else {
			        System.out.println("등록되지 않은 ID입니다.");
		        } 
		    }
			break;
		case "3":
			//로그아웃
			CurIdx = null;
			break;
		case "4":
			//내가 신청한 과목 정보 출력(여러 과목일수 있음)
			try {
				System.out.print("신청한 과목 : ");
				for(int i=0;i<CurIdx.Subject.length;i++) {
					if(CurIdx.Subject[i]!=null) {
						System.out.print(CurIdx.Subject[i]+" ");
					}
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("신청한 과목이 없습니다.");
			}
			break;
		case "5":
			//CurIdx에 있는 학생 정보객체에 과목을 입력받아 저장
			System.out.print("신청 가능한 과목 : ");
			for(C01Teacher teacher : T.Tchlist) {
				System.out.print(teacher.Subject);
			}
			System.out.print("신청할 과목 수 : ");
			int count = sc.nextInt();
			CurIdx.Subject = new String[count];
			System.out.print("신청할 과목 : ");
			for(int i=0;i<count;i++) {
				CurIdx.Subject[i] = sc.next();
			}
			System.out.println("수강 신청 완료!");
			break;
		case "6":
			//신청 취소할 과목을 입력받아
			//동일한 과목이 있다면 삭제(NULL값 입력)
			System.out.print("신청 취소할 과목 : ");
			String tmp = sc.next();
			for(int i=0;i<CurIdx.Subject.length;i++) {
				if(CurIdx.Subject[i].equals(tmp)) {
					CurIdx.Subject[i]=null;
					System.out.println("신청 취소 완료!");	
				}      
			}
	        break;
		case "7":
			//학생정보를 수정
			System.out.println("학생 정보를 수정합니다.");
			System.out.print("ID를 입력해주세요 : ");
			String editID = sc.next();
			try {
				if(CurIdx.stdId.equals(editID)) {
					System.out.println("현재 이름 : "+CurIdx.stdName);
					System.out.print("바꿀 이름 : ");
					CurIdx.stdName = sc.next();
					System.out.println("현재 주소 : "+CurIdx.stdAddr);
					System.out.print("바꿀 주소 : ");
					CurIdx.stdAddr = sc.next();
					System.out.println("현재 전화번호 : "+CurIdx.stdPhone);
					System.out.print("바꿀 전화번호 : ");
					CurIdx.stdPhone = sc.next();
					System.out.println("수정 완료!");
		        } else {
			        System.out.println("ID가 틀립니다.");
		        }
			} catch (Exception e) {
		        System.out.println("ID가 틀립니다.");
			}
			break;
		case "8":
			//계정삭제
			//현재 CurIdx 를 리스트에서 제거 
			System.out.print("ID를 입력해주세요 : ");
			String delID = sc.next();
			try {
				if(CurIdx.stdId.equals(delID)) {
					System.out.println("정말로 삭제 하시겠습니까?(\"네\"라고 입력)");
					String confirm = sc.next();
					if(confirm.equals("네")) {
						Stdlist.remove(CurIdx);
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
		case "9":
			//종료
			System.out.println("Main 메뉴로 돌아갑니다");
			return;
		default:
			//잘못입력 다시
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
		}
		}	
	}
}
