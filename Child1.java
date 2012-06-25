import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnore;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class Child1 extends ParentClass {
	
    @JsonView(JacksonViews.DefaultView.class)
	@JsonProperty
	public int SerializeMeAlways;

    @JsonView(JacksonViews.InternalView.class)
    @JsonProperty
	public int SerializeMeInternal;

    @JsonView(JacksonViews.ClientView.class)
    @JsonProperty
	public int SerializeMeClient;
	
	@JsonIgnore
	public int DontSerializeMe;

}