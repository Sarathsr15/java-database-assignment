import java.util.ArrayList;
import java.util.Scanner;
// import org.json.simple.parser.JSONParser;
// import org.json.simple.JSONObject;

class Urls {
    Urls(){
        this.Count=0;
 }

    public String Url;
    public String Key;
    public Integer Count;
}

public class urldatabase {

    private static long idCounter = 0;

    public static synchronized String createID() {
        return String.valueOf(idCounter++);
    }

    public static void main(String[] args) {
    
    String command ="";
    System.out.print("Enter Command: ");
    Scanner sc = new Scanner(System.in);
    command = sc.next();
    int flag=0;
    ArrayList<Urls> urls = new ArrayList<Urls>();
    while(!command.equals("exit")){
        if(command.equals("storeurl")){
            System.out.print("Enter URL: ");
            command = sc.next();
            Urls myurl = new Urls();
            myurl.Url=command;
            myurl.Key=createID();
            urls.add(myurl);
        }
        else if(command.equals("get")) {
        System.out.print("Enter URL: ");
        command = sc.next();
        for (Urls i : urls) {
        flag=0;
            if(command.equals(i.Url)){
                i.Count=i.Count+1;
                flag=1;
                System.out.print(i.Key + "\n");
                break;
                }
            }
        if(flag==0){
        System.out.print("URL Not Found\n");
        }
        }
        else if(command.equals("list")){
            String jsonString = "{\n";
            for (Urls i : urls) {
                jsonString = jsonString + "{\nURL :"+ i.Url +",\nCount :"+i.Count+"\n},\n" ;
            }
            jsonString = jsonString + "}\n";
            // JSONParser parser = new JSONParser();
            // JSONObject json = (JSONObject) parser.parse(stringToParse);
            // System.out.print(JSONObject);
            System.out.print(jsonString);
        }
        else if(command.equals("count")){
        System.out.print("Enter URL: ");
        command = sc.next();
        for (Urls i : urls) {
        flag=0;
            if(command.equals(i.Url)){
                flag=1;
                System.out.print(i.Count + "\n");
                break;
                }
            }
        if(flag==0){
        System.out.print("URL Not Found\n");
        }
        }
        else {
            System.out.print("Wrong input\n");
            System.out.print("Enter Command: ");
            command = sc.next();
        }
        System.out.print("Enter Command: ");
        command = sc.next();
    }
 }
}