/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.xalnite.util;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class OptionTest {
    @Test
    public void initialState() {
        assertEquals(Option.optarg, null);
        assertTrue(Option.opterr);
        assertEquals(Option.optind, 0);
        assertEquals(Option.optopt, Option.EOF);
    }
}
