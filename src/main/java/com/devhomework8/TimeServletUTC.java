package com.devhomework8;//package com.devhomework8;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//
//@WebServlet(value = "/time")
//public class TimeServletUTC extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html; charset=utf-8");
//
//        String timeZoneParam = req.getParameter("timezone");
//        ZoneId zoneId;
//
//        if (timeZoneParam != null && !timeZoneParam.isEmpty()) {
//            try {
//                zoneId = ZoneId.of(timeZoneParam);
//            } catch (Exception e) {
//                resp.getWriter().write("error with time zone parameter");
//                return;
//            }
//        } else {
//            zoneId = ZoneId.of("UTC");
//        }
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(zoneId);
//        String formattedTime = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'xxx"));
//
//        resp.getWriter().write(formattedTime);
//    }
//}
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet("/time")
public class TimeServletUTC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String timezoneParam = request.getParameter("timezone");
        TimeZone timezone = TimeZone.getTimeZone(timezoneParam != null ? timezoneParam : "UTC");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        dateFormat.setTimeZone(timezone);
        String currentTime = dateFormat.format(new Date());

        String htmlResponse = "<html><body><h2>Current Time</h2><p>" + currentTime + "</p></body></html>";
        response.getWriter().write(htmlResponse);
    }
}
