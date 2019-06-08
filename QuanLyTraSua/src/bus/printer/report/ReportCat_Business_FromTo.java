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

public class ReportCat_Business_FromTo extends ReportCat_Business {

	public ReportCat_Business_FromTo(Object[] arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Print getTittle() {
		Timestamp timestampfrom = (Timestamp) _arg[0];
		Timestamp timestampto = (Timestamp) _arg[1];
		TextPrint tp = new TextPrint("Báo cáo doanh thu từ : " + new SimpleDateFormat("dd/MM/yyy").format(timestampfrom)+" đến "+new SimpleDateFormat("dd/MM/yyy").format(timestampto));
		tp.setHorizontalAlignment(JLabel.CENTER);
		return tp;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected ArrayList<HoadonDto> getFillterResult(ResultSet resultSet) {
		ArrayList<HoadonDto> hdarr = new ArrayList<>();
		
		Timestamp timestampfrom = (Timestamp) _arg[0];
		Calendar from_calender = Calendar.getInstance();
		from_calender.setTimeInMillis(timestampfrom.getTime());
		
		Timestamp timestampto = (Timestamp) _arg[1];
		Calendar to_calender = Calendar.getInstance();
	    to_calender.setTimeInMillis(timestampto.getTime());
		
		try {
			while (resultSet.next()) {
				HoadonDto hddto = new HoadonDto();
				hddto.mapping(resultSet);
				if (!hddto.isdeleted) {
					Timestamp dtotime = hddto.ngaymua;
					Calendar dto_calender = Calendar.getInstance();
					dto_calender.setTimeInMillis(dtotime.getTime());
				    
					if (dtotime.getTime() >= timestampfrom.getTime() &&
							dtotime.getTime() <= timestampto.getTime()	) {
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
