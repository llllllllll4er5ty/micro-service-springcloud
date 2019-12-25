package com.leicx.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义负载均衡策略
 * @author daxiong
 * @date 2019-12-24 16:35
 */
public class RandomRule_LCX extends AbstractLoadBalancerRule {

    /**
     * 总共被调用的次数，目前要求每台被调用5次
     */
    private int total = 0;
    /**
     * 当前提供服务的机器
     */
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            int index = chooseInt(serverCount);
            server = upList.get(index);

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    /**
     * 负载均衡策略：每一台服务器访问五次，然后轮到下一个服务器
     * @author daxiong
     * @date 2019-12-24 16:50
     * @param serverCount
     * @return int
     */
    protected int chooseInt(int serverCount) {
        if (total < 5) {

        } else {
            total = 0;
            currentIndex++;
            if (currentIndex >= serverCount) {
                currentIndex = 0;
            }
        }
        total++;
        return currentIndex;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
