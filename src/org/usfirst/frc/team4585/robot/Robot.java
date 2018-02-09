
package org.usfirst.frc.team4585.robot;

import org.usfirst.frc.team4585.model.*;
import org.usfirst.frc.team4585.model.auto.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	
	private final int JOYSTICK_PORT = 0;
	
	
	private Timer timer = new Timer();
	private HuskyJoy joy = new HuskyJoy(JOYSTICK_PORT);
	private HuskyJoy weaponsJoy = joy;
	private Chassis chassis = new Chassis(joy, timer);
	private Arm arm = new Arm(weaponsJoy);
	private Claw claw = new Claw(weaponsJoy);
	private PositionTracker tracker = new PositionTracker(timer);
	private GhostController marcus = new GhostController(chassis, arm, claw, tracker, joy);
	private ArmExtender actuator = new ArmExtender(weaponsJoy);
	private Winch winch = new Winch(weaponsJoy);
	
	private ArduinoCom arduino = new ArduinoCom(claw);
	
	
	
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		tracker.dashInit();
		marcus.dashInit();
		
		arduino.setPins();
		
		
		//DriverStation.getInstance().getGameSpecificMessage();
		
	}

	/**
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() {
		marcus.autoInit();
		chassis.autoInit();
		arm.autoInit();
		claw.autoInit();
		tracker.autoInit();
		actuator.autoInit();
		
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		marcus.doAuto();
		chassis.doAuto();
		arm.doAuto();
		claw.doAuto();
		tracker.doAuto();
		
		arduino.setPins();
		
	}

	/**
	 * This function is called once each time the robot enters teleoperated mode.
	 */
	@Override
	public void teleopInit() {
		marcus.teleopInit();
		chassis.teleopInit();
		arm.teleopInit();
		claw.teleopInit();
		tracker.teleopInit();
		actuator.teleopInit();
		
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during teleoperated mode.
	 */
	@Override
	public void teleopPeriodic() {
		marcus.doTeleop();
		chassis.doTeleop();
		arm.doTeleop();
		claw.doTeleop();
		tracker.doTeleop();
		actuator.doTeleop();
		
		arduino.setPins();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		arduino.setPins();
	}
	
	@Override
	public void disabledPeriodic() {
		arduino.setPins();
	}
}
