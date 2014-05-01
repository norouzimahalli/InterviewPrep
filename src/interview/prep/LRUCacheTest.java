package interview.prep;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adunuthula on 4/13/2014.
 */
public class LRUCacheTest {
    private LRUCache<Integer> cache;
    private int cacheSize;

    @Before
    public void setUp() throws Exception {
        cacheSize = 5;
        cache = new LRUCache<Integer>(cacheSize);
    }


    @Test
    public void testPut() {
        for (int i = 0; i < cacheSize * 2; i++) {
            cache.put("Key" + i, new Integer(i));
        }
        cache.print();
        assertEquals("Cache Size", cacheSize, cache.size());
    }


    @Test
    public void testRandomGetAndPut() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            if (random.nextInt() % 4 == 0) {
                String key = "Key"  + (i - 4);
                System.out.println("Key " + key + " Val " + cache.get(key) );
            } else {
                cache.put("Key" + i, new Integer(i));
            }
            cache.print();
        }

    }
    @After
    public void tearDown() throws Exception {

    }
}
