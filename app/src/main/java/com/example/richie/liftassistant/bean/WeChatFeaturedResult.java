package com.example.richie.liftassistant.bean;


import java.util.List;

/**
 * Created by richie on 2016/5/21.
 */

public class WeChatFeaturedResult {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"pagebean":{"allNum":5961,"allPages":299,"contentlist":[{"contentImg":"http://mmbiz.qpic.cn/mmbiz/e5DwVY6II2ZdcrTjryOw0ibOOTEh7nXI88VxM9m9pzia8pEVEzicUfibL7aGUcdQ2AXb8ahO90icqAiaqiczCiahE4Gzbg/0?wx_fmt=jpeg","date":"08月06日","id":"55c3b1096e36e0e8c3953012","title":"纽约梦丨欲求翻身，任重道远","typeId":"19","typeName":"体育迷","url":"http://mp.weixin.qq.com/s?__biz=MzA3MTgyNjcxMA==&mid=211970632&idx=1&sn=cbc03c2911bbf981f455dd161526029c&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/287c5d08-0a52-4001-8e0c-8ed1222fa44d.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/0327beff-34d8-49d4-9dcc-cdbba069c730.jpg","userName":"篮球先锋报"}],"currentPage":1,"maxResult":20},"ret_code":0}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * pagebean : {"allNum":5961,"allPages":299,"contentlist":[{"contentImg":"http://mmbiz.qpic.cn/mmbiz/e5DwVY6II2ZdcrTjryOw0ibOOTEh7nXI88VxM9m9pzia8pEVEzicUfibL7aGUcdQ2AXb8ahO90icqAiaqiczCiahE4Gzbg/0?wx_fmt=jpeg","date":"08月06日","id":"55c3b1096e36e0e8c3953012","title":"纽约梦丨欲求翻身，任重道远","typeId":"19","typeName":"体育迷","url":"http://mp.weixin.qq.com/s?__biz=MzA3MTgyNjcxMA==&mid=211970632&idx=1&sn=cbc03c2911bbf981f455dd161526029c&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/287c5d08-0a52-4001-8e0c-8ed1222fa44d.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/0327beff-34d8-49d4-9dcc-cdbba069c730.jpg","userName":"篮球先锋报"}],"currentPage":1,"maxResult":20}
     * ret_code : 0
     */

    private ShowapiResBodyBean showapi_res_body;

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

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * allNum : 5961
         * allPages : 299
         * contentlist : [{"contentImg":"http://mmbiz.qpic.cn/mmbiz/e5DwVY6II2ZdcrTjryOw0ibOOTEh7nXI88VxM9m9pzia8pEVEzicUfibL7aGUcdQ2AXb8ahO90icqAiaqiczCiahE4Gzbg/0?wx_fmt=jpeg","date":"08月06日","id":"55c3b1096e36e0e8c3953012","title":"纽约梦丨欲求翻身，任重道远","typeId":"19","typeName":"体育迷","url":"http://mp.weixin.qq.com/s?__biz=MzA3MTgyNjcxMA==&mid=211970632&idx=1&sn=cbc03c2911bbf981f455dd161526029c&3rd=MzA3MDU4NTYzMw==&scene=6#rd","userLogo":"http://app1.showapi.com/weixin_info/287c5d08-0a52-4001-8e0c-8ed1222fa44d.jpg","userLogo_code":"http://app1.showapi.com/weixin_info/0327beff-34d8-49d4-9dcc-cdbba069c730.jpg","userName":"篮球先锋报"}]
         * currentPage : 1
         * maxResult : 20
         */

        private PagebeanBean pagebean;
        private int ret_code;

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public static class PagebeanBean {
            private int allNum;
            private int allPages;
            private int currentPage;
            private int maxResult;
            /**
             * contentImg : http://mmbiz.qpic.cn/mmbiz/e5DwVY6II2ZdcrTjryOw0ibOOTEh7nXI88VxM9m9pzia8pEVEzicUfibL7aGUcdQ2AXb8ahO90icqAiaqiczCiahE4Gzbg/0?wx_fmt=jpeg
             * date : 08月06日
             * id : 55c3b1096e36e0e8c3953012
             * title : 纽约梦丨欲求翻身，任重道远
             * typeId : 19
             * typeName : 体育迷
             * url : http://mp.weixin.qq.com/s?__biz=MzA3MTgyNjcxMA==&mid=211970632&idx=1&sn=cbc03c2911bbf981f455dd161526029c&3rd=MzA3MDU4NTYzMw==&scene=6#rd
             * userLogo : http://app1.showapi.com/weixin_info/287c5d08-0a52-4001-8e0c-8ed1222fa44d.jpg
             * userLogo_code : http://app1.showapi.com/weixin_info/0327beff-34d8-49d4-9dcc-cdbba069c730.jpg
             * userName : 篮球先锋报
             */

            private List<ContentlistBean> contentlist;

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                private String contentImg;
                private String date;
                private String id;
                private String title;
                private String typeId;
                private String typeName;
                private String url;
                private String userLogo;
                private String userLogo_code;
                private String userName;

                public String getContentImg() {
                    return contentImg;
                }

                public void setContentImg(String contentImg) {
                    this.contentImg = contentImg;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTypeId() {
                    return typeId;
                }

                public void setTypeId(String typeId) {
                    this.typeId = typeId;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getUserLogo() {
                    return userLogo;
                }

                public void setUserLogo(String userLogo) {
                    this.userLogo = userLogo;
                }

                public String getUserLogo_code() {
                    return userLogo_code;
                }

                public void setUserLogo_code(String userLogo_code) {
                    this.userLogo_code = userLogo_code;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }
            }
        }
    }
}
