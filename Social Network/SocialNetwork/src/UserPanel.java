
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;


public class UserPanel {
private static Scanner scanner = new Scanner(System.in);
    
    
    private static ArrayList<User> users = new ArrayList<User>();
    
    
    public static void main(String[]args) {
        
        
        
        users.add(new User("Damla", "user1@hotmail.com","26/05/1996", "İzmir",1));
        users.add(new User("Meltem", "user2@hotmail.com", "05/06/1996", "İzmir",2));
        users.add(new User("user3", "user3@hotmail.com", "24/04/1996", "İzmir",3));
        users.add(new User("user4", "user4@hotmail.com","18/1/1994", "İzmir",4));
        users.add(new User("user5", "user5@hotmail.com", "26/05/1996", "İzmir",5));
        users.add(new User("user6", "user6@hotmail.com", "11/10/1996", "İzmir",6));
        users.add(new User("user7", "user7@hotmail.com","26/05/1994", "İzmir",7));
        users.add(new User("user8", "user8@hotmail.com", "26/05/1996", "İzmir",8));
        users.add(new User("user9", "user9@hotmail.com", "24/04/1996", "İzmir",9));
        users.add(new User("user10", "user10@hotmail.com", "24/04/1996", "İzmir",10));
        
       
        
        
        users.get(1).follow(users.get(0));
     
        run(users.get(0));
        run(users.get(1));
       
    }
       
    
    public static void run(User user) {
        Administrator username = new Administrator();
        String birth_date = username.birtDay();
        
        if(user.getBirth().equals(birth_date)){
            
            user.notAdd();
            
        }
        
       
        System.out.println("Welcome "+ user.getName()+ ",choose a operation: ");
        System.out.println("1. Show Inbox\n"
                + "2. Show Outbox\n"
                + "3. Send Message\n"
                + "4. Share Post\n"
                + "5. Show Timeline\n"
                + "6. Show Contact list\n"
                + "7. Show Notifications\n"
                + "8. Follow People\n"
                + "9. Exit");
        
     
        
        
        boolean loop = false;
        
        while (!loop) {
            
        
        System.out.print(" Your Choise: ");
        int choise = scanner.nextInt();
        
        scanner.nextLine();
       
            switch (choise) {
                case 1:
                    
                  user.showInbox();
                    
                    break;
                    
                case 2:
                  
                  user.showOutbox();
                  
                    break;
                        
                case 3:
                    
                    System.out.println("Friends list..");
                    user.followshow();
                    System.out.println("Choose the person you want to send the message to:");
                    
                    int a =scanner.nextInt();
                    
                    for(int b=0;b<users.size();b++){
                        if(a==users.get(b).getId()){
                        user.sendMessage(user, users.get(b+1));
                    }
                    
                    }                    
                   
                    break;
                    
                 case 4:
                    
                    user.sendPost();
                    
                    break;
                    
                case 5:
                    
                   user.showTimeline();
                   
                    break;
                        
                case 6:
                    
                  user.followshow();
                    break;
                    
                case 7:
                    
                   user.notBox();
                    break;
                        
                
                
                case 8:
                    
                   System.out.println("Choose what you want to follow.");
                   
                   for(int k=0;k<users.size();k++){
                       
                       
                       System.out.println(users.get(k).getId()+"."+users.get(k).getName());
                   }
                   
                       int user_id = scanner.nextInt();
                       for(int k=0;k<users.size();k++){
                           
                           if(user_id==users.get(k).getId()){
                               
                               user.follow(users.get(k));
                               break;
                           }
                           
                       }                       
                   
                   break;
                    
                
                
                case 9:
                    
                    System.out.println("Exiting the program...");
                    loop = true;
                    break;
                
            }
                
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
 
    
  

    
    
    
    
    
    
    
    
    
}
