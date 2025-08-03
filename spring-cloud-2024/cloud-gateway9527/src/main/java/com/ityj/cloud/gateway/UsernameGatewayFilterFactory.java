package com.ityj.cloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class UsernameGatewayFilterFactory extends AbstractGatewayFilterFactory<UsernameGatewayFilterFactory.Config> {

	public static final String KEY = "userName";

	public UsernameGatewayFilterFactory() {
		super(Config.class);
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList(KEY);
	}

	@Override
	public GatewayFilter apply(Config config) {

		return new GatewayFilter() {
			@Override
			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
				log.info("into UsernameGatewayFilterFactory...");
				MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
				if (!queryParams.containsKey(KEY)) {
					log.error("Parameter should contain userName");
					return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameter should contain userName"));
				}
				return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
			}
		};
	}

	public static class Config {

		private String userName;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}
	}

}
