package swervemath;

public class Swerve {

    private double forward = 0.0;
    private double strafe = 0.0;
    private double rotation = 0.0;
    private double gyroAngle = 0.0;
    private double wheelBase = 24.0;
    private double trackWidth = 1.0;

    private double A = 0.0;
    private double B = 0.0;
    private double C = 0.0;
    private double D = 0.0;

    Swerve(double fwd, double str, double rot, double gyro) {
        this.forward = fwd;
        this.strafe = str;
        this.rotation = rot;
        this.gyroAngle = gyro * (Math.PI/180);
        
        // Calculate the foward and strafe commands inclusive of gyro angle
        double x = this.forward * Math.cos(this.gyroAngle) + this.strafe * Math.sin(this.gyroAngle);
        //System.out.println("x: " + x);
        this.strafe = -this.forward * Math.sin(this.gyroAngle) + this.strafe * Math.cos(this.gyroAngle);
        //System.out.println("strafe: " + this.strafe);
        this.forward = x;
        //System.out.println("forward: " + this.forward);

        // Calculate "R"
        double R = Math.sqrt(Math.pow(wheelBase, 2) + Math.pow(trackWidth, 2));
        //System.out.println("R: " + R);

        // Now variables A, B, C, D - these names suck, but it's in the paper that way
        A = this.strafe - this.rotation * wheelBase/R;
        //System.out.println("A: " + A);
        B = this.strafe + this.rotation * wheelBase/R;
        //System.out.println("B: " + B);
        C = this.forward - this.rotation * trackWidth/R;
        //System.out.println("C: " + C);
        D = this.forward + this.rotation * trackWidth/R;
        //System.out.println("D: " + D);
    }

    public double getWheelSpeed(Constants.Wheel wheelNum) {
        double wheelSpeed = 0.0;

        switch(wheelNum) {
            case FRONTLEFT:
                //System.out.println("front left");
                wheelSpeed = Math.sqrt(B*B + D*D);
                break;
            case FRONTRIGHT:
                //System.out.println("front right");
                wheelSpeed = Math.sqrt(B*B + C*C);
                break;
            case REARLEFT:
                //System.out.println("rear left");
                wheelSpeed = Math.sqrt(A*A + D*D);
                break;
            case REARRIGHT:
                //System.out.println("rear right");
                wheelSpeed = Math.sqrt(A*A + C*C);
                break;
            default:
            wheelSpeed = 0.0;
          }
          return wheelSpeed;
    }

    public double getWheelAngle(Constants.Wheel wheelNum) {
        double wheelAngle = 0.0;

        switch(wheelNum) {
            case FRONTLEFT:
                //System.out.println("front left");
                wheelAngle = Math.atan2(B, D) * (180/Math.PI);;
                break;
            case FRONTRIGHT:
                //System.out.println("front right");
                wheelAngle = Math.atan2(B, C) * (180/Math.PI);
                break;
            case REARLEFT:
                //System.out.println("rear left");
                wheelAngle = Math.atan2(A, D) * (180/Math.PI);;
                break;
            case REARRIGHT:
                //System.out.println("rear right");
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