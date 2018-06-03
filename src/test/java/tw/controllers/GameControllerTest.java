package tw.controllers;

import com.google.inject.Injector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import tw.GuessNumberModule;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import static org.mockito.Mockito.mock;

import static com.google.inject.Guice.createInjector;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController;
    private AnswerGenerator answerGenerator;
    private Answer answer;
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private String systemOut() {
        return outputStream.toString();
    }

    @Before
    public void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void should_print_string_when_beginGame() throws IOException{
        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);

        gameController.beginGame();
        assertEquals("------Guess Number Game, You have 6 chances to guess!  ------\r\n",systemOut());
    }

}