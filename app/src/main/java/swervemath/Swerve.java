package swervemath;

public class Swerve {

    private double forward = 0.0;
    private double strafe = 0.0;
    private double rotation = 0.0;
    private double gyroAngle = 0.0;

    Swerve(double fwd, double str, double rot, double gyro) {
        this.forward = fwd;
        this.strafe = str;
        this.rotation = rot;
        this.gyroAngle = gyro * (Math.PI/180);

        System.out.println("Constructor");
    }

    public double getForward() {
        return this.forward;
    }

    public double getStrafe() {
        return this.strafe;
    }

    public double getRotation() {
        return this.rotation;
    }

    public double getGyroAngle() {
        return this.gyroAngle;
    }

    
}