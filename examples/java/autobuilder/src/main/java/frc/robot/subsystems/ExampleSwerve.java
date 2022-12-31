package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.*;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExampleSwerve extends SubsystemBase {
  private final MockSwerveModule[] modules;
  private final SwerveDriveKinematics kinematics;
  private final SwerveDriveOdometry odometry; // Replace with SwerveDrivePoseEstimator if you prefer

  private Rotation2d mockGyro = new Rotation2d(); // Rotation2d to represent a gyro
  private Field2d field = new Field2d();

  public ExampleSwerve() {
    modules = new MockSwerveModule[]{
            new MockSwerveModule(), // FL
            new MockSwerveModule(), // FR
            new MockSwerveModule(), // BL
            new MockSwerveModule() // BR
    };

    kinematics = new SwerveDriveKinematics(
            Constants.Swerve.FL_MODULE_OFFSET,
            Constants.Swerve.FR_MODULE_OFFSET,
            Constants.Swerve.BL_MODULE_OFFSET,
            Constants.Swerve.BR_MODULE_OFFSET
    );

    odometry = new SwerveDriveOdometry(kinematics, mockGyro, getModulePositions());

    SmartDashboard.putData("Field", field);
  }

  @Override
  public void periodic() {
    odometry.update(mockGyro, getModulePositions());

    field.setRobotPose(getPose());
  }

  @Override
  public void simulationPeriodic() {

  }

  public Pose2d getPose() {
    return odometry.getPoseMeters();
  }

  public void resetOdometry(Pose2d pose){
    odometry.resetPosition(mockGyro, getModulePositions(), pose);
  }

  public void driveFieldRelative(ChassisSpeeds fieldRelativeSpeeds){
    ChassisSpeeds robotRelative = ChassisSpeeds.fromFieldRelativeSpeeds(
            fieldRelativeSpeeds.vxMetersPerSecond,
            fieldRelativeSpeeds.vyMetersPerSecond,
            fieldRelativeSpeeds.omegaRadiansPerSecond,
            mockGyro
    );

    SwerveModuleState[] targetStates = this.kinematics.toSwerveModuleStates(robotRelative);

    setModuleStates(targetStates);

    // Set the mock gyro position based on the rotation speed
    mockGyro = mockGyro.plus(new Rotation2d(fieldRelativeSpeeds.omegaRadiansPerSecond).times(0.02));
  }

  public void setModuleStates(SwerveModuleState[] states){
    for(int i = 0; i < modules.length; i++){
      modules[i].setDesiredState(states[i]);
    }
  }

  public SwerveModuleState[] getModuleStates() {
    SwerveModuleState[] states = new SwerveModuleState[4];
    for(int i = 0; i < modules.length; i++){
      states[i] = modules[i].getState();
    }
    return states;
  }

  public SwerveModulePosition[] getModulePositions() {
    SwerveModulePosition[] positions = new SwerveModulePosition[4];
    for(int i = 0; i < modules.length; i++){
      positions[i] = modules[i].getPosition();
    }
    return positions;
  }
}
