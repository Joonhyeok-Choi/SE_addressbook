package messaging_function;

import java.util.Scanner;
import java.util.Map;
import java.util.Hashtable;

public class Info {
	
	public static String name;
	public static Integer phoneNumber;
	public static Map<String, Integer> infoTable = new Hashtable<String, Integer>();
	public static int i=0;
	
	public static Scanner sc2;
	public static Scanner sc;
	public static Scanner sc1;

	public void Create(){
		sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println("전화번호를 입력하세요.");
		phoneNumber = sc.nextInt();
		
		infoTable.put(name, phoneNumber);
		System.out.println("입력이 완료되었습니다.");
	}
	
	public void Delete(){
		sc1 = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력해주세요.\n");
		String target = sc1.nextLine();
		boolean isContains = infoTable.containsKey(target);

		if(isContains){
			infoTable.remove(target);
			System.out.println("삭제가 완료되었습니다.");
		}
		else
			System.out.println("연락처에 없는 이름입니다.");
	}
	
	public void Search(){
		sc2 = new Scanner(System.in);
		System.out.println("검색할 이름을 입력해주세요.\n");
		String target = sc2.nextLine();
		boolean isContains = infoTable.containsKey(target);
		
		if(isContains){
			int num = infoTable.get(target);
			System.out.println("이름 : " + target + "전화번호 : " + num);
		}
		else
			System.out.println("연락처에 없는 이름입니다.");
	}
	
	public void mainMenu(){
		System.out.println("-----------------");
		System.out.println("1. 전화번호부 입력");
		System.out.println("2. 연락처보기(상위 10개)");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		System.out.println("-----------------");

	}
	

	
}

