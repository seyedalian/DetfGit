package ir.malv.detfgit.network.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name ="channel")
public class Channel
{
    @Element(name ="title")
    private String title;
    @Element(name ="managingEditor")
    private String managingEditor;
    @Element(name ="description")
    private String description;
    @Element(name ="link")
    private String link;
    @Element(name ="lastBuildDate")
    private String lastBuildDate;
    @ElementList(name ="item", required=false, entry="item", inline=true)
    private List<Item> item;
    @Element(name ="generator")
    private String generator;
    @Element(name ="webMaster")
    private String webMaster;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getManagingEditor ()
    {
        return managingEditor;
    }

    public void setManagingEditor (String managingEditor)
    {
        this.managingEditor = managingEditor;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getGenerator ()
    {
        return generator;
    }

    public void setGenerator (String generator)
    {
        this.generator = generator;
    }

    public String getWebMaster ()
    {
        return webMaster;
    }

    public void setWebMaster (String webMaster)
    {
        this.webMaster = webMaster;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", managingEditor = "+managingEditor+", description = "+description+", link = "+link+", lastBuildDate = "+lastBuildDate+", item = "+item+", generator = "+generator+", webMaster = "+webMaster+"]";
    }
}