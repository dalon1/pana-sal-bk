package com.panasalbk.app.model.abstract_model;


/**
 * 
 * @author AloniD
 *
 * @param <D> - D for Dto
 * @param <M> - M for Model
 * Example: ProfileMapper extends Mapper<ProfileDto, Profile>
 */
public abstract class Mapper<D, M> {
	
	public abstract D toDto(M model);
	public abstract M toModel(D dto);
}
