package org.usfirst.frc1701.helperfiles;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraFeeds extends Thread
{
	private int camCenter;
	private int camRight;
	private int curCam;
	private Image frame;
	public static final int btCamCenter = 1;
	public static final int btCamRight = 2;
	public static final String camNameCenter = "cam0";
	public static final String camNameRight = "cam1";
	CameraServer server;
	boolean camera1 = false;
	boolean camera2 = false;
	boolean running;
	
	public CameraFeeds()
	{
		
        // Get camera ids by supplying camera name ex 'cam0', found on roborio web interface
		try {
	        camCenter = NIVision.IMAQdxOpenCamera(camNameCenter, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			System.out.println("Camera 1 Session Started");
			camera1 = true;
		} catch (Exception e) {
			System.err.println("Camera 1 Session Failed to start.");
			camera1 = false;
			e.printStackTrace();
		}
		try {
	        camRight = NIVision.IMAQdxOpenCamera(camNameRight, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			System.out.println("Camera 2 Session Started");
			camera2 = true;
		} catch (Exception e) {
			System.err.println("Camera 2 Session Failed to start.");
			camera2 = false;
			e.printStackTrace();
		}
        curCam = camCenter;
        if(camera1){
    	NIVision.IMAQdxConfigureGrab(curCam);
    	NIVision.IMAQdxStartAcquisition(curCam);
        }
        // Img that will contain camera img
        server = CameraServer.getInstance();
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        running = false;
	}
	
	public void init()
	{
		changeCam(camCenter);
	}
	
	@Override
	public void run()
	{
		init();
		running = true;
		while(running){
			if(SmartDashboard.getBoolean("Camera1", true)){
				if(camera1){
					changeCam(camCenter);
				}
			}else{
				if(camera2){
					changeCam(camRight);
				}
			}
			updateCam();
			Timer.delay(0.05);
		}
		 end();
	}
	
	/**
	 * Stop aka close camera stream
	 */
	public void end()
	{
		NIVision.IMAQdxStopAcquisition(curCam);
	}
	
	/**
	 * Change the camera to get imgs from to a different one
	 * @param newId for camera
	 */
	public void changeCam(int newId)
    {
		NIVision.IMAQdxStopAcquisition(curCam);
    	NIVision.IMAQdxConfigureGrab(newId);
    	NIVision.IMAQdxStartAcquisition(newId);
    	curCam = newId;
    }
    
	/**
	 * Get the img from current camera and give it to the server
	 */
    public void updateCam()
    {
    	NIVision.IMAQdxGrab(curCam, frame, 1);
        server.setImage(frame);
    }
    public void finish() {
		running = false;
	}
}
