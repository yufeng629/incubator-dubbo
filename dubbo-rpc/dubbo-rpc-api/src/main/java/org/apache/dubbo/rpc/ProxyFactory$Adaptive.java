package org.apache.dubbo.rpc;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 这个不是dubbo框架自带的代码，而是在源码解析的时候通过debug断点之后，发现的动态创建的代理累的代码，
 * 放在这里是为了方便源码跟踪，方便在IDE中debug时的流程跟进
 */
public class ProxyFactory$Adaptive implements ProxyFactory {
    private static final org.apache.dubbo.common.logger.Logger logger = org.apache.dubbo.common.logger.LoggerFactory.getLogger(ExtensionLoader.class);
    private java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(0);

    public Object getProxy(Invoker arg0) throws RpcException {
        if (arg0 == null) throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        org.apache.dubbo.common.URL url = arg0.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(org.apache.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        ProxyFactory extension = null;
        try {
            extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        } catch (Exception e) {
            if (count.incrementAndGet() == 1) {
                logger.warn("Failed to find extension named " + extName + " for type org.apache.dubbo.rpc.ProxyFactory, will use default extension javassist instead.", e);
            }
            extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension("javassist");
        }
        return extension.getProxy(arg0);
    }

    public Object getProxy(Invoker arg0, boolean arg1) throws RpcException {
        if (arg0 == null) throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        org.apache.dubbo.common.URL url = arg0.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(org.apache.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        ProxyFactory extension = null;
        try {
            extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        } catch (Exception e) {
            if (count.incrementAndGet() == 1) {
                logger.warn("Failed to find extension named " + extName + " for type org.apache.dubbo.rpc.ProxyFactory, will use default extension javassist instead.", e);
            }
            extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension("javassist");
        }
        return extension.getProxy(arg0, arg1);
    }

    public Invoker getInvoker(Object arg0, Class arg1, org.apache.dubbo.common.URL arg2) throws RpcException {
        if (arg2 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg2;
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(org.apache.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        ProxyFactory extension = null;
        try {
            extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        } catch (Exception e) {
            if (count.incrementAndGet() == 1) {
                logger.warn("Failed to find extension named " + extName + " for type org.apache.dubbo.rpc.ProxyFactory, will use default extension javassist instead.", e);
            }
            extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension("javassist");
        }
        return extension.getInvoker(arg0, arg1, arg2);
    }
}