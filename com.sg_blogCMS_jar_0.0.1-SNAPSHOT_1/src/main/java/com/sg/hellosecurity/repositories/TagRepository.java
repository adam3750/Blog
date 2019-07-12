
package com.sg.hellosecurity.repositories;

import com.sg.hellosecurity.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMD3
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    
}
