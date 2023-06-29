package me.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TopKFrequentElementsTest {

    @Test
    void testTopFrequent() {
        Assertions.assertEquals(List.of(1, 2), TopKFrequentElements.topFrequent(new int[]{1,1,1,2,2,3}, 2));
        Assertions.assertEquals(List.of(3, 2), TopKFrequentElements.topFrequent(new int[]{3,1,3,0,2,3,2}, 2));
        Assertions.assertEquals(List.of(1, 50, 2), TopKFrequentElements.topFrequent(new int[]{1,1,1,2,2,3,4,50,50}, 3));
        Assertions.assertEquals(List.of(1), TopKFrequentElements.topFrequent(new int[]{1,1,2,3,4,5,6}, 1));
    }
}