package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.*;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Mock swerve subsystem that just displays the output from path following commands
// on a field 2d
public class ExampleSwerve extends SubsystemBase {
  private final Field2d field = new Field2d();

  public ExampleSwerve() {
    SmartDashboard.putData("Field", field);
  }

  @Override
  public void periodic() {

  }

  @Override
  public void simulationPeriodic() {

  }

  public Pose2d getPose() {
    return field.getRobotPose();
  }

  public void resetOdometry(Pose2d pose){
    field.setRobotPose(pose);
  }

  public void driveFieldRelative(ChassisSpeeds fieldRelativeSpeeds){
    Pose2d currentPose = field.getRobotPose();
    Translation2d newTrans = currentPose.getTranslation().plus(new Translation2d(
            fieldRelativeSpeeds.vxMetersPerSecond * 0.02,
            fieldRelativeSpeeds.vyMetersPerSecond * 0.02
    ));
    Rotation2d newRot = currentPose.getRotation().plus(new Rotation2d(fieldRelativeSpeeds.omegaRadiansPerSecond * 0.02));

    field.setRobotPose(new Pose2d(newTrans, newRot));
  }
}
