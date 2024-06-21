# 部署
启动服务：nohup java -jar -Xms128m  -Xmx512m -XX:PermSize=128m -XX:MaxPermSize=512m yb-td-1.0-SNAPSHOT.jar  &  
查看日志：tail -fn 200 nohup.out
