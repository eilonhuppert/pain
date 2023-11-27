// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  private TalonFX motor;
  private Arm(){
    this.motor = new TalonFX(Constants.IntakeConstants.KMotorID);
  }

  public static Arm instance;
  
  public static Arm getInstance(){
    if (instance == null){
      instance = new Arm();
    }
    return instance;
  }
  public void moveArm(Double motorspeed){
    this.motor.set(motorspeed);
  }
  public double getPosArm(){
    return this.motor.getPosition().getValue();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
