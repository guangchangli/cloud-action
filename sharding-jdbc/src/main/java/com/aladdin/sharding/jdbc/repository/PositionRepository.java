package com.aladdin.sharding.jdbc.repository;

import com.aladdin.sharding.jdbc.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author gopher lee
 * @Date 2020/9/3 00:31
 */
public interface PositionRepository extends JpaRepository<Position,Long> {
}
