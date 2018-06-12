package com.algaworks.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ElementType.FIELD, ElementType.METHOD,ElementType.ANNOTATION_TYPE})//onde ela pode ser aplicada
@Retention(RetentionPolicy.RUNTIME)//anotação avaliada em tempo de execução
@Constraint(validatedBy={})//indica que isso é uma validação, posso indicar dentro dele qual a classe que faz a validação
@Pattern (regexp="([a-zA-Z]{2}\\d{4})?")//expressão regular para validar SKU, deverá ter duas letras e mais 4 numeros
public @interface SKU {

	@OverridesAttribute(constraint=Pattern.class,name="message") //aqui vou sobrescrever o atributo message
	String message() default "SKU deve seguir o padrão XX9999";
	
	Class<?>[] groups() default {};//posso agrupar classes para validação
	Class<? extends Payload>[] payload() default {};//payload para carregar mais informações sobre a a
}
