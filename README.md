# SpringBoot-MybatisPlus-Practise

## Problems and solutions

1. Invalid bean definition with name ‘xxxxMapper’ defined in file [xxxx.class]
  - Check and match the version of mybatis and springboot.
    
2. PaginationInnerInterceptor not found.
  - Check [https://baomidou.com/getting-started/install/] and [https://baomidou.com/plugins/pagination/]
  - As of v3.5.9, the **PaginationInnerInterceptor** has been separated. To use it, you need to introduce the **mybatis-plus-jsqlparser** dependency separately.
  - Check [https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-jsqlparser/3.5.9]
    
3. Inserfill or updatefill doesn't work.
  - Check if the column name matches the entity class. (for example, "createTime" in class != "create_time" in DB). Use 'value = "(column name)"' in the annotation to match the column.
  - Also have to check the handler's parameter, should be the same as it is in the entity.
  - Check if the entity attribute is a basic type. For a basic type, its default value is 0, which will not be changed by the handler. If it is, change them to the class type. (long -> Long).
