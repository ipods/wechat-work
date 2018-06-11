package app.ipods.wechat.work.service.impl;

import app.ipods.wechat.work.api.OAuthConstants;
import app.ipods.wechat.work.config.WorkConfiguration;
import app.ipods.wechat.work.model.ParameterList;
import app.ipods.wechat.work.service.Oauth2Service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2018/6/11.
 */
@Service
public class Oauth2ServiceImpl implements Oauth2Service {

    private final String authorizationBaseUrl = "https://open.weixin.qq.com/connect/oauth2/authorize";

    @Resource
    private WorkConfiguration workConfig;

    @Resource
    private RestTemplate restTemplate;

    /**
     * https://open.weixin.qq.com/connect/oauth2/authorize
     * ?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&agentid=AGENTID&state=STATE#wechat_redirect
     *
     * @param scope
     * @param state
     * @return
     */
    public String getAuthorizationUrl(String callback, String scope, String state) {
        final ParameterList parameters = new ParameterList();

        parameters.add(OAuthConstants.APP_ID, workConfig.getCorpId());
        if (callback != null) {
            parameters.add(OAuthConstants.REDIRECT_URI, callback);
        }
        String responseType = OAuthConstants.RESPONSE_TYPE_CODE;//code
        parameters.add(OAuthConstants.RESPONSE_TYPE, responseType);
        if (scope != null) {
            parameters.add(OAuthConstants.SCOPE, scope);
        }
        if (state != null) {
            parameters.add(OAuthConstants.STATE, state);
        }
        parameters.add(OAuthConstants.AGENT_ID, workConfig.getAgentId());
        return parameters.appendTo(authorizationBaseUrl);
    }
}
