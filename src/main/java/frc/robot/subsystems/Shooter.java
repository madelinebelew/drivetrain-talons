package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
    
    private WPI_TalonSRX shooter;

    private double shooterSpeed = 0.5;

    public Shooter() { 
        shooter = new WPI_TalonSRX(RobotMap.SHOOTER);
    }

    public void shootBall() { 
        shooter.set(shooterSpeed);
    }
   
    public void stop() {
        shooter.set(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
    
        // This method will be called once per scheduler run during simulation
    }

    
}
