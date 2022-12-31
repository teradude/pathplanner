package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;

/**
 * Mock swerve module implementation that just holds its internal state.
 * This should be replaced with an actual swerve module implementation in a real robot project.
 */
public class MockSwerveModule {
  private SwerveModuleState state = new SwerveModuleState();
  private SwerveModulePosition position = new SwerveModulePosition();

  public MockSwerveModule() {

  }

  public SwerveModuleState getState() {
      return state;
  }

  public SwerveModulePosition getPosition() {
      return position;
  }

  public void setDesiredState(SwerveModuleState state){
      this.state = state;
      this.position = new SwerveModulePosition(this.position.distanceMeters + (state.speedMetersPerSecond * 0.02), state.angle);
  }
}
