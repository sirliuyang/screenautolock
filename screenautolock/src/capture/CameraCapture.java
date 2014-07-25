package capture;

import java.util.Random;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import detection.FaceDetection;

public class CameraCapture {

	static boolean isBlack(Mat image) {
		int height = image.height() - 1;
		int width = image.width() - 1;

		double[] getImageValue;
		Random rand = new Random();

		// print(temp[0]);
		for (int j = 0; j < 30; j++) {
			getImageValue = image
					.get(rand.nextInt(height), rand.nextInt(width));
			if (getImageValue[0] != 0.0) {
				return false;
			}
		}

		return true;
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture capture;
		Mat frame = new Mat();
		boolean flag = true;
		// Highgui highgui = new Highgui();

		capture = new VideoCapture(0);
		capture.open(0);

		String fileName = "./pic/capture.jpg";
		while (flag) {
			if (!capture.isOpened()) {
				System.out.println("Did not connect to camera.");
			} else {
				capture.read(frame);

				if (!isBlack(frame)) {
					Highgui.imwrite(fileName, frame);
					capture.release();
					flag = false;
					break;
				}
			}
		}
		capture.release();
		new FaceDetection().run();
	}

}