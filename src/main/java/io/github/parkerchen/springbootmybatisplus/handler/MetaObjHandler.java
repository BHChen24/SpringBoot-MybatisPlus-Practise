package io.github.parkerchen.springbootmybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
public class MetaObjHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("Start insert fill ....");
        long now = Instant.now().toEpochMilli();
        this.strictInsertFill(metaObject, "createTime", Long.class, now);
        this.strictInsertFill(metaObject, "updateTime", Long.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("Start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", Long.class, Instant.now().toEpochMilli());
//        metaObject.setValue("updateTime", Instant.now().toEpochMilli());
    }
}
