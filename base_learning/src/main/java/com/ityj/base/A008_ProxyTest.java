package com.ityj.base;

// interface 的应用。  代理模式
public class A008_ProxyTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }

}

// 同一个接口
interface NetWork {
    void browse();
}

// 被代理类
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("Server 真实方法执行。。。");
    }
}

// 代理类
class ProxyServer implements NetWork {

    private NetWork netWork;

    public ProxyServer (NetWork netWork) {
        this.netWork = netWork;
    }

    private void check () {
        System.out.println("ProxyServer 做一些检查工作。。。");
    }

    @Override
    public void browse() {
        System.out.println("ProxyServer 代理方法开始执行。。。");
        check();
        netWork.browse();
    }
}