package br.com.caelum.estoque.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

@SuppressWarnings("rawtypes")
public class DateAdapter extends XmlAdapter {

	private String pattern = "dd/MM/yyyy";
	
	
	public Date unmarshal(String arg0) throws Exception {
		return new SimpleDateFormat(pattern).parse(arg0);
	}

	public String marshal(Date arg0) throws Exception {
		return new SimpleDateFormat(pattern).format(arg0);
	}

	@Override
	public Object marshal(Object v) throws Exception {
		return new SimpleDateFormat(pattern).format(v);
	}

	@Override
	public Object unmarshal(Object v) throws Exception {
		return new SimpleDateFormat(pattern).parse(v.toString());
	}


}