package util.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionUtils {

  public static List<String> convertArrayToListJava8(String[] names) {
    List<String> namesLst = Arrays.stream(names).collect(Collectors.toList());
    return namesLst;
  }

}
