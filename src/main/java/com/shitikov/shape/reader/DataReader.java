package com.shitikov.shape.reader;

import com.shitikov.shape.exception.ProjectException;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    public List<String> readFile(String fileName) throws ProjectException {
        List<String> dataList = new ArrayList<>();
        Path path = Paths.get(fileName);

        if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
            try (Stream<String> dataStream = Files.lines(path)) {
                dataList = dataStream.collect(Collectors.toList());
            } catch (IOException | UncheckedIOException e) {
                throw new ProjectException("Program error.", e);
            }
        }
        return dataList;
    }
}
