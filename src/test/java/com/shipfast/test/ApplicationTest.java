package com.shipfast.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {
    @Test
    public void shouldPass() {
        assertThat(true).isEqualTo(true);
    }
}
