package com.algaworks.thymeleaf.processor;

import org.assertj.core.util.introspection.FieldUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class ClassForErrorAttributeTagPeocessor extends AbstractAttributeTagProcessor {
	
	private static final String NOME_ATRIBUTO = "classforerror";
	private static final int PRECEDENCIA=1000;

	public ClassForErrorAttributeTagPeocessor( String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false,  NOME_ATRIBUTO,true,PRECEDENCIA, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue,
			IElementTagStructureHandler structureHandler) {
		String field = attributeValue;
		boolean temErro = org.thymeleaf.spring5.util.FieldUtils.hasErrors(context, attributeValue);		
	
		if(temErro){
			String classesExistentes = tag.getAttributeValue("class");
			structureHandler.setAttribute("class", classesExistentes+"has-error"); // no lugar de class vou colocar as claasses existebetre
			
		}
	}

}
