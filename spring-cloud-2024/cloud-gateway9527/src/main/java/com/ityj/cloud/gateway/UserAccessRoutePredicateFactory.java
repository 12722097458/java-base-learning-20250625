
package com.ityj.cloud.gateway;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserAccessRoutePredicateFactory extends AbstractRoutePredicateFactory<UserAccessRoutePredicateFactory.Config> {

	public static final String KEY = "level";

	public UserAccessRoutePredicateFactory() {
		super(Config.class);
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Collections.singletonList(KEY);
	}

	@Override
	public Predicate<ServerWebExchange> apply(Config config) {
		return new GatewayPredicate() {
			@Override
			public boolean test(ServerWebExchange serverWebExchange) {

				List<String> values = serverWebExchange.getRequest().getQueryParams().get(KEY);
				if (values == null) {
					return false;
				}
				for (String value : values) {
					if (value != null && value.equals(config.getLevel())) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Object getConfig() {
				return config;
			}
		};
	}

	public static class Config {
		private String level;

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}
	}


}
