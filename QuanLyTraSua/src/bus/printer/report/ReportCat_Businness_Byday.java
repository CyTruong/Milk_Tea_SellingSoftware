package bus.printer.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;

import bus.HoadonBus;
import dto.ChitiethoadonDto;
import dto.HoadonDto;
import li.netcat.print.Print;
import li.netcat.print.util.TextPrint;

public class ReportCat_Businness_Byday extends ReportCat_Business {

	public ReportCat_Businness_Byday( Object[] arg) {
		super(arg);
	}

	@Override
	protected Print getTittle() {
		Timestamp timestamp = (Timestamp) _arg[0];
		System.out.println(timestamp.toString());
		TextPrint tp = new TextPrint("Báo cáo doanh thu ngày : " + new SimpleDateFormat("dd/MM/yyy").format(timestamp));
		tp.setHorizontalAlignment(JLabel.CENTER);
		return tp;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected ArrayList<HoadonDto> getFillterResult(ResultSet resultSet) {
		ArrayList<HoadonDto> hdarr = new ArrayList<>();
		Timestamp timestamp = (Timestamp) _arg[0];
		try {
			while (resultSet.next()) {
				HoadonDto hddto = new HoadonDto();
				hddto.mapping(resultSet);
				if (!hddto.isdeleted) {
					if (timestamp.getDay() == hddto.ngaymua.getDay()
							&& timestamp.getMonth() == hddto.ngaymua.getMonth()
							&& timestamp.getYear() == hddto.ngaymua.getYear()) {
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
