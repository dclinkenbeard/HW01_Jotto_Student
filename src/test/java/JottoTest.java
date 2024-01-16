import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JottoTest {

  static final String TEST_GOOD_TXT = "TEST_GOOD.txt";
  static final String TEST_BAD_TXT = "TEST_BAD.txt";
  private static final ArrayList<String> GOOD_WORDS = new  ArrayList<>() {
    {
      add("oiled");
      add("grant");
      add("adieu");
      add("salet");
    }
  };
  private static final ArrayList<String> BAD_WORDS = new  ArrayList<>() {
    {
      add("fish");
      add("grants");
      add("foo");
    }
  };

  Jotto jotto = null;

  @BeforeAll
  static void overallSetup(){
    File f = new File(TEST_GOOD_TXT);
    BufferedWriter fileWriter;
    try{
      f.createNewFile();
      fileWriter = new BufferedWriter(new FileWriter(TEST_GOOD_TXT));
      for(String word : GOOD_WORDS){
        fileWriter.write(word + "\n");
      }
      fileWriter.close();

    } catch(IOException e){
      System.out.println("Problem creating " + TEST_GOOD_TXT);
    }

  }

  @AfterAll
  static void overAllTearDown(){
    File f = new File(TEST_GOOD_TXT);
    f.delete();

  }

  @BeforeEach
  void preTestSetup(){
    jotto = new Jotto(TEST_GOOD_TXT);

  }

  @AfterEach
  void preTestTearDown(){
    jotto = null;

  }

  @Test
  void readWords() {
    ArrayList<String> readWordResults = null;
    readWordResults = jotto.readWords();
    assertNotNull(readWordResults);

    for(String word : GOOD_WORDS){
      System.out.printf("Checking %s%n",word);
      assertTrue(readWordResults.contains(word));
    }
  }

  @Test
  void showPlayedWords() {
  }

  @Test
  void showWordList() {
  }

  @Test
  void showPlayerGuesses() {
  }

  @Test
  void guess() {
  }

  @Test
  void getLetterCount() {
  }

  @Test
  void updateWordList() {

  }

  @Test
  /**
   * This test is NOT comprehensive, but it is good for now.
   */
  void pickWord() {
    assertNull(jotto.getCurrentWord());
    assertTrue(jotto.pickWord());
    assertNotNull(jotto.getCurrentWord());
    while(jotto.pickWord()){
      String currentWord = jotto.getCurrentWord();
      System.out.println("Pickword test: " + currentWord );
      assertTrue(GOOD_WORDS.contains(currentWord));
    }

  }

  @Test
  void score() {
  }

  @Test
  void addPlayerGuess() {
  }

  @Test
  void playerGuessScores() {
  }

  @Test
  void getWordList() {
  }

  @Test
  void getPlayerGuesses() {
  }

  @Test
  void getPlayedWords() {
  }

  @Test
  void getCurrentWord() {
  }

  @Test
  void getFilename() {
  }

  @Test
  void getScore() {
  }

  @Test
  void setCurrentWord() {
  }

  @Test
  void setFilename() {
  }
}