package ir.malv.detfgit.network.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "enclosure")
public class Enclosure
{

    @Attribute(required = false ,name ="length")
    private int length;
    @Attribute(required = false ,name ="type")

    private String type;
    @Attribute(required = false ,name ="url")

    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [length = "+length+", type = "+type+", url = "+url+"]";
    }
}

