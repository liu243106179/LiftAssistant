package com.example.richie.liftassistant.bean;


/**
 * Created by richie on 2016/5/21.
 */

public class WeChatFeaturedResult {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"0":{"description":"满婷神皂","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-568467.jpg/640","title":"夏天这几件事儿千万不要做","url":"http://mp.weixin.qq.com/s?__biz=MjM5MDQzOTg0Ng==&idx=1&mid=207874755&sn=15175c644e4fd478d19649a62446e453&qb_mtt_show_type=1"},"code":200,"msg":"ok"}
     */

    private int showapi_res_code;
    private String showapi_res_error;

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    /**
     * 0 : {"description":"满婷神皂","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-568467.jpg/640","title":"夏天这几件事儿千万不要做","url":"http://mp.weixin.qq.com/s?__biz=MjM5MDQzOTg0Ng==&idx=1&mid=207874755&sn=15175c644e4fd478d19649a62446e453&qb_mtt_show_type=1"}
     * code : 200
     * msg : ok
     */


    public ShowapiResBodyBean showapi_res_body;

    public static class  ShowapiResBodyBean{
        private String description;
        private String picUrl;
        private String title;
        private String url;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
