package LMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class LectureRoom
{
	int RoomNum;		//강의장번호
	boolean state; 		//강의배정여부
	String Subject;		//강의과목

}
public class C01AdminMenu {
	
	//강의실 룸정보 저장(교수메뉴/학생메뉴에도 볼수있도록 static 표시)
	public static ArrayList<LectureRoom> RoomList = new ArrayList();
	//학생정보,교수정보 확인용
	C01StudentMenu S;
	C01TeacherMenu T;
	
	//생성자를 이용해서 Menu에 있는 학생메뉴객체주소와
	//교수메뉴객체주소를 각각 멤버변수에 삽입합니다
	
	Scanner sc = new Scanner(System.in);
	String str;
	void run(C01TeacherMenu t, C01StudentMenu s) {
		this.S=s;
		this.T=t;
		while(true)
		{
		System.out.println("------------ Admin메뉴 -------------");
		System.out.println("1.가입교수 리스트");
		System.out.println("2.가입학생 리스트");
		System.out.println("3.가능강의 리스트");
		System.out.println("4.수강학생 리스트");
		System.out.println("5.강의실 리스트");
		System.out.println("6.강의실 배정");
		System.out.println("7.교수 계정삭제");
		System.out.println("8.학생 계정삭제");
		System.out.println("9.종료");
		System.out.println("------------ Admin메뉴 -------------");
		System.out.print("입력 :");
		str = sc.next();
		switch(str)
		{
		case "1":
			//가입교수 리스트
			//현재 저장된 교수 정보가 출력됩니다
			for(C01Teacher teacher : T.Tchlist) {
				System.out.println(teacher.TID);
			}
			break;
		case "2":
			//가입학생 리스트
			//현재 저장된 학생 정보가 출력됩니다
//			int size = S.Stdlist.size();
//			for(int i=0;i<size;i++) {
//				System.out.println(S.Stdlist.get(i).stdName);
//			}
			//코드간소화
			for(C01Student student : S.Stdlist) {
				System.out.println(student.stdName);
			}
		        
			break;
		case "3":
			//가능강의 리스트
			//현재 가능한 강의정보가 출력됩니다
			for(C01Teacher teacher : T.Tchlist) {
				System.out.println(teacher.Subject);
			}
			break;
		case "4":
			//수강학생 리스트 
			//현재 수강신청한 학생정보가 출력됩니다 
			for(C01Student student : S.Stdlist) {
				if(student.Subject.length>=0) {
					System.out.println(student.stdName+" : "+Arrays.toString(student.Subject));
				}
			}
			break;
		case "5":
			//강의실 리스트
			//전체 강의장 번호와 
			//수업배정반의 강의장과
			//잔여 강의장을 출력합니다
			break;
		case "6":
			//배정받은 강의실 정보 출력 합니다 
			break;
		case "7":
			//교수ID를 입력받아 해당ID를  리스트에서 삭제합니다\
			System.out.print("ID를 입력해주세요 : ");
			String delTID = sc.next();
			for(C01Teacher teacher : T.Tchlist) {
				if(teacher.TID.equals(delTID)) {
					System.out.println("정말로 삭제 하시겠습니까?");
					String confirm = sc.next();
					if(confirm.equals("Y")||confirm.equals("y")
					||confirm.equals("YES")||confirm.equals("yes")||confirm.equals("Yes")
					||confirm.equals("네")||confirm.equals("예")
					||confirm.equals("응")||confirm.equals("그래")||confirm.equals("오냐"))
					{
					T.Tchlist.remove(teacher);
					System.out.println("계정 삭제 완료");
					}
				}else	{
						System.out.println("해당하는 ID가 없습니다. ");
					}
				}
			break;
		case "8":
			//학생ID를 입력받아 해당ID를  리스트에서 삭제합니다
			System.out.print("ID를 입력해주세요 : ");
			String delSID = sc.next();		
			for(C01Student student : S.Stdlist) {
				if(student.stdId.equals(delSID)) {
					System.out.println("정말로 삭제 하시겠습니까?(\"네\"라고 입력)");
					String confirm = sc.next();
					if(confirm.equals("네")) {
						S.Stdlist.remove(student);
						System.out.println("계정 삭제 완료");
					}
				} else {
					System.out.println("해당하는 ID가 없습니다.");
				}
			}
			break;
		case "9":
			//Main 메뉴로 돌아갑니다
			System.out.println("Main 메뉴로 돌아갑니다");
			return ;
		default :
			//잘못입력 다시
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
						
		}
			
		
		}	

	}
}
