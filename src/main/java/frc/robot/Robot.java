// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private Talon l1 = new Talon(0);
  private Talon r1 = new Talon(1);
  private DifferentialDrive dT = new DifferentialDrive(l1,r1);
  private Joystick joystick = new Joystick(0);
  private edu.wpi.first.wpilibj.Timer m_Timer = new edu.wpi.first.wpilibj.Timer();

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    m_Timer.start();
    m_Timer.reset();
  }

  @Override
  public void autonomousPeriodic() {
    if (m_Timer.get() < 3) {
      dT.arcadeDrive(0.5, 0);
    }
    if (m_Timer.get() >= 3 && m_Timer.get() < 5) {
      dT.arcadeDrive(0, 0.5);
    }
    if (m_Timer.get() >= 5 && m_Timer.get() < 7) {
      dT.arcadeDrive(0.5, 0);
    }
    if (m_Timer.get() >= 7) {
      dT.arcadeDrive(0, 0);
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    dT.arcadeDrive(-0.8 * joystick.getRawAxis(0), 0.8 * joystick.getRawAxis(1));
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
