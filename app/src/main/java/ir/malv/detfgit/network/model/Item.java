package ir.malv.detfgit.network.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "item")
public class Item
{
    @Element(name ="author" ,required = false)
    private String author;
    @Element(name ="pubDate" ,required = false)
    private String pubDate;
    @Element(name ="title" ,required = false)
    private String title;
    @Element(type = Enclosure.class,name ="enclosure",required = false)
    private Enclosure enclosure;

    @Element(name ="description" ,required = false)
    private String description;
    @Element(name = "link" ,required = false)
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

    public void setDescription(String description) {
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

