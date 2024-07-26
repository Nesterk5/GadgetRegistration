package com.example.Gadget_Registration.repositories;

import com.example.Gadget_Registration.gadget.Gadgets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GadgetRepository extends JpaRepository<Gadgets, Integer> {
}
