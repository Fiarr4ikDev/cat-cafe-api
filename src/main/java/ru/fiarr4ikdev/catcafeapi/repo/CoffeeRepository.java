package ru.fiarr4ikdev.catcafeapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fiarr4ikdev.catcafeapi.entity.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
