package com.aladdin.sharding.jdbc;

import com.aladdin.sharding.jdbc.entity.Position;
import com.aladdin.sharding.jdbc.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author gopher lee
 * @Date 2020/9/3 00:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcApplication.class})
public class TestShardingDataSource {

    @Resource
    private PositionRepository positionRepository;

    @Test
    public void testAdd() {
        for (int i = 0; i < 20; i++) {
            Position position = new Position();
            position.setId(i);
            position.setName("gopher" + i);
            position.setSalary("1000000");
            position.setCity("北京");
            positionRepository.save(position);
        }
    }
}
