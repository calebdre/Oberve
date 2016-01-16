package com.observe.Persistence;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RestfulService {

    private OkHttpClient client = new OkHttpClient();

    public void makeRequest(final RestfulServiceRequest request){
        Builder builder = new Builder();
        if(request.getMethod().equalsIgnoreCase("DELETE")){
            builder.url(HttpUrl.parse(addQueryStringToUrl(request.getUrl(), request.getQueryParams())));
            builder.delete();
        }else if (request.getMethod().equalsIgnoreCase("GET") && request.getQueryParams() != null) {
            builder.url(HttpUrl.parse(addQueryStringToUrl(request.getUrl(), request.getQueryParams())));
            builder.get();
        }else{
            builder.url(request.getUrl());
            if(request.getJson() == null){
                builder.method(request.getMethod(), transformToRequestBody(request.getQueryParams()));
            }else{
                builder.method(request.getMethod(), RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request.getJson()));
            }
        }

        Request okoRequest = builder.build();
        client.newCall(okoRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {}

            @Override
            public void onResponse(Response response) throws IOException {
                JsonElement json = new JsonParser().parse(response.body().string());

                try{
                    JsonArray jsonArray = json.getAsJsonArray();
                    if(jsonArray.size() > 1){
                        int offset = jsonArray.get(jsonArray.size() - 1).getAsInt();
                        jsonArray.remove(jsonArray.size() - 1);
                    }
                }catch (UnsupportedOperationException | IllegalStateException e){
                    // carru on......
                }
                if(request.getExpectedClass() != null){
                    request.getResultEvent().onResult(new Gson().fromJson(json, request.expectedClass));
                }else{
                    request.getResultEvent().onResult(new Gson().fromJson(json, request.getExpectedClassToken()));
                }
            }
        });
    }

    private String addQueryStringToUrl(String url, HashMap<String, String> query) {
        return url + "?" + mapToQueryString(query);
    }

    @NonNull
    private String mapToQueryString(HashMap<String, String> queryString){
        StringBuilder sb = new StringBuilder();
        for(HashMap.Entry<String, String> e : queryString.entrySet()){
            if(sb.length() > 0){
                sb.append('&');
            }
            try {
                sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }

        return sb.toString();
    }

    @Nullable
    private RequestBody transformToRequestBody(HashMap<String, String> query) {
        if(query == null) return null;

        FormEncodingBuilder formBody = new FormEncodingBuilder();
        for (Map.Entry<String, String> entry : query.entrySet()) {
            formBody.add(entry.getKey(), entry.getValue());
        }
        return formBody.build();
    }

    public class RestfulServiceRequestBuilder {
        private String url, method, json;
        private RestRequestResultInterface resultEvent;
        private HashMap<String, String> queryParams;
        private Class expectedClass;
        private Type expectedClassToken;

        public RestfulServiceRequest build(){
            if(url == null) throw new IllegalStateException("Missing Url");
            if(expectedClass == null && expectedClassToken == null) throw new IllegalStateException("Missing expected type or class");
            if(resultEvent == null) throw new IllegalStateException("Missing event to post when request is made.");

            if(method == null){
                method = "GET";
            }else if(method == null && queryParams != null){
                method = "POST";
            }
            return new RestfulServiceRequest(url, method, json, resultEvent, queryParams, expectedClass, expectedClassToken);
        }

        public RestfulServiceRequestBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public RestfulServiceRequestBuilder setMethod(String method) {
            this.method = method;
            return this;
        }

        public RestfulServiceRequestBuilder setJson(String json) {
            this.json = json;
            return this;
        }

        public RestfulServiceRequestBuilder setResultEvent(RestRequestResultInterface resultEvent) {
            this.resultEvent = resultEvent;
            return this;
        }

        public RestfulServiceRequestBuilder setQueryParams(HashMap<String, String> queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public RestfulServiceRequestBuilder setExpectedClass(Class expectedClass) {
            this.expectedClass = expectedClass;
            return this;
        }

        public RestfulServiceRequestBuilder setExpectedClassToken(Type expectedClassToken) {
            this.expectedClassToken = expectedClassToken;
            return this;
        }
    }

    private class RestfulServiceRequest{
        private String url;
        private String method, json;
        private RestRequestResultInterface resultEvent;
        private HashMap<String, String> queryParams;
        private Class expectedClass;
        private Type expectedClassToken;

        public RestfulServiceRequest(String url, @Nullable String method, @Nullable String json, RestRequestResultInterface resultEvent, @Nullable HashMap<String, String> queryParams, @Nullable Class expectedClass, @Nullable Type expectedClassToken) {
            this.url = url;
            this.method = method;
            this.json = json;
            this.resultEvent = resultEvent;
            this.queryParams = queryParams;
            this.expectedClass = expectedClass;
            this.expectedClassToken = expectedClassToken;
        }

        public String getUrl() {
            return url;
        }

        public String getMethod() {
            return method;
        }

        public String getJson() {
            return json;
        }

        public RestRequestResultInterface getResultEvent() {
            return resultEvent;
        }

        public HashMap<String, String> getQueryParams() {
            return queryParams;
        }

        public Class getExpectedClass() {
            return expectedClass;
        }

        public Type getExpectedClassToken() {
            return expectedClassToken;
        }
    }

    public interface RestRequestResultInterface {
        void onResult(Object object);
    }
}