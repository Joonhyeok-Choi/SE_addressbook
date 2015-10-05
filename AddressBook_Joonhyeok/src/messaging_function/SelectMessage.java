package messaging_function;
import java.util.*;
import java.io.*;
public class SelectMessage {
	//파일을 읽어와서 ArrayList에 메시지 한줄씩 저장 
	public List<String> selectOne() throws IOException{
		List<String> messages = new ArrayList<String>(20);
		File file = new File("/Users/Joonhyeok/Desktop/message.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);//한줄씩 읽기위해서 사용 
		
		String cbuf = null;
		while((cbuf = br.readLine())!= null){//readLine으로 한줄씩 cbuf에 대입 
			messages.add(cbuf);//cbuf를 messages라는 ArrayList에 저장 
		}
		fr.close();
		return messages;
	}
	//selectOne에서 만든 ArrayList를 매개변수로 받아서 이름과 날짜만 출력 
	public void printList(List<String> messages){
		for(int i=0;i<4;i++){
			String message = messages.get(i);//순서대로 읽어온다.
			String[] info = message.split(" ");//앞의 이름과 날짜를 가져오기 위해 공백으로 분리.
			System.out.println(i+1+". "+info[0]+" "+info[1]);//이름과 날짜를 출력.
		}
	}
	//ArrayList와 출력하고자하는 메시지의 index를 매개변수로 받아서 메시지를 포함한 정보 출력.
	public void printMessage(List<String> messages, int index){
		System.out.println(messages.get(index-1));
	}
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int index=1;
		SelectMessage test = new SelectMessage();
		Info test2 = new Info();
		test2.Create();
		test2.Search();
		test2.Delete();
		List<String> list1 = test.selectOne();
		test.printList(list1);
		while(true){
			System.out.println("출력할 문자메시지의 번호를 선택하세요.(나가려면 0) : ");
			index = scan.nextInt();
			if(index==0)
				break;
			else
				test.printMessage(list1, index);
		}
	}
}
