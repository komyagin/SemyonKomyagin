package hw9.utils;

import com.google.gson.GsonBuilder;
import hw9.entity.InputDataSet;

import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static Object[] getDataSets(String dataFilePath) {
        Object[] dataSet = null;

        try (FileReader reader = new FileReader(dataFilePath)) {
            dataSet = new GsonBuilder().create().fromJson(reader, InputDataSet[].class);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
}
