package com.Demo;
//interface for RegularRegister
interface IRegularRegister{

     boolean isRegistered(String userName,String password);
    void registerInto(String userName,String password);
}

//THis class used for handling registration of user.
class RegularRegister implements IRegularRegister{
    public  boolean isRegistered(String userName,String password ){
        return true;
    }
     public void registerInto(String userName,String password){
         System.out.println(userName+" is registered in using normal process");
    }


}

//interface for RegularLogin

interface IRegularLogin{
    void loginInto(String userName,String password);
    void loginProcess(String userName,String password);
}

//This class used for login in normal way
class RegularLogin implements IRegularLogin{
    RegularRegister regularRegister =new RegularRegister();
   public void loginInto(String userName,String password){
        System.out.println(userName+" is logged in using normal process with "+password);
    }
    public void loginProcess(String userName,String password){

        if(!regularRegister.isRegistered(userName,password))
           regularRegister.registerInto(userName,password);

        loginInto(userName, password);

    }
}


///interface class for all social network site login
interface UsingSocialNetworkingSiteLogin{

     void loginInto();

}

//facebook class
class Facebook implements UsingSocialNetworkingSiteLogin{
    public void loginInto(){
        System.out.println("Logged in using Facebook ");    }

}

//twitter class
class Twitter implements UsingSocialNetworkingSiteLogin {
    public void loginInto() {
        System.out.println("Logged in using Twitter ");

    }
}


//Linkedin class
class Linkedin implements UsingSocialNetworkingSiteLogin {
    public void loginInto() {
        System.out.println("Logged in using Linkedin ");

    }
}


/*AdapterForSocialNetworkingSiteLogin class for choicing between different social site to logged in*/

class AdapterForSocialNetworkingSiteLogin{

    UsingSocialNetworkingSiteLogin usingSocialNetworkingSiteLogin;
    public AdapterForSocialNetworkingSiteLogin(UsingSocialNetworkingSiteLogin choiceSelected){

        this.usingSocialNetworkingSiteLogin=choiceSelected;
        }

    void loginUsingSocialNetworkSite(){
        usingSocialNetworkingSiteLogin.loginInto();
    }
}

/* Login class used for login process in main .It has two constructor for normal login and social network login purpose
*  It uses two class regularLogin for login in normal type and AdapterForSocialNetworkingSiteLogin in soical netwoek login.
* */
class Login{
    RegularLogin regularLogin;
    AdapterForSocialNetworkingSiteLogin adapterForSocialNetworkingSiteLogin;

    Login (UsingSocialNetworkingSiteLogin choice){
        adapterForSocialNetworkingSiteLogin =new AdapterForSocialNetworkingSiteLogin(choice);
        adapterForSocialNetworkingSiteLogin.loginUsingSocialNetworkSite();
    }

    Login(String userName,String password){
        regularLogin = new RegularLogin();
        regularLogin.loginProcess(userName,password);

    }


}


//Main class
public class Main {

    public static void main(String[] args) {
	// write your code here
        UsingSocialNetworkingSiteLogin u1=new Facebook();
        UsingSocialNetworkingSiteLogin u2=new Linkedin();
        UsingSocialNetworkingSiteLogin u3=new Twitter();
        Login L1= new Login(u1);//for Facebook login
        Login L2= new Login(u2);//for Linkedin login
        Login L3= new Login(u3);//for Twitter login
        Login L4= new Login("userName","password");//normal login
    }
}
