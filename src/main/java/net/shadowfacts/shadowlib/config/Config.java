package net.shadowfacts.shadowlib.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shadowfacts
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Config {

	String name();

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	@interface Prop {

		String category() default "general";

		String name() default "";

		String description() default "";

	}

}
