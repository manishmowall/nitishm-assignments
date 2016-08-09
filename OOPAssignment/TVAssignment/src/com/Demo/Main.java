package com.Demo;

//interface VolumeChange class
interface IIncrement{
    void increaseBy1();
}
//concrete class of Increment Volume
class Increment implements IIncrement{
     public void increaseBy1(){
        System.out.println("Increment volume ");
    }
}

//interface for Decrement volume
interface IDecrement{
    void decreaseBy1();
}

//concrete class of Decrement volume
class Decrement implements IDecrement{
    public void decreaseBy1(){
        System.out.println("Decrement volume ");
    }

}

//interface of mute volume
interface IMute{
    void muteFunction();

}

//concrete class of mute volume
class Mute implements IMute{

    public void muteFunction(){
        System.out.println("Mute Volume");
    }
}



//Interface for both on and off button class
interface OnAndOffInterface{
    void functionToPerform();

}

//this class implements onAndOffInterface and make TV on.
class OnButton implements  OnAndOffInterface{
    public void functionToPerform(){
        System.out.println("TV ON ");
    }

}

//this class implements onAndOffInterface and make TV off.
class OffButton implements  OnAndOffInterface{
    public void functionToPerform(){
        System.out.println("TV OFF ");
    }

}


//this is interface for all button (PowerButton and MenuButton) class .
interface IButton{
    void eventOnClickingButton();

}


//this class implements Ibutton and checks button is on or off and depending on that call OnButton class's function or OffButton class's function
class PowerButton implements IButton{

    OnButton onButton = new OnButton();
    OffButton offButton = new OffButton();
    private boolean isONButton(){
        return false;
    }
    public void eventOnClickingButton(){
        if(isONButton()){
          offButton.functionToPerform();
        }
        else{
            onButton.functionToPerform();
        }
    }

}

//this class also implements Ibutton and show menu for other feature.
class MenuButton implements IButton{

    public void eventOnClickingButton(){
        System.out.println("Show Menu");
    }
}

//interface for changing channel
interface IChannelChangeEvent{
    void eventOnClick ();
}


//this class implements IchannelChangeEvent and move channel upward.
class ChannelChangeUpward implements  IChannelChangeEvent{
    public void eventOnClick(){
        System.out.println("Moving Channel Up");
    }
}


//this class implements IchannelChangeEvent and move channel upward.
class ChannelChangeDownward implements IChannelChangeEvent{

    public void eventOnClick(){
        System.out.println("Moving Channel Down");
    }
}


//inteface of TV class
interface ITV{
    void incrementVolume();
    void decrementVolume();
    void muteVolume();
    void onClickingPowerButton();
    void onClickMenuButton();
    void changingChannelUp();
    void changingChannelDown();
}


//this is TV class which implements ITV interface and contain all features of TV to be used by User.
class TV implements ITV{
    private Increment increment=new Increment();
    private Decrement decrement= new Decrement();
    private Mute mute = new Mute();
    private PowerButton powerButton =new PowerButton();
    private MenuButton menuButton = new MenuButton();
    private ChannelChangeUpward channelChangeUpward = new ChannelChangeUpward();
    private ChannelChangeDownward channelChangeDownward = new ChannelChangeDownward();
    public void incrementVolume(){
        increment.increaseBy1();
    }

    public void decrementVolume(){
        decrement.decreaseBy1();
    }

    public void muteVolume(){
        mute.muteFunction();
    }

    public void onClickingPowerButton(){
        powerButton.eventOnClickingButton();
    }
    public void onClickMenuButton(){
        menuButton.eventOnClickingButton();
    }

    public void changingChannelUp(){
       channelChangeUpward.eventOnClick();
    }
    public void changingChannelDown(){
        channelChangeDownward.eventOnClick();
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        TV t1 = new TV();
        t1.incrementVolume();
        t1.decrementVolume();
        t1.muteVolume();
        t1.onClickingPowerButton();
        t1.onClickMenuButton();
        t1.changingChannelUp();
        t1.changingChannelDown();

    }
}
