package bus.printer.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;

import dto.HoadonDto;
import li.netcat.print.Print;
import li.netcat.print.util.TextPrint;

public class ReportCat_Business_Byyear extends ReportCat_Business {

	public ReportCat_Business_Byyear(Object[] arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Print getTittle() {
		Timestamp timestamp = (Timestamp) _arg[0];
		TextPrint tp = new TextPrint("Báo cáo doanh thu năm : " + new SimpleDateFormat("yyy").format(timestamp));
		tp.setHorizontalAlignment(JLabel.CENTER);
		return tp;
	}

	@Override
	protected ArrayList<HoadonDto> getFillterResult(ResultSet resultSet) {
		ArrayList<HoadonDto> hdarr = new ArrayList<>();
		Timestamp timestamp = (Timestamp) _arg[0];
		try {
			while (resultSet.next()) {
				HoadonDto hddto = new HoadonDto();
				hddto.mapping(resultSet);
				if (!hddto.isdeleted) {
					if (timestamp.getYear() == hddto.ngaymua.getYear()) {
						hdarr.add(hddto);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hdarr;
	}

}
