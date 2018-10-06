package org.apache.dubbo.rpc;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 这个不是dubbo框架自带的代码，而是在源码解析的时候通过debug断点之后，发现的动态创建的代理累的代码，
 * 放在这里是为了方便源码跟踪，方便在IDE中debug时的流程跟进
 */
public class Protocol$Adaptive implements Protocol {
    private static final org.apache.dubbo.common.logger.Logger logger = org.apache.dubbo.common.logger.LoggerFactory.getLogger(ExtensionLoader.class);
    private java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(0);

    public void destroy() {
        throw new UnsupportedOperationException("method public abstract void org.apache.dubbo.rpc.Protocol.destroy() of interface org.apache.dubbo.rpc.Protocol is not adaptive method!");
    }

    public int getDefaultPort() {
        throw new UnsupportedOperationException("method public abstract int org.apache.dubbo.rpc.Protocol.getDefaultPort() of interface org.apache.dubbo.rpc.Protocol is not adaptive method!");
    }

    public Invoker refer(Class arg0, org.apache.dubbo.common.URL arg1) throws RpcException {
        if (arg1 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg1;
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(org.apache.dubbo.rpc.Protocol) name from url(" + url.toString() + ") use keys([protocol])");
        Protocol extension = null;
        try {
            extension = (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName);
        } catch (Exception e) {
            if (count.incrementAndGet() == 1) {
                logger.warn("Failed to find extension named " + extName + " for type org.apache.dubbo.rpc.Protocol, will use default extension dubbo instead.", e);
            }
            extension = (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("dubbo");
        }
        return extension.refer(arg0, arg1);
    }

    public Exporter export(Invoker arg0) throws RpcException {
        if (arg0 == null) throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("org.apache.dubbo.rpc.Invoker argument getUrl() == null");
        org.apache.dubbo.common.URL url = arg0.getUrl();
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(org.apache.dubbo.rpc.Protocol) name from url(" + url.toString() + ") use keys([protocol])");
        Protocol extension = null;
        try {
            extension = (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName);
        } catch (Exception e) {
            if (count.incrementAndGet() == 1) {
                logger.warn("Failed to find extension named " + extName + " for type org.apache.dubbo.rpc.Protocol, will use default extension dubbo instead.", e);
            }
            extension = (Protocol) ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("dubbo");
        }
        return extension.export(arg0);
    }
}