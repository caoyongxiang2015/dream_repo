

back-end:
1、helloword ok 
2、crud ok
3、transaction service方法中命名规则 ok
4、log ok （非DB记录）
5、login/logout、needLogin ok
6、验证码(暂缓)
7、cache(redis) (暂缓)
8、right(shiro)  查询出的user绑定role,role绑定permission ok(filterChainDefinitions定义有问题) 地址栏直接输入url
9、junit:
jdbc.properties，此数据库连接配置文件放在env-service工程中，但为了部署在实际环境中，需要根据实际情况，部署完成后可修改配置。
将此文件转移到env-web工程中。但env-service中没有jdbc连接配置，无法在env-service中单独做单元测试。因此也在env-service
工程中放一份jdbc.properties，但不上传到svn。如果env-service，env-web两个工程中都存在jdbc.properties，实际环境中会以
env-service工程中的配置为准。
单元测试，save操作，数据保存没有提交入库。。。？？？遗留问题待处理,在test方法上加注解@Rollback(false)

10、xss
11、国际化(ok)
12、伪静态.htm or 静态化 (暂缓)
13、批量CUD


front-end:
1、sitemesh(ok)
2、jquery
3、bootstrap
4、组件标签(分页，常用术语选择),附件上传
5、

common
1、附件上传
2、excel导入，导出
3、代码自动生成

doc:
1、说明文档

环境：
1、center os
2、nexus
3、hundson/jenkins
4、maven

message.properties放到web工程
application*.xml放到service工程


