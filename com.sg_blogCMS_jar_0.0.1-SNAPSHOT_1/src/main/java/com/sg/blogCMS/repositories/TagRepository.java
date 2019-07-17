
package com.sg.blogCMS.repositories;

import com.sg.blogCMS.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMD3
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    
}
