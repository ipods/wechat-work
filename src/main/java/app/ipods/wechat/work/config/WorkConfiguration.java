package app.ipods.wechat.work.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * 微信的相关配置信息
 * <p>
 * Created by wangkun23 on 2018/6/11.
 */
@Configuration
public class WorkConfiguration {

    @Setter
    @Getter
    protected volatile String corpId;

    @Setter
    @Getter
    protected volatile String corpSecret;

    @Setter
    @Getter
    protected volatile String aesKey;

    @Setter
    @Getter
    protected volatile String agentId;
}
