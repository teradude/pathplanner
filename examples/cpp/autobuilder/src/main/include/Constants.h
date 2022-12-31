#pragma once

#include <frc/geometry/Translation2d.h>
#include <pathplanner/lib/auto/PIDConstants.h>

namespace swerve{
    constexpr frc::Translation2d FL_MODULE_OFFSET(0.4_m, 0.4_m);
    constexpr frc::Translation2d FR_MODULE_OFFSET(0.4_m, -0.4_m);
    constexpr frc::Translation2d BL_MODULE_OFFSET(-0.4_m, 0.4_m);
    constexpr frc::Translation2d BR_MODULE_OFFSET(-0.4_m, -0.4_m);

    constexpr pathplanner::PIDConstants AUTO_TRANSLATION_CONSTANTS(0, 0, 0);
}
