package com.panasalbk.app.annotation;
/**
 * Dannel Alon
 * Annotation Class must be implemented in every class developed.
 * @author AloniD
 *
 */
public @interface WrittenBy {
	String author() default "Dannel Alon";
	String date();
	String comment() default "No comment";
}
