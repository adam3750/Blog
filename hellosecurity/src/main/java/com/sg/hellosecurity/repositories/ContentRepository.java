
package com.sg.hellosecurity.repositories;

import com.sg.hellosecurity.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMD3
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    
}
