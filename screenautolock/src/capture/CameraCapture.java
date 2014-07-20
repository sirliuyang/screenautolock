package capture;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;


public class CameraCapture {


	public static void main(String[] args) throws Exception {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		
		VideoCapture capture;
		Mat frame = new Mat();
		
		capture = new VideoCapture(0);
		
		if(!capture.isOpened()){
			System.out.println("Did not connect to camera.");		
		}
		else{
			capture.retrieve(frame);
			capture.release();
		}
		
	}

}
