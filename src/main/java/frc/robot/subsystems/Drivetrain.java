// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.DifferentialDriveWithJoysticks;

public class Drivetrain extends SubsystemBase {
  
  public WPI_TalonSRX leftMain;
  public WPI_TalonSRX leftFollower;
  public WPI_TalonSRX rightMain;
  public WPI_TalonSRX rightFollower;

  public DifferentialDrive drive;

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {

    leftMain = new WPI_TalonSRX(RobotMap.LEFT_MAIN);
    leftFollower = new WPI_TalonSRX(RobotMap.LEFT_FOLLOWER);
    rightMain = new WPI_TalonSRX(RobotMap.RIGHT_MAIN);
    rightFollower = new WPI_TalonSRX(RobotMap.RIGHT_FOLLOWER);

    leftMain.setInverted(false);
    leftFollower.setInverted(false);
    rightMain.setInverted(false);
    rightFollower.setInverted(false);

    drive = new DifferentialDrive(leftMain, rightMain);
  }

  /**
   * Stops robot 
   */
  public void stop() {
    drive.arcadeDrive(0, 0);
  }

  /**
   * Drives the robot using arcade drive controls. 
   * 
   * @param fwd the commanded forwawrd movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) { 
    drive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    setDefaultCommand(new DifferentialDriveWithJoysticks());
    // This method will be called once per scheduler run during simulation
  }
}
