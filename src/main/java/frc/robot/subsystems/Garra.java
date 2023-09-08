// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Garra extends SubsystemBase {

  WPI_VictorSPX gd, ge;

  public Garra() {

    gd = new WPI_VictorSPX(7);
    ge = new WPI_VictorSPX(8);
    gd.follow(ge);
    gd.setInverted(true);

  }

  public void velcoleta(boolean ve) {
   
    if(ve) { 
    ge.set(VictorSPXControlMode.PercentOutput, (0.5));
   
    } else {
    ge.set(VictorSPXControlMode.PercentOutput, (0.0));

   }

  }

  public void velsolta(boolean ve) {
   
    if(ve) { 
    ge.set(VictorSPXControlMode.PercentOutput, (-0.5));
 
    } else {
    ge.set(VictorSPXControlMode.PercentOutput, (0.0));

   }

  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
