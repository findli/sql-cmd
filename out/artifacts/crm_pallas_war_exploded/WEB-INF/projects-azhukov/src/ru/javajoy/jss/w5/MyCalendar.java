package ru.javajoy.jss.w5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MyCalendar extends javax.servlet.http.HttpServlet {

    private static final int WEEK_LENGTH = 7;
    private Map<String, String> holidays = new HashMap<>();
    private Calendar calendar = Calendar.getInstance();
    private static int hitCount;

    public MyCalendar() {
        /**
         * dd/mm month -1
         */
        holidays.put("1/0", "New Year's Day");
        holidays.put("7/0", "Christmas Day");
        holidays.put("8/2", "International Women's Day");
        holidays.put("1/4", "Labor Day");
        holidays.put("2/4", "Labor Day");
        holidays.put("9/4", "Victory Day");
        holidays.put("28/5", "Constitution Day");
        holidays.put("24/7", "Independence Day");
        holidays.put("14/9", "Defender's Day");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        if (request.getSession(true).isNew()) {
            hitCount++;
        }
        String msg = request.getParameter("userData");
        if (msg != null && msg.length() != 0) {
            PrintWriter out = response.getWriter();
            out.println("<html><head><body bgcolor=#aaffee>");
            String[] dateInput = msg.split("-");
            int month = Integer.parseInt(dateInput[0]) - 1;
            int year = Integer.parseInt(dateInput[1]);
            out.print("<table><caption>" + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_STANDALONE, Locale.getDefault()) + " " + year + "</caption> <tr>");
            for (int i = 0; i < WEEK_LENGTH; i++) {
                calendar.set(Calendar.DAY_OF_WEEK, getWeekDayConstant(i));
                out.print("<th>" + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()) + "</th>");
            }
            out.println("</tr>");
            Calendar day = (Calendar) calendar.clone();
            String color;

            for (day.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                 day.before(calendar) || day.get(Calendar.MONTH) == month || day.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY;
                 day.add(Calendar.DAY_OF_YEAR, 1)) {
                String prefix = (day.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) ? "<tr>" : "";
                String postfix = (day.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) ? "<tr>\n" : "";
                String dayString = (day.get(Calendar.MONTH) == month) ? "" + day.get(Calendar.DAY_OF_MONTH) : "";
                switch (getDayType(day)) {
                    case WEEKEND:
                        color = "green";
                        break;
                    case HOLIDAY:
                        color = "red";
                        break;
                    default:
                        color = "black";
                }
                out.print(prefix + "<td><font color='" + color + "'>" + dayString + "</font></td>" + postfix);
            }
            out.write("</table>");
            out.println("<h> Hits: " + hitCount + "</h> </body></html>");
            out.close();
        }
    }

    enum DayType {ORDINARY, WEEKEND, HOLIDAY}

    private DayType getDayType(Calendar calendar) {
        String key = calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH);
        if (holidays.containsKey(key)) {
            return DayType.HOLIDAY;
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return DayType.WEEKEND;
        } else return DayType.ORDINARY;
    }

    private int getWeekDayConstant(int n) {   // CK: converts zero-based week day into calendar's constant
        return (n + 1) % WEEK_LENGTH + 1;
    }

    @Override
    public void init() {
        hitCount = 0;
    }

}
