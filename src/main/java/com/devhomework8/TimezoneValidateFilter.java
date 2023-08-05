package com.devhomework8;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Set;
import java.util.TimeZone;

@WebFilter(value = "/time")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse resp,
                            javax.servlet.FilterChain chain) throws IOException, javax.servlet.ServletException {

        String timezoneParam = req.getParameter("timezone");



        if (timezoneParam != null && !timezoneParam.isEmpty()) {
            String decodedTimezone = java.net.URLDecoder.decode(timezoneParam, "UTF-8");

            if (!isValidTimezone(timezoneParam)) {
                resp.setContentType("text/html; charset=utf-8");
                resp.getWriter().write("Invalid timezone " + timezoneParam);
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().close();
                return;
            }
        }

        chain.doFilter(req, resp);
    }

    private boolean isValidTimezone(String timezone) {
        ArrayList<String> availableTimezones = new ArrayList<>();
        availableTimezones.add("UTC+2");
        availableTimezones.add("UTC+3");
        availableTimezones.add("UTC+4");
        availableTimezones.add("UTC+5");
        availableTimezones.add("UTC+6");
        availableTimezones.add("UTC+7");
        availableTimezones.add("UTC+8");
        availableTimezones.add("UTC+9");
        availableTimezones.add("UTC+10");
        availableTimezones.add("UTC+11");
        availableTimezones.add("UTC+12");
        availableTimezones.add("UTC+13");
        availableTimezones.add("UTC+14");
        availableTimezones.add("UTC-2");
        availableTimezones.add("UTC-3");
        availableTimezones.add("UTC-4");
        availableTimezones.add("UTC-5");
        availableTimezones.add("UTC-6");
        availableTimezones.add("UTC-7");
        availableTimezones.add("UTC-8");
        availableTimezones.add("UTC-9");
        availableTimezones.add("UTC-10");
        availableTimezones.add("UTC-11");
        availableTimezones.add("UTC-12");
        return availableTimezones.contains(timezone);
    }


//    private boolean containsIgnoreCase(String[] array, String value) {
//        for (String str : array) {
//            if (str.equalsIgnoreCase(value)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
