//package com.example.richie.liftassistant.server;
//
//import com.zhy.http.okhttp.OkHttpUtils;
//import com.zhy.http.okhttp.callback.StringCallback;
//
//import okhttp3.OkHttpClient;
//
///**
// * Created by richie on 2016/5/18.
// */
//public class GetWeChatFeatureServer {
//    private Person gson(String url){
//        OkHttpClient client = new OkHttpClient();
//        Gson gson = new Gson();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//            Person person = gson.fromJson(response.body().charStream(), Person.class);
//            return person;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
