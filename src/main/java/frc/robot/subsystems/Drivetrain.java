// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.extensions.Talon;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  WPI_TalonSRX leftMotorOne;
  WPI_TalonSRX leftMotorTwo;
  WPI_TalonSRX leftMotorThree;
  WPI_TalonSRX leftMotorFour;
  WPI_TalonSRX rightMotorOne;
  WPI_TalonSRX rightMotorTwo;
  WPI_TalonSRX rightMotorThree;
  WPI_TalonSRX rightMotorFour;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  public DifferentialDrive diffDrive;

  Double m_MaxSpeed = Constants.maxspeed;
  public Object differentialDrive;


  public Drivetrain() {
    leftMotorOne = Talon.createDefaultTalon(Constants.leftMotorOneID);
    leftMotorTwo = Talon.createDefaultTalon(Constants.leftMotorTwoID);
    leftMotorThree = Talon.createDefaultTalon(Constants.leftMotorThreeID);
    leftMotorFour = Talon.createDefaultTalon(Constants.leftMotorFourID);
    rightMotorOne = Talon.createDefaultTalon(Constants.rightMotorOneID);
    rightMotorTwo = Talon.createDefaultTalon(Constants.rightMotorTwoID);
    rightMotorThree = Talon.createDefaultTalon(Constants.rightMotorThreeID);
    rightMotorFour = Talon.createDefaultTalon(Constants.rightMotorFourID);

    leftMotors = new MotorControllerGroup(leftMotorOne, leftMotorTwo, leftMotorThree, leftMotorFour);
    rightMotors = new MotorControllerGroup(rightMotorOne, rightMotorTwo, rightMotorThree, rightMotorFour);
    rightMotors.setInverted(true);

    diffDrive = new DifferentialDrive(leftMotors, rightMotors);
    
  }

  public void stopMotors(){
    leftMotors.stopMotor();
    rightMotors.stopMotor();
  }

  public void motorBackward(){
    diffDrive.tankDrive(-0.5, -0.5);
  }

  public void motorForward(){
    diffDrive.tankDrive(0.5, 0.5);
  }

  public void rotateLeft(){
    leftMotors.set(0.5);
    rightMotors.set(-0.5);
  }

  public void rotateRight(){
    leftMotors.set(-0.5);
    rightMotors.set(0.5);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          System.out.println("example method called");
        });
  }

  public CommandBase moveMotorsForward(){
    return runEnd(
        () -> motorForward(), 
        () -> stopMotors() 
        );
  }

  public CommandBase moveMotorsBackward(){
    return runEnd(
        () -> motorBackward(), 
        () -> stopMotors() 
        );
  }

  public CommandBase rotateMotorsRight(){
    return runEnd(
        () -> rotateRight(), 
        () -> stopMotors() 
        );
  }

  public CommandBase rotateMotorsLeft(){
    return runEnd(
        () -> rotateLeft(), 
        () -> stopMotors() 
        );
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}
