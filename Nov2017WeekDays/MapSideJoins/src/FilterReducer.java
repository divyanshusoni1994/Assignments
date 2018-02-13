import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.collections.IteratorUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FilterReducer 
	extends Reducer<Text, Text, Text, NullWritable>{

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Context context) throws IOException, InterruptedException {
		// hi <1,1,1,1>
		int sum=0;
        ArrayList<Text> cache = new ArrayList<Text>();
		
		for(Text val:values){
			sum=sum+1;
            cache.add(val);
			
		}
		if(sum>2){
			for(Text val:cache){
				context.write(val, NullWritable.get());
				
			}
		}
		
	}
}