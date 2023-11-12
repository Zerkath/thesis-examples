import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.io.Reader;

public class Main {
  public static void main(String[] args) {

    try {
      TestDataReader tdr = new TestDataReader();
      tdr.testGetCharacterCount();
      System.out.println("Test passed");
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (AssertionError e) {
      System.out.println("Test failed: " + e.getMessage());
    }

    try {
      File file = new File("sample.txt");
      DataReader dr = new DataReader();
      int result = dr.getCharacterCount(new BufferedReader(new FileReader(file)), 'a');
      System.out.println(result);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}

class DataReader {

  public int getCharacterCount(Reader r, char search) throws IOException {
    int count = 0;
    int d;
    while ((d = r.read()) != -1) {
      if ((char) d == search) {
        count++;
      }
    }

    r.close();
    return count;
  }
}

class TestDataReader {

  public void testGetCharacterCount() throws IOException, AssertionError {
    DataReader dr = new DataReader();
    int result = dr.getCharacterCount(new StringReader("aa foo bar aa"), 'a');
    if (result != 5) {
      throw new AssertionError("Expected 5, got " + result);
    }
  }
}
