package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.Map;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.networktables.NetworkTableEntry;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import org.usfirst.frc3707.Creedence.Robot;
import frc.robot.Constants;
import frc.robot.swerve.SwerveDrive;
import frc.robot.swerve.SwerveWheel;

public class SingleModule extends SubsystemBase{
    private CANCoder testModuleCANCoder = new CANCoder(Constants.DriveSubsystem.TestSwerveIDs.testSwerveCanCoder);
    private TalonFX testTalonAzimuth = new TalonFX(Constants.DriveSubsystem.TestSwerveIDs.testSwerveAzimuth);
    private TalonFX testTalonDrive = new TalonFX(Constants.DriveSubsystem.TestSwerveIDs.testSwerveDrive);
    private PIDController testModulePIDCOntroller = new PIDController(Constants.DriveSubsystem.kSwerveTwistPID_P, 0.0, 0.0);
    private SwerveWheel testSwerveWheel = new SwerveWheel(testModulePIDCOntroller,testModuleCANCoder, testTalonAzimuth,testTalonDrive, Constants.DriveSubsystem.testModuleOffset, "TestModule");

    


    public SwerveDrive swerve = new SwerveDrive(testSwerveWheel, null, null, null,null );

    private ShuffleboardTab subsystemShuffleboardTab = Shuffleboard.getTab("Drive Subsystem");
    private NetworkTableEntry sbFowardInput = subsystemShuffleboardTab.add("Forward Input", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();

    private NetworkTableEntry sbSidewaysInput = subsystemShuffleboardTab.add("Sideways Input", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();

    private NetworkTableEntry sbrotation = subsystemShuffleboardTab.add("rotation", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();

    private NetworkTableEntry sFieldRelative = subsystemShuffleboardTab.add("fieldOriented", false)
    .withWidget(BuiltInWidgets.kBooleanBox)
    .getEntry();

    private NetworkTableEntry sbFLEncoderRaw = subsystemShuffleboardTab.add("FLEncoder Raw", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();

    private NetworkTableEntry sbFREncoderRaw = subsystemShuffleboardTab.add("FREncoder Raw", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();

    private NetworkTableEntry sbRLEncoderRaw = subsystemShuffleboardTab.add("RLEncoder Raw", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();

    private NetworkTableEntry sbRREncoderRaw = subsystemShuffleboardTab.add("RREncoder Raw", 0)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", -1, "max", 1))
    .getEntry();


    private void setupEncoders() {
        testModulePIDCOntroller.enableContinuousInput(0.0, 360);

        testModulePIDCOntroller.setTolerance(Constants.DriveSubsystem.kSwerveTwistPIDTolerance);
    }

    public void init() {
        System.out.println("Initializing DriveSubsystem");
        setupEncoders();
    }

    /** 
    * @param directionX Proportional speed at which to move left to right
    * @param directionY Proportional speed at which to move front to back
    * @param rotation   Proportional speed at which to rotate
    * @param useGyro    Boolean for field-oriented driving
    * @param slowSpeed  Boolean for slow mode to make the robot drive slower.
    * @param noPush     Boolean to lock wheels at 45 degree angles, to prevent the
    *                   robot from being pushed in any direction
    */
   public void drive(double directionX, double directionY, double rotation, boolean useGyro, boolean slowSpeed,
           boolean noPush) {
       swerve.drive(directionX * 0.5, directionY * 0.5, rotation * 0.34, false, slowSpeed, noPush);
   }

   //rotates the swerves to a circle and runs the motors at a desired speed
   public void CircleDrive(double speed)
   {
       swerve.CircleRotate(speed);
   }

   public void driveSimple(double speed, double angle)
   {
       swerve.driveSimple(speed, angle);
   }

   public void xMode()
   {
       swerve.XModeActivate();
   }

   /**
    * The function which executes periodically to run the DriveTrain subsystem
    */
   @Override
   public void periodic() {
       publishDataToSmartDashboard();
   }
   private void publishDataToSmartDashboard() {

    // sbFLEncoderRaw.setDouble(m_frontLeft.getRawAngle());
    // sbFREncoderRaw.setDouble(m_frontRight.getRawAngle());
    // sbRLEncoderRaw.setDouble(m_rearLeft.getRawAngle());
    // sbRREncoderRaw.setDouble(m_rearRight.getRawAngle());

      // Publish encoder values to smart dashboard for offset tuning
      SmartDashboard.putNumber("Front Right Encoder", testModuleCANCoder.getAbsolutePosition());
     /*SmartDashboard.putNumber("Front Left Encoder", frontLeftEncoder.getAbsolutePosition());
      SmartDashboard.putNumber("Back Right Encoder", rearRightEncoder.getAbsolutePosition());
      SmartDashboard.putNumber("Back Left Encoder", rearLeftEncoder.getAbsolutePosition());
   */}

}
