package com.example.crm.chat.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageEvent {

    private String app_id;
    private Sender sender;
    private String user_id_by_app;
    private Recipient recipient;
    private String event_name;
    private Message message;
    private String timestamp;

    @Setter
    @Getter
    public static class Sender {
        private String id;
    }

    @Setter
    @Getter
    public static class Recipient {
        private String id;
    }

    @Setter
    @Getter
    public static class Message {
        private String text;
        private String msg_id;
    }

    @Setter
    @Getter
    public static class Attachment {
        private String type;
        @Setter
        @Getter
        public static class Payload {
            private String id;
            private String thumbnail;
            private String url;
            private String description;
            private String size;
            private String name;
            private String type;
            private String checksum;
        }
    }
}
