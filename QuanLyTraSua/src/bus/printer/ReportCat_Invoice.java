package bus.printer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import bus.ThongtinquanBus;
import li.netcat.print.Print;
import li.netcat.print.util.BorderPrint;
import li.netcat.print.util.GridPrint;
import li.netcat.print.util.GridPrintConstraints;
import li.netcat.print.util.ImagePrint;
import li.netcat.print.util.LinePrintBorder;
import li.netcat.print.util.TextPrint;

public class ReportCat_Invoice {
	public static Image FLOWER = ImageLoader.loadImage("./res/Flower.gif");

	public ReportCat_Invoice() {

	}

	public Print getPrint() {
		try {
			ThongtinquanBus.getInstance().getInfoFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GridPrintConstraints c = GridPrintConstraints.DEFAULT.hAlignCenter();
		GridPrint inner = new GridPrint();

		inner.add(Tenquan(), c.hAlignCenter().colWidth(150).colSpan(2));

		inner.add(Header(), c);

		//inner.add(new ImagePrint(getI()), c.hAlignRight());
		return inner;
	}

	private Print Tenquan() {
		TextPrint TPtenquan = new TextPrint(ThongtinquanBus.getInstance().info.tenquan);
		TPtenquan.setFont(new Font("SERIF", Font.BOLD, 20));
		LinePrintBorder border = new LinePrintBorder();
		border.setInsets(new Insets(10, 30, 10, 30));
		return new BorderPrint(TPtenquan, border);
	}
	
	private Print Header() {
		TextPrint TPHeader = new TextPrint(ThongtinquanBus.getInstance().info.header);
		return TPHeader;
	}

	private Image getI() {
		String text = "JavaInfinite";
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);// Represents an image with 8-bit
																					// RGBA color components packed into
																					// integer pixels.
		Graphics2D graphics2d = image.createGraphics();
		Font font = new Font("TimesNewRoman", Font.BOLD, 24);
		graphics2d.setFont(font);
		FontMetrics fontmetrics = graphics2d.getFontMetrics();
		int width = fontmetrics.stringWidth(text);
		int height = fontmetrics.getHeight();
		graphics2d.dispose();

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		graphics2d = image.createGraphics();
		graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		graphics2d.setFont(font);
		fontmetrics = graphics2d.getFontMetrics();
		graphics2d.setColor(Color.GREEN);
		graphics2d.drawString(text, 0, fontmetrics.getAscent());
		graphics2d.dispose();
		return image;
	}
}

class ImageLoader {

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