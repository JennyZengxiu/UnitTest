package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;
import static org.junit.Assert.*;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    Answer answer;
    private Answer rightAnswer = new Answer();
    {
        rightAnswer.setNumList(Arrays.asList("1","2","3","4"));
    }

    @Before
    public final void before() {
        answer = new Answer();
    }

    @Test
    public void should_return_answer_when_createAnswer() throws Exception {
        assertEquals(answer.createAnswer("1 2 3 4").toString(), "1 2 3 4");
    }

    @Test
    public void should_throw_execption_when_given_num_bigger_than_10() throws OutOfRangeAnswerException {
        Answer answer = new Answer();
        exception.expect(OutOfRangeAnswerException.class);
        exception.expectMessage("Answer format is incorrect");
        answer.setNumList(Arrays.asList("1", "2", "3", "12"));
        answer.validate();
    }

    @Test
    public void should_return_a_correct_record_when_given_an_input_string() {
        answer.setNumList(Arrays.asList("2", "3", "4", "5"));

        Answer inputAnswer1 = new Answer();
        inputAnswer1.setNumList(Arrays.asList("5", "3", "4", "1"));

        int[] expectedValue = {2,1};
        int[] recordValue = answer.check(inputAnswer1).getValue();
        assertEquals(expectedValue[0],recordValue[0]);
        assertEquals(expectedValue[1],recordValue[1]);
    }
}