package ir.malv.detfgit.network.model;

import java.util.List;

public class Rss {
    List<News>channel;
    String _version;

    public List<News> getChannel() {
        return channel;
    }

    public void setChannel(List<News> channel) {
        this.channel = channel;
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version;
    }
}
