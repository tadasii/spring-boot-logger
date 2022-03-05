## 简介

​	工作中经常碰到日志难查询的情况，比如某个controller接口出现异常了，查找异常信息只能根据关键字查找。而该日志的上下文信息很难查找。

​     而log4j框架中的MDC可以为每个线程创建相同的信息，我们可以用spring的拦截器或者过滤器，生成一个traceId，放到MDC中，在日志配置中打印出这个traceId。在每个controller返回的报文中，利用@ControllerAdvice 添加traceId信息。

# MDC介绍

​	MDC（Mapped Diagnostic Context，映射调试上下文）是 log4j 、logback及log4j2 提供的一种方便在多线程条件下记录日志的功能。MDC 可以看成是一个与当前线程绑定的哈希表，可以往其中添加键值对。MDC 中包含的内容可以被同一线程中执行的代码所访问。当前线程的子线程会继承其父线程中的 MDC 的内容。当需要记录日志时，只需要从 MDC 中获取所需的信息即可。MDC 的内容则由程序在适当的时候保存进去。对于一个 Web 应用来说，通常是在请求被处理的最开始保存这些数据。

# API说明：

- clear() => 移除所有MDC

- get (String key) => 获取当前线程MDC中指定key的值

- getContext() => 获取当前线程MDC的MDC

- put(String key, Object o) => 往当前线程的MDC中存入指定的键值对

- remove(String key) => 删除当前线程MDC中指定的键值对

