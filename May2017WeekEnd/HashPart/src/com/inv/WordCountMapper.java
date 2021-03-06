package com.inv;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable>  {

	IntWritable one=new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		String[] words=value.toString().split(" ");
		for (int i = 0; i < words.length; i++) {
			
			context.write(new IntWritable(Integer.parseInt(words[i])), one);
		}
		
		
		
	}

	
	
}
