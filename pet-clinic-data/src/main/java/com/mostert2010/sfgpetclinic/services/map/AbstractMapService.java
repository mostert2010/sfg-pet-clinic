package com.mostert2010.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.mostert2010.sfgpetclinic.models.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity> {

	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(Long id) {
		return map.get(id);
	}
	
	T save(T object) {
		
		if (object == null)
			throw new RuntimeException("Object can not be null");
			
		if (object.getId() == null) {
			object.setId(this.getNextId());
		}
		map.put(object.getId(), object);
		
		return object;
	}
	
	void deleteById(Long id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		
		if (map.keySet().isEmpty()) return 1L;
		
		return Collections.max(map.keySet()) + 1;
	}
}
