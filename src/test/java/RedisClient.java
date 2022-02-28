
import com.fc.V2Application;

import org.apache.shiro.dao.DataAccessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = V2Application.class)
public class RedisClient {
    @Autowired
    public RedisTemplate redisTemplate;
    private  static final String userId = "TH_12345678";
    private  static final String userId2 = "CH_12345678";
    @Test
    public void test(){
        for (int i = 10;i<10;i++) {
            redisTemplate.opsForHash().put("quo_views_" + userId,i+"", i+"value");
        }
        for (int i = 0;i<10;i++) {
            redisTemplate.opsForHash().put("quo_views_" + userId2,i+"y", i+"value");
        }
    }
    @Test
    public void test2() throws IOException {
      //  Cursor<Map.Entry<Object,Object>> dataCursor = redisTemplate.executeWithStickyConnection() opsForHash().scan("quo_views_", ScanOptions.NONE);

       // ScanOptions scanOptions = ScanOptions.scanOptions().match("quo_views_*").count(1000).build();
        Set<String> tmpKeys = new HashSet<>();
        redisTemplate.execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {

                ScanOptions options = ScanOptions.scanOptions().match("quo_views_*").count(1000).build();

                // 迭代一直查找，直到找到redis中所有满足条件的key为止(cursor变为0为止)
                Cursor<byte[]> cursor = connection.scan(options);
                while (cursor.hasNext()) {
                    tmpKeys.add(new String(cursor.next()));
                }
                return tmpKeys;
            }
        });
    /*    RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        Cursor<Map.Entry<Object,Object>> dataCursor = (Cursor) redisTemplate.executeWithStickyConnection((RedisCallback) redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));*/
        for(String s : tmpKeys){
            System.out.println(s);
        }
    }

    @Test
    public void test3() throws IOException {
        Map<Object,Object> map = redisTemplate.opsForHash().entries("quo_views_" + userId);


        for(Map.Entry entry : map.entrySet())
        {

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        //关闭cursor

    }
}
