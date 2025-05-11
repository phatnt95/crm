package com.example.crm.chat.zalo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Builder
public class ZaloOAResponse {

    private Data data;
    private int error;
    private String message;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        @JsonProperty("user_id")
        private String userId;
        @JsonProperty("user_id_by_app")
        private String userIdByApp;
        @JsonProperty("user_external_id")
        private String userExternalId;
        @JsonProperty("display_name")
        private String displayName;
        @JsonProperty("user_alias")
        private String userAlias;
        @JsonProperty("is_sensitive")
        private boolean isSensitive;
        @JsonProperty("user_last_interaction_date")
        private String userLastInteractionDate;
        @JsonProperty("user_is_follower")
        private boolean userIsFollower;
        private String avatar;
        private Map<String, String> avatars;
        @JsonProperty("tags_and_notes_info")
        private TagsAndNotesInfo tagsAndNotesInfo;
        @JsonProperty("shared_info")
        private SharedInfo sharedInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TagsAndNotesInfo {
        private List<String> notes;
        @JsonProperty("tag_names")
        private List<String> tagNames;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SharedInfo {
        private String address;
        private String city;
        private String district;
        private String phone;
        private String name;
    }
}
