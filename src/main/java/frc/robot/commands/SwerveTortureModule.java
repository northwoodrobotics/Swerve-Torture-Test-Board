package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.SingleModule;


public class SwerveTortureModule extends CommandBase{

    SingleModule singleModule; 

    public boolean nogyro; 
    public boolean noslow;
    public boolean noPushOff;

    public double xCommand;
    public double yCommand; 
    public double rCommand; 

    public SwerveTortureModule(double xCommand, double yCommand, double rCommand){
        addRequirements(singleModule);


        this.nogyro = false;
        this.noslow = false; 
        this.noPushOff = false;
    }
    
    public void execute (){
        singleModule.drive(xCommand, yCommand, rCommand, nogyro, noslow, noPushOff);

    }
    

    @Override
    public void end(boolean interrupted){
        singleModule.drive(0,0,0,false,false,false);
    }
    @Override
    public boolean isFinished() {
        return true;
    }


    


    
}
