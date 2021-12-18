package ExternalLib.WrangerLib.trajectory;

import ExternalLib.WrangerLib.geometry.Pose2d;
import ExternalLib.WrangerLib.geometry.Twist2d;

public interface IPathFollower {
    public Twist2d steer(Pose2d current_pose);

    public boolean isDone();
}
