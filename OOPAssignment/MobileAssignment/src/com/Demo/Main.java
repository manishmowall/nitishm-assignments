package com.Demo;

import javax.swing.*;


//interface for Login class
interface ILogin{
    void LoginProcess();
}

//login class used by onMobile class
class Login implements ILogin{

    public void LoginProcess(){
        System.out.println("Login in Mobile");
    }
}

//OnAndOffInterface for on and off camera, bluetoothand Mobile Switch on/off
interface OnAndOffInterface{
    void functionToPerform();

}


//this class implements onAndOffInterface and make Mobile on.
class OnMobile extends Login implements  OnAndOffInterface {

    public void functionToPerform(){
        LoginProcess();
        System.out.println("Mobile ON ");
    }

}

//this class implements onAndOffInterface and make Mobile off.
class OffMobile implements  OnAndOffInterface{
    public void functionToPerform(){
        System.out.println("Mobile OFF ");
    }

}


//this is interface for MobileSwitchOnAndOffProcesss .
interface IMobileSwitchOnAndOffProcesss{
    void eventOnClicking();

}


//this class implements IMobileSwitchOnAndOffProcesss and checks switch is on or off and depending on that call OnMobile class's function or OffMoblie class's function
class MobileSwitchButton implements IMobileSwitchOnAndOffProcesss{

    OnMobile onMobile = new OnMobile();
    OffMobile offMobile= new OffMobile();
    private boolean isONMobile(){
        return false;
    }
    public void eventOnClicking(){
        if(isONMobile()){
            offMobile.functionToPerform();
        }
        else{
            onMobile.functionToPerform();
        }
    }

}


//interface for call
interface ICall{

    void call();
}

//interface for DialAndThenCall
interface IDialAndThenCall {

    String dialPhoneNo();
}

// this class implementing both IDialAndThenCall and ICall  to perform dailing and Call resp.
class DialAndThenCall implements IDialAndThenCall,ICall{

    public String dialPhoneNo(){
        return "7385014713";
    }
    public void call(){
        String phoneNo=dialPhoneNo();
        System.out.println("call is made for "+phoneNo+" using Dial");
    }
}

//interface for Contact class
interface IContact{
    String searchContact();

}
// this class implementing both Icontact and ICall  to perform search in contact and Call resp.
class Contact implements IContact, ICall{

    public String searchContact(){

        return "90145296977";
    }

    @Override
    public void call(){
        String phoneNo = searchContact();
        System.out.println("call is made "+phoneNo+" using searching Contact");

    }
}

//this class is implementing OnAndOffInterface interface for camera on

class CameraOn implements OnAndOffInterface{

    public void functionToPerform(){
        System.out.println("Camera is On");

    }
}

//this class is implementing OnAndOffInterface interface for Camera off
class CameraOff implements OnAndOffInterface{
    public void functionToPerform(){
        System.out.println("Camera is Off");

    }
}

//interface for CameraFunction class
interface ICameraFunction{

    void onClickEvent();
}

////this class is implementing ICameraFunction and performing Camera
class CameraFunction implements ICameraFunction{

    public void onClickEvent(){
        System.out.println("Performing Camera function");
    }
}


//this class is implementing OnAndOffInterface interface for bluetooth on
class BluetoothOn implements OnAndOffInterface{

    public void functionToPerform(){
        System.out.println("Bluetooth is On");

    }
}

//this class is implementing OnAndOffInterface interface for bluetooth off
class BluetoothOff implements OnAndOffInterface{
    public void functionToPerform(){
        System.out.println("Bluetooth is Off");

    }
}

//interface for BluetoothFunction class
interface IBluetoothFunction{

    void onClickEvent();
}


//this class is implementing IBluetoothFunction interface and performing BLuetooth function.
class BluetoothFunction implements IBluetoothFunction{

    public void onClickEvent(){
        System.out.println("Performing Bluetooth function");
    }
}


//interface for Mobile class
interface IMobile{
    void setMobileSwitchButton();
    void setCameraOnOrOff(OnAndOffInterface onAndOffInterface);
    void useCameraFunction();
    void setBluetoothOnorOff(OnAndOffInterface onAndOffInterface);
    void setBluetoothFunction();
}

//This class implements IMobile and contain feature of Mobile.
class Mobile implements IMobile{

    private MobileSwitchButton mobileSwitchButton = new MobileSwitchButton();
    private CameraFunction cameraFunction = new CameraFunction();
    private BluetoothFunction bluetoothFunction = new BluetoothFunction();
    public void setMobileSwitchButton(){
        mobileSwitchButton.eventOnClicking();
    }
    public void callToPhoneNo(ICall iCall){
        iCall.call();
    }
    public void setBluetoothOnorOff(OnAndOffInterface onAndOffInterface){
        onAndOffInterface.functionToPerform();
    }
    public void setBluetoothFunction(){
        bluetoothFunction.onClickEvent();
    }
    public void setCameraOnOrOff(OnAndOffInterface onAndOffInterface){
        onAndOffInterface.functionToPerform();
    }
    public void useCameraFunction(){
        cameraFunction.onClickEvent();
    }
}

//In Main Mobile class object is created and used.
public class Main {

    public static void main(String[] args) {
	// write your code here
        Mobile mobile = new Mobile();
        mobile.setMobileSwitchButton();
        mobile.callToPhoneNo(new Contact());
        mobile.callToPhoneNo(new DialAndThenCall());
        mobile.setCameraOnOrOff(new CameraOn());
        mobile.useCameraFunction();
        mobile.setCameraOnOrOff(new CameraOff());
        mobile.setCameraOnOrOff(new BluetoothOn());
        mobile.setBluetoothFunction();
        mobile.setCameraOnOrOff(new BluetoothOff());

    }
}
