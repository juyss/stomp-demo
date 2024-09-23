# stomp-demo
Websocket  SockJS STOMP 示例代码。
基于SpringBoot
前端代码编译自` https://github.com/Samler-Lee/sockjs-client-tool `
提供了在线测试工具`http://ws-tool.samler.cn/`,需要将后端项目设置允许跨域。
```java  
registry.addEndpoint("/stomp").setAllowedOriginPatterns("http://ws-tool.samler.cn/").withSockJS();
```
运行项目浏览器地址打开 `localhost:8080`
