// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.subsystems.Armrafael;


public class Pitch extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  WPI_VictorSPX pitchM;
  Armrafael armrafael;
  DigitalInput limitP;
  DigitalInput rimitP;
  Encoder encoderP;
  Armrafael bracoencoder;

  

  public Pitch() {

 pitchM = new WPI_VictorSPX(22);
 bracoencoder = new Armrafael(); 
 pitchM.setNeutralMode(NeutralMode.Brake);
 

  }

  public void velpitch(double lt, double rt) {

 
    if(!limitP.get()) {

      pitchM.set(VictorSPXControlMode.PercentOutput, (lt * 0.5));
   }
   
   if(!rimitP.get()) {
   
     pitchM.set(VictorSPXControlMode.PercentOutput, (rt * 0.5));
   
   }

    double aut = ((bracoencoder.Leencoder() - encoderP.get()) * 0.001);
   
   pitchM.set(VictorSPXControlMode.PercentOutput, aut);

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
