// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;


public class Arm_command extends CommandBase {

  private final Arm arm = Arm.getInstance();
  private double setpoint;
  /** Creates a new Arm_command. */
  
  public Arm_command(double setpoint) {
    this.setpoint = setpoint;
    this.addRequirements(arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (this.setpoint < arm.getPosArm()){
      arm.moveArm(-1 * Constants.Arm_constants.CollectMotorSpeed);

    }else{
      arm.moveArm(Constants.Arm_constants.CollectMotorSpeed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.moveArm(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if ( arm.getPosArm() == this.setpoint){
      return true;
    }
    return false;
  }
}
