package bigbigboy.example.com.voicerecorder.bean;

/**
 * Created by BigBigBoy on 2015/3/22.
 */
public class MessageBean {
    String accountNmae;
    String content;
    String createTime;
    Long voiceTimeLength;
    String voicePath;
    int bgcolor;

    public MessageBean(String accountNmae, String content, String createTime, Long voiceTimeLength, String voicePath, int bgcolor) {
        this.accountNmae = accountNmae;
        this.content = content;
        this.createTime = createTime;
        this.voiceTimeLength = voiceTimeLength;
        this.voicePath = voicePath;
        this.bgcolor = bgcolor;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public int getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(int bgcolor) {
        this.bgcolor = bgcolor;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAccountNmae() {
        return accountNmae;
    }

    public void setAccountNmae(String accountNmae) {
        this.accountNmae = accountNmae;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getVoiceTimeLength() {
        return voiceTimeLength;
    }

    public void setVoiceTimeLength(Long voiceTimeLength) {
        this.voiceTimeLength = voiceTimeLength;
    }


    public MessageBean() {
    }

    public String getPath() {
        return "";
    }

}
