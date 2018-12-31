package com.mostert2010.sfgpetclinic.services;

import com.mostert2010.sfgpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
}
