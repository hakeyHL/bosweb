1. 本系统物流管理系统,总功能包括下单和后台管理,后台管理包括订单管理,快递员管理,车辆管理 . 
2. 第一个流程为下单,地址为ip:端口/项目名,示例地址localhost:8080/bosweb
3. 之后是后台管理 
访问地址为: ip:端口/项目名/admin.jsp,示例地址localhost:8080/bosweb/admin.jsp
4. 初始化sql脚本在项目的src\main\resources下,文件名为bos.sql ,实际使用时创建数据库后将初始数据导入到数据库中,
还需要将db-applicationContext.xml中的数据库连接配置修改成自己的.
5. 本项目为采用maven项目管理工具搭建的maven项目 ,搭建项目时使用了当前流行的框架:Spring , SpringMvc , mybatis 以及后台管理使用的是当前比较流行的bootstrap前端框架; 

6. mybatis用于操作数据库数据, 其操作数据的工具类使用的是mybatis的逆向工程工具mybatis-generator工具类生成, 实际操作方法参考如下地址 http://blog.csdn.net/for_my_life/article/details/51228098


(参考地址讲的是使用idea开发工具生成的例子,这个没关系,同样的原理操作方法在eclipse中也可以完成,这个可以不必深究,老师问起只说按照网上的方法生成的即可.)