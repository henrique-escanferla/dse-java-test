package com.example.anagrams;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class AnagramGeneratorTest {

    @Test
    void generatesCorrectAnagrams() {
        Set<String> expected = Set.of("abc","acb","bac","bca","cab","cba");
        assertEquals(expected, Set.copyOf(AnagramGenerator.generate("abc")));
    }
}
