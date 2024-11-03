package io.github.parkerchen.springbootmybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class Generator {
    public static void main(String[] args) {

        FastAutoGenerator
                .create("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "123456")
                .globalConfig(builder -> builder
                        .author("Parker Chen")
                        .outputDir("C:\\Users\\Starl\\Workstation\\Java\\SpringBoot-MybatisPlus\\src\\GeneratorOutput")
                )
                .packageConfig(builder -> builder
                        .parent("io.github.parkerchen.springbootmybatisplus")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
