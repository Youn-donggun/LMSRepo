package LMS;

import java.util.Scanner;

public class C01Menu {

	public static void main(String[] args) {
		C01TeacherMenu T = new C01TeacherMenu();
		C01StudentMenu S = new C01StudentMenu();
		C01AdminMenu A = new C01AdminMenu();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String str;
		while(true)
		{
		System.out.println("------------ L  M  S -------------");
		System.out.println("1.교수 메뉴");
		System.out.println("2.학생 메뉴");
		System.out.println("3.관리자 메뉴");
		System.out.println("4.종료");
		System.out.println("------------ L  M  S -------------");
		System.out.print("입력 :");
		str = sc.next();
		switch (str)
		{
			case "1":	
				T.run();			
				break;
			case "2":
				S.run(T);
				break;
			case "3":			
				A.run(T,S);
				break;
			case "4":
				System.out.println("종료 합니다");
				flag = true;
				break ;
			default:
				System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
		}	
		if(flag==true)
			break;
		
		}
		
		 
	}

}
