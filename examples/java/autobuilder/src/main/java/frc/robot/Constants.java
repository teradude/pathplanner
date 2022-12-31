package frc.robot;

import com.pathplanner.lib.auto.PIDConstants;
import edu.wpi.first.math.geometry.Translation2d;

public final class Constants {
    public static final class Swerve {
        public static final Translation2d FL_MODULE_OFFSET = new Translation2d(0.4, 0.4);
        public static final Translation2d FR_MODULE_OFFSET = new Translation2d(0.4, -0.4);
        public static final Translation2d BL_MODULE_OFFSET = new Translation2d(-0.4, 0.4);
        public static final Translation2d BR_MODULE_OFFSET = new Translation2d(-0.4, -0.4);

        public static final PIDConstants AUTO_TRANSLATION_CONSTANTS = new PIDConstants(5, 0, 0);
        public static final PIDConstants AUTO_ROTATION_CONSTANTS = new PIDConstants(0.5, 0, 0);
    }
}
