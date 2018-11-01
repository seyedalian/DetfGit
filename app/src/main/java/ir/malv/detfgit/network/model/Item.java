package ir.malv.detfgit.network.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

@Root(name = "item",strict = false)
public class Item
{

    private String author;
    @Element
    private String pubDate;
    @Element
    private String title;
    @Element(type = Enclosure.class,name ="enclosure" )
    private Enclosure enclosure;
    @Element(name = "description",data = true)
    private CharSequence description;
    @Element(name = "link" )
    private String link;

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Enclosure getEnclosure ()
    {
        return enclosure;
    }

    public void setEnclosure (Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }

    public String getDescription ()
    {
        return description.toString();
    }

    public void setDescription(CharSequence description) {
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

    @Override
    public String toString()
    {
        return "ClassPojo [author = "+author+", pubDate = "+pubDate+", title = "+title+", enclosure = "+enclosure+", description = "+description+", link = "+link+"]";
    }
}

