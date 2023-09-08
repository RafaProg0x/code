package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drive extends SubsystemBase {

    WPI_VictorSPX d1;
    TalonSRX e1, d2, e2;
    MotorControllerGroup l,r;
    //DifferentialDrive d;
 
    public Drive() {
  
      d1 = new WPI_VictorSPX(6);
      e1 = new TalonSRX(12);
      d2 = new TalonSRX(14);
      e2 = new TalonSRX(13);

     d1.setInverted(InvertType.InvertMotorOutput);
     d2.setInverted(InvertType.InvertMotorOutput);

      d1.follow(d2);
      e1.follow(e2);
      
      //l = new MotorControllerGroup(e1, e2);
     // r = new MotorControllerGroup(d1, d2);

     // d = new DifferentialDrive(l, r);

    }
  
    public void vel(double x, double y) {
  
     // d.arcadeDrive(x, y);
       d2.set(TalonSRXControlMode.PercentOutput, -y + x);
       e2.set(TalonSRXControlMode.PercentOutput, -y - x);
  
    }
  
    @Override
    public void periodic() {
  
    }
  }
  