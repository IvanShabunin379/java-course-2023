package edu.hw2.task4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CallingInfoUtilTest {
    @Test
    public void shouldReturnCallingInfoWithClassNameAndMethodNameOfThisMethod() {
        CallingInfo callingInfo = CallingInfoUtil.getInfo();

        assertThat(callingInfo).isNotNull();
        assertThat(callingInfo.className()).isEqualTo("edu.hw2.task4.CallingInfoUtilTest");
        assertThat(callingInfo.methodName()).isEqualTo("shouldReturnCallingInfoWithClassNameAndMethodNameOfThisMethod");
    }
}
