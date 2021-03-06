package org.usfirst.frc.team4585.model;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lifters implements HuskyClass {
	
	private final int SECONDS = 0;
	
	private final int LIFTERS_PORT = 10;
	private Servo lifters = new Servo(LIFTERS_PORT);
	
	private Joystick joy;
	private Timer timer;
	
	
	public Lifters(Joystick J, Timer T) {
		joy = J;
		timer = T;
	}

	@Override
	public void teleopInit() {
		lifters.setAngle(30);
		SmartDashboard.putNumber("lift", lifters.getAngle());

	}

	@Override
	public void doTeleop() {
		if (/*timer.get() >= SECONDS && */joy.getRawButton(2)) {
			lifters.setAngle(0);
		}
		SmartDashboard.putNumber("lift", lifters.getAngle());

	}

	@Override
	public void autoInit() {		
		    lifters.setAngle(30);

	}

	@Override
	public void doAuto() {
		// TODO Auto-generated method stub

	}

	@Override
	public double[] getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void giveInfo(double[] info) {
		// TODO Auto-generated method stub

	}

}
