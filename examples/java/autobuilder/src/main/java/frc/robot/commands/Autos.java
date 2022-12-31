package frc.robot.commands;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

import java.util.HashMap;
import java.util.Map;

public final class Autos {
  private static final Map<String, Command> eventMap = new HashMap<>(Map.ofEntries(
          Map.entry("example1", Commands.print("Example 1 triggered")),
          Map.entry("example2", Commands.print("Example 2 triggered")),
          Map.entry("example3", Commands.print("Example 3 triggered"))
  ));
  private static final SwerveAutoBuilder autoBuilder = new SwerveAutoBuilder(
          RobotContainer.swerve::getPose,
          RobotContainer.swerve::resetOdometry,
          Constants.Swerve.AUTO_TRANSLATION_CONSTANTS,
          Constants.Swerve.AUTO_ROTATION_CONSTANTS,
          RobotContainer.swerve::driveFieldRelative,
          eventMap,
          RobotContainer.swerve
  );

  public static CommandBase exampleAuto() {
    return autoBuilder.fullAuto(PathPlanner.loadPathGroup("Example Auto", new PathConstraints(4, 3)));
  }

  public static CommandBase none() {
    return Commands.none();
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}