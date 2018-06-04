package tw.core;

import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.RandomIntGenerator;
/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator generator;

    @Before
    public final void before() {
        generator = new RandomIntGenerator();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_return_IllegalArgumentException_when_digitmax_less_than_numbersOfNeed()
            throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Can't ask for more numbers than are available");
        String result = generator.generateNums(4, 5);
    }

    @Test
    public void should_retrun_a_random_answer_when_invoke_answer_generator() throws OutOfRangeAnswerException {
        String generateNums = generator.generateNums(9, 4);
        Assert.assertTrue(Pattern.matches("[0-9] [0-9] [0-9] [0-9]",generateNums));
    }
}