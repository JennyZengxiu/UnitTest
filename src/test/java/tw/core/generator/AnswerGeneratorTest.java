package tw.core.generator;

import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import tw.GuessNumberModule;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.regex.Pattern;

import static com.google.inject.Guice.createInjector;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    public void should_retrun_a_random_answer_when_invoke_answer_generator() throws OutOfRangeAnswerException {
        Injector injector = createInjector(new GuessNumberModule());
        AnswerGenerator answerGenerator = injector.getInstance(AnswerGenerator.class);
        Answer answer = answerGenerator.generate();
        Assert.assertTrue(Pattern.matches("[0-9] [0-9] [0-9] [0-9]", answer.toString()));
    }

}

