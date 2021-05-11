package com.paduankata.demo.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringHelperTest {
  // AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA
  @Mock
  private StringHelper stringHelper;

  @BeforeEach
  void before() {
    stringHelper = new StringHelper();
  }

  @Test
  void testTruncateAInFirst2PositionsAinFirst2Positions() {
    assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
  }

  @Test
  void testTruncateAInFirst2PositionsAinFirstPosition() {
    assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
  }

  // ABCD => false, ABAB => true, AB => true, A => false
  @Test
  void testAreFirstAndLastTwoCharactersTheSameBasicNegativeScenario() {
    assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
  }

  @Test
  void testAreFirstAndLastTwoCharactersTheSameBasicPositiveScenario() {
    assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
  }
}
