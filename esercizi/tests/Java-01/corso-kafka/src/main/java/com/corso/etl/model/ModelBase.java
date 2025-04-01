package com.corso.etl.model;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

public class ModelBase {

	public GenericRecord toAvro(Schema schema) {
		GenericRecord rec = new GenericData.Record(schema);
		Class<?> thisClass = null;
		try {
			thisClass = Class.forName(this.getClass().getName());
			
			Field[] fields = thisClass.getDeclaredFields();
			
			for(Field f: fields) {
				String fName = f.getName();
				rec.put(fName, f.get(this));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rec;
	}
	
	
}
