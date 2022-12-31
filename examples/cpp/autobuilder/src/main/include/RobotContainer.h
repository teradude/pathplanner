#pragma once

#include <frc2/command/CommandPtr.h>

#include "subsystems/ExampleSwerve.h"

class RobotContainer {
 public:
  static ExampleSwerve swerve;

  static void init();
  static frc2::CommandPtr GetAutonomousCommand();

 private:
  static void ConfigureBindings();
};
