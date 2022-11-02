// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.SwerveDriveSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final SwerveDriveSubsystem swerveSubsystem = new SwerveDriveSubsystem();

  private final XboxController m_pad = new XboxController(OIConstants.kDriverControllerPort);

  public RobotContainer() {
    swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(
      swerveSubsystem,
      () -> -m_pad.getLeftY(),
      () -> m_pad.getLeftX(),
      () -> m_pad.getRightX(),
      () -> true));

      configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(m_pad, 7).whenPressed(() -> swerveSubsystem.zeroHeading());
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
