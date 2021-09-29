import java.util.ArrayList;
import java.util.Scanner;

class Urls{

    Urls(){
        this.Count=0;
    }
        public String Url;
        public Integer Count;
    }


public class urldatabase {
    public static void main(String[] args) {
     String command ="";
     System.out.print("Enter Command: ");
     Scanner sc = new Scanner(System.in);
     int flag=0;
     ArrayList<Urls> urls = new ArrayList<Urls>();
     while(!command.equals("exit")){
         command = sc.next();
         if(command.equals("storeurl")){
             System.out.print("Enter URL: ");
             command = sc.next();
             Urls myurl = new Urls();
             myurl.Url=command;
             urls.add(myurl);
         }
         else if(command.equals("geturl")) {
             System.out.print("Enter URL: ");
             command = sc.next();
             for (Urls i : urls) {
                 flag=0;
                 if(command.equals(i.Url)){
                     i.Count=i.Count+1;
                     flag=1;
                     break;
                 }
                }
             if(flag==0){
                 System.out.print("URL Not Found");
             }
         }
         else if(command.equals("list")){
              for (Urls i : urls) {
                  System.out.println("URL :"+ i.Url +"\tCount :"+i.Count);
              }
         }
         else {
             System.out.print("Wrong input ");
             System.out.print("Enter Command: ");
             command = sc.next();
         }
         System.out.print("Enter Command: ");
         command = sc.next();
         
     }
     
     
 }
}