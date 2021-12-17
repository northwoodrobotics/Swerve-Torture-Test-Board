package frc.robot.commands;

//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants.DriveSubsystem;
import frc.robot.subsystems.SingleModule;
import edu.wpi.first.wpilibj2.command.RunCommand;

import edu.wpi.first.wpilibj2.command.WaitCommand;
public class SwerveTorture extends SequentialCommandGroup{

    Timer timer; 
    SingleModule singleModule; 

    public SwerveTorture(){
        new SequentialCommandGroup(
            new SwerveTortureModule(1, 0, 0),
            new WaitCommand(1),
            new SwerveTortureModule(1, .5, 0),
            new WaitCommand(1),
            new SwerveTortureModule(-1, -.5, 1)
        );
        
        
    }



    

    
}
