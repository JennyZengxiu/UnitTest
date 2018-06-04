package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.assertFalse;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Test
    public void should_return_false_when_inputNumber_is_bigger_than_9(){
        assertFalse(inputValidator.validate("1 2 3 10"));
    }

    @Test
    public void should_return_false_when_inputNumber_size_is_bigger_than_4(){
        assertFalse(inputValidator.validate("1 2 3 4 5 6"));
    }

    @Test
    public void should_return_false_when_inputNumber_size_is_less_than_4(){
        assertFalse(inputValidator.validate("1 2 3"));
    }

    @Test
    public void should_return_true_when_inputNumber_is_validate(){
        Assert.assertTrue(inputValidator.validate("1 2 4 3"));
    }
}
