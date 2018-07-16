package com.algaworks.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.algaworks.thymeleaf.processor.ClassForErrorAttributeTagPeocessor;

public class BrewerDialect extends AbstractProcessorDialect {

	protected BrewerDialect(String name, String prefix, int processorPrecedence) {
		super("AlgaWorks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagPeocessor(dialectPrefix));
				return processadores;
	}

}
