// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;
import frc.robot.extensions.Talon;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  static WPI_TalonSRX shooterAim;
  DoubleSolenoid shooterSolenoid;
  DoubleSolenoid shooterMag;
  Double m_MaxSpeed = Constants.maxspeed;
   
  public Shooter() {
    shooterAim = Talon.createDefaultTalon(Constants.shooterMotor);
    shooterAim.setInverted(true);

    shooterSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    shooterMag = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);


  }


  public void ShooterMag_Toggle(){
    shooterMag.toggle();
  }
  
  public void ShooterSolenoid_Toggle() {
    shooterSolenoid.toggle();
  }

  public static void ShooterAim_Up() {
    shooterAim.set(Constants.maxspeed);
  }

  public static void shooterAim_Down() {
    shooterAim.set(-Constants.maxspeed);
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
        });
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
