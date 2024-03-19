import java.util.Scanner;
public class HW41
{
	public static void main(String[] args) {
	    String temp="";
	    Scanner sc=new Scanner(System.in);
	    System.out.println("這是可以陪你聊天的程式，可以回答妳/你問題!");
	    while(true){
	        System.out.print("你說:");
	        temp=sc.nextLine();
	        temp=temp.replace("?","!");
	        temp=temp.replace("嗎","");
	        temp=temp.replace("會不會","會");
	        temp=temp.replace("能不能","能");
	        temp=temp.replace("你能","我能");
	        temp=temp.replace("你會","我會");
	        System.out.print("我說:");
	        System.out.println(temp);
	    
	        if(temp.equals("0")){
	            System.out.println("離開聊天程序");
	            break;
	        }
	        
	    }
	}
}
