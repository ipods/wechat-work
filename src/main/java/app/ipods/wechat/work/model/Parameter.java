package app.ipods.wechat.work.model;

import app.ipods.wechat.work.utils.OAuthEncoder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wangkun23 on 2018/6/11.
 */
@ToString
@EqualsAndHashCode
public class Parameter implements Comparable<Parameter>, Serializable {

    @Setter
    @Getter
    private final String key;

    @Setter
    @Getter
    private final String value;

    public Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String asUrlEncodedPair() {
        return OAuthEncoder.encode(key).concat("=").concat(OAuthEncoder.encode(value));
    }

    @Override
    public int compareTo(Parameter parameter) {
        final int keyDiff = key.compareTo(parameter.getKey());
        return keyDiff == 0 ? value.compareTo(parameter.getValue()) : keyDiff;
    }
}
