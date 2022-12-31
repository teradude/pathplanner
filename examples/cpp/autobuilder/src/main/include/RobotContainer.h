#pragma once

#include <frc2/command/CommandPtr.h>

#include "subsystems/ExampleSubsystem.h"

class RobotContainer {
 public:
  RobotContainer();

  frc2::CommandPtr GetAutonomousCommand();

 private:
  ExampleSubsystem m_subsystem;

  void ConfigureBindings();
};
