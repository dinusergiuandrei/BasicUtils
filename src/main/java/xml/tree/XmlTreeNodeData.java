package xml.tree;


import java.util.LinkedHashMap;
import java.util.Map;

public class XmlTreeNodeData {
    private String name;

    private Map<String, Object> attributes;

    private String text;

    private Integer height;

    public XmlTreeNodeData(String name) {
        this.name = name;
        attributes = new LinkedHashMap<>();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addAttribute(String key, Object value){
        this.attributes.put(key, value);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
