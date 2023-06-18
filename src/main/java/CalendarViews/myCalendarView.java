package CalendarViews;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import java.time.LocalTime;

public class myCalendarView {

    public myCalendarView(){

    }

    public void setMyView(){
        CalendarView calendarView = new CalendarView();
        Calendar birthdays = new Calendar("Birthdays"); // (2)
        birthdays.setStyle(Style.STYLE1); // (3)

        CalendarSource myCalendarSource = new CalendarSource("My Calendars");
        myCalendarSource.getCalendars().addAll(birthdays);

        calendarView.getCalendarSources().addAll(myCalendarSource); // (5)

        calendarView.setRequestedTime(LocalTime.now());

    }
}
