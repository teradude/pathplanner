package frc.robot.commands;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Autos {
  private static SwerveAutoBuilder autoBuilder;

  public static void init(){
    HashMap<String, Command> eventMap = new HashMap<>(Map.ofEntries(
            Map.entry("example1", Commands.print("Example 1 triggered")),
            Map.entry("example2", Commands.print("Example 2 triggered")),
            Map.entry("example3", Commands.print("Example 3 triggered"))
    ));

    autoBuilder = new SwerveAutoBuilder(
            RobotContainer.swerve::getPose,
            RobotContainer.swerve::resetOdometry,
            Constants.Swerve.AUTO_TRANSLATION_CONSTANTS,
            Constants.Swerve.AUTO_ROTATION_CONSTANTS,
            RobotContainer.swerve::driveFieldRelative,
            eventMap,
            RobotContainer.swerve
    );
  }

  public static CommandBase exampleAuto() {
    ArrayList<PathPlannerTrajectory> pathGroup = PathPlanner.loadPathGroup("Example Auto", new PathConstraints(4, 3));
    return autoBuilder.fullAuto(pathGroup);
  }

  public static CommandBase none() {
    return Commands.none();
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
