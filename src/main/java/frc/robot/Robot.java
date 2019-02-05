package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  public DifferentialDrive m_myRobot;
  public SpeedControllerGroup left_side;
  public SpeedControllerGroup right_side;
  public Joystick Xstick;
  public DigitalInput digi;
  public DigitalInput digi2;
  public boolean BValue;
  public WPI_VictorSPX m_1;
  public WPI_VictorSPX m_2;
  public boolean XValue;
  public double speed1;
  public double speed2;
  public double speed3;
  public double speed4;
  public double speed5;
  public double speed6;
  public boolean firstdigi;
  public boolean secondigi;
  public TimeUnit TimeU;
  @Override
  public void robotInit() {

    digi = new DigitalInput(1);
    digi2 = new DigitalInput(2);

    Xstick = new Joystick(0);


    left_side = new SpeedControllerGroup(new WPI_VictorSPX(1), new WPI_VictorSPX(2));
    right_side = new SpeedControllerGroup(new WPI_VictorSPX(3), new WPI_VictorSPX(4));

    m_1 = new WPI_VictorSPX(1);
    m_2 = new WPI_VictorSPX(3);
    m_myRobot = new DifferentialDrive(left_side, right_side);


    speed1 = 0;
    speed2 = -0.45;
    speed3 = 0;
    speed4 = 0.45;
    speed5 = 0.47;
    speed6 = 0.47;


  }

  @Override
  public void teleopPeriodic() {



    firstdigi = digi.get();
    secondigi = digi2.get();



    System.out.println("DIGI" + firstdigi);
 
    BValue = Xstick.getRawButton(3);
    XValue = Xstick.getRawButton(2);

    System.out.println(BValue);
    System.out.println(XValue);
    
    if(Xstick.getY() != 0 || Xstick.getX() != 0){
      m_myRobot.arcadeDrive(Xstick.getY(),Xstick.getX());
    }
      if(BValue == true){
        if(firstdigi == true && secondigi == true){
          System.out.println("FOUND TAPE");
          m_myRobot.tankDrive(speed6, speed5);
        }
        else{
          System.out.println("Robot is moving");
          m_myRobot.arcadeDrive(speed1,speed2); 
        }

        
      }
      else{

      }
      if(XValue == true){
        if(firstdigi == true && secondigi == true){
          System.out.println("FOUND TAPE");
          m_myRobot.tankDrive(speed6, speed5);
        }
        else{
          System.out.println("ROBOT is moving");
          m_myRobot.arcadeDrive(speed3, speed4);
        }

      }
      else{

      }

    }
    }