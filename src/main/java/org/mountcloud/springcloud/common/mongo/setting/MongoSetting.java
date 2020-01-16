package org.mountcloud.springcloud.common.mongo.setting;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConfigurationProperties(prefix="mongo")
public class MongoSetting {

	private int connectionsPerHost;
	
	private int connectTimeout;
	
	private int heartbeatConnectTimeout;
	
	private int maxConnectionIdleTime;
	
	private int maxConnectionLifeTime;
	
	private int minConnectionsPerHost;
	
	private String requiredReplicaSetName;
	
	private int minHeartbeatFrequency;
	
	
	private boolean socketKeepAlive;
	
	
	private int heartbeatSocketTimeout;
	
	private int threadsAllowedToBlockForConnectionMultiplier;

	public int getConnectionsPerHost() {
		return connectionsPerHost;
	}

	public void setConnectionsPerHost(int connectionsPerHost) {
		this.connectionsPerHost = connectionsPerHost;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getHeartbeatConnectTimeout() {
		return heartbeatConnectTimeout;
	}

	public void setHeartbeatConnectTimeout(int heartbeatConnectTimeout) {
		this.heartbeatConnectTimeout = heartbeatConnectTimeout;
	}

	public int getMaxConnectionIdleTime() {
		return maxConnectionIdleTime;
	}

	public void setMaxConnectionIdleTime(int maxConnectionIdleTime) {
		this.maxConnectionIdleTime = maxConnectionIdleTime;
	}

	public int getMaxConnectionLifeTime() {
		return maxConnectionLifeTime;
	}

	public void setMaxConnectionLifeTime(int maxConnectionLifeTime) {
		this.maxConnectionLifeTime = maxConnectionLifeTime;
	}

	public int getMinConnectionsPerHost() {
		return minConnectionsPerHost;
	}

	public void setMinConnectionsPerHost(int minConnectionsPerHost) {
		this.minConnectionsPerHost = minConnectionsPerHost;
	}

	public String getRequiredReplicaSetName() {
		return requiredReplicaSetName;
	}

	public void setRequiredReplicaSetName(String requiredReplicaSetName) {
		this.requiredReplicaSetName = requiredReplicaSetName;
	}

	public int getMinHeartbeatFrequency() {
		return minHeartbeatFrequency;
	}

	public void setMinHeartbeatFrequency(int minHeartbeatFrequency) {
		this.minHeartbeatFrequency = minHeartbeatFrequency;
	}

	public boolean isSocketKeepAlive() {
		return socketKeepAlive;
	}

	public void setSocketKeepAlive(boolean socketKeepAlive) {
		this.socketKeepAlive = socketKeepAlive;
	}

	public int getHeartbeatSocketTimeout() {
		return heartbeatSocketTimeout;
	}

	public void setHeartbeatSocketTimeout(int heartbeatSocketTimeout) {
		this.heartbeatSocketTimeout = heartbeatSocketTimeout;
	}

	public int getThreadsAllowedToBlockForConnectionMultiplier() {
		return threadsAllowedToBlockForConnectionMultiplier;
	}

	public void setThreadsAllowedToBlockForConnectionMultiplier(int threadsAllowedToBlockForConnectionMultiplier) {
		this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
	}
	
	
	
}
