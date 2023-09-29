package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class TalonSRXController implements MotorController {

    TalonSRX m_talon;
    // Constructor
    TalonSRXController(TalonSRX talon) {
        m_talon = talon;
    }

    @Override
    public void set(double speed) {
        m_talon.set(ControlMode.PercentOutput,speed);
    }

    @Override
    public double get() {
        // TODO Auto-generated method stub
        return m_talon.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
        m_talon.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return m_talon.getInverted();
    }

    @Override
    public void disable() {
        // TODO Auto-generated method stub
    }

    @Override
    public void stopMotor() {
        // TODO Auto-generated method stub
    }
    
}
