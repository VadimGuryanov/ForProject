package com.example.project;

import com.example.project.first_activity.MainActivity;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.VKApiCallback;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RequestListOfMaps {
    public static List<Map> getList(int[] uids) throws VKApiExecutionException {
        List<Map> userMap = new ArrayList<>();
        VKMyRequest request = new VKMyRequest(uids, "users.get");
        VK.execute(request, new VKApiCallback<List<String>>() {
            @Override
            public void success(List<String> strings) {
                Iterator<String> iterator = strings.iterator();
                while(iterator.hasNext()) {
                    String entry = iterator.next();
                    Map map = JsonToMapParser.parse(entry);
                    userMap.add(map);
                }
            }

            @Override
            public void fail(@NotNull VKApiExecutionException e) {
                e.printStackTrace();
            }
        });
        MainActivity.flag = true;
        return userMap;
    }

    public static Map getMap(int uid) throws VKApiExecutionException {
        Map user = new LinkedHashMap();
        VKMyRequest request = new VKMyRequest(new int[]{uid}, "users.get");
        VK.execute(request, new VKApiCallback<List<String>>() {
            @Override
            public void success(List<String> strings) {
                Iterator<String> iterator = strings.iterator();
                while(iterator.hasNext()) {
                    String entry = iterator.next();
                    Map map = JsonToMapParser.parse(entry);
                    user.putAll(map);
                }
            }

            @Override
            public void fail(@NotNull VKApiExecutionException e) {
                e.printStackTrace();
            }
        });
        return user;
    }
}
