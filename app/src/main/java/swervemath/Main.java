package swervemath;
/*
This is from a technical paper on swerve drive that was posted on
Chief Delphi, called SWERVE DRIVE, dated 3/28/2011, by "Ether"
*/


public class Main {
    public static void main(String[] args) {
        
        Joystick.forwardAxis = 1.0;
        Joystick.strafeAxis = 1.0;
        Joystick.rotationAxis = 0.0;
        double gyroAngle = 0.0;
        
        Swerve swerve = new Swerve(Joystick.forwardAxis, Joystick.strafeAxis, Joystick.rotationAxis, gyroAngle);

        // Define the wheels
        Wheel frontLeftWheel = new Wheel();
        Wheel frontRightWheel = new Wheel();
        Wheel rearLeftWheel = new Wheel();
        Wheel rearRightWheel = new Wheel();

        frontLeftWheel.speed = swerve.getWheelSpeed(Constants.Wheel.FRONTLEFT);
        frontLeftWheel.angle = swerve.getWheelAngle(Constants.Wheel.FRONTLEFT);
        
        frontRightWheel.speed = swerve.getWheelSpeed(Constants.Wheel.FRONTRIGHT);
        frontRightWheel.angle = swerve.getWheelAngle(Constants.Wheel.FRONTRIGHT);
        
        rearLeftWheel.speed = swerve.getWheelSpeed(Constants.Wheel.REARLEFT);
        rearLeftWheel.angle = swerve.getWheelAngle(Constants.Wheel.REARLEFT);

        rearRightWheel.speed = swerve.getWheelSpeed(Constants.Wheel.REARRIGHT);
        rearRightWheel.angle = swerve.getWheelAngle(Constants.Wheel.REARRIGHT);

        System.out.println("Front left wheel speed: " + frontLeftWheel.speed);
        System.out.println("Front left wheel angle: " + frontLeftWheel.angle);
        System.out.println();
        System.out.println("Front right wheel speed: " + frontRightWheel.speed);
        System.out.println("Front right wheel angle: " + frontRightWheel.angle);
        System.out.println();
        System.out.println("Rear left wheel speed: " + rearLeftWheel.speed);
        System.out.println("Rear left wheel angle: " + rearLeftWheel.angle);
        System.out.println();
        System.out.println("Rear right wheel speed: " + rearRightWheel.speed);
        System.out.println("Rear right wheel angle: " + rearRightWheel.angle);
        System.out.println();

    }
    
}
