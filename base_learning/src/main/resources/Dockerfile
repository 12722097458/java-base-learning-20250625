FROM openjdk:17-jdk
COPY *.jar /app.jar

EXPOSE 8888
CMD ["--server.port=9999"]
ENTRYPOINT ["java", "-jar", "/app.jar"]



# 1. 根据docker file 构建镜像image
# docker build -f Dockerfile -t springboot-server:1.0 .
# 2. 启动镜像
# docker run -it -d -p 8888:9999 --name=springboot-server8888 springboot-server:1.0
# 3. 测试：
# 容器外用8888端口访问 http://192.168.137.110:8888/ping
# 容器内用9999访问
# 进入容器 docker exec -it springboot-server8888 /bin/bash curl http://localhost:9999/ping

