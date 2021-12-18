package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SingleModule;

public class ManualStressTest extends CommandBase{
    SingleModule singleModule; 


    double xCommand;
    double yCommand;
    double rCommand;
    boolean gyroOff;
    boolean slowModeOff;
    boolean NoPushOff;

    public ManualStressTest(){
        addRequirements(singleModule);
    }


    @Override
    public void initialize(){
        this.gyroOff = false;
        this.slowModeOff = false;
        this.NoPushOff = false;

    }

    @Override 
    public void execute(){
        double xCommand = RobotContainer.testController.leftStick.getY();
        double yCommand = RobotContainer.testController.leftStick.getX();
        double rCommand = RobotContainer.testController.rightStick.getX();

        singleModule.drive(xCommand, yCommand, rCommand, gyroOff, slowModeOff, NoPushOff);
    }

    
}
