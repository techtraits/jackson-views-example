

import org.codehaus.jackson.map.ObjectMapper;
import java.util.Arrays;

public class Driver {
	public static void main(String[] args) {
	
		try {
			ObjectMapper oMapper = new ObjectMapper();

		
			Child1 child1 = new Child1();
			child1.SerializeMeAlways = 1;
			child1.SerializeMeClient = 1;
			child1.SerializeMeInternal = 1;			
			child1.DontSerializeMe = 12;


			oMapper.setSerializationConfig(oMapper.getSerializationConfig().withView(JacksonViews.ClientView.class));
			printChild(child1,oMapper); 
			
			oMapper.setSerializationConfig(oMapper.getSerializationConfig().withView(JacksonViews.InternalView.class));
			printChild(child1,oMapper); 

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void printChild(Child1 child1, ObjectMapper oMapper) throws Exception{
		String outputChild1 = oMapper.writeValueAsString(child1);
		System.out.println(outputChild1);
		
		ParentClass inputChild1 = oMapper.readValue(outputChild1, ParentClass.class);
		System.out.println(inputChild1.getClass().toString());
	
	}

} 
