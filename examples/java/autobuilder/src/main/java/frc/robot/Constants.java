package frc.robot;

import com.pathplanner.lib.auto.PIDConstants;
import edu.wpi.first.math.geometry.Translation2d;

public final class Constants {
    // All of the values in here should be changed for your robot
    public static final class Swerve {
        public static final PIDConstants AUTO_TRANSLATION_CONSTANTS = new PIDConstants(0, 0, 0);
        public static final PIDConstants AUTO_ROTATION_CONSTANTS = new PIDConstants(0, 0, 0);
    }
}
