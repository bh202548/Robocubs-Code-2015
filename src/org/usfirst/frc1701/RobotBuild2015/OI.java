// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1701.RobotBuild2015;

import org.usfirst.frc1701.RobotBuild2015.commands.Calibrate;
import org.usfirst.frc1701.RobotBuild2015.commands.DriveToStep;
import org.usfirst.frc1701.RobotBuild2015.commands.ElevatortoBottom;
import org.usfirst.frc1701.RobotBuild2015.commands.ElevatortoBottomandRetractSlides;
import org.usfirst.frc1701.RobotBuild2015.commands.ElevatortoOneTote;
import org.usfirst.frc1701.RobotBuild2015.commands.ElevatortoStep;
import org.usfirst.frc1701.RobotBuild2015.commands.ElevatortoTop;
import org.usfirst.frc1701.RobotBuild2015.commands.ExtendSlides;
import org.usfirst.frc1701.RobotBuild2015.commands.Impulse;
import org.usfirst.frc1701.RobotBuild2015.commands.Resetimu;
import org.usfirst.frc1701.RobotBuild2015.commands.RetractSlides;
import org.usfirst.frc1701.RobotBuild2015.commands.Slidestopickupposition;
import org.usfirst.frc1701.RobotBuild2015.commands.StopElevator;
import org.usfirst.frc1701.RobotBuild2015.commands.Warp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick driveJoystick;
    public Joystick stick2;
    public Joystick elevatorJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Button impulse;
    public Button warp;
    public Button resetIMU;
    public Button stopElevator;
    public Button retractSlides;
    public Button extendSlides;
    public Button slidesToHold;
    public Button elevatorToBottom;
    public Button elevatorToStep;
    public Button elevatorToOneTote;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        elevatorJoystick = new Joystick(1);
        
        stick2 = new Joystick(2);
        
        driveJoystick = new Joystick(0);
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Warp", new Warp());

        SmartDashboard.putData("Impulse", new Impulse());

        SmartDashboard.putData("DriveToStep", new DriveToStep());

        SmartDashboard.putData("Reset imu", new Resetimu());

        SmartDashboard.putData("Elevator to Top", new ElevatortoTop());

        SmartDashboard.putData("Elevator to Bottom", new ElevatortoBottom());

        SmartDashboard.putData("Elevator to Bottom and Retract Slides", new ElevatortoBottomandRetractSlides());

        SmartDashboard.putData("Elevator to One Tote", new ElevatortoOneTote());

        SmartDashboard.putData("Elevator to Step", new ElevatortoStep());

        SmartDashboard.putData("Extend Slides", new ExtendSlides());

        SmartDashboard.putData("Slides to pickup position", new Slidestopickupposition());

        SmartDashboard.putData("Retract Slides", new RetractSlides());

        SmartDashboard.putData("Stop Elevator", new StopElevator());

        SmartDashboard.putData("Calibrate", new Calibrate());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    	impulse = new JoystickButton(stick2, 1);
    	warp = new JoystickButton(stick2, 2);
    	resetIMU = new JoystickButton(stick2, 4);
    	stopElevator = new JoystickButton(elevatorJoystick,4);
    	retractSlides = new JoystickButton(elevatorJoystick,5);
    	extendSlides = new JoystickButton(elevatorJoystick,7);
    	slidesToHold = new JoystickButton(elevatorJoystick,2);
    	elevatorToBottom = new JoystickButton(elevatorJoystick,1);
    	elevatorToOneTote = new JoystickButton(elevatorJoystick,3);
    	elevatorToStep = new JoystickButton(elevatorJoystick,6);
    	impulse.whenPressed(new Impulse());
    	warp.whenPressed(new Warp());
    	resetIMU.whenPressed(new Resetimu());
    	stopElevator.whenPressed(new ElevatortoTop());
    	retractSlides.whenPressed(new RetractSlides());
    	extendSlides.whenPressed(new ExtendSlides());
    	slidesToHold.whenPressed(new Slidestopickupposition());
    	elevatorToBottom.whenPressed(new ElevatortoBottom());
    	elevatorToOneTote.whenPressed(new ElevatortoOneTote());
    	elevatorToStep.whenPressed(new ElevatortoStep());
    	
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }

    public Joystick getStick2() {
        return stick2;
    }

    public Joystick getElevatorJoystick() {
        return elevatorJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
