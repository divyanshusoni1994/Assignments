package com.inv;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends 
			Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		//convert Text into String 
		String line=value.toString();
		//String[] words=line.split(" ");
		
		//hi welcome to hadoop -> [hi, welcome, to, hadoop]
		StringTokenizer words=new StringTokenizer(line, " ");
		
		while(words.hasMoreTokens()){
			String val=words.nextToken();
			//emit one word at a time
			context.write(new Text(val),new IntWritable(1));
		}
	
	
	}
	

}
