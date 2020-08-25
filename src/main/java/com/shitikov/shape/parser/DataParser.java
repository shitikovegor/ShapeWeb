package com.shitikov.shape.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {

    private static final String POINT_DELIMITER = "\\s+";
    private static final String PATTERN = "(-*\\d+\\.*\\d*\\s+\\d+\\.*\\d*)\\s+(-*\\d+\\.*\\d*\\s+\\d+\\.*\\d*)\\s+" +
                                            "(-*\\d+\\.*\\d*\\s+\\d+\\.*\\d*)\\s+(-*\\d+\\.*\\d*\\s+\\d+\\.*\\d*)\\s*\\n*";

    private static Logger logger = LogManager.getLogger();

    public List<Double> parseQuadrangleData(List<String> data){
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher;
        List<Double> result = new ArrayList<>();

        for (String dataString : data) {
            matcher = pattern.matcher(dataString);

            if (matcher.find()) {
                String[] points = dataString.split(POINT_DELIMITER);
                for (String point : points) {
                    result.add(Double.parseDouble(point));
                }
            } else {
                logger.log(Level.ERROR, "Invalid parameters in string {}", dataString);
            }
        }
        return result;
    }
}
