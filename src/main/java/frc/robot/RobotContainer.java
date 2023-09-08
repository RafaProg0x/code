// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Armrafael;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Garra;
import frc.robot.subsystems.Pitch;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  Garra garra;
  Drive drive;
  XboxController c; 
  XboxController c2;
  Armrafael armrafael;
  Pitch pitch;
  
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //g = new Garra();
    drive = new Drive();
    c = new XboxController(0);
    armrafael = new Armrafael();
    garra = new Garra();
    pitch = new Pitch();

    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {

    garra.setDefaultCommand( new RunCommand(() -> {

    garra.velcoleta(c.getAButton());
    garra.velsolta(c.getBButton());

    }, garra));
 
drive.setDefaultCommand( new RunCommand(() -> {

  drive.vel(-c.getLeftX(), c.getRightY());


}, drive));

  armrafael.setDefaultCommand( new RunCommand(() -> {

   armrafael.velarm(c.getRightTriggerAxis(), -c.getLeftTriggerAxis());

   }, armrafael));

   pitch.setDefaultCommand( new RunCommand(() -> {

    pitch.velpitch(c2.getRightTriggerAxis(), -c2.getLeftTriggerAxis());
 
    }, pitch));

  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  
}
}