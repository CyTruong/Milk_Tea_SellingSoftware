package bus.printer;

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

public class ImageLoader {
	private final static Component component = new Component() {
	};
	private final static MediaTracker tracker = new MediaTracker(component);

	public static Image loadImage(String fileName) {
		Image image = Toolkit.getDefaultToolkit().createImage(fileName);
		loadImage(image);
		return image;
	}

	private static void loadImage(Image image) {
		synchronized (tracker) {
			tracker.addImage(image, 0);
			try {
				tracker.waitForID(0, 0);
			} catch (InterruptedException e) {
				System.out.println("INTERRUPTED while loading Image");
			}
			tracker.removeImage(image, 0);
		}
	}
}
