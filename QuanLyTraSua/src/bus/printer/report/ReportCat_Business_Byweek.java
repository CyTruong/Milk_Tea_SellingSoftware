package bus.printer.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;

import dto.HoadonDto;
import li.netcat.print.Print;
import li.netcat.print.util.TextPrint;

public class ReportCat_Business_Byweek extends ReportCat_Business {

	public ReportCat_Business_Byweek(Object[] arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Print getTittle() {
		Timestamp timestamp = (Timestamp) _arg[0];
		int day = timestamp.getDay() / 4;
		TextPrint tp = new TextPrint("Báo cáo doanh thu tuần "+(day+1)+" trong tháng " + new SimpleDateFormat("MM/yyy").format(timestamp));
		tp.setHorizontalAlignment(JLabel.CENTER);
		return tp;
	}
	@SuppressWarnings("deprecation")
	@Override
	protected ArrayList<HoadonDto> getFillterResult(ResultSet resultSet) {
		ArrayList<HoadonDto> hdarr = new ArrayList<>();
		Timestamp timestamp = (Timestamp) _arg[0];
		Calendar inputcalendar = Calendar.getInstance();
		inputcalendar.setTimeInMillis(timestamp.getTime());
		try {
			while (resultSet.next()) {
				HoadonDto hddto = new HoadonDto();
				hddto.mapping(resultSet);
				if (!hddto.isdeleted) {
					Calendar rscalendar = Calendar.getInstance();
					rscalendar.setTimeInMillis(timestamp.getTime());
					if(rscalendar.WEEK_OF_YEAR == inputcalendar.WEEK_OF_YEAR) {
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
