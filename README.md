# SpringBoot-MybatisPlus-Practise

## Problems and solutions

1. org.springframework.beans.factory.BeanDefinitionStoreException: Invalid bean definition with name ‘xxxxMapper’ defined in file [xxxx.class] …
  - Check and match the version of mybatis and springboot.
2. PaginationInnerInterceptor not found
  - Check [https://baomidou.com/getting-started/install/] and [https://baomidou.com/plugins/pagination/]
  - As of v3.5.9, the **PaginationInnerInterceptor** has been separated. To use it, you need to introduce the **mybatis-plus-jsqlparser** dependency separately.
  - Check [https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-jsqlparser/3.5.9]
