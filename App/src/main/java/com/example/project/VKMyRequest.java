package com.example.project;

import com.vk.api.sdk.requests.VKRequest;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VKMyRequest extends VKRequest<List<String>> {

    public VKMyRequest(int[] uids, @NotNull String method) {
        super(method);
        if(uids.length > 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < uids.length; i++) {
                sb.append(uids[i]);
                if(i < uids.length - 1) {
                    sb.append(",");
                }
            }
            addParam("user_ids", sb.toString());
        }
        addParam("fields", "photo_100");
    }

    @Override
    public List<String> parse(@NotNull JSONObject r) throws Exception {
        JSONArray users = r.getJSONArray("response");
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < users.length(); i++) {
            result.add(users.optString(i));
        }
        return result;
    }
}
