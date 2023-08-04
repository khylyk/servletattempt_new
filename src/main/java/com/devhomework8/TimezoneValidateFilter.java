package com.devhomework8;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

            if (!isValidTimezone(decodedTimezone)) {
                resp.setContentType("text/html; charset=utf-8");
                resp.getWriter().write("Invalid timezone");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().close();
                return;
            }
        }

        chain.doFilter(req, resp);
    }

    private boolean isValidTimezone(String timezone) {
        String[] availableTimezones = TimeZone.getAvailableIDs();
        return TimeZone.getTimeZone(timezone) != null && containsIgnoreCase(availableTimezones, timezone);
    }

    private boolean containsIgnoreCase(String[] array, String value) {
        for (String str : array) {
            if (str.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
