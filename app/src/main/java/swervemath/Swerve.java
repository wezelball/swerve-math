package swervemath;

public class Swerve {

    private double forward;
    private double strafe;
    private double rotation;
    private double gyroAngle;

    // Intermidiate variables
    private double A = 0.0;
    private double B = 0.0;
    private double C = 0.0;
    private double D = 0.0;

    Swerve(double fwd, double str, double rot, double gyro) {
        this.forward = fwd;
        this.strafe = str;
        this.rotation = rot;
        this.gyroAngle = gyro * (Math.PI/180);  // convert gyro angle to radians
        
        // Calculate the foward and strafe commands inclusive of gyro angle
        double x = this.forward * Math.cos(this.gyroAngle) + this.strafe * Math.sin(this.gyroAngle);
        this.strafe = -this.forward * Math.sin(this.gyroAngle) + this.strafe * Math.cos(this.gyroAngle);
        this.forward = x;

        // Calculate "R"
        double R = Math.sqrt(Math.pow(Constants.wheelBase, 2) + Math.pow(Constants.trackWidth, 2));

        // Now variables A, B, C, D - these names suck, but it's in the paper that way
        A = this.strafe - this.rotation * Constants.wheelBase/R;
        B = this.strafe + this.rotation * Constants.wheelBase/R;
        C = this.forward - this.rotation * Constants.trackWidth/R;
        D = this.forward + this.rotation * Constants.trackWidth/R;
    }

    public double getWheelSpeed(Constants.Wheel wheelNum) {
        double wheelSpeed = 0.0;

        switch(wheelNum) {
            case FRONTLEFT:
                wheelSpeed = Math.sqrt(B*B + D*D);
                break;
            case FRONTRIGHT:
                wheelSpeed = Math.sqrt(B*B + C*C);
                break;
            case REARLEFT:
                wheelSpeed = Math.sqrt(A*A + D*D);
                break;
            case REARRIGHT:
                wheelSpeed = Math.sqrt(A*A + C*C);
                break;
            default:
            wheelSpeed = 0.0;
          }
          return wheelSpeed;
    }

        /*
    Wheel angles are from -180 to +180 degrees CW; 0 is straight ahead. In this class they are converted to radians,
    but returned as degrees
    */
    public double getWheelAngle(Constants.Wheel wheelNum) {
        double wheelAngle = 0.0;

        switch(wheelNum) {
            case FRONTLEFT:
                wheelAngle = Math.atan2(B, D) * (180/Math.PI);;
                break;
            case FRONTRIGHT:
                wheelAngle = Math.atan2(B, C) * (180/Math.PI);
                break;
            case REARLEFT:
                wheelAngle = Math.atan2(A, D) * (180/Math.PI);;
                break;
            case REARRIGHT:
                wheelAngle = Math.atan2(A, C) * (180/Math.PI);;
                break;
            default:
          }
          return wheelAngle;
    }

    public double getMaxWheelSpeed(double ws1, double ws2, double ws3, double ws4) {
        double max = ws1;

        if(ws2 > max)
            max = ws2;
        else if(ws3 > max)
            max = ws3;
        else if(ws4 > max)
            max = ws4;
        return max;
    }

    public double normalize(double ws, double max) {
        if(max > 1.0) 
            return ws/max;
        else
            return ws;
    }


    
}