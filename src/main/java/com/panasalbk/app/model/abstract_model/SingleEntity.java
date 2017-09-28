package com.panasalbk.app.model.abstract_model;

/**
 * Note: This abstract class must be implemented to
 * __EVERY__ class that works as an identifier for a specific
 * domain object class.
 * For example: CustomerId extends SingleEntity
 * @author AloniD
 *
 * @param <T>
 */
public abstract class SingleEntity<T> {
	protected T id;
	
	public SingleEntity(T value) {
		this.id = value;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
}
