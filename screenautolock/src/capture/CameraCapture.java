package capture;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import detection.FaceDetection;

public class CameraCapture {

	public static void main(String[] args) throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		VideoCapture capture;
		Mat frame = new Mat();
		// Highgui highgui = new Highgui();

		capture = new VideoCapture(0);
		capture.open(0);

		int N = 100;

		for (int i = 1; i < N; i++) {
			if (!capture.isOpened()) {
				System.out.println("Did not connect to camera.");
			} else {
				capture.read(frame);
				// String fileName = "C:\\New_Thinking\\Frame\\frame"+i+".jpg";
				String fileName = "./pic/"+i + ".jpg";
				System.out.println(fileName);
				Highgui.imwrite(fileName, frame);
				// FaceDetection.detection(frame);
			}
		}
		capture.release();
		new FaceDetection().run();
	}

}
