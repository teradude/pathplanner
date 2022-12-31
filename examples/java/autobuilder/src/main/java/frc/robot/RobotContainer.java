package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Autos;
import frc.robot.subsystems.ExampleSwerve;

public class RobotContainer {
  public static final ExampleSwerve swerve = new ExampleSwerve();

  private static final SendableChooser<CommandBase> autoChooser = new SendableChooser<>();

  public static void init() {
    Autos.init();

    autoChooser.setDefaultOption("Example Auto", null);
    autoChooser.addOption("None", Autos.none());

    configureBindings();
  }

  private static void configureBindings() {}

  public static CommandBase getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
