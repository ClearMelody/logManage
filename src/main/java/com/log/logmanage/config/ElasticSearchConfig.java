package com.log.logmanage.config;

import java.net.UnknownHostException;

import com.log.logmanage.service.impl.EsLogServiceImpl;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * $DESCRIPTION
 *
 * @author wyk
 * @create 2019-10-16 14:52
 * @describe 日志client配置相关
 */
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfig {

	private String clusterName;

	private String clusterNodes;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    /**
     * 使用elasticsearch实现类时才触发
     *
     * @return
     */
	@Bean
    @ConditionalOnBean(value = EsLogServiceImpl.class)
	public TransportClient getESClient() {
		// 设置集群名字
		Settings settings = Settings.builder().put("cluster.name", this.clusterName).build();
		TransportClient client = new PreBuiltTransportClient(settings);
		try {
			// 读取的ip列表是以逗号分隔的
			for (String clusterNode : this.clusterNodes.split(",")) {
				String ip = clusterNode.split(":")[0];
				String port = clusterNode.split(":")[1];
				((TransportClient) client)
						.addTransportAddress(new TransportAddress(java.net.InetAddress.getByName(ip), Integer.parseInt(port)));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return client;
	}

}
