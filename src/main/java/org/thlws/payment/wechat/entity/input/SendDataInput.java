package org.thlws.payment.wechat.entity.input;

import org.thlws.payment.wechat.utils.JsonUtil;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by HanleyTang on 2016/11/18.
 */
public class SendDataInput {

    private String url;
    private String touser;
    private String template_id;
    private HashMap<String,Node> data;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    static public class Node implements Serializable {

        /**long SendDataInput.java**/
        private static final long serialVersionUID = -4831188890640769259L;
        private String value;
        private String color;

        public Node(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public String getValue() {
            return value;
        }
        public String getColor() {
            return color;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return JsonUtil.format(this);
        }
    }

    public String getTouser() {
        return touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public HashMap<String, Node> getData() {
        return data;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public void setData(HashMap<String, Node> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
