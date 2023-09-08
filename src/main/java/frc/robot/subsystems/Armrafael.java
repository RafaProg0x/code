// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.subsystems.Pitch;



public class Armrafael extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  WPI_VictorSPX motorA; 
  WPI_VictorSPX motorB;
  DigitalInput limit;
  DigitalInput rimit;
  Encoder encoder1;
  Encoder encoder2;
  Timer tempo;
  Pitch pitch;
  

  public Armrafael() {

  motorA = new WPI_VictorSPX(3);
  motorB = new WPI_VictorSPX(18);
  limit = new DigitalInput(8);
  rimit = new DigitalInput(7);
  encoder1 = new Encoder(10, 11);
  encoder2 = new Encoder(27, 33);
  tempo = new Timer();
  pitch = new Pitch();

  }

  public void velarm(double rt, double lt) {

if(!limit.get()) {

   motorA.set(VictorSPXControlMode.PercentOutput, (lt * 0.5));
}

if(!rimit.get()) {

  motorA.set(VictorSPXControlMode.PercentOutput, (rt * 0.5));

}

if(encoder1.get() > 200 && encoder2.get() < 50) {

 motorB.set(VictorSPXControlMode.PercentOutput, (0.5));


}

else if (encoder1.get() <= 200 && encoder2.get() > 0) {

  motorB.set(VictorSPXControlMode.PercentOutput, (-0.5));
  

}

else {

  motorB.set(VictorSPXControlMode.PercentOutput, (0.0));
}


}
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public double Leencoder() {
    
  return encoder2.get();

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
