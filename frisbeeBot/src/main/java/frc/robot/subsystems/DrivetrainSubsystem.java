// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */

  //motor declaration
  private TalonSRXController m_frontLeft = new TalonSRXController(new TalonSRX(Constants.MotorConstants.kDriveFrontLeft));
  private TalonSRXController m_frontRight = new TalonSRXController(new TalonSRX(Constants.MotorConstants.kDriveFrontRight));
  private TalonSRXController m_backLeft = new TalonSRXController(new TalonSRX(Constants.MotorConstants.kDriveBackLeft));
  private TalonSRXController m_backRight = new TalonSRXController(new TalonSRX(Constants.MotorConstants.kDriveBackRight));

  //control groups
  private MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_frontLeft, m_backLeft);
  private MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_frontRight, m_backRight);
  // //drive diff
  private DifferentialDrive m_drive = new DifferentialDrive(m_rightDrive, m_leftDrive);

  public DrivetrainSubsystem() {
    m_leftDrive.setInverted(true);
  }

  public void drive(XboxController xboxController) {
    double reducedLeftSpeed = xboxController.getLeftY()/2, reducedRightSpeed = xboxController.getRightY()/2;
    m_drive.tankDrive(reducedLeftSpeed, reducedRightSpeed);
    //m_frontLeft.set(reducedLeftSpeed);
    //m_frontLeft.set(ControlMode.PercentOutput,reducedLeftSpeed);

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
