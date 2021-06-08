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
	
	
	//생성자를 이용해서 메인메뉴에서 만든 학생객체의 주소를 받아
	//S에 저장 
	
	ArrayList<C01Teacher> Tchlist = new ArrayList();
	int CurIdx;	// 현재 로그인한 교수 Idx 저장
	
	Scanner sc = new Scanner(System.in);
	String str;
	void setS(C01StudentMenu S)
	{
		this.S = S;
	}
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
			C01Teacher tch = new C01Teacher();
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
		    String ID = sc.nextLine();
		    boolean flag=false;
			for(int i=0;i<Tchlist.size();i++)
			{
				if(ID.equals(Tchlist.get(i).Name))
				{
					CurIdx=i;
					System.out.println("로그인 성공");
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("로그인 성공");
			}
			else
			{
				System.out.println("로그인 실패");
			}
			break;
		case "3":
			//로그아웃
			//CurIdx 에 9999값 넣음 
			CurIdx = 9999;
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
			if(CurIdx==9999)
			{
				System.out.println("로그인하세요");
			}
			else
			{
				System.out.println("1 교수 ID   : "+Tchlist.get(CurIdx).TID);
				System.out.println("2 교수 이름  : "+Tchlist.get(CurIdx).Name);
				System.out.println("3 교수 과목  : "+Tchlist.get(CurIdx).Subject);
				System.out.println("4 이메일 주소 : "+Tchlist.get(CurIdx).Email);
				System.out.print("수정할 정보 번호 입력 : ");
				str = sc.next();
				sc.nextLine();
				switch(str)
				{
				case "1":
					System.out.print("변경할 ID 입력 : ");
					String tmpID = sc.nextLine();
					Tchlist.get(CurIdx).TID = tmpID;
					break;
				case "2":
					System.out.print("변경할 이름 입력 : ");
					String tmpName = sc.nextLine();
					Tchlist.get(CurIdx).Name = tmpName;
					break;
				case "3":
					System.out.print("변경할 과목 입력 : ");
					String tmpSub = sc.nextLine();
					Tchlist.get(CurIdx).Subject = tmpSub;
					break;
				case "4":
					System.out.print("변경할 이메일 주소 입력 : ");
					String tmpEmail = sc.nextLine();
					Tchlist.get(CurIdx).Email = tmpEmail;
					break;
				default:
					System.out.print("잘못 입력하셨습니다");
				
				}
			}
			break;
		case "6":
			//계정삭제
			//해당 idx에 있는 정보 삭제
			if(CurIdx==9999)
			{
				System.out.println("로그인하세요");
			}
			else
			{
				System.out.println("정말 삭제할 건가요?");
				String tmp=sc.next();
				if(tmp.equals("Y")||tmp.equals("y")
						||tmp.equals("YES")||tmp.equals("yes")||tmp.equals("Yes")
						||tmp.equals("네")||tmp.equals("예")
						||tmp.equals("응")||tmp.equals("그래")||tmp.equals("오냐"))
				{
				Tchlist.remove(CurIdx);
				System.out.println("계정 삭제 성공!");
				}
				else
				{
					System.out.println("계정 삭제 실패");
				}
			}
			break;
		case "7":
			//종료
			System.out.println("Main 메뉴로 돌아갑니다");
			return;
		default :
			//잘못입력 다시
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
		}
		
		}
	}
}
