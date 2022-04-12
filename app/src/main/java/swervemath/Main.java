package swervemath;

public class Main {
    public static void main(String[] args) {
        Swerve swerve = new Swerve(-0.5, 0.25, 0.75, 120);

        System.out.println("Forward cmd: " + swerve.getForward());
        System.out.println("Strafe cmd: " + swerve.getStrafe());
        System.out.println("Forward cmd: " + swerve.getRotation());
        // Gyro angle in degrees, converted to radians in Swerve
        System.out.println("Gyro angle: " + swerve.getGyroAngle());
    }
    
}
