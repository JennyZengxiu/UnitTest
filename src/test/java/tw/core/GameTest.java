package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tw.core.GameStatus.CONTINUE;
import static tw.core.GameStatus.FAIL;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Game game;
    private AnswerGenerator answerGenerator;
    private Answer answer;

    @Before
    public final void before() throws OutOfRangeAnswerException {
        Answer actualAnswer = new Answer();
        actualAnswer.setNumList(Arrays.asList("1", "2", "3", "4"));
        answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
        answer = new Answer();
    }

    @Test
    public void should_guess_return_0A0B_when_input_all_wrong(){
        answer.setNumList(Arrays.asList("6", "7", "8", "9"));
        assertEquals(game.guess(answer).getResult(), "0A0B");
    }

    @Test
    public void should_guess_return_1A0B_when_input_has_one_correct(){
        answer.setNumList(Arrays.asList("1", "7", "8", "9"));
        assertEquals(game.guess(answer).getResult(), "1A0B");
    }

    @Test
    public void should_guess_return_0A1B_when_input_has_one_mismatch(){
        answer.setNumList(Arrays.asList("6", "7", "4", "8"));
        assertEquals(game.guess(answer).getResult(), "0A1B");
    }

    @Test
    public void should_guess_return_0A4B_when_input_all_mismatch(){
        answer.setNumList(Arrays.asList("4", "3", "2", "1"));
        assertEquals(game.guess(answer).getResult(), "0A4B");
    }

    @Test
    public void should_guess_return_2A2B_when_input_has_two_correct_and_two_misMatch(){
        answer.setNumList(Arrays.asList("1", "3", "2", "4"));
        assertEquals(game.guess(answer).getResult(), "2A2B");
    }

    @Test
    public void should_return_success_when_first_guess_is_correct(){
        answer.setNumList(Arrays.asList("1", "2", "3", "4"));
        game.guess(answer);
        assertEquals("success",game.checkStatus());
    }
    @Test
    public void should_return_continue_when_guess_is_not_correct_and_guessTimes_less_than_six(){
        for (int i = 0; i < 5; i++) {
            answer.setNumList(Arrays.asList("1", "3", "2", "4"));
            game.guess(answer);
        }
        assertEquals("continue",game.checkStatus());
    }

    @Test
    public void should_return_fail_when_last_guess_is_not_correct(){
        for (int i = 0; i < 6; i++) {
            answer.setNumList(Arrays.asList("1", "3", "2", "4"));
            game.guess(answer);
        }
        assertEquals("fail",game.checkStatus());
    }
}
