import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



 
public class User {
    private static  Scanner scanner= new Scanner(System.in);
    
    private  String name;
    private  String email;
    private  String birth;
    private  String place;
    private int userid;

   
   
    private ArrayList<String> outbox = new ArrayList<String>();
    private ArrayList<String> inbox = new ArrayList<String>();
    private ArrayList<String> note = new ArrayList<String>();
    private ArrayList<String> postList = new ArrayList<String>();
    private static ArrayList<String> timeLine = new ArrayList<String>();
    private ArrayList<String> favPost = new ArrayList<String>();
    private ArrayList<User> followuser = new ArrayList<User>();
    
    


    
     public User(String name, String email, String birth, String place, int userid) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.place = place;
        this.userid = userid;
    }
    
    
            
    public void showInbox(){
        Message inboxmessage = new Message();
        inboxmessage.showInbox();
        
    }
    
    public void showOutbox(){
        
        Message outmessage = new Message();
        outmessage.showOutbox();
        
    }
    
    public void sendPost(){
        Post post_send = new Post(name);
        post_send.sendPost();
     
}
    
    public void showTimeline(){
        Post show_post = new Post(name);
        show_post.showTime();
        
    }
    
    public void sendMessage(User user1, User user2){
        
        Message send_message = new Message();
        send_message.messageSend(user1,user2);
    }
    
    public void notAdd(){
            note.add("Happy Birthday...");
        
    }
    
    public void notBox(){
        
        System.out.println("Welcome to NoticeBox");
         if(note.size()==0){
            
            System.out.println("Your NotBox is empty...");
            
        }
        
        for(String s: note){
            
            System.out.println(s);
            
        }
        
        
    }
    
    
    public void followshow(){
        
        System.out.println("Number of friends: "+ followuser.size());
        System.out.println("**These users**");
            for(int i=0;i<followuser.size();i++){
                
                
                System.out.println(followuser.get(i).userid+ "."+ followuser.get(i).name);
                                
            }
                
    }    
    
    
    public void follow(User user){
        
       
        
        followuser.add(user);
        System.out.println(user.name+ " followed");
           
    }     
           
   
    public class Message {
      
     Administrator name = new Administrator();
    public  void messageSend (User user1, User user2){
       
        String date = name.date();
        System.out.println("Enter your message: ");
        
        if((user1.followuser.contains(user2))&& (user2.followuser.contains(user1))){
            
            String newmessage= scanner.nextLine();
            
            user1.outbox.add(newmessage+ "\tSent by: "+ user2.getName() + "\t"+ date);
            
            user2.inbox.add(newmessage+"\tSender by: "+ user1.getName()+"\t"+ date);
            
            user2.note.add("You have 1 message");
            
            System.out.println("Your message was successfully sent.");
            
        }
        else 
            System.out.println("You not following this person .");
        
        
        
    }
    
    public void showInbox(){
        
        System.out.println("Welcome to İnbox");
        if(inbox.size()==0){
            
            System.out.println("Your inbox is empty...");
            
        }
        
        for(String s: inbox){
            
            System.out.println(s+"\n");
          
        }
        
        
    }
    
    public void showOutbox(){
        
        System.out.println("Welcome to Outbox");
        
         if(outbox.size()==0){
            
            System.out.println("Your outbox is empty");
            
        }
        
        for(String a: outbox){
            
            System.out.println(a+"\n");
        
    }
    
}    
        
}
    
    
    
    
    public  class Post {
        
    private String sentpost;
    private String post;
    private ArrayList<String> likes = new ArrayList<String>();
    Administrator name = new Administrator();

        public Post(String postSahibi) {
            this.sentpost = postSahibi;
        }
    
    
        
    public void sendPost(){
        
        String date = name.date();
        System.out.println("Your post: ");
        post = scanner.nextLine();
        timeLine.add(sentpost+": "+ post+"\t"+"\t Date: "+date);
        postList.add(post+"\t Date: "+ date);
        System.out.println(sentpost+": "+ post+"\t"+"\t Date: "+date);
        
        
    }
    
   
    public void like(String like){
                     
    }
    
    
   public void showTime(){
       
       for(String s: timeLine){
           
           System.out.println(s+"\n");
       }
       
   }    
    
        
    }           
   
  //Get/Set Methods
    
    
     public int getId() {
        return userid;
    }

    public void setId(int userid) {
        this.userid = userid;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }    
    
    
}
